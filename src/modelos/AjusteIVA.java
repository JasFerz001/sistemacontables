/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guill
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjusteIVA {

    private Connection connection;

    // Constructor para inicializar la conexión a la base de datos
    public AjusteIVA(Connection connection) {
        this.connection = connection;
    }

    // 1. Obtener IVA Crédito Fiscal
    public double obtenerIvaCredito() throws SQLException {
        String query = "SELECT \n"
                + "    COALESCE(SUM(CASE \n"
                + "                    WHEN ld.transaccion = 'Debe' THEN ld.monto \n"
                + "                    ELSE -ld.monto \n"
                + "                 END), 0) AS saldo_iva_credito\n"
                + "FROM libro_diario ld\n"
                + "LEFT JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta\n"
                + "LEFT JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor\n"
                + "WHERE cm.cod_mayor = '1108';";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("iva_credito");
            }
        }
        return 0.0;
    }

    // 2. Obtener IVA Débito Fiscal
    public double obtenerIvaDebito() throws SQLException {
        String query = "SELECT \n"
                + "    COALESCE(SUM(CASE \n"
                + "                    WHEN ld.transaccion = 'Haber' THEN ld.monto \n"
                + "                    ELSE -ld.monto \n"
                + "                 END), 0) AS saldo_iva_debito\n"
                + "FROM libro_diario ld\n"
                + "LEFT JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta\n"
                + "LEFT JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor\n"
                + "WHERE cm.cod_mayor = '2107';";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("iva_debito");
            }
        }
        return 0.0;
    }

    // 3. Ajustar IVA
    public void ajustarIva() throws SQLException {
        double debito = obtenerIvaDebito();
        double credito = obtenerIvaCredito();

        if (debito > credito) {
            double pagar = debito - credito;

            // Insertar IVA Débito Fiscal (Haber)
            insertarTransaccion("210701", debito, "Liquidación de IVA - Carga de IVA Débito Fiscal", "Debe");

            // Insertar IVA Crédito Fiscal (Debe)
            insertarTransaccion("110801", credito, "Liquidación de IVA - Abono de IVA Crédito Fiscal", "Haber");

            // Insertar la diferencia en Cuentas por Pagar (Haber)
            insertarTransaccion("210401", pagar, "Liquidación de IVA - Diferencia abonada a Cuentas y Documentos por Pagar", "Haber");

        } else {
            double remanente = credito - debito;

            // Insertar IVA Débito Fiscal (Haber)
            insertarTransaccion("210701", debito, "Liquidación de IVA - Carga de IVA Débito Fiscal", "Debe");

            // Insertar IVA Crédito Fiscal (Debe)
            insertarTransaccion("110801", credito, "Liquidación de IVA - Abono de IVA Crédito Fiscal", "Haber");

            // Insertar la diferencia en Remanente de IVA (Debe)
            insertarTransaccion("130101", remanente, "Liquidación de IVA - Diferencia cargada a Remanente de IVA", "Debe");
        }
    }

    // Método para insertar una transacción en la tabla libro_diario
// Método para insertar una transacción en la tabla libro_diario
    private void insertarTransaccion(String codSubcuenta, double monto, String concepto, String transaccion) throws SQLException {
        // Obtener el último número de partida
        String getLastPartidaQuery = "SELECT COALESCE(MAX(numero_partida), 0) AS ultimo_numero FROM libro_diario";
        int nuevoNumeroPartida;

        try (PreparedStatement getLastPartidaStmt = connection.prepareStatement(getLastPartidaQuery)) {
            ResultSet rs = getLastPartidaStmt.executeQuery();
            if (rs.next()) {
                nuevoNumeroPartida = rs.getInt("ultimo_numero") + 1; // Incrementar el último número de partida
            } else {
                nuevoNumeroPartida = 1; // Iniciar con 1 si no hay registros previos
            }
        }

        // Insertar la nueva transacción
        String insertQuery = "INSERT INTO libro_diario (numero_partida, cod_subcuenta, fecha, monto, concepto, transaccion) "
                + "VALUES (?, ?, CURRENT_DATE, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
            stmt.setInt(1, nuevoNumeroPartida); // Establecer el número de partida
            stmt.setString(2, codSubcuenta);   // Código de la subcuenta
            stmt.setDouble(3, monto);         // Monto
            stmt.setString(4, concepto);      // Concepto
            stmt.setString(5, transaccion);   // Tipo de transacción (Debe/Haber)
            stmt.executeUpdate();
        }
    }
}

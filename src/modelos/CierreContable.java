/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CierreContable {

    private Connection connection;

    // Constructor que inicializa automáticamente la conexión
    public CierreContable() {
        // Configuración predeterminada para la base de datos
        String url = "jdbc:mysql://localhost:3306/sic"; // Cambia el nombre de la base de datos si es necesario
        String user = "root"; // Cambia el usuario si es diferente
        String password = ""; // Cambia la contraseña

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Obtener el saldo de una cuenta específica
    private double obtenerSaldo(String codCuenta) throws SQLException {
        String query = "SELECT COALESCE(SUM(CASE WHEN transaccion = 'Debe' THEN monto ELSE -monto END), 0) AS saldo "
                + "FROM libro_diario ld "
                + "LEFT JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta "
                + "LEFT JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor "
                + "WHERE cm.cod_mayor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codCuenta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("saldo");
            }
        }
        return 0.0;
    }

    private double obtenerSaldoAbsoluto(String codCuenta) throws SQLException {
        String query = "SELECT COALESCE(SUM(monto), 0) AS saldo "
                + "FROM libro_diario ld "
                + "LEFT JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta "
                + "LEFT JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor "
                + "WHERE cm.cod_mayor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codCuenta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("saldo");
            }
        }
        return 0.0;
    }

    // Insertar una transacción en el libro diario
    private void insertarTransaccion(int numeroPartida, String codSubcuenta, double monto, String concepto, String transaccion) throws SQLException {
        String query = "INSERT INTO libro_diario (numero_partida, cod_subcuenta, fecha, monto, concepto, transaccion) "
                + "VALUES (?, ?, CURRENT_DATE, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, numeroPartida);
            stmt.setString(2, codSubcuenta);
            stmt.setDouble(3, monto);
            stmt.setString(4, concepto);
            stmt.setString(5, transaccion);
            stmt.executeUpdate();
        }
    }

    // Obtener el siguiente número de partida
    private int obtenerSiguienteNumeroPartida() throws SQLException {
        String query = "SELECT COALESCE(MAX(numero_partida), 0) + 1 AS siguiente_partida FROM libro_diario";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("siguiente_partida");
            }
        }
        return 1;
    }

    public void ventasNetas() throws SQLException {
        double ventas = obtenerSaldo("5101");
        double rebajas = obtenerSaldoAbsoluto("4104");
        double devoluciones = obtenerSaldoAbsoluto("4103");
        double total = rebajas + devoluciones;

        int numeroPartida = obtenerSiguienteNumeroPartida();
        insertarTransaccion(numeroPartida, "510101", total, "Ventas Netas", "Debe");
        insertarTransaccion(numeroPartida, "410401", rebajas, "Ventas Netas", "Haber");
        insertarTransaccion(numeroPartida, "410301", devoluciones, "Ventas Netas", "Haber");
    }

    public void ComprasTotales() throws SQLException {
        double compras = obtenerSaldo("4101");
        double gastos = obtenerSaldoAbsoluto("5103");

        int numeroPartida = obtenerSiguienteNumeroPartida();
        insertarTransaccion(numeroPartida, "410101", gastos, "Por liquidacion de gastos", "Debe");
        insertarTransaccion(numeroPartida, "410201", gastos, "Por liquidacion de gastos", "Haber");
    }

    public void ComprasNetas() throws SQLException {
        double compras = obtenerSaldo("4101");
        double devoluciones = obtenerSaldoAbsoluto("5102");
        double rebajas = obtenerSaldoAbsoluto("5103");
        double total = devoluciones + rebajas;

        int numeroPartida = obtenerSiguienteNumeroPartida();
        insertarTransaccion(numeroPartida, "510201", devoluciones, "liquidacion de reb. y dev.", "Debe");
        insertarTransaccion(numeroPartida, "510301", rebajas, "liquidacion de reb. y dev.", "Debe");
        insertarTransaccion(numeroPartida, "410101", total, "liquidacion de reb. y dev.", "Haber");
    }

    public void MercaderiaDisponible() throws SQLException {
        double compras = obtenerSaldo("4101");
        double inventario = obtenerSaldoAbsoluto("1106");

        int numeroPartida = obtenerSiguienteNumeroPartida();
        insertarTransaccion(numeroPartida, "410101", inventario, "saldar cuenta de inventario", "Debe");
        insertarTransaccion(numeroPartida, "110601", inventario, "saldar cuenta de inventario", "Haber");
    }

    public void CostoVenta(Double inventario) throws SQLException {

        int numeroPartida = obtenerSiguienteNumeroPartida();
        insertarTransaccion(numeroPartida, "410101", inventario, "saldar cuenta de inventario", "Debe");
        insertarTransaccion(numeroPartida, "111201", inventario, "saldar cuenta de inventario", "Haber");
    }

    // Cerrar la conexión automáticamente
    public void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

}

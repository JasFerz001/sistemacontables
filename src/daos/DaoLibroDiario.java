package daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import modelos.LibroDiario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelos.SubCuentas;

/**
 *
 * @author kevin
 */
public class DaoLibroDiario {

    Conexion conexion;
    private ArrayList<LibroDiario> listaLibroDiario;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private LibroDiario libroDiario;

    private static final String INSERT_LIBRO_DIARIO = "INSERT INTO libro_diario"
            + "(numero_partida, fecha, cod_subcuenta, concepto, monto, transaccion) VALUES (?, ?, ?, ?, ?, ?);";

    public DaoLibroDiario() {
        this.conexion = new Conexion();
    }

    public String insertarLibroDiario(LibroDiario libroDiario) throws SQLException, ClassNotFoundException {
        String resultado;
        int resultadoInsertar;
        try {
            this.conexion = new Conexion();
            this.conexion.getConexion();
            this.accesoDB = conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(INSERT_LIBRO_DIARIO);
            this.ps.setInt(1, libroDiario.getNumeroPartida());
            this.ps.setDate(2, new java.sql.Date(libroDiario.getFecha().getTime()));
            this.ps.setInt(3, libroDiario.getCodSubcuenta());
            this.ps.setString(4, libroDiario.getConcepto());
            this.ps.setBigDecimal(5, BigDecimal.valueOf(libroDiario.getMonto()));
            this.ps.setString(6, libroDiario.getTransaccion());

            System.out.println("libro_diario_insertar: " + libroDiario);

            resultadoInsertar = this.ps.executeUpdate();
            this.conexion.cerrarConexiones();

            if (resultadoInsertar > 0) {
                resultado = "exito";
            } else {
                resultado = "error_insertar_libro_diario";
            }

        } catch (SQLException e) {
            resultado = "error_excepcion";
            System.out.println("Fallo al insertar: " + e.getErrorCode());
            e.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<SubCuentas> obtenerSubCuentas() {
        ArrayList<SubCuentas> listaSubCuentas = new ArrayList<>();
        String sql = "SELECT cod_subcuenta, nombre FROM subcuentas ORDER BY cod_subcuenta";
        try {
            this.accesoDB = conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (rs.next()) {
                SubCuentas subCuenta = new SubCuentas();
                subCuenta.setCod_subcuenta(rs.getString("cod_subcuenta"));
                subCuenta.setNombre_sub(rs.getString("nombre"));
                listaSubCuentas.add(subCuenta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al obtener subcuentas: " + ex.getMessage());
        }
        return listaSubCuentas;
    }

    public int obtenerUltimaPartida() {
        int ultimaPartida = 0;
        String sql = "SELECT MAX(numero_partida) AS ultimaPartida FROM libro_diario";
        try {
            conexion = new Conexion();
            this.accesoDB = conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            if (rs.next()) {
                ultimaPartida = rs.getInt("ultimaPartida");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al consultar la última partida: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (accesoDB != null) {
                    accesoDB.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return ultimaPartida;
    }
// Método para obtener todas las partidas de la base de datos

    public ArrayList<LibroDiario> obtenerTodasLasPartidas() {
        ArrayList<LibroDiario> listaPartidas = new ArrayList<>();
        String sql = """
                 SELECT ld.numero_partida, ld.fecha, ld.cod_subcuenta, s.nombre, ld.concepto, ld.monto, ld.transaccion
                 FROM libro_diario ld
                 INNER JOIN subcuentas s ON ld.cod_subcuenta = s.cod_subcuenta;"""; // Consulta SQL

        try {
            // Obtener la conexión
            this.accesoDB = conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(sql);
            this.rs = this.ps.executeQuery();  // Ejecutar la consulta

            // Iterar a través de los resultados
            while (rs.next()) {
                // Crear un nuevo objeto LibroDiario para cada fila
                LibroDiario libroDiario = new LibroDiario(
                        rs.getInt("numero_partida"), // Número de partida
                        rs.getDate("fecha"), // Fecha
                        rs.getInt("cod_subcuenta"), // Código de subcuenta
                        rs.getString("nombre"), // Nombre de la cuenta
                        rs.getDouble("monto"), // Monto directamente como double
                        rs.getString("transaccion"), // Tipo de transacción
                        rs.getString("concepto") // Concepto
                );

                // Agregar el objeto a la lista
                listaPartidas.add(libroDiario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las partidas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (accesoDB != null) {
                    accesoDB.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaPartidas;  // Retornar la lista de partidas
    }

}

package daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import modelos.LibroDiario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

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

    private static final String MODIFICAR_LIBRO_DIARIO = "";

    private static final String SELECT_LIBRO_POR_ID = "";

    private static final String SELECT_ALL_LIBRO_DIARI = "";

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

    // Método para obtener el último número de partida registrado
    public int obtenerUltimaPartida() {
        int ultimaPartida = 0;
        String sql = "SELECT MAX(numero_partida) AS ultimaPartida FROM libro_diario";
        try {
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

}

package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.BalanceGeneral;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class DaoBalanceGeneral {

    Conexion conexion = new Conexion();
    private ArrayList<BalanceGeneral> listaBalanceGeneral;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;

    private static final String CONSULTAR_BALANZA = "SELECT DISTINCT \n"
            + "    catalogo.codigo,\n"
            + "    catalogo.nombrecuenta,\n"
            + "    (SELECT CAST(SUM(librodiario.monto) AS NUMERIC) AS total_x_cuenta\n"
            + "     FROM librodiario\n"
            + "     WHERE librodiario.codigo = catalogo.codigo\n"
            + "       AND catalogo.cuentatipo = ?) AS total_x_cuenta\n"
            + "FROM catalogo\n"
            + "JOIN librodiario ON catalogo.codigo = librodiario.codigo\n"
            + "WHERE catalogo.cuentatipo = ?\n"
            + "ORDER BY catalogo.codigo;";

    private static final String CONSULTAR_TOTAL = "SELECT CAST(SUM(librodiario.monto) AS NUMERIC) AS total\n"
            + "		 FROM librodiario, catalogo\n"
            + "		 WHERE librodiario.codigo = catalogo.codigo\n"
            + "		 AND catalogo.cuentatipo = ? ";

    private static final String CONSULTAR_TOTAL_ACTIVOS = " SELECT CAST(SUM(librodiario.monto) AS NUMERIC) AS total\n"
            + "		 FROM librodiario, catalogo\n"
            + "		 WHERE librodiario.codigo = catalogo.codigo\n"
            + "		 AND catalogo.cuentatipo < 3;";

    private static final String CONSULTAR_TOTAL_PASIVOS = "SELECT CAST(SUM(librodiario.monto) AS NUMERIC) AS total\n"
            + "		 FROM librodiario, catalogo\n"
            + "		 WHERE librodiario.codigo = catalogo.codigo\n"
            + "		 AND catalogo.cuentatipo >= 3;";

    public ArrayList<BalanceGeneral> CargarBalanceGeneral(int tipo) {

        this.listaBalanceGeneral = new ArrayList();

        try {

            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(CONSULTAR_BALANZA);
            this.ps.setInt(1, tipo);
            this.ps.setInt(2, tipo);
            this.rs = ps.executeQuery();

            BalanceGeneral obj = null;
            while (this.rs.next()) {
                obj = new BalanceGeneral();
                obj.setCodigo(rs.getString("codigo"));
                obj.setCuenta(rs.getString("nombrecuenta"));
                obj.setMonto(Integer.toString(rs.getInt("total_x_cuenta")));
                this.listaBalanceGeneral.add(obj);
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.listaBalanceGeneral;
    }

    public float GetTotal(int tipo) {
        float total = 0;

        try {

            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(CONSULTAR_TOTAL);
            this.ps.setInt(1, tipo);
            this.rs = ps.executeQuery();

            while (this.rs.next()) {
                total = rs.getFloat("total");
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }

    public float GetTotalActivos() {
        float total = 0;

        try {

            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(CONSULTAR_TOTAL_ACTIVOS);
            this.rs = ps.executeQuery();

            while (this.rs.next()) {
                total = rs.getFloat("total");
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }
    
    public float GetTotalPasivos() {
        float total = 0;

        try {

            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(CONSULTAR_TOTAL_PASIVOS);
            this.rs = ps.executeQuery();

            while (this.rs.next()) {
                total = rs.getFloat("total");
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }
    
}

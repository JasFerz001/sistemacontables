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

    private static final String CONSULTAR_BALANZA = "SELECT \n"
            + "s.cod_subcuenta AS codigo, \n"
            + "s.nombre AS nombre_subcuenta, \n"
            + "COALESCE(SUM(CASE \n"
            + "WHEN ld.transaccion = 'Debe' THEN ld.monto::NUMERIC \n"
            + "WHEN ld.transaccion = 'Haber' THEN -ld.monto::NUMERIC \n"
            + "ELSE 0 END), 0) AS saldo\n"
            + "FROM subcuentas s \n"
            + "JOIN cuentas_mayor cm ON s.cod_mayor = cm.cod_mayor\n"
            + "JOIN cuentas_principales cp ON cm.cod_principal = cp.cod_principal\n"
            + "LEFT JOIN libro_diario ld ON s.cod_subcuenta = ld.cod_subcuenta\n"
            + "WHERE cp.nombre = ?\n"
            + "GROUP BY s.cod_subcuenta, s.nombre\n"
            + "ORDER BY s.cod_subcuenta;";

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

    public ArrayList<BalanceGeneral> CargarBalanceGeneral(String tipo) {

        this.listaBalanceGeneral = new ArrayList();

        try {

            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(CONSULTAR_BALANZA);
            this.ps.setString(1, tipo);
            this.rs = ps.executeQuery();

            BalanceGeneral obj = null;
            while (this.rs.next()) {
                obj = new BalanceGeneral();
                obj.setCodigo(rs.getString("codigo"));
                obj.setCuenta(rs.getString("nombre_subcuenta"));
                obj.setMonto(Float.toString(rs.getFloat("saldo")));
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

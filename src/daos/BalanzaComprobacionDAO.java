package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.BalanzaComprobacion;

public class BalanzaComprobacionDAO {

   
    private static final String QUERY_BALANZA = 
        "SELECT " +
        "    s.cod_subcuenta AS codigo, " +
        "    s.nombre AS cuenta, " +
        "    COALESCE(SUM(CASE WHEN ld.transaccion = 'DEBE' THEN ld.monto ELSE 0 END), 0) AS debe, " +
        "    COALESCE(SUM(CASE WHEN ld.transaccion = 'HABER' THEN ld.monto ELSE 0 END), 0) AS haber, " +
        "    COALESCE(SUM(CASE WHEN ld.transaccion = 'DEBE' THEN ld.monto ELSE 0 END), 0) - " +
        "    COALESCE(SUM(CASE WHEN ld.transaccion = 'HABER' THEN ld.monto ELSE 0 END), 0) AS saldodeudor, " +
        "    COALESCE(SUM(CASE WHEN ld.transaccion = 'HABER' THEN ld.monto ELSE 0 END), 0) - " +
        "    COALESCE(SUM(CASE WHEN ld.transaccion = 'DEBE' THEN ld.monto ELSE 0 END), 0) AS saldoacreedor " +
        "FROM " +
        "    subcuentas s " +
        "LEFT JOIN " +
        "    libro_diario ld ON s.cod_subcuenta = ld.cod_subcuenta " +
        "GROUP BY " +
        "    s.cod_subcuenta, s.nombre " +
        "ORDER BY " +
        "    s.cod_subcuenta";

    
    public List<BalanzaComprobacion> obtenerBalanzaComprobacion() {
        List<BalanzaComprobacion> balanza = new ArrayList<>();
        Conexion conexionBD = new Conexion();

        try (Connection conexion = conexionBD.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(QUERY_BALANZA);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BalanzaComprobacion registro = new BalanzaComprobacion(
                    rs.getString("codigo"),
                    rs.getString("cuenta"),
                    rs.getDouble("debe"),
                    rs.getDouble("haber"),
                    rs.getDouble("saldodeudor"),
                    rs.getDouble("saldoacreedor"),
                    rs.getDouble("saldodeudor") - rs.getDouble("saldoacreedor")
                );
                balanza.add(registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balanza;
    }
}

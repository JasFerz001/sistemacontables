/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import modelos.EstadoResultado;
/**
 *
 * @author guill
 */
public class DaoEstadoResultado {

    Conexion conexion;
    private Connection conection;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private EstadoResultado estado;

    public EstadoResultado select_ventas_totales(String fechaInicio, String fechafin){
    String sql = "SELECT \n"
            + "    (ventas - devoluciones - rebajas) AS total_ventas\n"
            + "FROM (\n"
            + "    SELECT \n"
            + "        (SELECT COALESCE(SUM(monto), 0) \n"
            + "         FROM libro_diario \n"
            + "         JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "         JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "         WHERE cuentas_mayor.cod_mayor = '5101'"
            + "         AND fecha BETWEEN ? AND ?) AS ventas,\n"
            + "        (SELECT COALESCE(SUM(monto), 0) \n"
            + "         FROM libro_diario \n"
            + "         JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "         JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "         WHERE cuentas_mayor.cod_mayor = '4103'"
            + "         AND fecha BETWEEN ? AND ?) AS devoluciones,\n"
            + "        (SELECT COALESCE(SUM(monto), 0) \n"
            + "         FROM libro_diario \n"
            + "         JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "         JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "         WHERE cuentas_mayor.cod_mayor = '4104'"
            + "         AND fecha BETWEEN ? AND ?) AS rebajas\n"
            + ") AS ventas_totales;";
    return ventas_Totales(sql, fechaInicio, fechafin);
    }
    private static final String costo_de_venta = "SELECT (inventario_inicial - inventario_final + compras + gastos_compras - devoluciones - rebajas) AS costo_ventas\n"
            + "FROM (SELECT (SELECT COALESCE(SUM(monto), 0) FROM libro_diario  \n"
            + "WHERE cod_subcuenta = '110601' AND fecha BETWEEN ? AND ?) AS inventario_inicial,\n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario\n"
            + " WHERE cod_subcuenta = '110602' AND fecha BETWEEN ? AND ?) AS inventario_final, \n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario \n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor \n"
            + "WHERE cuentas_mayor.cod_mayor = '4101' AND fecha BETWEEN ? AND ?) AS compras,\n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario \n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor \n"
            + "WHERE cuentas_mayor.cod_mayor = '4102' AND fecha BETWEEN ? AND ?) AS gastos_compras, \n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario \n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "WHERE cuentas_mayor.cod_mayor = '5102' AND fecha BETWEEN ? AND ?) AS devoluciones,\n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario\n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "WHERE cuentas_mayor.cod_mayor = '5103' AND fecha BETWEEN ? AND ?) AS rebajas) AS costo_venta;";

    private static final String gastos_administrativos = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS gastos_administrativos\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '4302' AND ld.fecha BETWEEN ? AND ?;";

    private static final String gastos_venta = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS gastos_ventas\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '4301' AND ld.fecha BETWEEN ? AND ?;";

    private static final String ingresos_financieros = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS ingresos_financieros\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '5201' AND ld.fecha BETWEEN ? AND ?;";

    private static final String gastos_financieros = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS gastos_financieros\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '4303' AND ld.fecha BETWEEN ? AND ?;";

    
    
    private EstadoResultado ventas_Totales(String sql,String fecha_Inicio, String fecha_Fin){
        EstadoResultado obj = null;
        try {
            this.conexion = new Conexion();
            this.conexion.getConexion();
            this.conection = conexion.getConexion();
            ps = conection.prepareStatement(sql);
            ps.setString(1, "" + fecha_Inicio + "");
            ps.setString(2, "" + fecha_Fin + "");
            ps.setString(3, "" + fecha_Inicio + "");
            ps.setString(4, "" + fecha_Fin + "");
            ps.setString(5, "" + fecha_Inicio + "");
            ps.setString(6, "" + fecha_Fin + "");
            rs = ps.executeQuery();
            
            if (rs.next()) {
                obj =  new EstadoResultado();
                obj.setVentas_Totales(rs.getString("total_ventas"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if (ps !=null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            conexion.cerrarConexiones();
        }
        return obj;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.LibroMayor;
import modelos.SubCuentas;
import modelos.detallesMayor;




public class DaoMayor {
    
    Conexion conexion;
    private ArrayList<LibroMayor> listaLibroMayor;
    private ArrayList<detallesMayor>listDetalles;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
   
     private static final String Mostar = "SELECT \n" +
"    cm.cod_mayor AS codigo_cuenta_mayor,\n" +
"    cm.nombre AS nombre_cuenta_mayor,\n" +
"    SUM(CASE WHEN ld.transaccion = 'Debe' THEN CAST(ld.monto AS DECIMAL(10,2)) ELSE 0 END) AS debe,\n" +
"    SUM(CASE WHEN ld.transaccion = 'Haber' THEN CAST(ld.monto AS DECIMAL(10,2)) ELSE 0 END) AS haber,\n" +
"    CASE \n" +
"        WHEN cm.naturaleza = 'DEUDOR' THEN \n" +
"            SUM(CASE WHEN ld.transaccion = 'Debe' THEN CAST(ld.monto AS DECIMAL(10,2)) ELSE 0 END) \n" +
"            - \n" +
"            SUM(CASE WHEN ld.transaccion = 'Haber' THEN CAST(ld.monto AS DECIMAL(10,2)) ELSE 0 END)\n" +
"        WHEN cm.naturaleza = 'ACREEDOR' THEN \n" +
"            SUM(CASE WHEN ld.transaccion = 'Haber' THEN CAST(ld.monto AS DECIMAL(10,2)) ELSE 0 END) \n" +
"            - \n" +
"            SUM(CASE WHEN ld.transaccion = 'Debe' THEN CAST(ld.monto AS DECIMAL(10,2)) ELSE 0 END)\n" +
"        ELSE 0\n" +
"    END AS saldo\n" +
"FROM \n" +
"    cuentas_mayor cm\n" +
"JOIN \n" +
"    subcuentas sc ON cm.cod_mayor = sc.cod_mayor\n" +
"JOIN \n" +
"    libro_diario ld ON sc.cod_subcuenta = ld.cod_subcuenta\n" +
"GROUP BY \n" +
"    cm.cod_mayor, cm.nombre, cm.naturaleza\n" +
"ORDER BY \n" +
"    cm.cod_mayor;";
     
     
//    public detallesMayor select_cod_principal(String dato) {
//        String SELECT_SUB = "SELECT \n" +
//"    cm.cod_mayor AS id_cuenta_mayor,\n" +
//"    sc.cod_subcuenta AS id_subcuenta,\n" +
//"    sc.nombre AS nombre_subcuenta,\n" +
//"    ld.numero_partida AS numero_partida,\n" +
//"    ld.fecha AS fecha_agregado,\n" +
//"    ld.concepto AS concepto,\n" +
//"    ld.monto AS monto,\n" +
//"    ld.transaccion AS transaccion\n" +
//"FROM \n" +
//"    cuentas_mayor cm\n" +
//"INNER JOIN \n" +
//"    subcuentas sc ON cm.cod_mayor = sc.cod_mayor\n" +
//"INNER JOIN \n" +
//"    libro_diario ld ON sc.cod_subcuenta = ld.cod_subcuenta\n" +
//"WHERE \n" +
//"    cm.cod_mayor LIKE ?\n" +
//"ORDER BY \n" +
//"    cm.cod_mayor, sc.cod_subcuenta, ld.numero_partida;";
//        return selectSub(SELECT_SUB,dato );
//    }
    

    public DaoMayor() {
        this.conexion = conexion;
    }
     
      public ArrayList<LibroMayor> seleccionaDatos()  {

        this.listaLibroMayor = new ArrayList();

        try {
            this.conexion = new Conexion();
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(Mostar);
            this.rs = ps.executeQuery();

            LibroMayor obj = null;
            while (this.rs.next()) {
                obj = new LibroMayor();
                obj.setCodigo(rs.getString("codigo_cuenta_mayor"));
                obj.setNombre(rs.getString("nombre_cuenta_mayor"));
                
                obj.setDebe(rs.getDouble("debe"));
                obj.setHaber(rs.getDouble("haber"));
                obj.setSaldo(rs.getDouble("saldo"));
                this.listaLibroMayor.add(obj);
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.listaLibroMayor;
    }
      
//          private detallesMayor selectSub(String sql, String dato) {
//        detallesMayor obj = null;
//        try {
//            Connection con = conexion.getConexion();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, "%" + dato + "%");
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                obj = new detallesMayor();
//                obj.setIdMayor(rs.getString("id_cuenta_mayor"));
//                 obj.setIdSubCuenta(rs.getString("id_subcuenta"));
//                 obj.setNombreSub(rs.getString("nombre_subcuenta"));
//                  obj.setPartida(rs.getInt("numero_partida"));
//                obj.setFecha(rs.getDate("fecha_agregado"));
//              
//                obj.setConcepto(rs.getString("concepto"));
//                obj.setMonto(rs.getDouble("monto"));
//                obj.setTransaccion(rs.getString("transaccion"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace(); // Agrega un log adecuado o manejo de errores
//        } finally {
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace(); // Agrega un log adecuado o manejo de errores
//            }
//            conexion.cerrarConexiones();
//        }
//        return obj;
//    }
//     
//      
      
        public ArrayList<Cuenta> buscarCuentasJerarquicas(String busqueda) {
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(
                    "SELECT DISTINCT c.cod_catalogo AS Codigo, c.nombre AS Nombre "
                    + "FROM catalogo c "
                    + "WHERE c.cod_catalogo LIKE ? OR c.nombre LIKE ? "
                    + "UNION ALL "
                    + "SELECT DISTINCT CONCAT(cp.cod_principal) AS Codigo, cp.nombre AS Nombre "
                    + "FROM cuentas_principales cp "
                    + "JOIN catalogo c ON cp.cod_catalogo = c.cod_catalogo "
                    + "WHERE cp.cod_principal LIKE ? OR cp.nombre LIKE ? "
                    + "UNION ALL "
                    + "SELECT DISTINCT CONCAT(cm.cod_mayor) AS Codigo, cm.nombre AS Nombre "
                    + "FROM cuentas_mayor cm "
                    + "JOIN cuentas_principales cp ON cm.cod_principal = cp.cod_principal "
                    + "JOIN catalogo c ON cp.cod_catalogo = c.cod_catalogo "
                    + "WHERE cm.cod_mayor LIKE ? OR cm.nombre LIKE ? "
                    + "UNION ALL "
                    + "SELECT DISTINCT CONCAT(sc.cod_subcuenta) AS Codigo, sc.nombre AS Nombre "
                    + "FROM subcuentas sc "
                    + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor "
                    + "JOIN cuentas_principales cp ON cm.cod_principal = cp.cod_principal "
                    + "JOIN catalogo c ON cp.cod_catalogo = c.cod_catalogo "
                    + "WHERE sc.cod_subcuenta LIKE ? OR sc.nombre LIKE ? "
                    + "ORDER BY Codigo;"
            );

            String queryBusqueda = "%" + busqueda + "%";
            for (int i = 1; i <= 8; i++) {
                this.ps.setString(i, queryBusqueda);
            }

            this.rs = ps.executeQuery();

            Cuenta cuenta;
            while (this.rs.next()) {
                cuenta = new Cuenta();
                cuenta.setCodigo(rs.getString("Codigo"));
                cuenta.setNombre(rs.getString("Nombre"));
                listaCuentas.add(cuenta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.ps != null) {
                    this.ps.close();
                }
                if (this.rs != null) {
                    this.rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.conexion.cerrarConexiones();
        }

        return listaCuentas;
    }
      
      
   
}

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




public class DaoMayor {
    
    Conexion conexion;
    private ArrayList<LibroMayor> listaLibroMayor;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
   
     private static final String Mostar = "SELECT \n" +
"    cm.cod_mayor AS codigo_cuenta_mayor,\n" +
"    cm.nombre AS nombre_cuenta_mayor,\n" +
"    SUM(CASE WHEN ld.transaccion = 'debe' THEN CAST(ld.monto AS NUMERIC) ELSE 0 END) AS debe,\n" +
"    SUM(CASE WHEN ld.transaccion = 'haber' THEN CAST(ld.monto AS NUMERIC) ELSE 0 END) AS haber,\n" +
"    CASE \n" +
"        WHEN cm.naturaleza = 'DEUDOR' THEN \n" +
"            SUM(CASE WHEN ld.transaccion = 'debe' THEN CAST(ld.monto AS NUMERIC) ELSE 0 END) \n" +
"            - \n" +
"            SUM(CASE WHEN ld.transaccion = 'haber' THEN CAST(ld.monto AS NUMERIC) ELSE 0 END)\n" +
"        WHEN cm.naturaleza = 'ACREEDOR' THEN \n" +
"            SUM(CASE WHEN ld.transaccion = 'haber' THEN CAST(ld.monto AS NUMERIC) ELSE 0 END) \n" +
"            - \n" +
"            SUM(CASE WHEN ld.transaccion = 'debe' THEN CAST(ld.monto AS NUMERIC) ELSE 0 END)\n" +
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

    public DaoMayor(Conexion conexion) {
        this.conexion = conexion;
    }
     
      public ArrayList<LibroMayor> seleccionaDatos() throws SQLException, ClassNotFoundException {

        this.listaLibroMayor = new ArrayList();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(Mostar);
            this.rs = ps.executeQuery();

            LibroMayor obj = null;
            while (this.rs.next()) {
                obj = new LibroMayor();
                obj.setCodigo(rs.getString("codigo_cuenta_mayor"));
                obj.setNombre(rs.getString("nombre_cuenta_mayor"));
                
                obj.setDebe(rs.getDouble("debe"));
                obj.setDebe(rs.getDouble("haber"));
                obj.setDebe(rs.getDouble("saldo"));
                this.listaLibroMayor.add(obj);
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.listaLibroMayor;
    }
   
}

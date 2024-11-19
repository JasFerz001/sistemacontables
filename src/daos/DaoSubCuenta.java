/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import modelos.Cuentas_Mayor;
import modelos.SubCuentas;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author guill
 */
public class DaoSubCuenta {

    Conexion conexion;
    private ArrayList<Cuentas_Mayor> listaMayor;
    private ArrayList<SubCuentas> listaSub;

    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private SubCuentas subcuenta;

//    public ArrayList<Cuentas_Mayor> select_nombres_mayor(String dato) {
//        String sql = "SELECT c.nombre AS nombre FROM cuentas_mayor AS c INNER JOIN cuentas_principales As p ON p.cod_principal = c.cod_principal WHERE p.nombre LIKE ?;";
//        //return selectNombres(sql, dato);
//    }

//    public ArrayList<Cuentas_Mayor> selectNombres(String sql, String dato) {
//         
//    }
}

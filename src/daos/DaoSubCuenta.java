/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import java.sql.SQLException;
import modelos.Cuentas_Mayor;
import modelos.SubCuentas;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

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

    public ArrayList<Cuentas_Mayor> select_nombres_mayor(String dato) {
        String sql = "SELECT c.nombre AS nombre FROM cuentas_mayor AS c INNER JOIN cuentas_principales As p ON p.cod_principal = c.cod_principal WHERE p.nombre LIKE ? ORDER BY c.cod_mayor;";
        return selectNombres(sql, dato);
    }

    public Cuentas_Mayor select_cod_mayor(String dato) {
        String sql = "SELECT cod_mayor FROM cuentas_mayor WHERE nombre LIKE ? LIMIT 1;";
        return selectmayor(sql, dato);
    }

    public ArrayList<Cuentas_Mayor> selectNombres(String sql, String dato) {
        ArrayList<Cuentas_Mayor> lista = new ArrayList<>();

        this.conexion = new Conexion();
        this.conexion.getConexion();
        this.accesoDB = conexion.getConexion();
        try (PreparedStatement stmt = accesoDB.prepareStatement(sql)) {

            stmt.setString(1, "%" + dato + "%"); // Preparar el parámetro con LIKE

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cuentas_Mayor cuenta = new Cuentas_Mayor();
                    cuenta.setNombre_Mayor(rs.getString("nombre")); // Asignar el nombre desde el ResultSet
                    lista.add(cuenta);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    private Cuentas_Mayor selectmayor(String sql, String dato) {
        Cuentas_Mayor obj = null;
        try {
            this.conexion = new Conexion();
            this.conexion.getConexion();
            this.accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            ps.setString(1, "%" + dato + "%");
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Cuentas_Mayor();
                obj.setCod_Mayor(rs.getString("cod_mayor"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Agrega un log adecuado o manejo de errores
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Agrega un log adecuado o manejo de errores
            }
            conexion.cerrarConexiones();
        }
        return obj;
    }

}

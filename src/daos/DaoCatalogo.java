/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import modelos.Catalogo;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelos.Cuentas_Mayor;
import modelos.Cuentas_Principales;
import modelos.SubCuentas;

/**
 *
 * @author guill
 */
public class DaoCatalogo {

    Conexion conexion;
    private ArrayList<Catalogo> listaCatalogo;
    private ArrayList<Cuentas_Mayor> listaMayor;
    private ArrayList<Cuentas_Principales> listaPrincipal;
    private ArrayList<SubCuentas> listaSub;

    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Cuentas_Principales cuentasprin;
    private SubCuentas subcuenta;

    private static final String SELECCIONAR_CATALOGO = "SELECT cod_catalogo, nombre FROM catalogo;";
    private static final String SELECT_CUENTA_PRINC = "SELECT cod_principal, nombre FROM cuentas_principales;";

    public Cuentas_Principales select_cod_principal(String dato) {
        String SELECT_ID_PRINC = "SELECT cod_principal FROM cuentas_principales WHERE nombre LIKE ? LIMIT 1;";
        return selectPrincipal(SELECT_ID_PRINC, dato);
    }

    private static final String SELECT_MAYOR = "SELECT * FROM cuentas_mayor;";

    private static final String INSERTAR_MAYOR = "INSERT INTO cuentas_mayor(cod_mayor,"
            + " nombre, naturaleza, cod_principal) VALUES (?,?,?,?)";

    private static final String ACTUALIZAR_MAYOR = "UPDATE cuentas_mayor SET "
            + " cod_mayor =?, nombre =?, naturaleza =?, cod_principal WHERE cod_mayor =?";

    public DaoCatalogo() {
        this.conexion = new Conexion();
    }

    private Cuentas_Principales selectPrincipal(String sql, String dato) {
        Cuentas_Principales obj = null;
        try {
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + dato + "%");
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Cuentas_Principales();
                obj.setCod_Principal(rs.getString("cod_principal"));
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

    public ArrayList<Cuentas_Principales> selectTodoPrincipales() {

        ArrayList<Cuentas_Principales> listaPrin = new ArrayList();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement("SELECT cod_principal, nombre FROM cuentas_principales;");
            this.rs = ps.executeQuery();

            Cuentas_Principales obj = null;
            while (this.rs.next()) {
                obj = new Cuentas_Principales();
                obj.setCod_Principal(rs.getString("cod_principal"));
                obj.setNombre_Principal(rs.getString("nombre"));
                listaPrin.add(obj);
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPrin;
    }

    public ArrayList<Cuentas_Mayor> selectTodoMayor() {

        this.listaMayor = new ArrayList();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(SELECT_MAYOR);
            this.rs = ps.executeQuery();

            Cuentas_Mayor obj = null;
            while (this.rs.next()) {
                obj = new Cuentas_Mayor();
                obj.setCod_Mayor(rs.getString("cod_mayor"));
                obj.setNombre_Mayor(rs.getString("nombre"));
                obj.setNaturaleza(rs.getString("naturaleza"));
                Cuentas_Principales cuentasprinc = new Cuentas_Principales();
                cuentasprinc.setCod_Principal(rs.getString("cod_principal"));
                obj.setCod_principal((cuentasprinc));
                this.listaMayor.add(obj);
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.listaMayor;
    }

    public String insertMayor(Cuentas_Mayor mayor) {

        String resultado;
        int resultado_insertar;
        try {
            this.conexion = new Conexion();
            this.conexion.getConexion();
            this.accesoDB = conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(INSERTAR_MAYOR);

            this.ps.setString(1, mayor.getCod_Mayor());
            this.ps.setString(2, mayor.getNombre_Mayor());
            this.ps.setString(3, mayor.getNaturaleza());
            this.ps.setString(4, mayor.getCod_principal().getCod_Principal());
            System.out.println("servicio_insertar" + mayor);
            resultado_insertar = this.ps.executeUpdate();
            this.conexion.cerrarConexiones();
            if (resultado_insertar > 0) {
                resultado = "exito";
            } else {
                resultado = "error_insertar_servicio";
            }
        } catch (SQLException e) {
            resultado = "error_excepcion";
            System.out.println("fallo insertar" + e.getErrorCode());
            e.printStackTrace();
        }
        return resultado;
    }

    public String updateMayor(Cuentas_Mayor mayor) {
        System.out.println(mayor.getCod_Mayor());
        String resultado;
        int res_actualizar;
        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(ACTUALIZAR_MAYOR);

            this.ps.setString(1, mayor.getCod_Mayor());
            this.ps.setString(2, mayor.getNombre_Mayor());
            this.ps.setString(3, mayor.getNaturaleza());
            this.ps.setString(4, mayor.getCod_principal().getCod_Principal());
            res_actualizar = this.ps.executeUpdate();
            System.out.println(res_actualizar);

            if (res_actualizar > 0) {
                resultado = "exito";
            } else {
                resultado = "error_actualizar";
            }
        } catch (SQLException e) {
            resultado = "error_exception";
            e.printStackTrace();
        }
        return resultado;
    }
}

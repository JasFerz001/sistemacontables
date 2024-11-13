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

/**
 *
 * @author guill
 */
public class DaoCatalogo {

    Conexion conexion;
    private ArrayList<Catalogo> listaCatalogo;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Catalogo catalogo;
    

    private static final String INSERTAR_CATALOGO = "INSERT INTO catalogo(codigo,"
            + " nombrecuenta, cuentatipo) VALUES (?,?,?)";

    private static final String ACTUALIZAR_CATALOGO = "UPDATE catalogo SET  "
            + " codigo =?, nombrecuenta =?, cuentatipo =? WHERE codigo =?";

    private static final String SELECCIONAR_CATALOGO_POR_ID = "SELECT * FROM catalogo WHERE codigo =?";

    private static final String SELECCIONAR_TODO_EL_CATALOGO = "SELECT codigo, nombrecuenta, cuentatipo FROM catalogo ORDER BY codigo ASC;";

    public DaoCatalogo() {
        this.conexion = new Conexion();
    }

    public String insertarCatalogo(Catalogo catalogo) throws SQLException, ClassNotFoundException {

        String resultado;
        int resultado_insertar;
        try {
            this.conexion = new Conexion();
            this.conexion.getConexion();
            this.accesoDB = conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(INSERTAR_CATALOGO);

            this.ps.setInt(0, catalogo.getCodigo());
            this.ps.setString(1, catalogo.getNombreCuenta());
            this.ps.setInt(2, catalogo.getTipoCuenta());
            System.out.println("catalogo_insertar" + catalogo);
            resultado_insertar = this.ps.executeUpdate();
            this.conexion.cerrarConexiones();
            if (resultado_insertar > 0) {
                resultado = "exito";
            } else {
                resultado = "error_insertar_catalogo";
            }
        } catch (SQLException e) {
            resultado = "error_excepcion";
            System.out.println("fallo al insertar" + e.getErrorCode());
            e.printStackTrace();
        }
        return resultado;
    }

    public String actualizarCatalogo(Catalogo catalogo) throws SQLException {
        System.out.println(catalogo.getCodigo());
        String resultado;
        int res_actualizar;
        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(ACTUALIZAR_CATALOGO);

            this.ps.setInt(1, catalogo.getCodigo());
            this.ps.setString(2, catalogo.getNombreCuenta());
            this.ps.setInt(3, catalogo.getTipoCuenta());
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

    public Catalogo findById(int id) throws Exception {

        try {
            Catalogo catalogo = null;
            this.accesoDB = this.conexion.getConexion();
            System.out.println("sql" + id + SELECCIONAR_CATALOGO_POR_ID);
            this.ps = this.accesoDB.prepareStatement(SELECCIONAR_CATALOGO_POR_ID);
            this.ps.setInt(1, id);
            this.rs = ps.executeQuery();
            if (this.rs.next()) {
                catalogo = new Catalogo();
                catalogo.setCodigo(rs.getInt("codigo"));
                catalogo.setNombreCuenta(rs.getString("nombrecuenta"));
                catalogo.setTipoCuenta(rs.getInt("cuentatipo"));
            }

            this.conexion.cerrarConexiones();
            return catalogo;

        } catch (SQLException e) {
            throw new Exception("error en catalogo, metodo FindById " + e.getMessage());
        }
    }

    public ArrayList<Catalogo> seleccionarCatalogo() throws SQLException, ClassNotFoundException {

        this.listaCatalogo = new ArrayList();

        try {
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(SELECCIONAR_TODO_EL_CATALOGO);
            this.rs = ps.executeQuery();

            Catalogo obj = null;
            while (this.rs.next()) {
                obj = new Catalogo();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNombreCuenta(rs.getString("nombrecuenta"));
                obj.setTipoCuenta(rs.getInt("cuentatipo"));
                this.listaCatalogo.add(obj);
            }
            this.conexion.cerrarConexiones();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.listaCatalogo;
    }

}

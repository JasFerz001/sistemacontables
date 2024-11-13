/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author guill
 */
public class Catalogo {
    private int codigo;
    private String nombreCuenta;
    private int tipoCuenta;
    
    
    public Catalogo() {
    }

    public Catalogo(int codigo) {
        this.codigo = codigo;
    }

    public Catalogo(int codigo, String nombreCuenta, int tipoCuenta) {
        this.codigo = codigo;
        this.nombreCuenta = nombreCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.sql.SQLException;
import modelos.CierreContable;

/**
 *
 * @author guill
 */
public class a {

    public static void main(String[] args) throws SQLException {
        CierreContable c = new CierreContable();
        double a = c.obtenerSaldoHaber("5101");
//        System.out.println(a);
//        c.ventasNetas();
//        c.comprasTotales();
//        c.comprasNetas();
//        c.mercaderiaDisponible();
//        c.costoVenta(200000.00);
//        c.utilidadBruta();
//        c.liquidarVentas(a);
//        c.liquidarGastos();
//        c.liquidarOtrosGastos();
//        c.utilidadEjercicio();

        Double s = c.obtenerSaldoHaber("5101");
        System.out.println(s);
    }
}

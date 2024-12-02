/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.DaoEstadoResultado;
import java.util.Date;
import javax.swing.JFrame;
import modelos.EstadoResultado;
import vistas.Catalogos;


/**
 *
 * @author guill
 */
public class MIAU {
//tonto el q lo lea:3
    public static void main(String[] args) {
        EstadoResultado est = new EstadoResultado();
        DaoEstadoResultado dao = new DaoEstadoResultado();
        String fechaInicio = "2024-11-01";
        String fechafin = "2024-11-30";
        
        est = dao.select_ventas_totales(fechaInicio, fechafin);
        System.out.println(est.getVentas_Totales());
        
    }

}

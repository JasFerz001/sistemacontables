/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Controladores.ControladorEstadoResultado;
import daos.DaoEstadoResultado;
import java.util.Date;
import javax.swing.JFrame;
import modelos.EstadoResultado;
import vistas.Catalogos;
import vistas.VistaEstadoResultado;


/**
 *
 * @author guill
 */
public class MIAU {
//tonto el q lo lea:3
    public static void main(String[] args) {
        VistaEstadoResultado v = new VistaEstadoResultado(new JFrame(), true);
        ControladorEstadoResultado c = new ControladorEstadoResultado(v);
        v.iniciar();
    }

}

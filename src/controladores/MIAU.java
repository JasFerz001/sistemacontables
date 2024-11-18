/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.DaoCatalogo;
import javax.swing.JFrame;
import modelos.Cuentas_Principales;
import vistas.Catalogos;

/**
 *
 * @author guill
 */
public class MIAU {

    public static void main(String[] args) {
        Catalogos mia = new Catalogos(new JFrame(), true);
        ControladorMostrarCatalogo ctrl= new ControladorMostrarCatalogo(mia);
        mia.iniciar();
    }

}

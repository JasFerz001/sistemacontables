/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javax.swing.JFrame;
import vistas.Catalogos;


/**
 *
 * @author guill
 */
public class MIAU {
//tonto el q lo lea:3
    public static void main(String[] args) {
        Catalogos miau = new Catalogos(new JFrame(), true);
        ControladorMostrarCatalogo ctrl = new ControladorMostrarCatalogo(miau);
        miau.iniciar();
    }

}

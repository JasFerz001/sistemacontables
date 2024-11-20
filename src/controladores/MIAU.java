/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.DaoCatalogo;
import daos.DaoSubCuenta;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelos.Cuentas_Mayor;
import modelos.Cuentas_Principales;
import vistas.AgregarSubcuenta;
import vistas.Catalogos;

/**
 *
 * @author guill
 */
public class MIAU {

    public static void main(String[] args) {
        AgregarSubcuenta s = new AgregarSubcuenta(new JFrame(), true);
        s.iniciar();
    }

}

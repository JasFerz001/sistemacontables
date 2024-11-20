package controladores;

import Controladores.ControladorLibroMayor;
import Vistas.VistaMayor;
import java.awt.Frame;
import javax.swing.JFrame;
import vistas.Catalogos;
import vistas.Dashboard;

/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

        VistaMayor miua= new VistaMayor(new JFrame(), true);
        ControladorLibroMayor ctr = new ControladorLibroMayor(miua);
        miua.iniciar();
    }
}

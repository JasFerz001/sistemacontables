package controladores;

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

       // Catalogos miua= new Catalogos(new JFrame(), true);
        Dashboard d = new Dashboard();
       // ControladorCatalogo ctrl = new ControladorCatalogo(miua);
        d.iniciar();
    }
}

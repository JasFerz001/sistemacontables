package controladores;

import java.awt.Frame;
import javax.swing.JFrame;
import vistas.AgregarCatalogo;
import vistas.Catalogos;
import vistas.Dashboard;

/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

        AgregarCatalogo miua= new AgregarCatalogo(new JFrame(), true);
        ControladorCatalogo ctrl = new ControladorCatalogo(miua);
        miua.iniciar(); 
    }
}

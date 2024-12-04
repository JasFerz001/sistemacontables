
package Controladores;

import Vistas.VistaBalanzaComprobacion;
import javax.swing.JFrame;

public class testbc {
    public static void main(String[] args) { 
       
      VistaBalanzaComprobacion vista = new VistaBalanzaComprobacion(new JFrame(), true);
       ControladorBalanzaC crt = new ControladorBalanzaC(vista);
       vista.setVisible(true);
    }

}

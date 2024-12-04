package controladores;

import vistas.Dashboard;


/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

        Dashboard principal = new Dashboard();
        principal.setVisible(true);

        Dashboard d = new Dashboard();
        d.iniciar();
    }
}

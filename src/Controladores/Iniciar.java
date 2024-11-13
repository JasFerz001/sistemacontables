package controladores;

import daos.Conexion;
import vistas.Dashboard;

/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }
}

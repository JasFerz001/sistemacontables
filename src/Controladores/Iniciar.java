package controladores;

import Controladores.ControladorBalanceGeneral;
import Vistas.VistaBalanceGeneral;
import daos.Conexion;
import vistas.Dashboard;

/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

//        Dashboard dashboard = new Dashboard();
//        dashboard.setVisible(true);

          ControladorBalanceGeneral control = new ControladorBalanceGeneral();
          control.setModels();
    }
}

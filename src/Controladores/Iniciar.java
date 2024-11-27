package controladores;

import Controladores.ControladorBalanceGeneral;
import Vistas.VistaBalanceGeneral;
import Vistas.Vista_BalanceGeneral;
import daos.Conexion;
import daos.DaoBalanceGeneral;
import java.awt.Frame;
import javax.swing.JFrame;

import vistas.Dashboard;

/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

//        Dashboard dashboard = new Dashboard();
//        dashboard.setVisible(true);

        Dashboard principal = new Dashboard();
        principal.setVisible(true);
    }
}

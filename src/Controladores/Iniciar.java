package controladores;

import Controladores.ControladorBalanceGeneral;
import Vistas.VistaBalanceGeneral;
import Vistas.Vista_BalanceGeneral;
import daos.Conexion;
import daos.DaoBalanceGeneral;
import vistas.Dashboard;

/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

        DaoBalanceGeneral dao = new DaoBalanceGeneral();
        VistaBalanceGeneral vista = new VistaBalanceGeneral();
        vista.setVisible(true);
//        Dashboard dashboard = new Dashboard();
//        dashboard.setVisible(true);

          ControladorBalanceGeneral control = new ControladorBalanceGeneral(vista);
          control.setModels();
    }
}

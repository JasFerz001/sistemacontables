package controladores;

import Controladores.ControladorLibroMayor;
import Vistas.VistaMayor;
import javax.swing.JFrame;

import vistas.Dashboard;

import Controladores.ControladorLogin;
import Vistas.Login;





/**
 *
 * @author kevin
 */
public class Iniciar {

    public static void main(String[] args) {

        Login login = new Login();
        ControladorLogin ctrl = new ControladorLogin(login);
        login.setVisible(true);    

    }
}

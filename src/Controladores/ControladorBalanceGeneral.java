package Controladores;

import Vistas.VistaBalanceGeneral;
import daos.Conexion;
import daos.DaoBalanceGeneral;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.BalanceGeneral;

/**
 *
 * @author Luis
 */
public class ControladorBalanceGeneral {

    int activo = 0, aN = 1, pasivo = 2, pN = 3, patrimonio = 4;
    int tamaño = 0;

    VistaBalanceGeneral vista = new VistaBalanceGeneral();
    DaoBalanceGeneral dao = new DaoBalanceGeneral();

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();

    ArrayList<BalanceGeneral> listaActivos = new ArrayList();
    ArrayList<BalanceGeneral> lisAcNocorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivos = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivosNoCorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPatrimonio = new ArrayList();

    Conexion con = new Conexion();
    
    public void setModels(){
        //--para mostrar activos
        dtm.addColumn("Activos");
        dtm.addColumn("Total Activos");
        dtm.addColumn("Total:");
        vista.tabla_activos.setModel(dtm);

        //--para mostrar pasivos
        dtm2.addColumn("Pasivos");
        dtm2.addColumn("Total Pasivos");
        dtm2.addColumn("Total:");
        vista.tabla_pasivos.setModel(dtm2);

       listaActivos=dao.CargarBalanceGeneral(1);
       lisAcNocorrientes=dao.CargarBalanceGeneral(aN);
       listaPasivos=dao.CargarBalanceGeneral(pasivo);;  
       listaPasivosNoCorrientes=dao.CargarBalanceGeneral(pN);
       listaPatrimonio=dao.CargarBalanceGeneral(patrimonio);
    }

    public void agregarATabla() {

//        int aux = 0;
//        dtm.addRow(new Object[]{"Activo Corriente", " ", " "});
//        for (int i = 0; i < listaActivos.size(); i++) {
//
//            dtm.addRow(new Object[]{listaActivos.get(i).getCuenta(), listaActivos.get(i).getMonto(), " "});
//        }
//        dtm.addRow(new Object[]{"Activo No Corriente", " ", " "});
//        for (int i = 0; i < lisAcNocorrientes.size(); i++) {
//            dtm.addRow(new Object[]{lisAcNocorrientes.get(i).getCuenta(), lisAcNocorrientes.get(i).getMonto(), " "});
//        }
//
//        //-----añadiendo pasivos y patrimonio si esque hay
//        dtm2.addRow(new Object[]{"Pasivo Corriente", " ", " "});
//        for (int i = 0; i < listaPasivos.size(); i++) {
//            dtm2.addRow(new Object[]{listaPasivos.get(i).getCuenta(), listaPasivos.get(i).getMonto(), " "});
//        }
//        dtm2.addRow(new Object[]{"Pasivo No Corriente", " ", " "});
//        for (int i = 0; i < listaPasivosNoCorrientes.size(); i++) {
//            dtm2.addRow(new Object[]{listaPasivosNoCorrientes.get(i).getCuenta(), listaPasivosNoCorrientes.get(i).getMonto(), " "});
//        }
//        //--añadiendo cuentas de patrimonio
//        dtm2.addRow(new Object[]{"Patrimonio", " ", " "});
//        if (!listaPatrimonio.isEmpty()) {
//            for (int i = 0; i < listaPatrimonio.size(); i++) {
//                dtm2.addRow(new Object[]{listaPatrimonio.get(i).getCuenta(), listaPatrimonio.get(i).getMonto(), " "});
//            }
//        }
    }

    public ControladorBalanceGeneral() {
    }
}

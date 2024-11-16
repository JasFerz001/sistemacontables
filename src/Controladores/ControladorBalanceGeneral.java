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

    String activo = "Activo Corriente", aN = "Activo No Corriente", pasivo = "Pasivo Corriente", pN = "Pasivo No Corriente", patrimonio = "Capital Contable";
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
        
        vista.setVisible(true);
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

       listaActivos=dao.CargarBalanceGeneral(activo);
       lisAcNocorrientes=dao.CargarBalanceGeneral(aN);
       listaPasivos=dao.CargarBalanceGeneral(pasivo);;  
       listaPasivosNoCorrientes=dao.CargarBalanceGeneral(pN);
       listaPatrimonio=dao.CargarBalanceGeneral(patrimonio);
       
       agregarATabla();
    }

    public void agregarATabla() {
        int aux = 0;
        
        //CONSULTAR EL TOTAL DE ACTIVOS CORRIENTES
//        float total_AC = dao.GetTotal(activo);
        //CONSULTAR CADA CUENTA DE ACTIVOS CORRIENTES
        dtm.addRow(new Object[]{"Activo Corriente", " ", "Agregar total"});
        for (int i = 0; i < listaActivos.size(); i++) {
            dtm.addRow(new Object[]{listaActivos.get(i).getCuenta(), listaActivos.get(i).getMonto(), " "});
        }
        
        //CONSULTAR EL TOTAL DE ACTIVOS NO CORRIENTES
//        float total_ANC = dao.GetTotal(aN);
        //CONSULTAR CADA CUENTA DE ACTIVOS NO CORRIENTES
        dtm.addRow(new Object[]{"Activo No Corriente", " ", "Agregar total"});
        for (int i = 0; i < lisAcNocorrientes.size(); i++) {
            dtm.addRow(new Object[]{lisAcNocorrientes.get(i).getCuenta(), lisAcNocorrientes.get(i).getMonto(), " "});
        }

        //CONSULTAR EL TOTAL DE PASIVOS CORRIENTES
//        float total_PC = dao.GetTotal(pasivo);
        //CONSULTAR CADA CUENTA DE PASIVOS CORRIENTES
        dtm2.addRow(new Object[]{"Pasivo Corriente", " ", "Agregar total"});
        for (int i = 0; i < listaPasivos.size(); i++) {
            dtm2.addRow(new Object[]{listaPasivos.get(i).getCuenta(), listaPasivos.get(i).getMonto(), " "});
        }
        
        //CONSULTAR EL TOTAL DE PASIVOS NO CORRIENTES
//        float total_PNC = dao.GetTotal(pN);
        //CONSULTAR CADA CUENTA DE PASIVOS CORRIENTES
        dtm2.addRow(new Object[]{"Pasivo No Corriente", " ", "Agregar total"});
        for (int i = 0; i < listaPasivosNoCorrientes.size(); i++) {
            dtm2.addRow(new Object[]{listaPasivosNoCorrientes.get(i).getCuenta(), listaPasivosNoCorrientes.get(i).getMonto(), " "});
        }
        
        //CONSULTAR EL TOTAL DE CAPITAL
//        float total_CAP = dao.GetTotal(patrimonio);
        //CONSULTAR CADA CUENTA DE TOTAL DE CAPITAL
        dtm2.addRow(new Object[]{"Patrimonio", " ", "Agregar total"});
        if (!listaPatrimonio.isEmpty()) {
            for (int i = 0; i < listaPatrimonio.size(); i++) {
                dtm2.addRow(new Object[]{listaPatrimonio.get(i).getCuenta(), listaPatrimonio.get(i).getMonto(), " "});
            }
        }
        
        
//        float total_activos = dao.GetTotalActivos();
//        float total_pasivos = dao.GetTotalPasivos();
//        
//        vista.totalActivos.setText(Float.toString(total_activos));
//        vista.totalPasivos.setText(Float.toString(total_pasivos));
    }
}

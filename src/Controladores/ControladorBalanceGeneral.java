package Controladores;

import Vistas.VistaBalanceGeneral;
import daos.Conexion;
import daos.DaoBalanceGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import modelos.BalanceGeneral;

/**
 *
 * @author Luis
 */
public class ControladorBalanceGeneral implements ActionListener {
    Calendar calendario = Calendar.getInstance();
    int anio = calendario.get(Calendar.YEAR);

    String activo = "ACTIVO CORRIENTE", aN = "ACTIVO NO CORRIENTE", pasivo = "PASIVO CORRIENTE", pN = "PASIVO NO CORRIENTE", patrimonio = "CAPITAL CONTABLE";
    int tamaño = 0 ;

    VistaBalanceGeneral vista = new VistaBalanceGeneral();
    DaoBalanceGeneral dao = new DaoBalanceGeneral();

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();

    ArrayList<BalanceGeneral> listaActivos = new ArrayList();
    ArrayList<BalanceGeneral> lisAcNocorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivos = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivosNoCorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPatrimonio = new ArrayList();

    float ResEjercicio = (float) 0;

    Conexion con = new Conexion();

    public ControladorBalanceGeneral(VistaBalanceGeneral v) {
        this.vista = v;
        this.vista.Btn_Guardar.addActionListener(this);
    }

    public void setModels() {

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

        listaActivos = dao.CargarBalanceGeneralActivos(activo, anio);
        lisAcNocorrientes = dao.CargarBalanceGeneralActivos(aN, anio);
        listaPasivos = dao.CargarBalanceGeneralPasivos(pasivo, anio);
        listaPasivosNoCorrientes = dao.CargarBalanceGeneralPasivos(pN, anio);
        listaPatrimonio = dao.CargarBalanceGeneralPasivos(patrimonio, anio);

        agregarATabla();
    }

    public void agregarATabla() {
        int aux = 0;

        //CONSULTAR EL TOTAL DE ACTIVOS CORRIENTES
        float total_AC = dao.GetTotalCuentasActivo(activo, anio);
        //CONSULTAR CADA CUENTA DE ACTIVOS CORRIENTES
        dtm.addRow(new Object[]{"ACTIVO CORRIENTE", " ", total_AC});
        for (int i = 0; i < listaActivos.size(); i++) {
            dtm.addRow(new Object[]{listaActivos.get(i).getCuenta(), listaActivos.get(i).getMonto(), " "});
        }

        //CONSULTAR EL TOTAL DE ACTIVOS NO CORRIENTES
        float total_ANC = dao.GetTotalCuentasActivo(aN, anio);
        //CONSULTAR CADA CUENTA DE ACTIVOS NO CORRIENTES
        dtm.addRow(new Object[]{"ACTIVO NO CORRIENTE", " ", total_ANC});
        for (int i = 0; i < lisAcNocorrientes.size(); i++) {
            dtm.addRow(new Object[]{lisAcNocorrientes.get(i).getCuenta(), lisAcNocorrientes.get(i).getMonto(), " "});
        }

        //CONSULTAR EL TOTAL DE PASIVOS CORRIENTES
        float total_PC = dao.GetTotalCuentasPasivo(pasivo, anio);
        //CONSULTAR CADA CUENTA DE PASIVOS CORRIENTES
        dtm2.addRow(new Object[]{"PASIVO CORRIENTE", " ", total_PC});
        for (int i = 0; i < listaPasivos.size(); i++) {
            dtm2.addRow(new Object[]{listaPasivos.get(i).getCuenta(), listaPasivos.get(i).getMonto(), " "});
        }

        //CONSULTAR EL TOTAL DE PASIVOS NO CORRIENTES
        float total_PNC = dao.GetTotalCuentasPasivo(pN, anio);
        //CONSULTAR CADA CUENTA DE PASIVOS CORRIENTES
        dtm2.addRow(new Object[]{"PASIVO NO CORRIENTE", " ", total_PNC});
        for (int i = 0; i < listaPasivosNoCorrientes.size(); i++) {
            dtm2.addRow(new Object[]{listaPasivosNoCorrientes.get(i).getCuenta(), listaPasivosNoCorrientes.get(i).getMonto(), " "});
        }

        //CONSULTAR EL TOTAL DE CAPITAL
        float total_CAP = dao.GetTotalCuentasPasivo(patrimonio, anio);
        //CONSULTAR CADA CUENTA DE TOTAL DE CAPITAL
        dtm2.addRow(new Object[]{"CAPITAL CONTABLE", " ", total_CAP});
        if (!listaPatrimonio.isEmpty()) {
            for (int i = 0; i < listaPatrimonio.size(); i++) {
                dtm2.addRow(new Object[]{listaPatrimonio.get(i).getCuenta(), listaPatrimonio.get(i).getMonto(), " "});
            }
        }
        dtm2.addRow(new Object[]{"Resultado del ejercicio", ResEjercicio, " "});

        float total_activos = dao.GetTotalActivos(anio);
        float total_pasivos = dao.GetTotalPasivos(anio) + ResEjercicio;

        vista.totalActivos.setText(Float.toString(total_activos));
        vista.totalPasivos.setText(Float.toString(total_pasivos));
    }

    public Boolean GuardarBalance() {

        int rowActivo = vista.tabla_activos.getModel().getRowCount();
        int columnActivo = vista.tabla_activos.getModel().getColumnCount();

        int rowPasivo = vista.tabla_pasivos.getModel().getRowCount();
        int columnPasivo = vista.tabla_pasivos.getModel().getColumnCount();

        int n = dao.GetNBalance();

        dao.IniciarBalanceGeneral(n, anio);

        float totalActivoCorriente = 0, totalActivoNoCorriente = 0,
                totalPasivoCorriente = 0, totalPasivoNoCorriente = 0,
                totalPatrimonio = 0, totalActivo = Float.parseFloat(vista.totalActivos.getText()), totalPasivo = Float.parseFloat(vista.totalPasivos.getText());

        for (int i = 0; i < rowActivo; i++) {
            for (int j = 0; j < columnActivo; j++) {
                if (vista.tabla_activos.getValueAt(i, j) == "Activo Corriente") {
                    totalActivoCorriente = Float.parseFloat(String.valueOf(vista.tabla_activos.getValueAt(i, j + 2)));
                    j = j + 2;
                } else if (vista.tabla_activos.getValueAt(i, j) == "Activo No Corriente") {
                    totalActivoNoCorriente = Float.parseFloat(String.valueOf(vista.tabla_activos.getValueAt(i, j + 2)));
                    j = j + 2;
                } else {
                    if (vista.tabla_activos.getValueAt(i, j) != " ") {
                        dao.IngresardetallesBalanceGeneral(String.valueOf(vista.tabla_activos.getValueAt(i, j)), Float.parseFloat(String.valueOf(vista.tabla_activos.getValueAt(i, j + 1))), n);
                        j = j + 1;
                    }
                }
            }
        }

        for (int i = 0; i < rowPasivo; i++) {
            for (int j = 0; j < columnPasivo; j++) {
                if (vista.tabla_pasivos.getValueAt(i, j) == "Pasivo Corriente") {
                    totalPasivoCorriente = Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 2)));
                    j = j + 2;
                } else if (vista.tabla_pasivos.getValueAt(i, j) == "Pasivo No Corriente") {
                    totalPasivoNoCorriente = Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 2)));
                    j = j + 2;
                } else if (vista.tabla_pasivos.getValueAt(i, j) == "Patrimonio") {
                    totalPatrimonio = Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 2)));
                    j = j + 2;
                } else {
                    if (vista.tabla_pasivos.getValueAt(i, j) != " ") {
                        dao.IngresardetallesBalanceGeneral(String.valueOf(vista.tabla_pasivos.getValueAt(i, j)), Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 1))), n);
                        j = j + 1;
                    }
                }
            }
        }

        dao.IngresarTotalesBalanceGeneral(totalActivoCorriente, totalActivoNoCorriente, totalPasivoCorriente, totalPasivoNoCorriente, totalPatrimonio, totalActivo, totalPasivo, n);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.Btn_Guardar) {
            GuardarBalance();
        }
    }
}

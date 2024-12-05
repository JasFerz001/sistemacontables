package Controladores;

import Reportes.Jasper;
import javax.swing.JFrame;
import Vistas.VistaBalanceGenerales;
import daos.Conexion;
import daos.DaoBalanceGeneral;
import daos.DaoEstadoResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.BalanceGeneral;
import modelos.EstadoResultado;

/**
 *
 * @author Luis
 */


public class ControladorBalanceGeneral implements ActionListener {

    Calendar calendario = Calendar.getInstance();
    int anio = calendario.get(Calendar.YEAR);

    String activo = "ACTIVO CORRIENTE", aN = "ACTIVO NO CORRIENTE", pasivo = "PASIVO CORRIENTE", pN = "PASIVO NO CORRIENTE", patrimonio = "CAPITAL CONTABLE";
    int tamaño = 0;

    VistaBalanceGenerales vista = new VistaBalanceGenerales(new JFrame(), true);
    DaoBalanceGeneral dao = new DaoBalanceGeneral();
    
    DaoEstadoResultado daoResultado = new DaoEstadoResultado();
    EstadoResultado estado = new EstadoResultado();

    Jasper jasper = new Jasper();

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();

    ArrayList<BalanceGeneral> listaActivos = new ArrayList();
    ArrayList<BalanceGeneral> lisAcNocorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivos = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivosNoCorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPatrimonio = new ArrayList();

    float ResEjercicio;

    Conexion con = new Conexion();

    public ControladorBalanceGeneral(VistaBalanceGenerales v) {
        this.vista = v;
        this.vista.Btn_Guardar.addActionListener(this);
        this.vista.Btn_Imprimir.addActionListener(this);
    }

    public void setModels() {

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

        String exito = "";

        dao.IniciarBalanceGeneral(n, anio);

        if (exito == "fracaso") {
            JOptionPane.showMessageDialog(vista, "hola");
        }

        float totalActivoCorriente = 0, totalActivoNoCorriente = 0,
                totalPasivoCorriente = 0, totalPasivoNoCorriente = 0,
                totalPatrimonio = 0, totalActivo = Float.parseFloat(vista.totalActivos.getText()), totalPasivo = Float.parseFloat(vista.totalPasivos.getText());

        int tipo_cuenta = 0;

        for (int i = 0; i < rowActivo; i++) {
            for (int j = 0; j < columnActivo; j++) {
                if (vista.tabla_activos.getValueAt(i, j) == "ACTIVO CORRIENTE") {
                    totalActivoCorriente = Float.parseFloat(String.valueOf(vista.tabla_activos.getValueAt(i, j + 2)));
                    j = j + 2;
                    tipo_cuenta = 1;
                } else if (vista.tabla_activos.getValueAt(i, j) == "ACTIVO NO CORRIENTE") {
                    totalActivoNoCorriente = Float.parseFloat(String.valueOf(vista.tabla_activos.getValueAt(i, j + 2)));
                    j = j + 2;
                    tipo_cuenta = 2;
                } else {
                    if (vista.tabla_activos.getValueAt(i, j) != " ") {
                        if (tipo_cuenta > 0) {
                            exito = dao.IngresardetallesBalanceGeneral(String.valueOf(vista.tabla_activos.getValueAt(i, j)), Float.parseFloat(String.valueOf(vista.tabla_activos.getValueAt(i, j + 1))), n, tipo_cuenta);
                            j = j + 1;
                        }
                    }
                }
            }
        }

        if (exito == "fracaso") {
            JOptionPane.showMessageDialog(vista, "Error al guardar detalles del activo");
            return false;
        }

        for (int i = 0; i < rowPasivo; i++) {
            for (int j = 0; j < columnPasivo; j++) {
                if (vista.tabla_pasivos.getValueAt(i, j) == "PASIVO CORRIENTE") {
                    totalPasivoCorriente = Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 2)));
                    j = j + 2;
                    tipo_cuenta = 3;
                } else if (vista.tabla_pasivos.getValueAt(i, j) == "PASIVO NO CORRIENTE") {
                    totalPasivoNoCorriente = Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 2)));
                    j = j + 2;
                    tipo_cuenta = 4;
                } else if (vista.tabla_pasivos.getValueAt(i, j) == "CAPITAL CONTABLE") {
                    totalPatrimonio = Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 2)));
                    j = j + 2;
                    tipo_cuenta = 5;
                } else {
                    if (vista.tabla_pasivos.getValueAt(i, j) != " ") {
                        if (tipo_cuenta > 2) {
                            exito = dao.IngresardetallesBalanceGeneral(String.valueOf(vista.tabla_pasivos.getValueAt(i, j)), Float.parseFloat(String.valueOf(vista.tabla_pasivos.getValueAt(i, j + 1))), n, tipo_cuenta);
                            j = j + 1;
                        }
                    }
                }
            }
        }

        if (exito == "fracaso") {
            JOptionPane.showMessageDialog(vista, "Error al guardar detalles del pasivo");
            return false;
        }

        dao.IngresarTotalesBalanceGeneral(totalActivoCorriente, totalActivoNoCorriente, totalPasivoCorriente, totalPasivoNoCorriente, totalPatrimonio, totalActivo, totalPasivo, n);

        JOptionPane.showMessageDialog(vista, "Balance guardado con éxito");

        return true;

    }

    public void iniciar() {
        vista.setLocationRelativeTo(vista);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.Btn_Guardar) {
            GuardarBalance();
        } else if (e.getSource() == vista.Btn_Imprimir) {
            vista.setVisible(false);
            jasper.Reporte(1);
        }
    }
    
    
        public void generar() {
        estado = new EstadoResultado();
        String fc_inicio = "2024-01-01";
        String fc_fin = "2024-12-30";
        float ivfinal = (float) 200000.00;
        estado = (daoResultado.select_ventas_totales(fc_inicio, fc_fin));
        String vn = estado.getVentas_Totales();

        estado = (daoResultado.select_costo_de_venta(fc_inicio, fc_fin));
        String cv = estado.getCosto_Ventas();
        
        float utilidadBruta = (Float.parseFloat(vn) - (Float.parseFloat(cv) - ivfinal));
        System.out.println(utilidadBruta);

        estado = daoResultado.select_gastos_admin(fc_inicio, fc_fin);
        String ga = estado.getGastos_Admin();
        
        estado = daoResultado.select_gasto_venta(fc_inicio, fc_fin);
        String gv = estado.getGastos_Ventas();
        
        float utilidadOperacion = utilidadBruta - (Float.parseFloat(ga) + Float.parseFloat(gv));
        
        EstadoResultado e = new EstadoResultado();
        e = daoResultado.select_ingresos_finan(fc_inicio, fc_fin);
        String inf = e.getIngresos_Finan();
        
        estado = daoResultado.select_gasto_finan(fc_inicio, fc_fin);
        String gf = estado.getGastos_Finan();
        
        float utilidadAntes;
        if (Float.parseFloat(inf) == Float.parseFloat(gf)) {
            utilidadAntes = utilidadOperacion;
            
        } else if (Float.parseFloat(inf) < Float.parseFloat(gf)) {
            utilidadAntes = utilidadOperacion - (Float.parseFloat(inf) - Float.parseFloat(gf));
            
        } else {
            utilidadAntes = utilidadOperacion + (Float.parseFloat(inf) - Float.parseFloat(gf));
            
        }

        float ventas = Float.parseFloat(daoResultado.select_ventas(fc_inicio, fc_fin));
        System.out.println(ventas);

        float isr;
        float reservaLegal;
        if (ventas < 1500000) {
            isr = (float) (utilidadAntes * 0.25);
            reservaLegal = (float) ((utilidadAntes - isr) * 0.07);
            //this.frmResultado.isr.setText("$" + isr);
            //this.frmResultado.reservaLegal.setText("$" + reservaLegal);
            float ue = utilidadAntes - isr - reservaLegal;
            ResEjercicio = ue;
        } else {
            isr = (float) (utilidadAntes * 0.30);
            //this.frmResultado.isr.setText("$" + isr);
            reservaLegal = (float) ((utilidadAntes - isr) * 0.07);
            //this.frmResultado.reservaLegal.setText("$" + reservaLegal);
            float ue = utilidadAntes - isr - reservaLegal;
            ResEjercicio = ue;
        }

    }
}

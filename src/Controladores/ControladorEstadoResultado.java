/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Reportes.Jasper;
import daos.DaoEstadoResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.crypto.AEADBadTagException;
import modelos.EstadoResultado;
import vistas.VistaEstadoResultado;

/**
 *
 * @author guill
 */
public class ControladorEstadoResultado extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener {

    VistaEstadoResultado frmResultado;
    DaoEstadoResultado daoResultado;
    EstadoResultado estado;
    
    Jasper jasper = new Jasper();
    
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public ControladorEstadoResultado(VistaEstadoResultado frmResultado) {
        this.frmResultado = frmResultado;
        this.frmResultado.generar.addActionListener(this);
        this.frmResultado.salir.addActionListener(this);
        this.frmResultado.reporte.addActionListener(this);
        daoResultado = new DaoEstadoResultado();
        estado = new EstadoResultado();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmResultado.generar) {
            generar();
        }
        if (e.getSource() == this.frmResultado.salir) {
            salir();
        }
        if(e.getSource() == this.frmResultado.reporte){
            frmResultado.setVisible(false);
            jasper.Reporte(3);
        }
    }

    public void generar() {
        estado = new EstadoResultado();
        float ivfinal = Float.parseFloat(this.frmResultado.inventariofinal.getText());
        estado = (daoResultado.select_ventas_totales());
        String vn = estado.getVentas_Totales();
        this.frmResultado.ventasNetas.setText("$" + estado.getVentas_Totales());

        estado = (daoResultado.select_costo_de_venta());
        String cv = estado.getCosto_Ventas();
        this.frmResultado.costoVendido.setText("$" + (Float.parseFloat(estado.getCosto_Ventas()) - ivfinal));

        float a = (Float.parseFloat(vn) - (Float.parseFloat(cv) - ivfinal));
        
        float utilidadBruta = Float.parseFloat(String.format("%.2f", a));
        System.out.println(utilidadBruta);
        this.frmResultado.utilidadBruta.setText("$" + utilidadBruta);
        
        estado = daoResultado.select_gastos_admin();
        String ga = estado.getGastos_Admin();
        this.frmResultado.gastosAdmin.setText("$" + ga);

        estado = daoResultado.select_gasto_venta();
        String gv = estado.getGastos_Ventas();
        this.frmResultado.gastoVentas.setText("$" + gv);

        
        float b = utilidadBruta - (Float.parseFloat(ga) + Float.parseFloat(gv));
        
        float utilidadOperacion = Float.parseFloat(String.format("%.2f", b));
        this.frmResultado.utilidadOperacion.setText("$" + utilidadOperacion);

        EstadoResultado e = new EstadoResultado();
        e = daoResultado.select_ingresos_finan();
        String inf = e.getIngresos_Finan();
        this.frmResultado.ingresosFinancieros.setText("$" + inf);
        estado = daoResultado.select_gasto_finan();
        String gf = estado.getGastos_Finan();
        this.frmResultado.gastosFinancieros.setText("$" + gf);
        float utilidadAntes;
        if (Float.parseFloat(inf) == Float.parseFloat(gf)) {
            utilidadAntes = utilidadOperacion;
            this.frmResultado.utilidadAntes.setText("$" + utilidadAntes);
        } else if (Float.parseFloat(inf) < Float.parseFloat(gf)) {
            utilidadAntes = utilidadOperacion - (Float.parseFloat(inf) - Float.parseFloat(gf));
            this.frmResultado.utilidadAntes.setText("$" + utilidadAntes);
        } else {
            utilidadAntes = utilidadOperacion + (Float.parseFloat(inf) - Float.parseFloat(gf));
            this.frmResultado.utilidadAntes.setText("$" + utilidadAntes);
        }

        float ventas = Float.parseFloat(daoResultado.select_ventas());
        System.out.println(ventas);

        float isr;
        float reservaLegal;
        if (ventas < 1500000) {
            float c = (float) ((utilidadAntes) * 0.07);
            reservaLegal = Float.parseFloat(String.format("%.2f", c));
            
            float d = (float) ((utilidadAntes - reservaLegal) * 0.25);
            isr = Float.parseFloat(String.format("%.2f", d));
            this.frmResultado.isr.setText("$" + isr);
            this.frmResultado.reservaLegal.setText("$" + reservaLegal);
            float ue = utilidadAntes - isr - reservaLegal;
            this.frmResultado.utilidadEjercicio.setText("$" + ue);
        } else {
            reservaLegal = (float) ((utilidadAntes) * 0.07);
            isr = (float) ((utilidadAntes -reservaLegal) * 0.30);
            this.frmResultado.isr.setText("$" + isr);
            this.frmResultado.reservaLegal.setText("$" + reservaLegal);
            float ue = utilidadAntes - isr - reservaLegal;
            this.frmResultado.utilidadEjercicio.setText("$" + ue);
        }

    }

    public void salir() {
        this.frmResultado.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}

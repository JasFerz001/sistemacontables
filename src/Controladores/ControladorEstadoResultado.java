/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import daos.DaoEstadoResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
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

    public ControladorEstadoResultado(VistaEstadoResultado frmResultado) {
        this.frmResultado = frmResultado;
        this.frmResultado.generar.addActionListener(this);
        this.frmResultado.salir.addActionListener(this);
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
    }

    public void generar() {
        estado = new EstadoResultado();
        String fc_inicio = "2024-01-01";
        String fc_fin = "2024-12-30";
        float ivfinal = Float.parseFloat(this.frmResultado.inventariofinal.getText());
        estado = (daoResultado.select_ventas_totales(fc_inicio, fc_fin));
        String vn = estado.getVentas_Totales();
        this.frmResultado.ventasNetas.setText("$" + estado.getVentas_Totales());

        estado = (daoResultado.select_costo_de_venta(fc_inicio, fc_fin));
        String cv = estado.getCosto_Ventas();
        this.frmResultado.costoVendido.setText("$" + (Float.parseFloat(estado.getCosto_Ventas()) - ivfinal));

        float utilidadBruta = (Float.parseFloat(vn) - (Float.parseFloat(cv) - ivfinal));
        System.out.println(utilidadBruta);
        this.frmResultado.utilidadBruta.setText("$" + utilidadBruta);
        
        estado = daoResultado.select_gastos_admin(fc_inicio, fc_fin);
        String ga = estado.getGastos_Admin();
        this.frmResultado.gastosAdmin.setText("$" + ga);

        estado = daoResultado.select_gasto_venta(fc_inicio, fc_fin);
        String gv = estado.getGastos_Ventas();
        this.frmResultado.gastoVentas.setText("$" + gv);

        float utilidadOperacion = utilidadBruta - (Float.parseFloat(ga) + Float.parseFloat(gv));
        this.frmResultado.utilidadOperacion.setText("$" + utilidadOperacion);

        EstadoResultado e = new EstadoResultado();
        e = daoResultado.select_ingresos_finan(fc_inicio, fc_fin);
        String inf = e.getIngresos_Finan();
        this.frmResultado.ingresosFinancieros.setText("$" + inf);
        estado = daoResultado.select_gasto_finan(fc_inicio, fc_fin);
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

        float ventas = Float.parseFloat(daoResultado.select_ventas(fc_inicio, fc_fin));
        System.out.println(ventas);

        float isr;
        float reservaLegal;
        if (ventas < 1500000) {
            reservaLegal = (float) ((utilidadAntes) * 0.07);
            isr = (float) ((utilidadAntes -reservaLegal) * 0.25);
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

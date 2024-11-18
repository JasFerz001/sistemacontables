/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.DaoCatalogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Catalogos;
import modelos.Catalogo;
import modelos.Cuentas_Mayor;
import modelos.Cuentas_Principales;
import vistas.AgregarCatalogo;

/**
 *
 * @author guill
 */
public class ControladorCatalogo extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener {

    AgregarCatalogo frmCatalogo;
    DaoCatalogo daoCatalogo;
    Cuentas_Mayor mayor;

    public ControladorCatalogo(AgregarCatalogo frmCatalogo) {
        this.frmCatalogo = frmCatalogo;
        this.frmCatalogo.registrar.addActionListener(this);
        this.frmCatalogo.cancelar.addActionListener(this);
        this.frmCatalogo.salir.addActionListener(this);
        daoCatalogo = new DaoCatalogo();
    }

    public ControladorCatalogo(AgregarCatalogo frmCatalogo, Cuentas_Mayor mayor) {
        this.frmCatalogo = frmCatalogo;
        this.frmCatalogo.registrar.addActionListener(this);
        this.frmCatalogo.cancelar.addActionListener(this);
        this.frmCatalogo.salir.addActionListener(this);
        this.mayor = mayor;
        daoCatalogo = new DaoCatalogo();

        this.frmCatalogo.codigo.setText(this.mayor.getCod_Mayor());
        this.frmCatalogo.nombreCuenta.setText(this.mayor.getNombre_Mayor());
        this.frmCatalogo.naturaleza.setSelectedItem(this.mayor.getNaturaleza());
        this.frmCatalogo.tipoCuenta.setSelectedItem(this.mayor.getCod_principal().getNombre_Principal());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmCatalogo.registrar) {
            guardar();
        } else if (e.getSource() == this.frmCatalogo.cancelar) {
            limpiar();
        } else if (e.getSource() == this.frmCatalogo.salir) {
            salir();
        }
    }

    public void guardar() {
        String codigo = this.frmCatalogo.codigo.getText();
        String cuenta = this.frmCatalogo.nombreCuenta.getText();
        String naturaleza = (String) this.frmCatalogo.naturaleza.getSelectedItem();
        String cod_prin = (String) this.frmCatalogo.tipoCuenta.getSelectedItem();
        
        Cuentas_Principales prin = daoCatalogo.select_cod_principal(cod_prin);
        
        
        if (!cuenta.isEmpty()) {
            if (this.mayor == null) {
                Cuentas_Mayor cat = new Cuentas_Mayor(codigo, cuenta, naturaleza, prin);
                daoCatalogo.insertMayor(cat);
            }
        }
    }

    public void limpiar() {
        this.frmCatalogo.codigo.setText(" ");
        this.frmCatalogo.nombreCuenta.setText(" ");
        this.frmCatalogo.tipoCuenta.setSelectedIndex(0);
    }

    public void salir() {
        System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

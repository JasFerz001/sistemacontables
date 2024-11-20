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
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Catalogos;
import modelos.Catalogo;

/**
 *
 * @author guill
 */
public class ControladorCatalogo extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener {

    Catalogos frmCatalogo;
    DaoCatalogo daoCatalogo;
    Catalogo catalogo;

    public ControladorCatalogo(Catalogos frmCatalogo) {
        this.frmCatalogo = frmCatalogo;
        this.frmCatalogo.registrar.addActionListener(this);
        this.frmCatalogo.cancelar.addActionListener(this);
        this.frmCatalogo.salir.addActionListener(this);
        daoCatalogo = new DaoCatalogo();
    }

    public ControladorCatalogo(Catalogos frmCatalogo, Catalogo catalogo) {
        this.frmCatalogo = frmCatalogo;
        this.frmCatalogo.registrar.addActionListener(this);
        this.frmCatalogo.cancelar.addActionListener(this);
        this.frmCatalogo.salir.addActionListener(this);
        this.catalogo = catalogo;
        daoCatalogo = new DaoCatalogo();

        this.frmCatalogo.codigo.setText(String.valueOf(this.catalogo.getCodigo()));
        this.frmCatalogo.nombreCuenta.setText(this.catalogo.getNombreCuenta());
        this.frmCatalogo.tipoCuenta.setSelectedIndex(this.catalogo.getTipoCuenta() - 1);
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
        int codigo = Integer.parseInt(this.frmCatalogo.codigo.getText());
        String cuenta = this.frmCatalogo.nombreCuenta.getText();
        int tipo = (this.frmCatalogo.tipoCuenta.getSelectedIndex() + 1);

        if (!cuenta.isEmpty()) {
            if (this.catalogo == null) {
                try {
                    Catalogo cat = new Catalogo(codigo, cuenta, tipo);
                    daoCatalogo.insertarCatalogo(cat);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorCatalogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }
    
    public void limpiar() {
        this.frmCatalogo.codigo.setText(" ");
        this.frmCatalogo.nombreCuenta.setText(" ");
        this.frmCatalogo.tipoCuenta.setSelectedIndex(0);
    }
    
    public void salir(){
        this.frmCatalogo.dispose();
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

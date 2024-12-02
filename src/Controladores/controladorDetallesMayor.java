/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.VistaDetallesMayor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import modelos.LibroMayor;

/**
 *
 * @author Mac
 */
public class controladorDetallesMayor  extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener{

    
    VistaDetallesMayor frmDetalles;
    ControladorLibroMayor ctrMayor;
    LibroMayor cuentaSeleccionada;

    public controladorDetallesMayor(VistaDetallesMayor frmDetalles, ControladorLibroMayor ctrMayor) {
        this.frmDetalles = frmDetalles;
        this.ctrMayor = ctrMayor;
    }

    public controladorDetallesMayor(VistaDetallesMayor frmDetalles, ControladorLibroMayor ctrMayor, LibroMayor cuentaSeleccionada) {
        this.frmDetalles = frmDetalles;
        this.ctrMayor = ctrMayor;
        this.cuentaSeleccionada = cuentaSeleccionada;
        
        this.frmDetalles.CuentaMayor.setText(this.cuentaSeleccionada.getNombre());
    }
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

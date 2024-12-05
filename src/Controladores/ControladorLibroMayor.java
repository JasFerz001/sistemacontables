package Controladores;

import Vistas.VistaMayor;
import Vistas.VistadetallesMayor;

import daos.Conexion;
import daos.DaoMayor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelos.LibroMayor;

public class ControladorLibroMayor extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener {

    VistaMayor frmMayor;
    DaoMayor daoMayor;
    LibroMayor mayor;
    DefaultTableModel modelo;
    ArrayList<LibroMayor> listaMayor;
    LibroMayor cuentaSeleccionada;

    public ControladorLibroMayor(VistaMayor frmMayor)  {
        this.frmMayor = frmMayor;
        this.frmMayor.btnDetalles.addActionListener(this);
        this.frmMayor.tbDatos.addMouseListener(this);
        
        
        listaMayor = new ArrayList();
        daoMayor = new DaoMayor();
       
        mostrar();
    }

    public ControladorLibroMayor(VistaMayor frmMayor, LibroMayor mayor) {
        this.frmMayor = frmMayor;
        this.mayor = mayor;
         listaMayor = new ArrayList();
        daoMayor = new DaoMayor();
        this.frmMayor.tbDatos.addMouseListener(this);
    }
    
    
    
    

    public void mostrar()  {

        listaMayor = (daoMayor.seleccionaDatos());
        modelo = new DefaultTableModel();
        String titulos[] = {"COD CUENTA", "CUENTA", "DEBE", "HABER", "SALDO"};
        modelo.setColumnIdentifiers(titulos);

        for (LibroMayor x : listaMayor.toArray(new LibroMayor[0])) {

            Object datos[] = {x.getCodigo(), x.getNombre(), x.getDebe(), x.getHaber(), x.getSaldo()};
            modelo.addRow(datos);
        }
        this.frmMayor.tbDatos.setModel(modelo);
        this.frmMayor.tbDatos.setDefaultEditor(Object.class, null);

    }
    
     @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource()==this.frmMayor.tbDatos) {
             int fila = this.frmMayor.tbDatos.getSelectedRow();
             if (fila>=0) {
                 cuentaSeleccionada = listaMayor.get(fila);
                 this.frmMayor.btnDetalles.setEnabled(true);
                 
             }
         }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource()==this.frmMayor.btnDetalles) {
            VistadetallesMayor frm = new VistadetallesMayor(new JFrame(),true);
        controladorDetallesMayor ctrMayor= new controladorDetallesMayor(frm,this,cuentaSeleccionada);
        frm.iniciar();
        }
        
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

package Controladores;

import Vistas.VistaMayor;

import daos.Conexion;
import daos.DaoMayor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.LibroMayor;

public class ControladorLibroMayor extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener {

    VistaMayor frmMayor;
    DaoMayor daoMayor;
    LibroMayor mayor;
    DefaultTableModel modelo;
    ArrayList<LibroMayor> listaMayor;

    public ControladorLibroMayor(VistaMayor frmMayor) throws SQLException, ClassNotFoundException {
        this.frmMayor = frmMayor;
        listaMayor = new ArrayList();
        this.daoMayor = new DaoMayor();
        mostrar();
    }

    public void mostrar() throws SQLException, ClassNotFoundException {

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

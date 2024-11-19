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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Cuentas_Mayor;
import modelos.Cuentas_Principales;
import vistas.AgregarCatalogo;

/**
 *
 * @author guill
 */
public class ControladorAgregarCatalogo extends MouseAdapter implements ActionListener,
        MouseListener, KeyListener, ItemListener {

    AgregarCatalogo frmCatalogo;
    ArrayList<Cuentas_Mayor> listaMayor;
    ControladorMostrarCatalogo ctrol;
    DaoCatalogo daoCatalogo;
    Cuentas_Mayor mayor;
    DefaultTableModel modelo;

    public ControladorAgregarCatalogo(AgregarCatalogo frmCatalogo, ControladorMostrarCatalogo ctrol) {
        this.frmCatalogo = frmCatalogo;
        this.ctrol = ctrol;
        this.frmCatalogo.registrar.addActionListener(this);
        this.frmCatalogo.cancelar.addActionListener(this);
        this.frmCatalogo.salir.addActionListener(this);
        this.frmCatalogo.editar.addActionListener(this);
        this.frmCatalogo.tablita.addMouseListener(this);
        this.frmCatalogo.editar.setEnabled(false);
        daoCatalogo = new DaoCatalogo();
        mostrar();
    }

    public ControladorAgregarCatalogo(AgregarCatalogo frmCatalogo, ControladorMostrarCatalogo ctrol, Cuentas_Mayor mayor) {
        this.frmCatalogo = frmCatalogo;
        this.frmCatalogo.registrar.addActionListener(this);
        this.frmCatalogo.cancelar.addActionListener(this);
        this.frmCatalogo.salir.addActionListener(this);
        this.mayor = mayor;
        this.ctrol = ctrol;
        daoCatalogo = new DaoCatalogo();

        this.frmCatalogo.codigo.setText(this.mayor.getCod_Mayor());
        this.frmCatalogo.nombreCuenta.setText(this.mayor.getNombre_Mayor());
        this.frmCatalogo.naturaleza.setSelectedItem(this.mayor.getNaturaleza());
        this.frmCatalogo.tipoCuenta.setSelectedItem(this.mayor.getCod_principal().getNombre_Principal());
    }

    public void mostrar() {
        listaMayor = daoCatalogo.selectTodoMayor();
        modelo = new DefaultTableModel();
        String titulos[] = {"CODIGO", "NOMBRE", "NATURALEZA", "CUENTA PRINCIPAL"};
        modelo.setColumnIdentifiers(titulos);
        int i = 0;
        for (Cuentas_Mayor x : listaMayor) {
            i++;
            Object datos[] = {x.getCod_Mayor(), x.getNombre_Mayor(), x.getNaturaleza(), x.getCod_principal().getNombre_Principal()};
            modelo.addRow(datos);
        }
        this.frmCatalogo.tablita.setModel(modelo);
        this.frmCatalogo.tablita.setDefaultEditor(Object.class, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmCatalogo.registrar) {
            guardar();
            mostrar();
        }
        if (e.getSource() == this.frmCatalogo.editar) {
            agregar();
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
            } else {
                this.mayor.setCod_Mayor(codigo);
                this.mayor.setNombre_Mayor(cuenta);
                this.mayor.setNaturaleza(naturaleza);
                this.mayor.setCod_principal(prin);

                daoCatalogo.updateMayor(mayor);
            }
            mostrar();
            limpiar();
            this.mayor = null;
        }
    }

    public void agregar() {
        if (this.mayor != null) {
            this.frmCatalogo.codigo.setText(this.mayor.getCod_Mayor());
            this.frmCatalogo.nombreCuenta.setText(this.mayor.getNombre_Mayor());
            this.frmCatalogo.naturaleza.setSelectedItem(this.mayor.getNaturaleza());
            this.frmCatalogo.tipoCuenta.setSelectedItem(this.mayor.getCod_principal().getNombre_Principal());
            this.frmCatalogo.codigo.setEditable(false);
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
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.frmCatalogo.tablita) {
            int fila = this.frmCatalogo.tablita.getSelectedRow();
            if (fila >= 0) {
                this.mayor = listaMayor.get(fila);
                this.frmCatalogo.editar.setEnabled(true);
            }
        }
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

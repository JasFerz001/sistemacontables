package Controladores;

import Vistas.VistaLibroDiario;
import daos.DaoLibroDiario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.LibroDiario;
import modelos.SubCuentas;

public class ControladorLibroDiario extends MouseAdapter implements ActionListener,
        MouseListener {

    VistaLibroDiario frmLibro;
    DaoLibroDiario daoLibro;
    LibroDiario libro;
    private ArrayList<LibroDiario> listaLibroDiario = new ArrayList<>();
    private String conceptoGlobal = "";

    public ControladorLibroDiario(VistaLibroDiario vista) {
        this.frmLibro = vista;
        this.frmLibro.btnAgregar.addActionListener(this);
        this.frmLibro.btnModificar.addActionListener(this);
        this.frmLibro.btnProcesarPartida.addActionListener(this);
        this.frmLibro.tbDatos.addMouseListener(this);
        daoLibro = new DaoLibroDiario();
        mostrarNumeroPartida();
        mostrarPartidaAnterior();
        cargarSubCuentas();
    }

    public ControladorLibroDiario(VistaLibroDiario frmLibro, LibroDiario libro) {
        this.frmLibro = frmLibro;
        this.frmLibro.btnAgregar.addActionListener(this);
        this.frmLibro.btnModificar.addActionListener(this);
        this.frmLibro.btnProcesarPartida.addActionListener(this);
        this.libro = libro;
        daoLibro = new DaoLibroDiario();

        this.frmLibro.tfFecha.setDate(this.libro.getFecha());
        this.frmLibro.cbCodigo.setSelectedIndex(this.libro.getCodSubcuenta());
        this.frmLibro.tfCuenta.setText(this.libro.getNombreCuenta());
        this.frmLibro.tfMonto.setText(Double.toString(this.libro.getMonto()));
        this.frmLibro.cbTransaccion.setSelectedIndex(Integer.parseInt(this.libro.getTransaccion()));
        this.frmLibro.tfConcepto.setText(this.libro.getConcepto());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLibro.btnAgregar) {
            agregarDatosTabla();
        } else if (e.getSource() == frmLibro.btnModificar) {
            modificarFilaSeleccionada();
        } else if (e.getSource() == frmLibro.btnProcesarPartida) {
            procesarPartida();
        }
    }

    private void cargarSubCuentas() {
        ArrayList<SubCuentas> listaSubCuentas = daoLibro.obtenerSubCuentas();
        frmLibro.cbCodigo.removeAllItems();
        frmLibro.cbCodigo.addItem("Seleccione código");
        for (SubCuentas subCuenta : listaSubCuentas) {
            frmLibro.cbCodigo.addItem(subCuenta.getCod_subcuenta());
        }
        frmLibro.cbCodigo.addActionListener(e -> {
            String codigoSeleccionado = (String) frmLibro.cbCodigo.getSelectedItem();
            for (SubCuentas subCuenta : listaSubCuentas) {
                if (subCuenta.getCod_subcuenta().equals(codigoSeleccionado)) {
                    frmLibro.tfCuenta.setText(subCuenta.getNombre_sub());
                    return;
                }
            }
            frmLibro.tfCuenta.setText("");
        });
    }

    public void agregarDatosTabla() {
        try {
            if (frmLibro.tfConcepto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Concepto no puede estar vacío.");
                return;
            }
            Date fechaSeleccionada = frmLibro.tfFecha.getDate();
            int codigoSubcuenta = Integer.parseInt(frmLibro.cbCodigo.getSelectedItem().toString());
            String nombreCuenta = frmLibro.tfCuenta.getText();
            double monto = Double.parseDouble(frmLibro.tfMonto.getText());
            String transaccion = frmLibro.cbTransaccion.getSelectedItem().toString();

            if (!frmLibro.tfConcepto.getText().isEmpty()) {
                conceptoGlobal = frmLibro.tfConcepto.getText();
                frmLibro.tfConcepto.setEnabled(false);
            }
            String concepto = conceptoGlobal;
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoFecha.format(fechaSeleccionada);
            
            Object[] fila = new Object[7];
            fila[0] = fechaFormateada;
            fila[1] = codigoSubcuenta;
            fila[2] = nombreCuenta;
            fila[5] = concepto;

            double montoDebe = 0;
            double montoHaber = 0;

            if ("Debe".equals(transaccion)) {
                montoDebe = monto;
                fila[3] = monto;
                fila[4] = "";
            } else if ("Haber".equals(transaccion)) {
                montoHaber = monto;
                fila[3] = "";
                fila[4] = monto;
            }
            DefaultTableModel modeloTabla = (DefaultTableModel) frmLibro.tbDatos.getModel();
            modeloTabla.addRow(fila);
            listaLibroDiario.add(new LibroDiario(
                    Integer.parseInt(frmLibro.tfNumeroPartida.getText()),
                    fechaSeleccionada,
                    codigoSubcuenta,
                    nombreCuenta,
                    monto,
                    transaccion,
                    concepto
            ));
            actualizarSumas();
            frmLibro.cbCodigo.setSelectedIndex(0);
            frmLibro.tfMonto.setText("");
            frmLibro.cbTransaccion.setSelectedIndex(0);
            frmLibro.tfCuenta.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al capturar o agregar datos: " + ex.getMessage());
        }
    }

    private void modificarFilaSeleccionada() {
        try {
            int filaSeleccionada = (int) frmLibro.tbDatos.getClientProperty("filaSeleccionada");
            Date fechaSeleccionada = frmLibro.tfFecha.getDate();
            int codigoSubcuenta = Integer.parseInt(frmLibro.cbCodigo.getSelectedItem().toString());
            String nombreCuenta = frmLibro.tfCuenta.getText();
            double monto = Double.parseDouble(frmLibro.tfMonto.getText());
            String transaccion = frmLibro.cbTransaccion.getSelectedItem().toString();
            String concepto = frmLibro.tfConcepto.getText();
            // Actualizar datos en la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) frmLibro.tbDatos.getModel();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoFecha.format(fechaSeleccionada);
            modeloTabla.setValueAt(fechaFormateada, filaSeleccionada, 0);
            modeloTabla.setValueAt(codigoSubcuenta, filaSeleccionada, 1);
            modeloTabla.setValueAt(nombreCuenta, filaSeleccionada, 2);
            modeloTabla.setValueAt("Debe".equals(transaccion) ? monto : "", filaSeleccionada, 3);
            modeloTabla.setValueAt("Haber".equals(transaccion) ? monto : "", filaSeleccionada, 4);
            modeloTabla.setValueAt(concepto, filaSeleccionada, 5);
            // Actualizar datos en el ArrayList
            LibroDiario libro = listaLibroDiario.get(filaSeleccionada);
            libro.setFecha(fechaSeleccionada);
            libro.setCodSubcuenta(codigoSubcuenta);
            libro.setNombreCuenta(nombreCuenta);
            libro.setMonto(monto);
            libro.setTransaccion(transaccion);
            libro.setConcepto(concepto);
            JOptionPane.showMessageDialog(null, "Fila modificada correctamente.");
            actualizarSumas();
            frmLibro.cbCodigo.setSelectedIndex(0);
            frmLibro.tfCuenta.setText("");
            frmLibro.tfMonto.setText("");
            frmLibro.cbTransaccion.setSelectedIndex(0);
            frmLibro.btnModificar.setEnabled(false);
            frmLibro.btnAgregar.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar la fila: " + ex.getMessage());
        }
    }

    public void procesarPartida() {
        try {
            if (frmLibro.tbDatos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se puede procesar la partida. No hay registros en la tabla.");
                return;
            }
            // Para verificar si el debe y el haber son iguales
            double totalDebe = 0.0;
            double totalHaber = 0.0;
            for (int i = 0; i < frmLibro.tbDatos.getRowCount(); i++) {
                String debe = frmLibro.tbDatos.getValueAt(i, 3).toString();
                String haber = frmLibro.tbDatos.getValueAt(i, 4).toString();
                if (!debe.isEmpty()) {
                    totalDebe += Double.parseDouble(debe);
                }
                if (!haber.isEmpty()) {
                    totalHaber += Double.parseDouble(haber);
                }
            }
            if (totalDebe != totalHaber) {
                JOptionPane.showMessageDialog(null, "El total del debe y el haber no son iguales. No se puede procesar.");
                return;
            }
            // Limpia la lista (datos Anteriores en la tabla) para evitar duplicados
            listaLibroDiario.clear();
            //Recorro el ArrayList Nuevamente para obtener los datos de las filas actualizadas 
            DefaultTableModel modeloTabla = (DefaultTableModel) frmLibro.tbDatos.getModel();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                //Capturando los datos actuales de la tabla filas modificadas
                Date fecha = formatoFecha.parse(modeloTabla.getValueAt(i, 0).toString());
                int codigoSubcuenta = Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());
                String nombreCuenta = modeloTabla.getValueAt(i, 2).toString();
                double monto = modeloTabla.getValueAt(i, 3).toString().isEmpty()
                        ? Double.parseDouble(modeloTabla.getValueAt(i, 4).toString())
                        : Double.parseDouble(modeloTabla.getValueAt(i, 3).toString());
                String transaccion = modeloTabla.getValueAt(i, 3).toString().isEmpty() ? "Haber" : "Debe";
                String concepto = modeloTabla.getValueAt(i, 5).toString();
                // Agregar al ArrayList
                listaLibroDiario.add(new LibroDiario(
                        Integer.parseInt(frmLibro.tfNumeroPartida.getText()),
                        fecha,
                        codigoSubcuenta,
                        nombreCuenta,
                        monto,
                        transaccion,
                        concepto
                ));
            }
            // Guardando los datos en la base de datos
            int numeroPartida = daoLibro.obtenerUltimaPartida();
            numeroPartida++;
            frmLibro.tfNumeroPartida.setText(String.valueOf(numeroPartida));
            for (LibroDiario libro : listaLibroDiario) {
                libro.setNumeroPartida(numeroPartida);
                String resultado = daoLibro.insertarLibroDiario(libro);
                if ("exito".equals(resultado)) {
                    System.out.println("Partida guardada correctamente: " + libro);
                } else {
                    System.out.println("Error al guardar la partida: " + libro);
                }
            }
            JOptionPane.showMessageDialog(null, "Partida procesada correctamente.");
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra partida?", "Agregar Partida", JOptionPane.YES_NO_OPTION);
            limpiarCampos();
            frmLibro.tfPartidaAnterior.setText(String.valueOf(numeroPartida));
            frmLibro.tfNumeroPartida.setText(String.valueOf(numeroPartida + 1));
            frmLibro.tfConcepto.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al procesar las partidas: " + e.getMessage());
        }
    }

    public void limpiarCampos() {
        frmLibro.cbCodigo.setSelectedIndex(0);
        frmLibro.tfCuenta.setText("");
        frmLibro.tfMonto.setText("");
        frmLibro.cbTransaccion.setSelectedIndex(0);
        frmLibro.tfConcepto.setText("");
        frmLibro.tfSumaDebe.setText("");
        frmLibro.tfSumaHaber.setText("");
        DefaultTableModel modeloTabla = (DefaultTableModel) frmLibro.tbDatos.getModel();
        modeloTabla.setRowCount(0);
    }

    public void actualizarSumas() {
        double sumaDebe = 0;
        double sumaHaber = 0;
        DefaultTableModel modeloTabla = (DefaultTableModel) frmLibro.tbDatos.getModel();
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String debe = modeloTabla.getValueAt(i, 3).toString();
            String haber = modeloTabla.getValueAt(i, 4).toString();
            if (!debe.isEmpty()) {
                sumaDebe += Double.parseDouble(debe);
            }
            if (!haber.isEmpty()) {
                sumaHaber += Double.parseDouble(haber);
            }
        }
        frmLibro.tfSumaDebe.setText(String.format("%.2f", sumaDebe));
        frmLibro.tfSumaHaber.setText(String.format("%.2f", sumaHaber));
    }

    public void mostrarNumeroPartida() {
        try {
            int ultimaPartida = daoLibro.obtenerUltimaPartida();
            int nuevoNumeroPartida = ultimaPartida + 1;
            frmLibro.tfNumeroPartida.setText(String.valueOf(nuevoNumeroPartida));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al obtener el número de partida: " + ex.getMessage());
        }
    }

    public void mostrarPartidaAnterior() {
        try {
            int ultimaPartida = daoLibro.obtenerUltimaPartida();
            frmLibro.tfPartidaAnterior.setText(String.valueOf(ultimaPartida));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al obtener el último número de partida: " + ex.getMessage());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.frmLibro.tbDatos) {
            int fila = this.frmLibro.tbDatos.getSelectedRow();
            if (fila >= 0) {
                // Cargar datos de la fila seleccionada a los campos de la vista
                DefaultTableModel modeloTabla = (DefaultTableModel) this.frmLibro.tbDatos.getModel();
                String fecha = modeloTabla.getValueAt(fila, 0).toString();
                int codigoSubcuenta = Integer.parseInt(modeloTabla.getValueAt(fila, 1).toString());
                String nombreCuenta = modeloTabla.getValueAt(fila, 2).toString();
                String debe = modeloTabla.getValueAt(fila, 3).toString();
                String haber = modeloTabla.getValueAt(fila, 4).toString();
                String concepto = modeloTabla.getValueAt(fila, 5).toString();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date fechaSeleccionada = formatoFecha.parse(fecha);
                    this.frmLibro.tfFecha.setDate(fechaSeleccionada);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //Aqui Obtengo el codigo de la cuenta para cuando modifico me lo cargue al combobox
                String codigoSubcuentaStr = String.valueOf(codigoSubcuenta);
                for (int i = 0; i < this.frmLibro.cbCodigo.getItemCount(); i++) {
                    String item = (String) this.frmLibro.cbCodigo.getItemAt(i);
                    if (item.startsWith(codigoSubcuentaStr)) {
                        this.frmLibro.cbCodigo.setSelectedIndex(i);
                        break;
                    }
                }
                this.frmLibro.tfCuenta.setText(nombreCuenta);
                this.frmLibro.tfMonto.setText(!debe.isEmpty() ? debe : haber);
                this.frmLibro.cbTransaccion.setSelectedItem(!debe.isEmpty() ? "Debe" : "Haber");
                this.frmLibro.tfConcepto.setText(concepto);
                this.frmLibro.btnModificar.setEnabled(true);
                this.frmLibro.btnAgregar.setEnabled(false);
                this.frmLibro.tbDatos.putClientProperty("filaSeleccionada", fila);
            }
        }
    }
}

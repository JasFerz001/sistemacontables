/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vistas;

import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class VistaLibroDiario extends javax.swing.JDialog {

    DefaultTableModel tb = new DefaultTableModel();

    /**
     * Creates new form LibroDiarioVista
     */
    public VistaLibroDiario(java.awt.Frame parent, boolean modal,
            String titulo) {
        super(parent, modal);
        initComponents();
        lbTitulo.setText(titulo);

        tb.addColumn("Fecha");
        tb.addColumn("Código");
        tb.addColumn("Cuenta");
        tb.addColumn("Debe");
        tb.addColumn("Haber");
        tb.addColumn("Concepto");
        tbDatos.setModel(tb);
        ButtonGroup grupoIVA = new ButtonGroup();
        grupoIVA.add(this.rbAgregarIVA);  // Asegúrate de tener el botón en tu vista
        grupoIVA.add(this.rbExtraerIVA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbTitulo = new javax.swing.JLabel();
        lbIngresoLibroDiario = new javax.swing.JLabel();
        lbNumeroPartida = new javax.swing.JLabel();
        tfNumeroPartida = new javax.swing.JTextField();
        lbPartidaAnterior = new javax.swing.JLabel();
        tfPartidaAnterior = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        lbCuenta = new javax.swing.JLabel();
        lbMonto = new javax.swing.JLabel();
        lbTransaccion = new javax.swing.JLabel();
        tfCuenta = new javax.swing.JTextField();
        cbTransaccion = new javax.swing.JComboBox<>();
        lbConcepto = new javax.swing.JLabel();
        tfConcepto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnProcesarPartida = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        tfSumaDebe = new javax.swing.JTextField();
        tfSumaHaber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMonto = new javax.swing.JTextField();
        tfFecha = new newscomponents.RSDateChooser();
        tfCodigo = new javax.swing.JTextField();
        lbBuscar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        rbAgregarIVA = new javax.swing.JRadioButton();
        rbExtraerIVA = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDatos = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setPreferredSize(new java.awt.Dimension(945, 574));
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 960, 10));
        PanelFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 960, 10));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PanelFondo.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -4, 150, 40));

        lbIngresoLibroDiario.setBackground(new java.awt.Color(153, 0, 0));
        lbIngresoLibroDiario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIngresoLibroDiario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIngresoLibroDiario.setText("Registro de Partidas");
        PanelFondo.add(lbIngresoLibroDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 0, 160, 30));

        lbNumeroPartida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNumeroPartida.setText("N° de la Nueva Partida");
        PanelFondo.add(lbNumeroPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, 30));

        tfNumeroPartida.setEditable(false);
        tfNumeroPartida.setBackground(new java.awt.Color(255, 255, 255));
        tfNumeroPartida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfNumeroPartida.setForeground(new java.awt.Color(153, 0, 0));
        tfNumeroPartida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNumeroPartida.setBorder(null);
        PanelFondo.add(tfNumeroPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 50, 30));

        lbPartidaAnterior.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPartidaAnterior.setText("N° de Partida Anterior");
        PanelFondo.add(lbPartidaAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, 30));

        tfPartidaAnterior.setEditable(false);
        tfPartidaAnterior.setBackground(new java.awt.Color(255, 255, 255));
        tfPartidaAnterior.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfPartidaAnterior.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPartidaAnterior.setBorder(null);
        PanelFondo.add(tfPartidaAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 50, 30));

        lbFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbFecha.setText("Fecha");
        PanelFondo.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 30));

        lbCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCodigo.setText("Codigo ");
        PanelFondo.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        lbCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCuenta.setText("Cuenta");
        PanelFondo.add(lbCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 30));

        lbMonto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbMonto.setText("Monto $");
        PanelFondo.add(lbMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        lbTransaccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTransaccion.setText("Transaccion");
        PanelFondo.add(lbTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, 30));

        tfCuenta.setEditable(false);
        tfCuenta.setBackground(new java.awt.Color(255, 255, 255));
        tfCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfCuenta.setForeground(new java.awt.Color(153, 0, 0));
        PanelFondo.add(tfCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 480, 30));

        cbTransaccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTransaccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debe", "Haber" }));
        PanelFondo.add(cbTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 140, 30));

        lbConcepto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbConcepto.setText("Concepto");
        PanelFondo.add(lbConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        tfConcepto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PanelFondo.add(tfConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 390, 30));

        btnAgregar.setBackground(new java.awt.Color(0, 153, 51));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 90, 30));

        btnModificar.setBackground(new java.awt.Color(255, 153, 0));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setEnabled(false);
        PanelFondo.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 100, 30));

        btnProcesarPartida.setBackground(new java.awt.Color(51, 51, 255));
        btnProcesarPartida.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnProcesarPartida.setForeground(new java.awt.Color(255, 255, 255));
        btnProcesarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/procesar.png"))); // NOI18N
        btnProcesarPartida.setText("Procesar Partida");
        btnProcesarPartida.setBorder(null);
        btnProcesarPartida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(btnProcesarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 150, 30));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTotal.setText("Total");
        PanelFondo.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, -1, 30));

        tfSumaDebe.setEditable(false);
        tfSumaDebe.setBackground(new java.awt.Color(255, 255, 255));
        tfSumaDebe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfSumaDebe.setForeground(new java.awt.Color(153, 0, 0));
        tfSumaDebe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSumaDebe.setBorder(null);
        PanelFondo.add(tfSumaDebe, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 100, 30));

        tfSumaHaber.setEditable(false);
        tfSumaHaber.setBackground(new java.awt.Color(255, 255, 255));
        tfSumaHaber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfSumaHaber.setForeground(new java.awt.Color(153, 0, 0));
        tfSumaHaber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSumaHaber.setBorder(null);
        PanelFondo.add(tfSumaHaber, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 100, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("$");
        PanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 10, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("$");
        PanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 10, 30));

        tfMonto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PanelFondo.add(tfMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, -1));

        tfFecha.setBackground(new java.awt.Color(153, 0, 0));
        tfFecha.setForeground(new java.awt.Color(153, 0, 0));
        tfFecha.setBgColor(new java.awt.Color(153, 0, 0));
        tfFecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfFecha.setFormatDate("dd/MM/yyyy");
        PanelFondo.add(tfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 220, -1));

        tfCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfCodigo.setForeground(new java.awt.Color(153, 0, 0));
        PanelFondo.add(tfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, 30));

        lbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        lbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(lbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 20, 30));

        btnEliminar.setBackground(new java.awt.Color(153, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar Fila");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        PanelFondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 130, 30));

        rbAgregarIVA.setBackground(new java.awt.Color(255, 255, 255));
        rbAgregarIVA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbAgregarIVA.setText("Agregar IVA");
        PanelFondo.add(rbAgregarIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, 30));

        rbExtraerIVA.setBackground(new java.awt.Color(255, 255, 255));
        rbExtraerIVA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rbExtraerIVA.setText("Extraer IVA");
        PanelFondo.add(rbExtraerIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, 30));

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDatos.setRowHeight(25);
        jScrollPane2.setViewportView(tbDatos);

        PanelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 850, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LibroDiarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LibroDiarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LibroDiarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LibroDiarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                LibroDiarioVista dialog = new LibroDiarioVista(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFondo;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnProcesarPartida;
    public javax.swing.JComboBox<String> cbTransaccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lbBuscar;
    public javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbConcepto;
    public javax.swing.JLabel lbCuenta;
    public javax.swing.JLabel lbFecha;
    public javax.swing.JLabel lbIngresoLibroDiario;
    public javax.swing.JLabel lbMonto;
    public javax.swing.JLabel lbNumeroPartida;
    public javax.swing.JLabel lbPartidaAnterior;
    public javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTransaccion;
    public javax.swing.JRadioButton rbAgregarIVA;
    public javax.swing.JRadioButton rbExtraerIVA;
    public rojerusan.RSTableMetro tbDatos;
    public javax.swing.JTextField tfCodigo;
    public javax.swing.JTextField tfConcepto;
    public javax.swing.JTextField tfCuenta;
    public newscomponents.RSDateChooser tfFecha;
    public javax.swing.JTextField tfMonto;
    public javax.swing.JTextField tfNumeroPartida;
    public javax.swing.JTextField tfPartidaAnterior;
    public javax.swing.JTextField tfSumaDebe;
    public javax.swing.JTextField tfSumaHaber;
    // End of variables declaration//GEN-END:variables
}

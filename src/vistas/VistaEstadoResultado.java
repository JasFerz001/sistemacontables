/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author guill
 */
public class VistaEstadoResultado extends javax.swing.JDialog {

    /**
     * Creates new form VistaEstadoResultado
     */
    public VistaEstadoResultado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void iniciar() {
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        ventasNetas = new javax.swing.JLabel();
        costoVendido = new javax.swing.JLabel();
        utilidadBruta = new javax.swing.JLabel();
        totalOperacion = new javax.swing.JLabel();
        gastoVentas = new javax.swing.JLabel();
        utilidadOperacion = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        gastosFinancieros = new javax.swing.JLabel();
        utilidadAntes = new javax.swing.JLabel();
        isr = new javax.swing.JLabel();
        reservaLegal = new javax.swing.JLabel();
        utilidadEjercicio = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        inventariofinal = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        generar = new javax.swing.JButton();
        reporte = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        rebajasCompras = new javax.swing.JLabel();
        ventas = new javax.swing.JLabel();
        otrosGastos = new javax.swing.JLabel();
        tDevReb = new javax.swing.JLabel();
        inventarioInicial = new javax.swing.JLabel();
        gastosCompras = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        descuentosVentas = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        inventarioFinal = new javax.swing.JLabel();
        comprasTotales = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Compras = new javax.swing.JLabel();
        descuentosCompras = new javax.swing.JLabel();
        comprasNetas = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        devolucionesVentas = new javax.swing.JLabel();
        ingresosFinancieros = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        gastosAdmin = new javax.swing.JLabel();

        jLabel19.setText("jLabel17");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("jLabel17");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("jLabel17");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 235, 235));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ESTADO DE RESULTADO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 970, 20));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("REBAJAS SOBRE COMPRAS:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 510, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 980, 12));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("INVENTARIO FINAL:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 660, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 153, 255));
        jLabel7.setText("GASTOS DE OPERACION:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 810, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("GASTOS ADMINISTRATIVOS:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 660, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("GASTOS DE VENTAS:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 660, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 153, 255));
        jLabel10.setText("UTILIDAD DE OPERACION:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 810, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("GASTOS FINANCIEROS:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 660, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("OTROS GASTOS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 660, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 153, 255));
        jLabel13.setText("UTILIDAD ANTES DE IMPUESTOS:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 810, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("IMPUESTO SOBRE LA RENTA:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 343, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("RESERVA LEGAL:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 810, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 153, 255));
        jLabel16.setText("UTILIDAD DEL EJERCICIO:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 810, 20));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 20, 500));

        ventasNetas.setBackground(new java.awt.Color(0, 0, 0));
        ventasNetas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ventasNetas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ventasNetas.setText(".");
        jPanel1.add(ventasNetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 160, -1));

        costoVendido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        costoVendido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costoVendido.setText(".");
        jPanel1.add(costoVendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 160, -1));

        utilidadBruta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        utilidadBruta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        utilidadBruta.setText(".");
        jPanel1.add(utilidadBruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 160, -1));

        totalOperacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalOperacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOperacion.setText(".");
        jPanel1.add(totalOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 160, -1));

        gastoVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gastoVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gastoVentas.setText(".");
        jPanel1.add(gastoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 150, -1));

        utilidadOperacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        utilidadOperacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        utilidadOperacion.setText(".");
        jPanel1.add(utilidadOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 520, 160, -1));

        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText(".");
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 560, 160, -1));

        gastosFinancieros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gastosFinancieros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gastosFinancieros.setText(".");
        jPanel1.add(gastosFinancieros, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 150, -1));

        utilidadAntes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        utilidadAntes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        utilidadAntes.setText(".");
        jPanel1.add(utilidadAntes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 160, 20));

        isr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        isr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isr.setText(".");
        jPanel1.add(isr, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 160, -1));

        reservaLegal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reservaLegal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reservaLegal.setText(".");
        jPanel1.add(reservaLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, 160, -1));

        utilidadEjercicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        utilidadEjercicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        utilidadEjercicio.setText(".");
        jPanel1.add(utilidadEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 640, 160, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("INVENTARIO FINAL:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 159, 30));

        inventariofinal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inventariofinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inventariofinalKeyTyped(evt);
            }
        });
        jPanel1.add(inventariofinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 170, 30));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 580, 150, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 150, 10));

        generar.setBackground(new java.awt.Color(0, 153, 51));
        generar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        generar.setForeground(new java.awt.Color(255, 255, 255));
        generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        generar.setText("Generar");
        generar.setBorder(null);
        generar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 120, 40));

        reporte.setBackground(new java.awt.Color(102, 102, 255));
        reporte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        reporte.setForeground(new java.awt.Color(255, 255, 255));
        reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        reporte.setText("Reporte");
        reporte.setBorder(null);
        reporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });
        jPanel1.add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 120, 40));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 980, 12));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 20, 500));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 30, 500));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, -1, 500));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("OTROS PRODUCTOS");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 660, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 153, 255));
        jLabel20.setText("UTILIDAD BRUTA:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 810, -1));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 150, 10));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 160, 10));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 153, 255));
        jLabel21.setText("COSTO DE LO VENDIDO:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 810, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 153, 255));
        jLabel22.setText("COMPRAS NETAS:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 660, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("DESCUENTOS SOBRE COMPRAS:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 510, -1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 153, 255));
        jLabel24.setText("COMPRAS TOTALES:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 510, -1));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("GASTOS SOBRE COMPRAS:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 510, -1));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("COMPRAS:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 510, -1));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("VENTAS:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 660, -1));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 153, 255));
        jLabel28.setText("VENTAS NETAS:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 810, -1));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("INVENTARIO INICIAL:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 660, -1));

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("DEVOLUCIONES SOBRE VENTAS:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 510, -1));
        jPanel1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 150, 10));

        rebajasCompras.setBackground(new java.awt.Color(0, 0, 0));
        rebajasCompras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rebajasCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rebajasCompras.setText(".");
        jPanel1.add(rebajasCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 150, -1));

        ventas.setBackground(new java.awt.Color(0, 0, 0));
        ventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ventas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ventas.setText(".");
        jPanel1.add(ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 150, -1));

        otrosGastos.setBackground(new java.awt.Color(0, 0, 0));
        otrosGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        otrosGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        otrosGastos.setText(".");
        jPanel1.add(otrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 150, 20));

        tDevReb.setBackground(new java.awt.Color(0, 0, 0));
        tDevReb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tDevReb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tDevReb.setText(".");
        jPanel1.add(tDevReb, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 150, -1));

        inventarioInicial.setBackground(new java.awt.Color(0, 0, 0));
        inventarioInicial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inventarioInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventarioInicial.setText(".");
        jPanel1.add(inventarioInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 150, -1));

        gastosCompras.setBackground(new java.awt.Color(0, 0, 0));
        gastosCompras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gastosCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gastosCompras.setText(".");
        jPanel1.add(gastosCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 150, -1));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 150, 10));

        descuentosVentas.setBackground(new java.awt.Color(0, 0, 0));
        descuentosVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descuentosVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descuentosVentas.setText(".");
        jPanel1.add(descuentosVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 150, -1));
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 150, 10));

        inventarioFinal.setBackground(new java.awt.Color(0, 0, 0));
        inventarioFinal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inventarioFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventarioFinal.setText(".");
        jPanel1.add(inventarioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 150, -1));

        comprasTotales.setBackground(new java.awt.Color(0, 0, 0));
        comprasTotales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comprasTotales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comprasTotales.setText(".");
        jPanel1.add(comprasTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 150, -1));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("DESCUENTOS SOBRE VENTAS:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 510, -1));

        Compras.setBackground(new java.awt.Color(0, 0, 0));
        Compras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Compras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Compras.setText(".");
        jPanel1.add(Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 150, -1));

        descuentosCompras.setBackground(new java.awt.Color(0, 0, 0));
        descuentosCompras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descuentosCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descuentosCompras.setText(".");
        jPanel1.add(descuentosCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 150, -1));

        comprasNetas.setBackground(new java.awt.Color(0, 0, 0));
        comprasNetas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comprasNetas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comprasNetas.setText(".");
        jPanel1.add(comprasNetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 150, -1));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 160, 10));

        devolucionesVentas.setBackground(new java.awt.Color(0, 0, 0));
        devolucionesVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        devolucionesVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        devolucionesVentas.setText(".");
        jPanel1.add(devolucionesVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 150, -1));

        ingresosFinancieros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresosFinancieros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresosFinancieros.setText(".");
        jPanel1.add(ingresosFinancieros, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 150, -1));
        jPanel1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 640, 160, 10));
        jPanel1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 160, 10));

        jSeparator21.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator21.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 160, 20, 500));

        gastosAdmin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gastosAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gastosAdmin.setText(".");
        jPanel1.add(gastosAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inventariofinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventariofinalKeyTyped
        JTextField textField = (JTextField) evt.getSource();
        String textoActual = textField.getText();
        char c = evt.getKeyChar();

        // Permitir números, el punto decimal y retroceso
        if (!Character.isDigit(c) && c != '.' && c != '\b') {
            evt.consume(); // Ignorar cualquier carácter no válido
            return;
        }

        // Evitar múltiples puntos decimales
        if (c == '.' && textoActual.contains(".")) {
            evt.consume();
            return;
        }

        // Limitar a dos decimales
        if (textoActual.contains(".")) {
            int indexPunto = textoActual.indexOf('.');
            String decimales = textoActual.substring(indexPunto + 1);
            if (decimales.length() >= 2 && c != '\b') { // Permitir retroceso para corregir
                evt.consume();
            }
        }
    }//GEN-LAST:event_inventariofinalKeyTyped

    private void reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reporteActionPerformed

    private boolean esFechaValida(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Validación estricta
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
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
//            java.util.logging.Logger.getLogger(VistaEstadoResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaEstadoResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaEstadoResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaEstadoResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                VistaEstadoResultado dialog = new VistaEstadoResultado(new javax.swing.JFrame(), true);
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
    public javax.swing.JLabel Compras;
    public javax.swing.JLabel comprasNetas;
    public javax.swing.JLabel comprasTotales;
    public javax.swing.JLabel costoVendido;
    public javax.swing.JLabel descuentosCompras;
    public javax.swing.JLabel descuentosVentas;
    public javax.swing.JLabel devolucionesVentas;
    public javax.swing.JLabel gastoVentas;
    public javax.swing.JLabel gastosAdmin;
    public javax.swing.JLabel gastosCompras;
    public javax.swing.JLabel gastosFinancieros;
    public javax.swing.JButton generar;
    public javax.swing.JLabel ingresosFinancieros;
    public javax.swing.JLabel inventarioFinal;
    public javax.swing.JLabel inventarioInicial;
    public javax.swing.JTextField inventariofinal;
    public javax.swing.JLabel isr;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JLabel otrosGastos;
    public javax.swing.JLabel rebajasCompras;
    public javax.swing.JButton reporte;
    public javax.swing.JLabel reservaLegal;
    public javax.swing.JLabel tDevReb;
    public javax.swing.JLabel total;
    public javax.swing.JLabel totalOperacion;
    public javax.swing.JLabel utilidadAntes;
    public javax.swing.JLabel utilidadBruta;
    public javax.swing.JLabel utilidadEjercicio;
    public javax.swing.JLabel utilidadOperacion;
    public javax.swing.JLabel ventas;
    public javax.swing.JLabel ventasNetas;
    // End of variables declaration//GEN-END:variables
}

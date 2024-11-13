/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controladores.ControladorBalanceGeneral;
import daos.DaoBalanceGeneral;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.BalanceGeneral;

/**
 *
 * @author Luis
 */
public class VistaBalanceGeneral extends javax.swing.JFrame {

    int activo = 0, aN = 1, pasivo = 2, pN = 3, patrimonio = 4;
    int tamaño = 0;

    DaoBalanceGeneral dao = new DaoBalanceGeneral();

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();

    ArrayList<BalanceGeneral> listaActivos = new ArrayList();
    ArrayList<BalanceGeneral> lisAcNocorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivos = new ArrayList();
    ArrayList<BalanceGeneral> listaPasivosNoCorrientes = new ArrayList();
    ArrayList<BalanceGeneral> listaPatrimonio = new ArrayList();
    /**
     * Creates new form BalanceGeneral
     */
    public VistaBalanceGeneral() {

        initComponents();
//        control.setModels();
        //--para mostrar activos
        dtm.addColumn("Activos");
        dtm.addColumn("Total Activos");
        dtm.addColumn("Total:");
        tabla_activos.setModel(dtm);

        //--para mostrar pasivos
        dtm2.addColumn("Pasivos");
        dtm2.addColumn("Total Pasivos");
        dtm2.addColumn("Total:");
        tabla_pasivos.setModel(dtm2);

       listaActivos=dao.CargarBalanceGeneral(activo);
       lisAcNocorrientes=dao.CargarBalanceGeneral(aN);
       listaPasivos=dao.CargarBalanceGeneral(pasivo);
       listaPasivosNoCorrientes=dao.CargarBalanceGeneral(pN);
       listaPatrimonio=dao.CargarBalanceGeneral(patrimonio);

        agregarATabla();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_pasivos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_activos = new javax.swing.JTable();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Balance General");

        tabla_pasivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pasivo", "Total por Cuenta", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabla_pasivos);

        tabla_activos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activos", "Total por Cuenta", "Total"
            }
        ));
        jScrollPane2.setViewportView(tabla_activos);

        btn_salir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(324, 324, 324))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_salir)
                        .addGap(350, 350, 350))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salir)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaBalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaBalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaBalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaBalanceGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBalanceGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla_activos;
    public javax.swing.JTable tabla_pasivos;
    // End of variables declaration//GEN-END:variables

    private void agregarATabla() {
                int aux = 0;
        dtm.addRow(new Object[]{"Activo Corriente", " ", " "});
        for (int i = 0; i < listaActivos.size(); i++) {

            dtm.addRow(new Object[]{listaActivos.get(i).getCuenta(), listaActivos.get(i).getMonto(), " "});
        }
        dtm.addRow(new Object[]{"Activo No Corriente", " ", " "});
        for (int i = 0; i < lisAcNocorrientes.size(); i++) {
            dtm.addRow(new Object[]{lisAcNocorrientes.get(i).getCuenta(), lisAcNocorrientes.get(i).getMonto(), " "});
        }

        //-----añadiendo pasivos y patrimonio si esque hay
        dtm2.addRow(new Object[]{"Pasivo Corriente", " ", " "});
        for (int i = 0; i < listaPasivos.size(); i++) {
            dtm2.addRow(new Object[]{listaPasivos.get(i).getCuenta(), listaPasivos.get(i).getMonto(), " "});
        }
        dtm2.addRow(new Object[]{"Pasivo No Corriente", " ", " "});
        for (int i = 0; i < listaPasivosNoCorrientes.size(); i++) {
            dtm2.addRow(new Object[]{listaPasivosNoCorrientes.get(i).getCuenta(), listaPasivosNoCorrientes.get(i).getMonto(), " "});
        }
        //--añadiendo cuentas de patrimonio
        dtm2.addRow(new Object[]{"Patrimonio", " ", " "});
        if (!listaPatrimonio.isEmpty()) {
            for (int i = 0; i < listaPatrimonio.size(); i++) {
                dtm2.addRow(new Object[]{listaPatrimonio.get(i).getCuenta(), listaPatrimonio.get(i).getMonto(), " "});
            }
        }
    }
}

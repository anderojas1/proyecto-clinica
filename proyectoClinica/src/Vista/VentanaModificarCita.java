/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.DriverPaciente;
import dataAccesss.DaoPaciente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julian
 */
public class VentanaModificarCita extends javax.swing.JFrame {

   private VentanaAdminEnfermera ventAdminEnfer;
   private DaoPaciente daoPaciente;
   private DefaultTableModel modeloTabla;        
   
    /**
     * Creates new form VentanaModificarCita
     */
    public VentanaModificarCita() throws SQLException {
        
        initComponents();
        daoPaciente = new DaoPaciente();
        
        tablaCitas.setModel(modeloTabla = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Medico", "Fecha - Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *  */
    
      public void acomodarVentana(VentanaAdminEnfermera ventAdminEnfer){
    
        this.ventAdminEnfer = ventAdminEnfer;
    
        
    }
      
     public void cargarCitas() throws SQLException{
     
         ArrayList <String[]> citasProgramadas = new ArrayList();
         
         if(campoIdPaciente.getText() != null){
            
             citasProgramadas = daoPaciente.mostrarCitasPacientes(campoIdPaciente.getText());
             
             JOptionPane.showMessageDialog(null,"tama;o citas"+citasProgramadas.size());
         
         }
         
         for(int i = 0; i < citasProgramadas.size(); i++){
             
             String idMedico = citasProgramadas.get(i)[0];
             String fecha = citasProgramadas.get(i)[1];
             String estado = citasProgramadas.get(i)[2];
             
             modeloTabla.addRow(new Object[]{idMedico,fecha,estado});
        
         }
     
     }
     
     public void limpiarTabla(){
    
        int numFilas = tablaCitas.getRowCount();
        for(int i = 0; i< numFilas; i++){
        
            modeloTabla.removeRow(0);
            //modeloTabla.removeRow(1);
       }
     }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoIdPaciente = new javax.swing.JTextField();
        btVerCitas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        btCancelarCita = new javax.swing.JButton();
        btAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setText("Modificar Cita");

        jLabel3.setText("Identificacion Paciente");

        btVerCitas.setText("Ver Citas");
        btVerCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVerCitasMouseClicked(evt);
            }
        });

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Medico", "Fecha - Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCitas);

        btCancelarCita.setText("Cancelar cita");
        btCancelarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarCitaMouseClicked(evt);
            }
        });

        btAtras.setText("Atras");
        btAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCancelarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(82, 82, 82)
                                .addComponent(campoIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btVerCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel1)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVerCitas)
                    .addComponent(jLabel3)
                    .addComponent(campoIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtrasMouseClicked
       
        ventAdminEnfer.setVisible(true);
        dispose();
    }//GEN-LAST:event_btAtrasMouseClicked

    private void btVerCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVerCitasMouseClicked
      
       try {
      
           if(campoIdPaciente.getText() != null || !"".equals(campoIdPaciente.getText())){
           
               limpiarTabla();
               cargarCitas();
           
           }
           
       } catch (SQLException ex) {
       
           JOptionPane.showMessageDialog(null, "Error en la consulta");
       
       }
    }//GEN-LAST:event_btVerCitasMouseClicked

    private void btCancelarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarCitaMouseClicked
        
        if(campoIdPaciente.getText() != null && campoIdPaciente.getText() != ""){
        
            try {
           
                daoPaciente.cancelarCita(campoIdPaciente.getText(), (String)tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 0), (String)tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 1));
            
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                
                limpiarTabla();
                cargarCitas();
            } catch (SQLException ex) {
            
                JOptionPane.showMessageDialog(null, "Error en la consulta SQL");
            
            }
        }
    }//GEN-LAST:event_btCancelarCitaMouseClicked

    
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
            java.util.logging.Logger.getLogger(VentanaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
              
                    new VentanaModificarCita().setVisible(true);
                
                } catch (SQLException ex) {
                
                    JOptionPane.showMessageDialog(null, "Error en la consulta");
                
                }catch (NullPointerException np){
                
                    JOptionPane.showMessageDialog(null, "el fallo era aca");
                    
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtras;
    private javax.swing.JButton btCancelarCita;
    private javax.swing.JButton btVerCitas;
    private javax.swing.JTextField campoIdPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}

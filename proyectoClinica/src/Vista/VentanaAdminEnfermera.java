/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import logica.Persona;

/**
 *
 * @author julian
 */
public class VentanaAdminEnfermera extends javax.swing.JFrame {

    
    private VentanaLogin ventLog;
    private Persona sesion;
    
    /**
     * Creates new form VentanaAdminEnfermera
     */
    public VentanaAdminEnfermera() {
        
        initComponents();
        this.ventLog = ventLog;
        
    }
    
    public void datosUsuario (Persona usuario) {
        
        sesion = usuario;
        lbNombreUser.setText("@" + sesion.getNombre());
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void acomodarVentana(VentanaLogin ventLog){
            
        this.ventLog = ventLog;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        lbBienvenida = new javax.swing.JLabel();
        lbNombreUser = new javax.swing.JLabel();
        btCerrarSesion = new javax.swing.JButton();
        btAsignarCama = new javax.swing.JButton();
        lbAsigCama = new javax.swing.JLabel();
        btAsignarCita = new javax.swing.JButton();
        lbAsignarCita = new javax.swing.JLabel();
        btModificarCita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        lbBienvenida.setText("Bienvenida");

        btCerrarSesion.setText("Cerrar Sesion");
        btCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCerrarSesionMouseClicked(evt);
            }
        });

        btAsignarCama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/camaPaciente.jpg"))); // NOI18N
        btAsignarCama.setBorderPainted(false);
        btAsignarCama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAsignarCamaMouseClicked(evt);
            }
        });

        lbAsigCama.setText("Asignar Cama Paciente");

        btAsignarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agenda2.jpg"))); // NOI18N
        btAsignarCita.setBorderPainted(false);
        btAsignarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAsignarCitaMouseClicked(evt);
            }
        });

        lbAsignarCita.setText("Asignar cita");

        btModificarCita.setBackground(new java.awt.Color(254, 254, 254));
        btModificarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cambiarCita.png"))); // NOI18N
        btModificarCita.setBorderPainted(false);
        btModificarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarCitaMouseClicked(evt);
            }
        });

        jLabel1.setText("Cambiar cita");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAsignarCama, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAsigCama))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAsignarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbAsignarCita)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbBienvenida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNombreUser))
                            .addComponent(btCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btModificarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBienvenida)
                            .addComponent(lbNombreUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCerrarSesion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAsignarCama)
                    .addComponent(btAsignarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btModificarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAsigCama)
                    .addComponent(lbAsignarCita)
                    .addComponent(jLabel1))
                .addContainerGap(43, Short.MAX_VALUE))
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

    private void btCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCerrarSesionMouseClicked
        
        ventLog.setVisible(true);
        ventLog.getJpfcontraseña().setText("");
        ventLog.getJtfUsuario().setText("");
        
        dispose();
        
    }//GEN-LAST:event_btCerrarSesionMouseClicked

    private void btAsignarCamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAsignarCamaMouseClicked
       
        VentanaRegCamaPaciente ventAsigCama = new VentanaRegCamaPaciente();
        
        ventAsigCama.setVisible(true);
        ventAsigCama.setLocationRelativeTo(null);
        ventAsigCama.acomodarVentana(this);
        
        dispose();
        
    }//GEN-LAST:event_btAsignarCamaMouseClicked

    private void btAsignarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAsignarCitaMouseClicked
       
        VentanaAsignacionCita ventAsigcita = new VentanaAsignacionCita();
        
        ventAsigcita.setVisible(true);
        ventAsigcita.setLocationRelativeTo(null);
        ventAsigcita.acomodarVentana(this);
        
        dispose();
    }//GEN-LAST:event_btAsignarCitaMouseClicked

    private void btModificarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarCitaMouseClicked
       
        VentanaModificarCita ventModiCita = new VentanaModificarCita();
        
        ventModiCita.setVisible(true);
        ventModiCita.setLocationRelativeTo(null);
        ventModiCita.acomodarVentana(this);
        
       dispose();
                
    }//GEN-LAST:event_btModificarCitaMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaAdminEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdminEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdminEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdminEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdminEnfermera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAsignarCama;
    private javax.swing.JButton btAsignarCita;
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btModificarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAsigCama;
    private javax.swing.JLabel lbAsignarCita;
    private javax.swing.JLabel lbBienvenida;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbNombreUser;
    // End of variables declaration//GEN-END:variables
}

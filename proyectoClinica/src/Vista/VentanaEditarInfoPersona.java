/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import controlador.DriverPersona;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Persona;

/**
 *
 * @author Santa Gutierrez
 */
public class VentanaEditarInfoPersona extends javax.swing.JFrame {

    private DriverPersona contPersona;
    private VentanaAdministrador ventAdmin;
    /**
     * Creates new form VentanaEditarInfoPMedico
     */
    public VentanaEditarInfoPersona() {
        
        initComponents();
        contPersona = new DriverPersona();
        jBEditar.setVisible(false);
        jLApellido_dos.setVisible(false);
        jLApellido_uno.setVisible(false);
        jLDireccion.setVisible(false);
        jTApellidoUno.setVisible(false);
        jTApellido_dos.setVisible(false);
        jTDireccion.setVisible(false);
        jTNombre.setVisible(false);
        jlNombre.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTIdentificacion = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLApellido_uno = new javax.swing.JLabel();
        jTApellidoUno = new javax.swing.JTextField();
        jLApellido_dos = new javax.swing.JLabel();
        jTApellido_dos = new javax.swing.JTextField();
        jLDireccion = new javax.swing.JLabel();
        jTDireccion = new javax.swing.JTextField();
        jBEditar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jBAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Editar información Persona");

        jLabel2.setText("Identificación:");

        jlNombre.setText("Nombres:");

        jLApellido_uno.setText("Primer apellido:");

        jLApellido_dos.setText("Segundo apellido:");

        jLDireccion.setText("Dirección:");

        jTDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDireccionActionPerformed(evt);
            }
        });

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBAtras.setText("Atras");
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(179, 179, 179))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLDireccion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLApellido_dos)
                                    .addComponent(jLApellido_uno))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTNombre)
                                            .addComponent(jTApellidoUno)
                                            .addComponent(jTIdentificacion)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTDireccion)
                                            .addComponent(jTApellido_dos))))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBEditar)
                                    .addComponent(jBBuscar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBAtras)))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido_uno)
                    .addComponent(jTApellidoUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido_dos)
                    .addComponent(jTApellido_dos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDireccion)
                    .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jBAtras)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDireccionActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        String identificacion = jTIdentificacion.getText();
        
        if(identificacion.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese la identificación");
        }else{
            boolean respuesta = contPersona.consultarPersonaEditar(identificacion);
            
            if(!respuesta){
                JOptionPane.showMessageDialog(null, "La persona no se encuentra en el sistema de la clinica");
            }else{
                try {
                    Persona persona = contPersona.consultarPersona(identificacion);
                     jBEditar.setVisible(true);
                     jLApellido_dos.setVisible(true);
                     jLApellido_uno.setVisible(true);
                     jLDireccion.setVisible(true);
                     jTApellidoUno.setVisible(true);
                     jTApellido_dos.setVisible(true);
                     jTDireccion.setVisible(true);
                     jTNombre.setVisible(true);
                     jlNombre.setVisible(true);
                     jBBuscar.setVisible(false);
                     jTIdentificacion.setEditable(false);
                     
                     jTApellidoUno.setText(persona.getApellidoUno());
                     jTApellido_dos.setText(persona.getApellidoDos());
                     jTDireccion.setText(persona.getDireccion());
                     jTNombre.setText(persona.getNombre());
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaEditarInfoPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
        
        String identificacion, nombres, apellido_uno, apellido_dos, direccion;
        
        identificacion=jTIdentificacion.getText();
        nombres = jTNombre.getText();
        apellido_uno = jTApellidoUno.getText();
        apellido_dos = jTApellido_dos.getText();
        direccion = jTDireccion.getText();
        
        if(nombres.equals("") || apellido_uno.equals("")){
            JOptionPane.showMessageDialog(null, "El nombre y el primer apellido son necesarios");
        }else{
        
        contPersona.editarPersona(identificacion, nombres, apellido_uno, apellido_dos, direccion);
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        // TODO add your handling code here:
        ventAdmin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBAtrasActionPerformed

    
     public void acomodarVentana(VentanaAdministrador ventAdmin){
    
        this.ventAdmin = ventAdmin;
    
    }
     
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
            java.util.logging.Logger.getLogger(VentanaEditarInfoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEditarInfoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEditarInfoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEditarInfoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEditarInfoPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtras;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JLabel jLApellido_dos;
    private javax.swing.JLabel jLApellido_uno;
    private javax.swing.JLabel jLDireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTApellidoUno;
    private javax.swing.JTextField jTApellido_dos;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTIdentificacion;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JLabel jlNombre;
    // End of variables declaration//GEN-END:variables
}

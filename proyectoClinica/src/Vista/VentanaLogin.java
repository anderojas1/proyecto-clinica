/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import excepciones.ExcepcionCamposVacios;
import excepciones.Validador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author anderojas
 */
public class VentanaLogin extends javax.swing.JFrame {
    
    private Validador validadorDatos;

    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
        validadorDatos = new Validador();
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
        jPanel2 = new javax.swing.JPanel();
        jlLogo = new javax.swing.JLabel();
        jbIniciar = new javax.swing.JButton();
        jpfcontraseña = new javax.swing.JPasswordField();
        jtfUsuario = new javax.swing.JTextField();
        jlDerechos = new javax.swing.JLabel();
        jlAño = new javax.swing.JLabel();
        jlDesarrolladores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlLogo.setBackground(new java.awt.Color(255, 255, 255));
        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logoClinica.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jlLogo)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlLogo)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jbIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iniciar-sesion.jpg"))); // NOI18N
        jbIniciar.setToolTipText("Pulse para ingresar");
        jbIniciar.setBorder(null);
        jbIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbIniciarMouseClicked(evt);
            }
        });

        jpfcontraseña.setToolTipText("Ingrese su contraseña");
        jpfcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfcontraseñaActionPerformed(evt);
            }
        });

        jtfUsuario.setToolTipText("Ingrese su usuario");
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });

        jlDerechos.setFont(new java.awt.Font("DejaVu Sans", 1, 10)); // NOI18N
        jlDerechos.setText("©Derechos reservados");

        jlAño.setFont(new java.awt.Font("DejaVu Sans", 1, 10)); // NOI18N
        jlAño.setText("2014");

        jlDesarrolladores.setFont(new java.awt.Font("Ubuntu", 3, 10)); // NOI18N
        jlDesarrolladores.setText("Desarrollado por ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(jpfcontraseña)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jlAño))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jlDerechos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlDesarrolladores)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jbIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jlDerechos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAño)
                .addGap(18, 18, 18)
                .addComponent(jlDesarrolladores)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void iniciarSesion () {
        
        try {
        
            if (validarAcceso() == true) {
            
                JOptionPane.showMessageDialog(this, "Nos encontramos en desarrollo", "Módulo sin desarrollar", JOptionPane.INFORMATION_MESSAGE);
            
            }
        
            else JOptionPane.showMessageDialog(this, "Usuario o contraseña inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (ExcepcionCamposVacios ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Campos obligatorios sin llenar", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    
    private boolean validarAcceso () throws ExcepcionCamposVacios {
        
        String pass = new String(jpfcontraseña.getPassword());
        String user = jtfUsuario.getText();
        
        ArrayList <String> campos = new ArrayList<>();
        campos.add(user);
        campos.add(pass);
        
        validadorDatos.validarModulos(campos);
        
        return jtfUsuario.getText().equals("admin") && pass.equals("12345");
    }
    
    private void jpfcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfcontraseñaActionPerformed

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void jbIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbIniciarMouseClicked
        
        iniciarSesion ();
    }//GEN-LAST:event_jbIniciarMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JLabel jlAño;
    private javax.swing.JLabel jlDerechos;
    private javax.swing.JLabel jlDesarrolladores;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JPasswordField jpfcontraseña;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}

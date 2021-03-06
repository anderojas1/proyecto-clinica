/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.*;
import java.awt.event.*;
import excepciones.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author anderojas
 */
public class VentanaLogin extends javax.swing.JFrame {
    
    private Validador validadorDatos;
    private final DriverPersona controladorPersona;

    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
        
        validadorDatos = new Validador();
        
        controladorPersona = new DriverPersona();
                
        setResizable(false);
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
        setPassword = new javax.swing.JButton();

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
                .addGap(106, 106, 106)
                .addComponent(jlLogo)
                .addContainerGap(119, Short.MAX_VALUE))
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
        jbIniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbIniciarKeyPressed(evt);
            }
        });

        jpfcontraseña.setToolTipText("Ingrese su contraseña");
        jpfcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfcontraseñaActionPerformed(evt);
            }
        });
        jpfcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfcontraseñaKeyPressed(evt);
            }
        });

        jtfUsuario.setToolTipText("Ingrese su usuario");
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });

        jlDerechos.setFont(new java.awt.Font("DejaVu Sans", 1, 10)); // NOI18N
        jlDerechos.setText("©Derechos reservados");

        jlAño.setFont(new java.awt.Font("DejaVu Sans", 1, 10)); // NOI18N
        jlAño.setText("2014");

        jlDesarrolladores.setFont(new java.awt.Font("Ubuntu", 3, 10)); // NOI18N
        jlDesarrolladores.setText("Desarrollado por ");

        setPassword.setBackground(new java.awt.Color(254, 254, 254));
        setPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help.jpg"))); // NOI18N
        setPassword.setToolTipText("Establecer contraseña");
        setPassword.setBorder(null);
        setPassword.setBorderPainted(false);
        setPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPasswordActionPerformed(evt);
            }
        });

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
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(jpfcontraseña)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(setPassword))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jlAño))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jlDerechos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlDesarrolladores)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(setPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jbIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
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
            
            String perfil = validarAcceso();
        
            if ("administrador".equals(perfil)) {
            
                VentanaAdministrador ventAdmin = new VentanaAdministrador();
                             
                ventAdmin.setVisible(true);
                ventAdmin.setLocationRelativeTo(null);
                ventAdmin.acomodarVentana(this);
                ventAdmin.datosUsuario(controladorPersona.consultarPersona(jtfUsuario.getText()));               
               
               dispose();
            
            } else if("Enfermera".equals(perfil)){
                
                VentanaAdminEnfermera ventEnfer =  new VentanaAdminEnfermera();
                
                ventEnfer.setVisible(true);
                ventEnfer.setLocationRelativeTo(null);
                ventEnfer.acomodarVentana(this);
                ventEnfer.datosUsuario(controladorPersona.consultarPersona(jtfUsuario.getText()));
                                
                dispose();           
            
            } else if("Medico".equals(perfil)){
                
                VentanaAdminMedico ventDoc = new VentanaAdminMedico();
                
                ventDoc.setVisible(true);
                ventDoc.setLocationRelativeTo(null);
                ventDoc.acomodarVentana(this);
                ventDoc.datosUsuario(controladorPersona.consultarPersona(jtfUsuario.getText()));
                
                dispose();
            
            
            } else if ("Paciente".equals(perfil)) {
                
                VentanaPaciente paciente = new VentanaPaciente();
                paciente.setLocationRelativeTo(null);
                paciente.setVisible(true);
                paciente.datosPaciente(controladorPersona.consultarPersona(jtfUsuario.getText()));
                
                dispose();
            }
            
            else {
                
                JOptionPane.showMessageDialog(this, "Usuario o contraseña inválidos", "Error", JOptionPane.ERROR_MESSAGE);
                jpfcontraseña.setText("");
                
            }
            
        } catch (ExcepcionCamposVacios ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Campos obligatorios sin llenar", JOptionPane.ERROR_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Verificación fallida", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    private String validarAcceso () throws ExcepcionCamposVacios, SQLException {
        
        String pass = new String(jpfcontraseña.getPassword());
        String user = jtfUsuario.getText();
        
        ArrayList <String> campos = new ArrayList<>();
        campos.add(user);
        campos.add(pass);
        
        validadorDatos.validarModulos(campos);
            
        String perfil = controladorPersona.consultarPerfil(user, pass);

        return perfil;
        
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

    private void jbIniciarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbIniciarKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbIniciarKeyPressed

    private void jpfcontraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfcontraseñaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) iniciarSesion();
    }//GEN-LAST:event_jpfcontraseñaKeyPressed

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) iniciarSesion();
    }//GEN-LAST:event_jtfUsuarioKeyPressed

    private void setPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPasswordActionPerformed
        
        EstablecerPassword interfazPass = new EstablecerPassword();
        interfazPass.setLocationRelativeTo(null);
        interfazPass.setVisible(true);
        
        dispose ();
        
    }//GEN-LAST:event_setPasswordActionPerformed

    public JPasswordField getJpfcontraseña() {
        return jpfcontraseña;
    }

    public void setJpfcontraseña(JPasswordField jpfcontraseña) {
        this.jpfcontraseña = jpfcontraseña;
    }

    public JTextField getJtfUsuario() {
        return jtfUsuario;
    }

    public void setJtfUsuario(JTextField jtfUsuario) {
        this.jtfUsuario = jtfUsuario;
    }

   

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
    private javax.swing.JButton setPassword;
    // End of variables declaration//GEN-END:variables
}

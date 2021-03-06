/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.ArrayList;
import logica.Telefono;
import controlador.*;
import excepciones.ExcepcionCamposVacios;
import excepciones.Validador;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.*;

/**
 *
 * @author juliancv
 */
public class VentanaRegistroEmpleado extends javax.swing.JFrame {

    
    private VentanaAdministrador ventAdmin;
    private String [] datosPersonales;
    private ArrayList<Telefono> telefonos;
    private ArrayList<String[]> infoAreas;
    private DriverEmpleado controladorEmpleado = new DriverEmpleado();
    private DriverEnfermera infoEnfermeras = new DriverEnfermera ();
    private DriverArea areas = new DriverArea();
    
    /**
     * Creates new form VentanaRegistroEmpleado
     */
    public VentanaRegistroEmpleado() {
        initComponents();
        consultarAreasClinica();
        consultarEmpleadosClinica();
    }
    
    public void acomodarVentana(VentanaAdministrador ventAdmin){
    
        this.ventAdmin = ventAdmin;
        
    }
    
    public void setDatosPersonales (String [] datos, ArrayList<Telefono> num_tel) {
        
        datosPersonales = datos;
        telefonos = num_tel;
        
    }
    
    private void consultarAreasClinica () {
        
        comboAreaEmpleado.removeAllItems();
        
        try {
            
            infoAreas = areas.consultarAreas();
            
            for (String[] nombreArea : infoAreas) {
                
                comboAreaEmpleado.addItem(nombreArea[1]);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de módulo", JOptionPane.ERROR_MESSAGE);
            ventAdmin.setVisible(true);
            
            dispose();
            
        }
        
    }
    
    
    private void consultarEmpleadosClinica () {
        
        boolean buscarTodos = true;
        comboJefes.removeAllItems();
        
        if (comboCargoEmpleado.getSelectedItem().toString().equals("Medico")) buscarTodos = false;
        
        try {
                        
            ArrayList<String[]> datos = controladorEmpleado.consultarEmpleados(buscarTodos);
            
            for (String [] empleados : datos) {
                
                comboJefes.addItem(empleados[0].toString());
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de módulo", JOptionPane.ERROR_MESSAGE);
            ventAdmin.setVisible(true);
            
            dispose();
            
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboAreaEmpleado = new javax.swing.JComboBox();
        campoSalarioEmpleado = new javax.swing.JTextField();
        campoEmailEmpleado = new javax.swing.JTextField();
        comboCargoEmpleado = new javax.swing.JComboBox();
        comboJefes = new javax.swing.JComboBox();
        btAgregar = new javax.swing.JButton();
        btAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setText("Registro Empleado");

        jLabel2.setText("Codigo Area");

        jLabel3.setText("Salario");

        jLabel4.setText("Email");

        jLabel5.setText("Cargo");

        jLabel6.setText("Jefe");

        comboAreaEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Area1" }));
        comboAreaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaEmpleadoActionPerformed(evt);
            }
        });

        comboCargoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Medico", "Enfermera" }));
        comboCargoEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCargoEmpleadoItemStateChanged(evt);
            }
        });

        comboJefes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "jefe" }));

        btAgregar.setText("Agregar");
        btAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarMouseClicked(evt);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoSalarioEmpleado)
                            .addComponent(comboAreaEmpleado, 0, 226, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(168, 168, 168)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoEmailEmpleado)
                            .addComponent(comboJefes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCargoEmpleado, 0, 226, Short.MAX_VALUE))))
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(comboAreaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmailEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboCargoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboJefes, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregar)
                    .addComponent(btAtras))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAreaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAreaEmpleadoActionPerformed

    private void btAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtrasMouseClicked
     
        ventAdmin.setVisible(true);
        dispose();
    }//GEN-LAST:event_btAtrasMouseClicked

    private void btAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarMouseClicked
        
        try {
            
            String area = infoAreas.get(comboAreaEmpleado.getSelectedIndex())[0];        
            String salario = campoSalarioEmpleado.getText();
            String email = campoEmailEmpleado.getText();
            String tipoUsuario = comboCargoEmpleado.getSelectedItem().toString();
            String jefe = datosPersonales[4];
            
            try {
                
                jefe = comboJefes.getSelectedItem().toString();
                
            } catch (NullPointerException ex) {
                
                JOptionPane.showMessageDialog(this, "No hay empleados registrados. Jefe por defecto", "Sobre información de jefe", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
            String [] validarDatos = {salario, email};            
            
            Validador validar = new Validador();
            validar.validarModulos(validarDatos);
            
            double salarioEmpleado = Double.parseDouble(salario);
            
            Object [] datosEmpleado = {area, salarioEmpleado, email, tipoUsuario, jefe};
        
            if(comboCargoEmpleado.getSelectedItem() == "Medico"){
        
                VentanaRegistroMedico ventRegMedico = new VentanaRegistroMedico();
                ventRegMedico.establecerDatosEmpleado(telefonos, datosPersonales, datosEmpleado);
                ventRegMedico.setVisible(true);
                ventRegMedico.setLocationRelativeTo(null);
                ventRegMedico.acomodarVentana(this, ventAdmin);

                dispose();

            } else if (comboCargoEmpleado.getSelectedItem() == "Enfermera") {

                VentanaRegEnfermera ventRegEnfermera = new VentanaRegEnfermera();
                ventRegEnfermera.setVisible(true);
                ventRegEnfermera.setLocationRelativeTo(null);
                ventRegEnfermera.acomodarVentana(this, ventAdmin);
                ventRegEnfermera.establecerDatosEmpleado(telefonos, datosPersonales, datosEmpleado);

                dispose();

            }
            
        } catch (NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(this, "El campo salario debe ser numérico", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            
        } catch (ExcepcionCamposVacios ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Campos requeridos sin llenar", JOptionPane.ERROR_MESSAGE);
            
        }
                
    }//GEN-LAST:event_btAgregarMouseClicked

    private void comboCargoEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCargoEmpleadoItemStateChanged
        
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
           
            consultarEmpleadosClinica();
            
        }
    }//GEN-LAST:event_comboCargoEmpleadoItemStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAtras;
    private javax.swing.JTextField campoEmailEmpleado;
    private javax.swing.JTextField campoSalarioEmpleado;
    private javax.swing.JComboBox comboAreaEmpleado;
    private javax.swing.JComboBox comboCargoEmpleado;
    private javax.swing.JComboBox comboJefes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

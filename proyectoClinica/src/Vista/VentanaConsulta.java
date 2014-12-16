/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.DriverCausa;
import controlador.DriverMedicamento;
import controlador.DriverPaciente;
import dataAccesss.DaoPaciente;
import excepciones.ExcepcionCamposVacios;
import excepciones.Validador;
import java.sql.Driver;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Persona;

/**
 *
 * @author julian
 */
public class VentanaConsulta extends javax.swing.JFrame {

    private VentanaAdminMedico ventAdminMed;
    private DefaultTableModel modeloMedicamento;
    private DefaultTableModel modeloCausa;
    private Persona sesionActiva;
    private DriverPaciente paciente = new DriverPaciente();
    private Validador validar = new Validador();
    private DriverMedicamento medicamentos = new DriverMedicamento();
    private ArrayList<Object[]> datosMedicina;
    private ArrayList<String[]> datosCausas;
    private DriverCausa causa = new DriverCausa();
    private String numHistoria;
    private String fecha_hora;
    
    /**
     * Creates new form VentanaConsulta
     */
    public VentanaConsulta() {
        
        modeloMedicamento = new DefaultTableModel (new Object [][] {

            },
            new String [] {
                "ID medicamento", "Nombre", "Cantidad", "Costo"
            });
        
        modeloCausa = new DefaultTableModel (new Object [][] {

            },
            new String [] {
                "ID causa", "Nombre"
            });
        
        initComponents();
    
    }
    
    
    public void setSesion (Persona sesion) {
        
        sesionActiva = sesion;
        lbMedico.setText(sesionActiva.getNombre());
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void acomodarVentana(VentanaAdminMedico ventAdminMed){
        
        this.ventAdminMed = ventAdminMed;
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbMedico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoIDHClinica = new javax.swing.JTextField();
        comboMedicamentos = new javax.swing.JComboBox();
        btAgregarMedicamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable(modeloMedicamento);
        campoCantidadMedica = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btEliminarMedica = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCausas = new javax.swing.JTable(modeloCausa);
        comboCausas = new javax.swing.JComboBox();
        btAgregarCausa = new javax.swing.JButton();
        btEliminarCausa = new javax.swing.JButton();
        btGuardarConsulta = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        btNuevaCausa = new javax.swing.JButton();
        consultarCita = new javax.swing.JButton();
        comboHoras = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setText("Consulta Medica");

        jLabel2.setText("Medico");

        jLabel3.setText("Numero H.Clinica");

        jLabel6.setText("Medicamentos");

        jLabel7.setText("Causa");

        comboMedicamentos.setEnabled(false);

        btAgregarMedicamento.setText("Agregar");
        btAgregarMedicamento.setEnabled(false);
        btAgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarMedicamentoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tablaMedicamentos);

        campoCantidadMedica.setEnabled(false);

        jLabel8.setText("cantidad");

        btEliminarMedica.setText("Eliminar");
        btEliminarMedica.setEnabled(false);

        jScrollPane2.setViewportView(tablaCausas);

        comboCausas.setEnabled(false);

        btAgregarCausa.setText("Agregar");
        btAgregarCausa.setEnabled(false);
        btAgregarCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCausaActionPerformed(evt);
            }
        });

        btEliminarCausa.setText("Eliminar");
        btEliminarCausa.setEnabled(false);

        btGuardarConsulta.setText("Guardar");
        btGuardarConsulta.setEnabled(false);
        btGuardarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarConsultaActionPerformed(evt);
            }
        });

        btSalir.setText("Salir");
        btSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSalirMouseClicked(evt);
            }
        });

        btNuevaCausa.setText("Nueva");
        btNuevaCausa.setEnabled(false);
        btNuevaCausa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNuevaCausaMouseClicked(evt);
            }
        });

        consultarCita.setText("Consultar cita");
        consultarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCitaActionPerformed(evt);
            }
        });

        comboHoras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30" }));

        jLabel4.setText("Hora consulta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(415, 415, 415))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(396, 396, 396))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btEliminarCausa)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btGuardarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(comboMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(campoCantidadMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btAgregarMedicamento)
                                .addGap(160, 160, 160))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoIDHClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(consultarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btEliminarMedica)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(comboCausas, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btAgregarCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btNuevaCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIDHClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(consultarCita))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregarMedicamento)
                    .addComponent(campoCantidadMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminarMedica)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btAgregarCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNuevaCausa)
                    .addComponent(comboCausas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEliminarCausa)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevaCausaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNuevaCausaMouseClicked
       
        VentanaRegistroCausaMedica ventRegCausa =  new VentanaRegistroCausaMedica();
        
        ventRegCausa.setVisible(true);
        ventRegCausa.setLocationRelativeTo(null);
        ventRegCausa.acomodarVentana(this);
        
        dispose();
        
    }//GEN-LAST:event_btNuevaCausaMouseClicked

    private void btSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalirMouseClicked
        
        ventAdminMed.setVisible(true);
        dispose();
    }//GEN-LAST:event_btSalirMouseClicked

    private void consultarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCitaActionPerformed
        
        numHistoria = campoIDHClinica.getText();
        
        try {
            
            validar.validarCampo(numHistoria);
            
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String horaConsulta = comboHoras.getSelectedItem().toString();
            
            fecha_hora = fecha + " " + horaConsulta;
            
            boolean asignado = paciente.consultarCitasPaciente(numHistoria, sesionActiva.getIdentificacion(), fecha_hora);
            
            activarCampos ();
            
            if (asignado) {
                
                JOptionPane.showMessageDialog(this, "Cita encontrada", "Consulta exitosa", JOptionPane.INFORMATION_MESSAGE);
                consultarCita.setEnabled(false);
                campoIDHClinica.setEditable(false);
                
            } else JOptionPane.showMessageDialog(this, "No hay citas para el día " + fecha + " para el paciente " +
                    numHistoria, "No hay citas", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (ExcepcionCamposVacios ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información incompleta", JOptionPane.ERROR_MESSAGE);
            
        } catch (SQLException ex) {
            
            
        }
    }//GEN-LAST:event_consultarCitaActionPerformed

    private void btAgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarMedicamentoActionPerformed
        
        try {
            
            int cantidad = Integer.parseInt(campoCantidadMedica.getText());
            
            Object[] medicamento_seleccionado = datosMedicina.get(comboMedicamentos.getSelectedIndex());
            String id = medicamento_seleccionado[0].toString();
            String nombre = medicamento_seleccionado[1].toString();
            double precio = cantidad * Double.parseDouble(medicamento_seleccionado[2].toString());
            
            Object[] registrar = {id, nombre, cantidad, precio};
            
            modeloMedicamento.addRow(registrar);
            
            campoCantidadMedica.setText("");
            
        } catch (NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(this, "Se requiere un dato numérico en cantidad", "Información requerida", 
                    JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btAgregarMedicamentoActionPerformed

    private void btGuardarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarConsultaActionPerformed
        
        if (tablaCausas.getRowCount() > 0) {
            
            ArrayList<String> codigosMedicamento = new ArrayList<>();
            
            for (int i = 0; i < tablaMedicamentos.getRowCount(); i++) {
                
                codigosMedicamento.add(tablaMedicamentos.getValueAt(i, 0).toString());
                
            }
            
            ArrayList<String> codigosCausa = new ArrayList<>();
            
            for (int i = 0; i < tablaCausas.getRowCount(); i++) {
                
                codigosCausa.add(tablaCausas.getValueAt(i, 0).toString());
                
            }
            
            
        }
        
        else JOptionPane.showMessageDialog(this, "Se requiere al menos una causa motivo de la consulta", "Información requerida", 
                    JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btGuardarConsultaActionPerformed

    private void btAgregarCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCausaActionPerformed

        modeloCausa.addRow(datosCausas.get(comboCausas.getSelectedIndex()));

    }//GEN-LAST:event_btAgregarCausaActionPerformed

    
    private void activarCampos () {
        
        campoCantidadMedica.setEnabled(true);
        comboMedicamentos.setEnabled(true);
        btAgregarMedicamento.setEnabled(true);
        btEliminarCausa.setEnabled(true);
        btEliminarMedica.setEnabled(true);
        btAgregarCausa.setEnabled(true);
        btNuevaCausa.setEnabled(true);
        btGuardarConsulta.setEnabled(true);
        comboCausas.setEnabled(true);
        
        cargarMedicamentos ();
        cargarCausas();
    }
    
    
    public void cargarMedicamentos () {
        
        comboMedicamentos.removeAllItems();
        
        try {
            
            datosMedicina = medicamentos.consultarMedicamentos();
            
            for (Object[] dato : datosMedicina) {
                
                comboMedicamentos.addItem(dato[1]);
                
            }
            
        } catch (SQLException ex) {
            
            
        }
    }
    
    public void cargarCausas () {
        
        comboCausas.removeAllItems();
        
        try {
            
            datosCausas = causa.consultarCausas();
            
            for (String [] dato : datosCausas) {
                
                comboCausas.addItem(dato[1]);
                
            }
            
        } catch (SQLException ex) {
            
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarCausa;
    private javax.swing.JButton btAgregarMedicamento;
    private javax.swing.JButton btEliminarCausa;
    private javax.swing.JButton btEliminarMedica;
    private javax.swing.JButton btGuardarConsulta;
    private javax.swing.JButton btNuevaCausa;
    private javax.swing.JButton btSalir;
    private javax.swing.JTextField campoCantidadMedica;
    private javax.swing.JTextField campoIDHClinica;
    private javax.swing.JComboBox comboCausas;
    private javax.swing.JComboBox comboHoras;
    private javax.swing.JComboBox comboMedicamentos;
    private javax.swing.JButton consultarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMedico;
    private javax.swing.JTable tablaCausas;
    private javax.swing.JTable tablaMedicamentos;
    // End of variables declaration//GEN-END:variables
}

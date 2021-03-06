/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import logica.Persona;
import controlador.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.*;
import logica.Telefono;
import excepciones.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import logica.Cama;
import logica.Medicamento;

/**
 *
 * @author juliancv
 */
public class VentanaAdministrador extends javax.swing.JFrame {

    private VentanaLogin ventLog;
    private Persona sesion;
    private Validador validar = new Validador();
    private DriverArea area;
    private DriverCausa causa;
    private DriverCama driverCama = new DriverCama();
    private ArrayList<String[]> infoAreas;
    private DefaultTableModel modeloTablaCamas;
    private DefaultTableModel modeloTablaMedicamento;
    private ArrayList<Cama> camilla = new ArrayList<>();
    private ArrayList<ArrayList<String>>areas = new ArrayList<>();
    private ArrayList<ArrayList<String>>causas = new ArrayList<>();
    
    
    private ArrayList <Telefono> telefonos = new ArrayList<>();
    
    /**
     * Creates new form VentanaAdministrador
     */
    public VentanaAdministrador() {
        
        modeloTablaCamas = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "# inventario", "Descripción", "Área", "Estado", "En servicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, Boolean.class, Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        modeloTablaMedicamento = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        initComponents();
        causa = new DriverCausa();
        area = new DriverArea();
        cargarAreas();
        agregarCamillasInformacion();
        cargarMedicamentos();
        actualizarArea(false);
        actualizarCausa(false);
        
    }
    
    
    public void agregarCamillasInformacion () {
        
        for (int i = tablaInformacionCamas.getRowCount(); i > 0; i--) {
            
            modeloTablaCamas.removeRow(i-1);
            
        }
        
        try {
            
            ArrayList<Cama> camas = driverCama.listarCamasActivas();
            
            for (int i = 0; i < camas.size(); i++) {
                
                Cama nuevaCama = camas.get(i);
                
                Object [] datosCamas = {
                    
                    nuevaCama.getNumeroInventario(), nuevaCama.getDescripcion(), nuevaCama.getCod_area(),
                    nuevaCama.getEstado(), nuevaCama.getActivoInventario()
                };
                
                modeloTablaCamas.addRow(datosCamas);
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex.getMessage());
        }
        
    }
    
    
    public void datosUsuario (Persona usuario) {
        
        sesion = usuario;
        lbUser.setText("@" + sesion.getNombre());
        
    }
    
    public void registrarArea () {
        
        String codigo = campoCodigoArea.getText();
        String nombre = campoNombreArea.getText();
        String descripcion = areaDescripArea.getText();
        boolean estado = true;
        try {
            
            area.registrarArea(codigo, nombre, descripcion, estado);
            JOptionPane.showMessageDialog(this, "Se ha registrado el área correctamente",
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            
            cargarAreas();
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "Error en el registro",
                "Registro fallido", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void registrarCausa () {
        
        String codigo = campoCodigoCausa.getText();
        String nombre = campoNombreCausa.getText();
        String descripcion = areaDescripCausa.getText();
        causa.registrarCausa(codigo, nombre, descripcion);
        JOptionPane.showMessageDialog(this, "Se ha registrado la causa correctamente",
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        actualizarCausa(false);
        
    }
    
    public void actualizarArea(boolean flag){
        DefaultTableModel modelArea = (DefaultTableModel) tablaArea.getModel();
        if(modelArea.getRowCount()>0&&flag){
            for(int i=0;i<modelArea.getRowCount();i++){
                if(tablaArea.getValueAt(i, 1).toString()!=areas.get(i).get(1)
                 ||tablaArea.getValueAt(i, 2).toString()!=areas.get(i).get(2)){
                    area.editarArea(areas.get(i).get(0), tablaArea.getValueAt(i, 1).toString(), tablaArea.getValueAt(i, 2).toString(), true);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                }
            }
        }
        
        else{
        
        areas = area.listarAreas();
        
        while(modelArea.getRowCount()>0){modelArea.removeRow(0);}
        int sizeArea=areas.size();
        for(int i=0;i<sizeArea;i++){
            modelArea.addRow(new Object[]{areas.get(i).get(0), areas.get(i).get(1), areas.get(i).get(2)});
        }
        }
    }
    
    public void actualizarCausa(boolean flag){
        DefaultTableModel modelCausa = (DefaultTableModel) tablaCausa.getModel();
        if(modelCausa.getRowCount()>0&&flag){
            for(int i=0;i<modelCausa.getRowCount();i++){
                if(tablaCausa.getValueAt(i, 1).toString()!=causas.get(i).get(1)
                 ||tablaCausa.getValueAt(i, 2).toString()!=causas.get(i).get(2)){
                    causa.editarCausa(causas.get(i).get(0), tablaCausa.getValueAt(i, 1).toString(), tablaCausa.getValueAt(i, 2).toString());
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                }
            }
        }
        
        else{
        
        causas = causa.listarCausas();
        
        while(modelCausa.getRowCount()>0){modelCausa.removeRow(0);}
        int sizeCausa=causas.size();
        for(int i=0;i<sizeCausa;i++){
            modelCausa.addRow(new Object[]{causas.get(i).get(0), causas.get(i).get(1), causas.get(i).get(2)});
        }
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

        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lbCodAreaCama = new javax.swing.JLabel();
        lbNumCama = new javax.swing.JLabel();
        lbDescripCama = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaDescripCama = new javax.swing.JTextArea();
        comboAreasCama = new javax.swing.JComboBox();
        btAgregarCama = new javax.swing.JButton();
        campoNumeroCama = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaInformacionCamas = new javax.swing.JTable();
        actualizarInformacionCamas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbNombreMedicamento = new javax.swing.JLabel();
        lbCodigoMedicamento = new javax.swing.JLabel();
        lbCostoMedicamento = new javax.swing.JLabel();
        lbDescripMedicamento = new javax.swing.JLabel();
        campoNomMedicamento = new javax.swing.JTextField();
        campoCodigoMedicamento = new javax.swing.JTextField();
        campoCostoMedicamento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaDescripMedicamento = new javax.swing.JTextArea();
        btAgregarMedicamento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaInformacionMedicamentos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        EliminarMedicamento = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbSubTituloArea = new javax.swing.JLabel();
        lbNombreArea = new javax.swing.JLabel();
        lbCodigoArea = new javax.swing.JLabel();
        lbDescripArea = new javax.swing.JLabel();
        campoNombreArea = new javax.swing.JTextField();
        campoCodigoArea = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescripArea = new javax.swing.JTextArea();
        btAgregarArea = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaArea = new javax.swing.JTable();
        btEditarArea = new javax.swing.JButton();
        btActualizarArea = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btListaEmpleados = new javax.swing.JButton();
        btCuentasEmpleados = new javax.swing.JButton();
        lbListaEmpleados = new javax.swing.JLabel();
        lbCuentasEmpleados = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbNombreUsu = new javax.swing.JLabel();
        lbPApellidoUsu = new javax.swing.JLabel();
        lbSApellidoUsu = new javax.swing.JLabel();
        lbTipoIdenUsu = new javax.swing.JLabel();
        lbNumIdenUsu = new javax.swing.JLabel();
        lbTelUsu = new javax.swing.JLabel();
        lbDirUsu = new javax.swing.JLabel();
        LbTipoUsu = new javax.swing.JLabel();
        campoNomUsu = new javax.swing.JTextField();
        campoSApellido = new javax.swing.JTextField();
        campoPApellido = new javax.swing.JTextField();
        comboTipoIdent = new javax.swing.JComboBox();
        campoNumIdenUsu = new javax.swing.JTextField();
        campoDirUsu = new javax.swing.JTextField();
        combotipoUsu = new javax.swing.JComboBox();
        btAgregarUsu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        registrarTelefono = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBEditarP = new javax.swing.JButton();
        jBConsultarM = new javax.swing.JButton();
        jBConsultarE = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lbSubTituloCausa = new javax.swing.JLabel();
        lbNombreCausa = new javax.swing.JLabel();
        campoNombreCausa = new javax.swing.JTextField();
        campoCodigoCausa = new javax.swing.JTextField();
        lbCodigoCausa = new javax.swing.JLabel();
        lbDescripCausa = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaDescripCausa = new javax.swing.JTextArea();
        btAgregarCausa = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaCausa = new javax.swing.JTable();
        btActualizarCausa = new javax.swing.JButton();
        btEliminarCausa = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        btCerrarSesion = new javax.swing.JButton();
        lbBienvenido = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));

        lbCodAreaCama.setText("Codigo de Area");

        lbNumCama.setText("Numero ");

        lbDescripCama.setText("Descripcion");

        AreaDescripCama.setColumns(20);
        AreaDescripCama.setLineWrap(true);
        AreaDescripCama.setRows(5);
        AreaDescripCama.setWrapStyleWord(true);
        jScrollPane1.setViewportView(AreaDescripCama);

        btAgregarCama.setText("Agregar");
        btAgregarCama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCamaActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(254, 254, 254));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información y edición de camas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(1, 1, 1)));

        tablaInformacionCamas.setModel(modeloTablaCamas);
        jScrollPane4.setViewportView(tablaInformacionCamas);
        if (tablaInformacionCamas.getColumnModel().getColumnCount() > 0) {
            tablaInformacionCamas.getColumnModel().getColumn(0).setResizable(false);
            tablaInformacionCamas.getColumnModel().getColumn(1).setResizable(false);
            tablaInformacionCamas.getColumnModel().getColumn(3).setResizable(false);
            tablaInformacionCamas.getColumnModel().getColumn(4).setResizable(false);
        }

        actualizarInformacionCamas.setText("Actualizar datos");
        actualizarInformacionCamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarInformacionCamasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Las camas cuyo estado sea ocupado, no podrán ser dadas de baja ni cambiadas a otra área");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(actualizarInformacionCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarInformacionCamas)
                    .addComponent(jLabel1)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumCama)
                    .addComponent(lbCodAreaCama))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAgregarCama, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAreasCama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campoNumeroCama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(lbDescripCama)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNumCama)
                            .addComponent(campoNumeroCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescripCama, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCodAreaCama, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAreasCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAgregarCama))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Camas", jPanel3);

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));

        lbNombreMedicamento.setText("Nombre");

        lbCodigoMedicamento.setText("Codigo");

        lbCostoMedicamento.setText("Costo");

        lbDescripMedicamento.setText("Descripcion");

        AreaDescripMedicamento.setColumns(20);
        AreaDescripMedicamento.setRows(5);
        jScrollPane2.setViewportView(AreaDescripMedicamento);

        btAgregarMedicamento.setText("Agregar");
        btAgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarMedicamentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Nuevo Medicamento");

        jPanel11.setBackground(new java.awt.Color(254, 254, 254));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información sobre medicamentos registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(2, 125, 168)));

        tablaInformacionMedicamentos.setModel(modeloTablaMedicamento);
        jScrollPane6.setViewportView(tablaInformacionMedicamentos);

        jButton2.setText("Actualizar información");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        EliminarMedicamento.setText("Eliminar medicamento");
        EliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarMedicamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliminarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(EliminarMedicamento))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbNombreMedicamento)
                                .addComponent(lbCodigoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoCodigoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoNomMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbCostoMedicamento)
                                .addComponent(lbDescripMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btAgregarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoCostoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(36, 36, 36)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreMedicamento)
                            .addComponent(campoNomMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCodigoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCodigoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCostoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCostoMedicamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescripMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btAgregarMedicamento)))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Medicamentos", jPanel4);

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));

        lbSubTituloArea.setText(" Nueva Area");

        lbNombreArea.setText("Nombre");

        lbCodigoArea.setText("Codigo");

        lbDescripArea.setText("Descripcion");

        areaDescripArea.setColumns(20);
        areaDescripArea.setLineWrap(true);
        areaDescripArea.setRows(5);
        areaDescripArea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(areaDescripArea);

        btAgregarArea.setText("Agregar");
        btAgregarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarAreaActionPerformed(evt);
            }
        });

        tablaArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripción"
            }
        ));
        jScrollPane7.setViewportView(tablaArea);

        btEditarArea.setText("Eliminar Registro");
        btEditarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarAreaActionPerformed(evt);
            }
        });

        btActualizarArea.setText("Actualizar Datos");
        btActualizarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbNombreArea)
                                .addGap(88, 88, 88)
                                .addComponent(campoNombreArea, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btAgregarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbCodigoArea)
                                        .addComponent(lbDescripArea))
                                    .addGap(71, 71, 71)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoCodigoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(btActualizarArea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btEditarArea))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(lbSubTituloArea)))
                .addGap(409, 409, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbSubTituloArea)
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombreArea)
                            .addComponent(campoNombreArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCodigoArea)
                            .addComponent(campoCodigoArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescripArea)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarArea)
                    .addComponent(btEditarArea)
                    .addComponent(btActualizarArea))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Areas", jPanel6);

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));

        btListaEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/listado.jpg"))); // NOI18N
        btListaEmpleados.setBorderPainted(false);
        btListaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btListaEmpleadosMouseClicked(evt);
            }
        });

        btCuentasEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cuentas.jpg"))); // NOI18N
        btCuentasEmpleados.setBorderPainted(false);
        btCuentasEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCuentasEmpleadosMouseClicked(evt);
            }
        });

        lbListaEmpleados.setText("Lista Empleados");

        lbCuentasEmpleados.setText("Costos");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbListaEmpleados)
                    .addComponent(btListaEmpleados))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btCuentasEmpleados))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lbCuentasEmpleados)))
                .addContainerGap(745, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCuentasEmpleados)
                    .addComponent(btListaEmpleados))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbListaEmpleados)
                    .addComponent(lbCuentasEmpleados))
                .addContainerGap(286, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel7);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        lbNombreUsu.setText("Nombre Completo");

        lbPApellidoUsu.setText("Primer Apellido");

        lbSApellidoUsu.setText("Segundo Apellido");

        lbTipoIdenUsu.setText("Tipo Identificacion");

        lbNumIdenUsu.setText("Numero de Identificacion");

        lbTelUsu.setText("Telefono");

        lbDirUsu.setText("Direccion");

        LbTipoUsu.setText("Tipo de Usuario");

        campoPApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPApellidoActionPerformed(evt);
            }
        });

        comboTipoIdent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula de Ciudadania", "Cedula de Extranjeria", "Tarjeta de Identidad", "Registro Civil" }));

        combotipoUsu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paciente", "Empleado" }));

        btAgregarUsu.setText("Siguiente");
        btAgregarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarUsuActionPerformed(evt);
            }
        });

        jLabel2.setText("Nuevo Usuario");

        registrarTelefono.setText("registrar teléfono");
        registrarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarTelefonoActionPerformed(evt);
            }
        });

        jLabel4.setText("Opciones");

        jBEditarP.setText("Editar Persona");
        jBEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarPActionPerformed(evt);
            }
        });

        jBConsultarM.setText("Consultar Medico");
        jBConsultarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarMActionPerformed(evt);
            }
        });

        jBConsultarE.setText("Concultar Enfermera");
        jBConsultarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAgregarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbTipoUsu)
                            .addComponent(lbSApellidoUsu)
                            .addComponent(lbPApellidoUsu)
                            .addComponent(lbTipoIdenUsu)
                            .addComponent(lbDirUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNumIdenUsu)
                            .addComponent(lbTelUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoSApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(campoPApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(campoNomUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(combotipoUsu, 0, 301, Short.MAX_VALUE)
                            .addComponent(comboTipoIdent, 0, 301, Short.MAX_VALUE)
                            .addComponent(campoNumIdenUsu)
                            .addComponent(campoDirUsu)
                            .addComponent(registrarTelefono))))
                .addGap(179, 179, 179)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBEditarP)
                        .addGap(42, 42, 42)
                        .addComponent(jBConsultarM))
                    .addComponent(jBConsultarE))
                .addGap(0, 194, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(305, 305, 305))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEditarP, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNombreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNomUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBConsultarM)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBConsultarE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbPApellidoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSApellidoUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTipoIdenUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNumIdenUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDirUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbTipoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboTipoIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNumIdenUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDirUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combotipoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTelUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarTelefono))
                .addGap(22, 22, 22)
                .addComponent(btAgregarUsu)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Usuarios", jPanel2);

        jPanel8.setBackground(new java.awt.Color(254, 254, 254));

        lbSubTituloCausa.setText("Nueva Causa");

        lbNombreCausa.setText("Nombre");

        lbCodigoCausa.setText("Codigo");

        lbDescripCausa.setText("Descripcion");

        areaDescripCausa.setColumns(20);
        areaDescripCausa.setLineWrap(true);
        areaDescripCausa.setRows(5);
        areaDescripCausa.setWrapStyleWord(true);
        jScrollPane5.setViewportView(areaDescripCausa);

        btAgregarCausa.setText("Agregar");
        btAgregarCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCausaActionPerformed(evt);
            }
        });

        tablaCausa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripción"
            }
        ));
        jScrollPane8.setViewportView(tablaCausa);

        btActualizarCausa.setText("Actualizar Datos");
        btActualizarCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarCausaActionPerformed(evt);
            }
        });

        btEliminarCausa.setText("Eliminar Registro");
        btEliminarCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarCausaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNombreCausa)
                    .addComponent(lbCodigoCausa)
                    .addComponent(lbDescripCausa)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAgregarCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoNombreCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbSubTituloCausa)
                                .addComponent(campoCodigoCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btActualizarCausa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEliminarCausa)))
                .addGap(354, 354, 354))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbSubTituloCausa)
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombreCausa)
                            .addComponent(campoNombreCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lbCodigoCausa))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(campoCodigoCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lbDescripCausa))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarCausa)
                    .addComponent(btActualizarCausa)
                    .addComponent(btEliminarCausa))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Causas de consulta", jPanel8);

        btCerrarSesion.setBackground(new java.awt.Color(254, 254, 254));
        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/black-logout-256.png"))); // NOI18N
        btCerrarSesion.setText("Cerrar sesión");
        btCerrarSesion.setToolTipText("Cerrar sesión");
        btCerrarSesion.setBorder(null);
        btCerrarSesion.setBorderPainted(false);
        btCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCerrarSesion.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btCerrarSesion.setFocusPainted(false);
        btCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCerrarSesionMouseClicked(evt);
            }
        });
        btCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSesionActionPerformed(evt);
            }
        });

        lbBienvenido.setText("Bienvenido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbBienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCerrarSesionMouseClicked
       
        ventLog.setVisible(true);
        ventLog.getJpfcontraseña().setText("");
        ventLog.getJtfUsuario().setText("");
        dispose();
    }//GEN-LAST:event_btCerrarSesionMouseClicked


    private void btCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCerrarSesionActionPerformed

    private void registrarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarTelefonoActionPerformed

        VentanaRegistrarTelefono registrarNumeros = new VentanaRegistrarTelefono(telefonos);
        registrarNumeros.setVisible(true);
        registrarNumeros.setVentanaAdministrador(this);
        registrarNumeros.setAlwaysOnTop(true);
        registrarNumeros.setLocationRelativeTo(null);

        setEnabled(false);

    }//GEN-LAST:event_registrarTelefonoActionPerformed

    private void btAgregarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarUsuActionPerformed

        String nombre = campoNomUsu.getText();
        String apellido1 = campoPApellido.getText();
        String apellido2 = campoSApellido.getText();
        String tipoId = comboTipoIdent.getSelectedItem().toString();
        String numeroId = campoNumIdenUsu.getText();
        String direccion = campoDirUsu.getText();
        String tipoUsuario = combotipoUsu.getSelectedItem().toString();

        try {

            String [] datosValidar = {nombre, apellido1, numeroId, direccion};

            validar.validarModulos(datosValidar);

            String [] datosPersonales = {nombre, apellido1, apellido2, tipoId, numeroId, direccion, tipoUsuario};

            switch (tipoUsuario) {

                case "Paciente": {

                    VentanaRegPaciente registrarPaciente = new VentanaRegPaciente();
                    registrarPaciente.acomodarVentana(this);
                    registrarPaciente.setDatosPersonales(datosPersonales, telefonos);
                    registrarPaciente.setVisible(true);

                    setVisible(false);

                }; break;

                case "Empleado": {

                    VentanaRegistroEmpleado registrarEmpleado = new VentanaRegistroEmpleado();
                    registrarEmpleado.acomodarVentana(this);
                    registrarEmpleado.setDatosPersonales(datosPersonales, telefonos);
                    registrarEmpleado.setVisible(true);

                    setVisible(false);

                }; break;
            }

        } catch (ExcepcionCamposVacios ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Campos requeridos sin llenar", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btAgregarUsuActionPerformed

    private void campoPApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPApellidoActionPerformed

    private void btCuentasEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCuentasEmpleadosMouseClicked

        ventanaCuentas ventCuen = new ventanaCuentas();
        ventCuen.setVisible(true);
        ventCuen.setLocationRelativeTo(null);
        ventCuen.acomodarVentana(this);

        dispose();

    }//GEN-LAST:event_btCuentasEmpleadosMouseClicked

    private void btListaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btListaEmpleadosMouseClicked

        VentanaListadoEmpleados ventList;
        try {

            ventList = new VentanaListadoEmpleados();
            ventList.setVisible(true);
            ventList.setLocationRelativeTo(null);
            ventList.acomodarVentana(this);

        } catch (SQLException ex) {
            Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();
    }//GEN-LAST:event_btListaEmpleadosMouseClicked

    private void btAgregarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarAreaActionPerformed

        registrarArea();
        actualizarArea(false);
        campoNombreArea.setText("");
        campoCodigoArea.setText("");
        areaDescripArea.setText("");
    }//GEN-LAST:event_btAgregarAreaActionPerformed

    private void btAgregarCamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCamaActionPerformed

        String numeroCama = campoNumeroCama.getText();
        String cod_area = infoAreas.get(comboAreasCama.getSelectedIndex())[0];
        String descripcion = AreaDescripCama.getText();

        String datosCama[] = {numeroCama, cod_area, descripcion};

        try {

            validar.validarModulos(datosCama);

            driverCama.guardarCama(numeroCama, descripcion, cod_area);

            JOptionPane.showMessageDialog(this, "Se ha registrado la cama correctamente", "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE);
                        
            Object[] infoCamas = {numeroCama, descripcion, cod_area, true, true};
            
            modeloTablaCamas.addRow(infoCamas);

            comboAreasCama.setSelectedIndex(0);
            campoNumeroCama.setText("");
            AreaDescripCama.setText("");

        } catch (ExcepcionCamposVacios ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Campos vacíos", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Registro fallido", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btAgregarCamaActionPerformed

    private void actualizarInformacionCamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarInformacionCamasActionPerformed
        
        if (tablaInformacionCamas.getRowCount() > 0){
            
            try {
                
                ArrayList<Cama> camas = new ArrayList<>();
        
                for (int i = 0; i < tablaInformacionCamas.getRowCount(); i++) {

                    String codigo = tablaInformacionCamas.getValueAt(i, 0).toString();
                    String descrip = tablaInformacionCamas.getValueAt(i, 1).toString();
                    String area = tablaInformacionCamas.getValueAt(i, 2).toString();
                    boolean estado = (Boolean) tablaInformacionCamas.getValueAt(i, 3);
                    boolean activo=(Boolean) tablaInformacionCamas.getValueAt(i, 4);
                    
                    String [] camposvalidar = {descrip, area};
                    
                    validar.validarModulos(camposvalidar);

                    Cama nuevaCama = new Cama(descrip, estado, codigo, area, activo);

                    driverCama.actualizarInformacionCamas(nuevaCama);

                }
                
                agregarCamillasInformacion();
                
                JOptionPane.showMessageDialog(this, "Información actualizada correctamente", "Actualización exitosa",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException | ExcepcionCamposVacios ex) {
                
                System.err.println(ex.getMessage());
            }
            
        } else {
            
            JOptionPane.showMessageDialog(this, "No hay camas registradas", "Error editando", JOptionPane.ERROR_MESSAGE);
            
        }

        
    }//GEN-LAST:event_actualizarInformacionCamasActionPerformed

    public void cargarMedicamentos () {
        
        for (int i = tablaInformacionMedicamentos.getRowCount(); i > 0; i--) {
            
            modeloTablaMedicamento.removeRow(i-1);
            
        }
        
        DriverMedicamento consultarMedicamento = new DriverMedicamento();
        try {
            
            ArrayList<Medicamento> medicamentos = consultarMedicamento.consultarDatosMedicamentos();
            
            for (Medicamento medicina : medicamentos) {
                
                String codigo = medicina.getCodigo();
                String nombre = medicina.getNombre();
                double costo = medicina.getCosto();
                String descripcion = medicina.getDescripcion();
                
                Object datosMedicamentos [] = {codigo, nombre, descripcion, costo};
                
                modeloTablaMedicamento.addRow(datosMedicamentos);
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    private void btAgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarMedicamentoActionPerformed
        
        String nombreMedicamento = campoNomMedicamento.getText();
        String codigoMedicamento = campoCodigoMedicamento.getText();
        String descripcionMedicamento = AreaDescripMedicamento.getText();
        String costoMedicamento = campoCostoMedicamento.getText();
        
        try {
            
            String [] validarDatos = {codigoMedicamento, nombreMedicamento, descripcionMedicamento, costoMedicamento};            
            validar.validarModulos(validarDatos);
            
            double valorMedicamento = Double.parseDouble(costoMedicamento);
            
            DriverMedicamento driverMedicamento = new DriverMedicamento();
            
            driverMedicamento.registrarMedicamento(codigoMedicamento, nombreMedicamento, valorMedicamento, descripcionMedicamento);
            
            modeloTablaMedicamento.addRow(validarDatos);
            
            JOptionPane.showMessageDialog(this, "El medicamento se ha registrado exitosamente", "Registro con éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            campoCodigoMedicamento.setText("");
            campoNomMedicamento.setText("");
            campoCostoMedicamento.setText("");
            AreaDescripMedicamento.setText("");
            
        } catch (ExcepcionCamposVacios | SQLException | NumberFormatException ex) {
            
            System.err.println(ex.getMessage());
            
        }
    }//GEN-LAST:event_btAgregarMedicamentoActionPerformed

    private void EliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMedicamentoActionPerformed
        
        int index = tablaInformacionMedicamentos.getSelectedRow();
        
        if (index != -1) {
            
            String codigo = tablaInformacionMedicamentos.getValueAt(index, 0).toString();
            
            DriverMedicamento eliminar = new DriverMedicamento();
            try {
                
                eliminar.eliminarMedicamento(codigo);            
            
                cargarMedicamentos();
            
                JOptionPane.showMessageDialog(this, "Se ha eliminado el medicamento exitosamente", 
                    "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                
                System.err.println(ex.getMessage());
            }
        }
        
        else {
            
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún medicamento para eliminar", 
                    "Seleccione un medicamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_EliminarMedicamentoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int index = tablaInformacionMedicamentos.getSelectedRow();
        
        if (index != -1) {
            
            String codigo = tablaInformacionMedicamentos.getValueAt(index, 0).toString();
            String nombre = tablaInformacionMedicamentos.getValueAt(index, 1).toString();
            String descripcion = tablaInformacionMedicamentos.getValueAt(index, 2).toString();
            double costo = Double.parseDouble(tablaInformacionMedicamentos.getValueAt(index, 3).toString());
            
            DriverMedicamento driverMedicamento = new DriverMedicamento();
            try {
                
                driverMedicamento.editarMedicamento(codigo, nombre, costo, descripcion);
                cargarMedicamentos();
            
                JOptionPane.showMessageDialog(this, "Se ha actualizado la información del medicamento", 
                    "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException | NumberFormatException ex) {
                System.err.println(ex.getMessage());
                
            } 
            
        }
            
        
        else {
            
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún medicamento para eliminar", 
                    "Seleccione un medicamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btAgregarCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCausaActionPerformed
        registrarCausa ();
        actualizarCausa(false);
        campoNombreCausa.setText("");
        campoCodigoCausa.setText("");
        areaDescripCausa.setText("");
    }//GEN-LAST:event_btAgregarCausaActionPerformed

    private void btEditarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarAreaActionPerformed
        area.habilitarArea(tablaArea.getValueAt(tablaArea.getSelectedRow(), 0).toString(), false);
        actualizarArea(false);
        
    }//GEN-LAST:event_btEditarAreaActionPerformed

    private void btActualizarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarAreaActionPerformed
        actualizarArea(true);// TODO add your handling code here:
    }//GEN-LAST:event_btActualizarAreaActionPerformed

    private void btActualizarCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarCausaActionPerformed
        actualizarCausa(true);
    }//GEN-LAST:event_btActualizarCausaActionPerformed

    private void btEliminarCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarCausaActionPerformed
        causa.eliminarCausa(tablaCausa.getValueAt(tablaCausa.getSelectedRow(), 0).toString());
        actualizarCausa(false);
    }//GEN-LAST:event_btEliminarCausaActionPerformed

    private void jBEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarPActionPerformed

        // TODO add your handling code here:
        VentanaEditarInfoPersona ventEditarInfo = new VentanaEditarInfoPersona();
        
        ventEditarInfo.setVisible(true);
        ventEditarInfo.setLocationRelativeTo(null);
        ventEditarInfo.acomodarVentana(this);
        
        dispose();
    }//GEN-LAST:event_jBEditarPActionPerformed

    private void jBConsultarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarMActionPerformed
        // TODO add your handling code here:
        VentanaConsultaMedico ventConMed = new VentanaConsultaMedico();
        
        ventConMed.setVisible(true);
        ventConMed.setLocationRelativeTo(null);
        ventConMed.acomodarVentana(this);
        
        dispose();
    }//GEN-LAST:event_jBConsultarMActionPerformed

    private void jBConsultarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarEActionPerformed
        // TODO add your handling code here:
        VentanaConsultaEnfermera ventConEnf = new VentanaConsultaEnfermera();
        
        ventConEnf.setVisible(true);
        ventConEnf.setLocationRelativeTo(null);
        ventConEnf.acomodarVentana(this);
        
        dispose();
    }//GEN-LAST:event_jBConsultarEActionPerformed

    private void cargarAreas () {
        
        comboAreasCama.removeAllItems();
        
        try {
            
            infoAreas = area.consultarAreas();
            
            for (String[] nombreArea : infoAreas) {
                
                comboAreasCama.addItem(nombreArea[1]);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de módulo", JOptionPane.ERROR_MESSAGE);
                        
            dispose();
            
        }
    }
    
    
    
    public void limpiarCampos () {
        
        campoNomUsu.setText("");
        campoSApellido.setText("");
        campoPApellido.setText("");
        campoNumIdenUsu.setText("");
        campoDirUsu.setText("");
        comboTipoIdent.setSelectedIndex(0);
        combotipoUsu.setSelectedIndex(0);
        
        telefonos = new ArrayList<>();
        
    }
    

    public void acomodarVentana(VentanaLogin ventLog){
    
    this.ventLog = ventLog;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaDescripCama;
    private javax.swing.JTextArea AreaDescripMedicamento;
    private javax.swing.JButton EliminarMedicamento;
    private javax.swing.JLabel LbTipoUsu;
    private javax.swing.JButton actualizarInformacionCamas;
    private javax.swing.JTextArea areaDescripArea;
    private javax.swing.JTextArea areaDescripCausa;
    private javax.swing.JButton btActualizarArea;
    private javax.swing.JButton btActualizarCausa;
    private javax.swing.JButton btAgregarArea;
    private javax.swing.JButton btAgregarCama;
    private javax.swing.JButton btAgregarCausa;
    private javax.swing.JButton btAgregarMedicamento;
    private javax.swing.JButton btAgregarUsu;
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btCuentasEmpleados;
    private javax.swing.JButton btEditarArea;
    private javax.swing.JButton btEliminarCausa;
    private javax.swing.JButton btListaEmpleados;
    private javax.swing.JTextField campoCodigoArea;
    private javax.swing.JTextField campoCodigoCausa;
    private javax.swing.JTextField campoCodigoMedicamento;
    private javax.swing.JTextField campoCostoMedicamento;
    private javax.swing.JTextField campoDirUsu;
    private javax.swing.JTextField campoNomMedicamento;
    private javax.swing.JTextField campoNomUsu;
    private javax.swing.JTextField campoNombreArea;
    private javax.swing.JTextField campoNombreCausa;
    private javax.swing.JTextField campoNumIdenUsu;
    private javax.swing.JTextField campoNumeroCama;
    private javax.swing.JTextField campoPApellido;
    private javax.swing.JTextField campoSApellido;
    private javax.swing.JComboBox comboAreasCama;
    private javax.swing.JComboBox comboTipoIdent;
    private javax.swing.JComboBox combotipoUsu;
    private javax.swing.JButton jBConsultarE;
    private javax.swing.JButton jBConsultarM;
    private javax.swing.JButton jBEditarP;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbCodAreaCama;
    private javax.swing.JLabel lbCodigoArea;
    private javax.swing.JLabel lbCodigoCausa;
    private javax.swing.JLabel lbCodigoMedicamento;
    private javax.swing.JLabel lbCostoMedicamento;
    private javax.swing.JLabel lbCuentasEmpleados;
    private javax.swing.JLabel lbDescripArea;
    private javax.swing.JLabel lbDescripCama;
    private javax.swing.JLabel lbDescripCausa;
    private javax.swing.JLabel lbDescripMedicamento;
    private javax.swing.JLabel lbDirUsu;
    private javax.swing.JLabel lbListaEmpleados;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbNombreArea;
    private javax.swing.JLabel lbNombreCausa;
    private javax.swing.JLabel lbNombreMedicamento;
    private javax.swing.JLabel lbNombreUsu;
    private javax.swing.JLabel lbNumCama;
    private javax.swing.JLabel lbNumIdenUsu;
    private javax.swing.JLabel lbPApellidoUsu;
    private javax.swing.JLabel lbSApellidoUsu;
    private javax.swing.JLabel lbSubTituloArea;
    private javax.swing.JLabel lbSubTituloCausa;
    private javax.swing.JLabel lbTelUsu;
    private javax.swing.JLabel lbTipoIdenUsu;
    private javax.swing.JLabel lbUser;
    private javax.swing.JButton registrarTelefono;
    private javax.swing.JTable tablaArea;
    private javax.swing.JTable tablaCausa;
    private javax.swing.JTable tablaInformacionCamas;
    private javax.swing.JTable tablaInformacionMedicamentos;
    // End of variables declaration//GEN-END:variables
}

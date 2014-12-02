/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaAdministrar extends JFrame {
    
    private JTabbedPane opcionesAdministracion;
    
    private JPanel panelCamas;
    private JPanel panelUsuarios;
    private JPanel panel;
    private JPanel encabezado;
    
    private JLabel lbNombreCompleto;
    private JLabel lbPrimerApellido;
    private JLabel lbSegundoApellido;
    private JLabel lbDireccion;
    private JLabel lbTelefono;
    private JLabel lbCelular;
    
    private JTextField jtfNombreCompleto;
    private JTextField jtfPrimerApellido;
    private JTextField jtfSegundoApellido;
    private JTextField jtfDireccion;
    private JTextField jtfTelefono;
    private JTextField jtfCelular;
    
    
    public VentanaAdministrar () {
        
        super("Admministración - Clínica");
        
        inicializarComponentes();
        agregarComponentes();
        acomodarComponentes();
        
        setSize(800, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    private void inicializarComponentes () {
        
        panel = new JPanel(null);
        
        opcionesAdministracion = new JTabbedPane();
        opcionesAdministracion.setBackground(Color.WHITE);
        encabezado = new JPanel(null);
        encabezado.setBackground(Color.WHITE);
        
        panelCamas = new JPanel(null);
        panelCamas.setBackground(Color.WHITE);
        panelUsuarios = new JPanel(null);
        panelUsuarios.setBackground(Color.WHITE);
        panelUsuarios.setBorder(BorderFactory.createTitledBorder("Registrar Usuario"));
        
        lbNombreCompleto = new JLabel("Nombre completo");
        lbPrimerApellido = new JLabel("Primer apellido");
        lbSegundoApellido = new JLabel("Segundo apellido");
        lbTelefono = new JLabel("Teléfono");
        lbCelular = new JLabel("Celular");
        
        jtfNombreCompleto = new JTextField();
        jtfPrimerApellido = new JTextField();
        jtfSegundoApellido = new JTextField();
        jtfTelefono = new JTextField();
        jtfCelular = new JTextField();
        
    }
    
    
    private void agregarComponentes () {
        
        getContentPane().add(panel);
        
        panel.add(opcionesAdministracion);
        panel.add(encabezado);
        
        opcionesAdministracion.addTab("Administración de usuarios", panelUsuarios);
        opcionesAdministracion.addTab("Administración de camas", panelCamas);
        
        panelUsuarios.add(lbNombreCompleto);
        panelUsuarios.add(jtfNombreCompleto);
        panelUsuarios.add(lbPrimerApellido);
        panelUsuarios.add(jtfPrimerApellido);
        panelUsuarios.add(lbSegundoApellido);
        panelUsuarios.add(jtfSegundoApellido);
        panelUsuarios.add(lbTelefono);
        panelUsuarios.add(jtfTelefono);
        panelUsuarios.add(lbCelular);
        panelUsuarios.add(jtfCelular);
    
    }
    
    
    private void acomodarComponentes() {
        
        encabezado.setBounds(0, 0, 800, 150);
        opcionesAdministracion.setBounds(0, 100, 800, 600);
        
        lbNombreCompleto.setBounds(10, 50, 150, 30);
        jtfNombreCompleto.setBounds(170, 50, 200, 30);
        
        lbPrimerApellido.setBounds(10, 90, 150, 30);
        jtfPrimerApellido.setBounds(170, 90, 200, 30);
        
        lbSegundoApellido.setBounds(10, 130, 150, 30);
        jtfSegundoApellido.setBounds(170, 130, 200, 30);
        
        lbTelefono.setBounds(10, 170, 150, 30);
        
        
    }
    
    
    public static void main (String [] args) {
        
        VentanaAdministrar ad = new VentanaAdministrar();
        
    }
    
}

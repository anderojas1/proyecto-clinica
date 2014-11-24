/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.*;

/**
 *
 * @author anderojas
 */
public class VentanaAdministrar extends JFrame {
    
    private JTabbedPane opcionesAdministracion;
    
    private JPanel panelCamas;
    private JPanel panelUsuarios;
    
    
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
        
        opcionesAdministracion = new JTabbedPane();
        
        panelCamas = new JPanel(null);
        panelUsuarios = new JPanel(null);
        
    }
    
    
    private void agregarComponentes () {
        
        getContentPane().add(opcionesAdministracion);
        
        opcionesAdministracion.addTab("Administración de usuarios", panelUsuarios);
        opcionesAdministracion.addTab("Administración de camas", panelCamas);
    
    }
    
    
    private void acomodarComponentes() {
        
        
    }
    
    
    public static void main (String [] args) {
        
        VentanaAdministrar ad = new VentanaAdministrar();
        
    }
    
}

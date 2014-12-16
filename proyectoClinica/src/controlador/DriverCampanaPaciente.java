/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dataAccesss.DaoCampanaPaciente;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author Mariano
 */
public class DriverCampanaPaciente {
    private DaoCampanaPaciente daoCampanaPaciente;

    public DriverCampanaPaciente() {
        
        daoCampanaPaciente = new DaoCampanaPaciente();
        
    }
    
    public void registrarCampanaPaciente (String id_campana, String id_paciente) throws ParseException{
        
        try{
        daoCampanaPaciente.registrarCampanaPaciente(id_campana, id_paciente);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar Campaña con su paciente. Por favor intente nuevamente");
        }
    }
    
    public void eliminarCampanaPaciente (String id_campana, String id_paciente) throws ParseException{
        
        try{
        daoCampanaPaciente.eliminarCampanaPaciente(id_campana, id_paciente);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar Campaña con su paciente. Por favor intente nuevamente");
        }
    }
}
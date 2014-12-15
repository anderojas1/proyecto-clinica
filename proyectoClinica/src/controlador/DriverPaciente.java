/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.*;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Paciente;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DriverPaciente {
    
    DaoPaciente paciente = new DaoPaciente();
    DaoPersona persona = new DaoPersona();
    DaoHistoriaClinica historia = new DaoHistoriaClinica();
    
    
    public void registrarPaciente (String doc_id, String tipo, String nombre, String apellido1, String apellido2, 
            ArrayList<Telefono> num_telefonos, String direccion_residencia, boolean estado, String num_seguridad, 
            String actividad, String fecha_nac, String tipoUsuario, String fechaRegistro) throws SQLException {
        
        Paciente nuevoPaciente = new Paciente(doc_id, tipo, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, 
                estado, num_seguridad, actividad, fecha_nac);
        
        persona.crearPersona(nuevoPaciente, tipoUsuario);
        persona.registrarTelefono(nuevoPaciente, num_telefonos);
        
        paciente.registrarPaciente(nuevoPaciente);
        historia.crearHistoriaClinica(nuevoPaciente, fechaRegistro);
        
    }
    
}

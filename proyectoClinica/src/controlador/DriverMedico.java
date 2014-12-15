/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.*;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Empleado;
import logica.Medico;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DriverMedico {
    
    DaoEmpleado empleado = new DaoEmpleado();
    DaoMedico datosMedico = new DaoMedico();
    DaoPersona datosPersona = new DaoPersona();
    
    
    public void registrarMedico (String doc_id, String tipo, String nombre, String apellido1, String apellido2, 
            ArrayList<Telefono> num_telefonos, String direccion_residencia, boolean estado, String tipoUsuario, 
            String area, double salario, String email, String cargo, String jefe, String especialidad, String universidad, 
            String num_licencia) throws SQLException {
        
        Medico nuevoMedico = new Medico(doc_id, tipo, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, 
                estado,area, cargo, email, salario, jefe, especialidad, universidad, num_licencia);
        
        datosPersona.crearPersona(nuevoMedico, tipoUsuario);
        datosPersona.registrarTelefono(nuevoMedico, num_telefonos);
        empleado.registrarEmpleado(nuevoMedico);
        datosMedico.registrarMedico(nuevoMedico);
        
    }
    
}

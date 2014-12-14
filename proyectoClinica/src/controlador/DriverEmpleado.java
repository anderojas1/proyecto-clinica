/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.*;
import java.sql.*;
import java.util.ArrayList;
import logica.Empleado;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DriverEmpleado {
    
    DaoEmpleado datosEmpleado = new DaoEmpleado();
    DaoPersona datosPersona = new DaoPersona();
    
    
    public void registrarEmpleado (String doc_id, String tipo, String nombre, String apellido1, String apellido2, 
            ArrayList<Telefono> num_telefonos, String direccion_residencia, boolean estado, String cod_area, double salario, 
            String email, String cargo, String jefe, String tipoUsuario) throws SQLException {
        
        Empleado nuevoEmpleado = new Empleado(doc_id, tipo, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, 
                estado, cod_area, cargo, email, salario, jefe);
        
        datosPersona.crearPersona(nuevoEmpleado, tipoUsuario);
        datosPersona.registrarTelefono(nuevoEmpleado, num_telefonos);
        
        datosEmpleado.registrarEmpleado(nuevoEmpleado);        
        
    }
    
    
    public ArrayList<String[]> consultarEmpleados (boolean buscarTodos) throws SQLException {
        
        return datosEmpleado.consultarEmpleadosActivos(buscarTodos);
        
    }
    
}

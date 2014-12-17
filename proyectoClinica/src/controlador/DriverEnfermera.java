/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Empleado;
import logica.Enfermera;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DriverEnfermera {
    
    DaoEnfermera datosEnfermera = new DaoEnfermera();
    DaoEmpleado datosEmpleado = new DaoEmpleado();
    DaoPersona datosPersona = new DaoPersona();
    
    
    public void registrarEnfermera (String doc_id, String tipo, String nombre, String apellido1, String apellido2, 
            ArrayList<Telefono> num_telefonos, String direccion_residencia, boolean estado, String tipoUsuario, 
            String area, double salario, String email, String cargo, String jefe, int añosExp, ArrayList<String> habilidades) 
            throws SQLException {
        
        Enfermera nuevaEnfermera = new Enfermera(doc_id, tipo, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, 
                estado,area, cargo, email, salario, jefe, añosExp, habilidades);
        
        datosPersona.crearPersona(nuevaEnfermera, tipoUsuario);
        datosPersona.registrarTelefono(nuevaEnfermera, num_telefonos);
        datosEmpleado.registrarEmpleado(nuevaEnfermera);
        datosEnfermera.registrarEnfermera(nuevaEnfermera);
        datosEnfermera.registrarHabilidadesEnfermera(nuevaEnfermera, habilidades);
        
    }
    
     public boolean estaEnfermera(String identificacion){
         boolean respuesta = false;
         
         try{
            respuesta = datosEnfermera.estaEnfermera(identificacion);
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error al consultar identificacion enfermera");
         }
         return respuesta;
     }
     
     public ArrayList<String> consultarEnfermera(String identificacion){
        ArrayList<String> enfermera = new ArrayList();
        
        try{
            enfermera=datosEnfermera.consultarEnfermera(identificacion);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar medico");
        }
        return enfermera;
    }
    
}

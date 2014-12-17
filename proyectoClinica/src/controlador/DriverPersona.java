/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Persona;
import dataAccesss.DaoPersona;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author anderojas
 */
public class DriverPersona {
    
    private DaoPersona daoPersona;
    
    public DriverPersona () {
        
        daoPersona = new DaoPersona();
        
    }
    
    
    public String consultarPerfil (String user, String pass) throws SQLException {
        
        return daoPersona.consultarUsuario(user, pass);
        
    }
    
    
    public Persona consultarPersona (String identificacion) throws SQLException {
        
        return daoPersona.consultarPersona(identificacion);
        
    }
    
    
    public void actualizarContraseña (String id, String pass) throws SQLException {
        
        daoPersona.configurarCuentaAcceso(id, pass);
        
    }
    
     public boolean consultarPersonaEditar(String identificacion){
        boolean respuesta = false;
        
        try{
            respuesta = daoPersona.consultarPersonaEditar(identificacion);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar la persona");
        }
        return respuesta;
    }
     
      public void editarPersona(String identificacion, String nombres, String apellido_uno, String apellido_dos, String direccion){
          
          try{
              daoPersona.editarPersona(identificacion, nombres, apellido_uno, apellido_dos, direccion);
          }catch(SQLException e){
              
          }
      }
}

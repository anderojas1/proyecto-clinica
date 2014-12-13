/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Persona;
import dataAccesss.DaoPersona;
import java.sql.SQLException;

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
    
}

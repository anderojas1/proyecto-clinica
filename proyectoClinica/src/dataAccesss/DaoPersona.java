/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import logica.Persona;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DaoPersona {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoPersona () {

        fachada = new Fachada();

    }
    
    public void ejecutarUpdate () throws SQLException, NullPointerException {
                          
        conectar = fachada.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sentenciaSql);

        conectar.close();            
        
    }
    
    public void ejecutarConsulta () throws SQLException {
        
        conectar = fachada.conectar();
        sentencia = conectar.createStatement();
        
        registros = sentencia.executeQuery(sentenciaSql);
        
        conectar.close();
        
    }
    
    public void crearPersona (Persona persona) throws SQLException {
        
        sentenciaSql = "INSERT INTO Persona VALUES ('" + persona.getIdentificacion() + "', '" + persona.getNombre() + "'"
                + ",'" + persona.getApellidoUno() + "','" + persona.getApellidoDos() + "','" + persona.getDireccion() + "'"
                + "," + persona.getEstado() + ");";
        
        ejecutarUpdate();
        
    }
    
    
    public void registrarTelefono (Persona persona, Telefono numero) throws SQLException {
        
        sentenciaSql = "INSERT INTO Telefonos_Persona VALUES ('" + persona.getIdentificacion() + "','" + numero.getNumero() + "'"
                + ",'" + numero.getTipo() + "');";
        
        ejecutarUpdate();
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import logica.Paciente;

/**
 *
 * @author anderojas
 */
public class DaoPaciente {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoPaciente () {
        
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
    
    public void registrarPaciente (Paciente usuario) throws SQLException {
        
        sentenciaSql = "INSERT INTO Paciente VALUES ('" + usuario.getIdentificacion() + "','" + usuario.getActividadEconomica() + "'"
                + ",'" + usuario.getNumeroSeguridadSocial() + "','" + usuario.getFechaNacimiento() + "'," + usuario.getActivoClinica()
                + ");";
        
        ejecutarUpdate();
        
    }
    
}

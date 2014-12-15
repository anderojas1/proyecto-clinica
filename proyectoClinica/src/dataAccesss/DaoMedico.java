/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logica.Medico;

/**
 *
 * @author anderojas
 */
public class DaoMedico {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoMedico () {
        
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
    
    public void registrarMedico (Medico medico) throws SQLException {
        
        sentenciaSql = "INSERT INTO Medico VALUES ('" + medico.getIdentificacion() + "','" + medico.getEspecialidad() + "'"
                + ",'" + medico.getUniversidad() + "','" + medico.getNum_licencia() + "');";
        
        ejecutarUpdate();
        
    }
    
    
    
}

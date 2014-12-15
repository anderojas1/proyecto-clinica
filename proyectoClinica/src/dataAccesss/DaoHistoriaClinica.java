/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logica.Paciente;

/**
 *
 * @author jorgeaer
 */
public class DaoHistoriaClinica {
    
    private final Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoHistoriaClinica () {
        
        fachada = new Fachada();
        
    }
    
        
    public void ejecutarUpdate () throws SQLException {
                          
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
    
    public void crearHistoriaClinica (Paciente paciente, String fechaRegistro) throws SQLException {
        
        sentenciaSql = "INSERT INTO Historia_c VALUES ('" + fechaRegistro + "', '" + paciente.getIdentificacion() + "');";
        ejecutarUpdate();
        
    }
}

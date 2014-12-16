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
import java.text.ParseException;

/**
 *
 * @author Mariano
 */
public class DaoCampanaPaciente {
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoCampanaPaciente () {

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
    
    public void registrarCampanaPaciente (String id_campana, String id_paciente) throws SQLException, ParseException {
       
        sentenciaSql = "INSERT INTO Campana_paciente VALUES ('"
                + id_campana
                + "','"
                + id_paciente
                + "');";
        System.out.println(sentenciaSql);
        ejecutarUpdate();
        
    }
    
    public void eliminarCampanaPaciente (String id_campana, String id_paciente) throws SQLException, ParseException {
       
        sentenciaSql = "DELETE FROM Campana_paciente WHERE cod_campana = '"
                + id_campana
                + "' AND id_paciente ='"
                + id_paciente
                + "';";
        System.out.println(sentenciaSql);
        ejecutarUpdate();
        
    }
}
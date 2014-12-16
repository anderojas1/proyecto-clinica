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
import javax.swing.JOptionPane;

/**
 *
 * @author julian
 */
public class DaoCamaPaciente {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
        
    public DaoCamaPaciente () {

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

    public void registrarCamaPaciente(String idCama, String fecha, String idPaciente) throws SQLException{
    
        sentenciaSql = "INSERT INTO cama_paciente (numero_cama, f_asignacion, id_paciente ) VALUES ('"+ idCama +"','"+idPaciente+"','"+fecha +"');";
       
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
        ejecutarUpdate();
    
    }
    
    public void liberarCama(String idCama) throws SQLException{
        
        sentenciaSql = "DELETE FROM cama_paciente WHERE numero_cama = '"+idCama+"';";
        ejecutarUpdate();
    
    }
}


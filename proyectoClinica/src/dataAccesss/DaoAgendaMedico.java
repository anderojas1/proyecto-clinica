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
import java.util.ArrayList;

/**
 *
 * @author julian
 */
public class DaoAgendaMedico {
    
    private final Fachada fachadaConectar;
    private Connection conectar;
    private Statement sentencia;
    private String sentenciaSql;
    private ResultSet registros;
    
    public DaoAgendaMedico(){
        
        fachadaConectar = new Fachada();
    }
    
    public void ejecutarUpdate () throws SQLException, NullPointerException {
                          
        conectar = fachadaConectar.conectar();

        sentencia = conectar.createStatement();
        sentencia.executeUpdate(sentenciaSql);

        conectar.close();            
        
    }
    
    
    public void ejecutarConsulta () throws SQLException {
        
        conectar = fachadaConectar.conectar();
        sentencia = conectar.createStatement();
        
        registros = sentencia.executeQuery(sentenciaSql);
        
        conectar.close();
        
    }
    
    public ArrayList <String[]> consultarAgenda(String fecha) throws SQLException{
    
        ArrayList <String[]> citas = new ArrayList();
        
        sentenciaSql = "SELECT DISTINCT id_paciente, nombres, apellido_uno, apellido_dos, fecha_hora, ag.estado "
                        + " FROM agenda_cita ag INNER JOIN persona per ON ag.id_paciente = per.identificacion"
                        + "  WHERE fecha_hora between '"+fecha+" 00:00:00' AND '"+fecha+" 24:00:00';";
        
        ejecutarConsulta();
        
        while (registros.next()) {
            
            String idPaci = registros.getString(1);
            String nombreCom = registros.getString(2) +" "+registros.getString(3) +" "+ registros.getString(4);
            String fechaConsulta = registros.getString(5);
            String estado = registros.getString(6);
            
            String [] cita = {idPaci,nombreCom,fechaConsulta,estado};
            
            citas.add(cita);            
            
        }
        
        return citas;    
    }
    
}

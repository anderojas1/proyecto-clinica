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
import logica.Enfermera;

/**
 *
 * @author anderojas
 */
public class DaoEnfermera {
    
    private final Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoEnfermera () {
        
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
    
    public void registrarEnfermera (Enfermera enfermera) throws SQLException {
        
        sentenciaSql = "INSERT INTO Enfermera VALUES ('" + enfermera.getIdentificacion() + "'," + enfermera.getAnios_exp() + ");";      
        ejecutarUpdate();
        
    }
    
    
    public void registrarHabilidadesEnfermera (Enfermera enfermera, ArrayList<String> habilidades) throws SQLException {
        
        String conjuntoHabilidades = "";
        
        if (!habilidades.isEmpty()) {
            
            for (String habilidad : habilidades) {
            
                conjuntoHabilidades += "('" + enfermera.getIdentificacion() + "','"+ habilidad + "'),";
                
            }
        
            conjuntoHabilidades = conjuntoHabilidades.substring(0, conjuntoHabilidades.length() - 1);
            
        }
        
        if (!conjuntoHabilidades.isEmpty()) {
            
            sentenciaSql = "INSERT INTO Enfermera_Habilidad VALUES " + conjuntoHabilidades + ";";
        
            ejecutarUpdate();
            
        }
        
    }
    
     public boolean estaEnfermera(String identificacion) throws SQLException{
        boolean respuesta = false;
        
        sentenciaSql="SELECT identificacion FROM Enfermera WHERE identificacion='"+identificacion+"';";
        ejecutarConsulta();
        
        while(registros.next()){
            respuesta = true;
        }
        
        return respuesta;
    }
     
     public ArrayList<String> consultarEnfermera(String identificacion) throws SQLException{
        ArrayList<String> enfermera = new ArrayList();
        
        sentenciaSql = "SELECT * FROM PERSONA NATURAL JOIN EMPLEADO NATURAL JOIN ENFERMERA WHERE identificacion = '"+identificacion+"';";
        
        ejecutarConsulta();
        
        while(registros.next()){
            
            enfermera.add(registros.getString(3));
            enfermera.add(registros.getString(4));
            enfermera.add(registros.getString(5));
            enfermera.add(registros.getString(6));
            enfermera.add(registros.getString(8));
            enfermera.add(registros.getString(9));
            enfermera.add(registros.getString(10));
            enfermera.add(registros.getString(11));
            enfermera.add(registros.getString(12));
            enfermera.add(registros.getString(13));
        
        }
        
        return enfermera;
    }
    
}

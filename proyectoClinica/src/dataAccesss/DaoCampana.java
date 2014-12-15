/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;
import java.sql.*;
import java.text.ParseException;
import logica.Campana;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author Mariano
 */
public class DaoCampana {
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoCampana () {

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
    
    public void registrarCampana (Campana campana) throws SQLException, ParseException {
       
        sentenciaSql = "INSERT INTO Campana VALUES ('"
                + campana.getCodigo()
                + "','"
                + campana.getObjetivo()
                + "','"
                + campana.getNombre()
                + "','"
                + campana.getF_realizacion()
                + "','"
                + campana.getId_medico()
                + "',"
                + "true"
                + ");";
        System.out.println(sentenciaSql);
        ejecutarUpdate();
        
    }
        
    public void estadoCampana (String codigo, boolean estado) throws SQLException {
        
        sentenciaSql = "UPDATE Campana SET estado = " + estado + " WHERE codigo = '" + codigo + "';";
        
        ejecutarUpdate();
        
    }
    
    public Campana consultarCampana (String codigo) throws SQLException {
        
        Campana campana = new Campana("","","","","");
        
        sentenciaSql = "SELECT * FROM Campana WHERE codigo = '" + codigo + "';";
        
        ejecutarConsulta();
        
        while (registros.next()) {
            
            campana.setCodigo(registros.getString(1));
            campana.setObjetivo(registros.getString(2));
            campana.setNombre(registros.getString(3));
            campana.setF_realizacion(registros.getString(4));
            campana.setId_medico(registros.getString(5));
        }
        
        return campana;
                
    }
    
     public void editarCampana(Campana campana)throws SQLException{
        
        sentenciaSql = "UPDATE Campana SET nombre = '"+campana.getNombre()+
                "', objetivo = '"+ campana.getObjetivo() +
                "', f_realizacion = '"+campana.getF_realizacion()+
                "', id_medico = '"+campana.getId_medico()+
                "' WHERE codigo = '"+campana.getCodigo()+"';";
        ejecutarUpdate();
    }
    
}

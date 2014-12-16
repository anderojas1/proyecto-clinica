/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Cama;

/**
 *
 * @author anderojas
 */
public class DaoCama {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoCama () {

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
    
    
    public void registrarCama (Cama camilla) throws SQLException {
        
        sentenciaSql = "INSERT INTO Cama VALUES ('" + camilla.getNumeroInventario() + "','" + camilla.getDescripcion() + "',"
                + "" + camilla.getEstado() + ",'" + camilla.getCod_area() + "'," + camilla.getActivoInventario() + ");";
        
        ejecutarUpdate();
        
    }
    
    public void cambiarEstadoCama (Cama camilla, boolean nuevoEstado) throws SQLException {
        
        sentenciaSql = "UPDATE Cama SET estado = " + nuevoEstado + " WHERE numero = '" + camilla.getNumeroInventario() + "';";
        
        ejecutarUpdate();
        
    }
    
     public ArrayList <Cama> listarCamasLibres() throws SQLException{
    
        ArrayList <Cama> camas  = new ArrayList();
        
        sentenciaSql = "SELECT * FROM Cama WHERE estado = true AND dardebaja = true;";
        
        ejecutarConsulta();
        
        
        
        while(registros.next()){
        
            String numero = registros.getString(1);
            String descripcion = registros.getString(2);
            boolean estado = registros.getBoolean(3);
            String codigoArea = registros.getString(4);
            boolean activo = registros.getBoolean(5);
            
            
            Cama miCama = new Cama(descripcion, estado, numero, codigoArea, activo);
            
            camas.add(miCama);      
        
        }
        
        
       return camas;
        
       
    }
    
}

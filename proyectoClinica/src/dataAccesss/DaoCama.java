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
    
    public Cama buscarCama(String idCama) throws SQLException{
    
        sentenciaSql =  "SELECT * FROM Cama WHERE numero = '"+ idCama+"';";
        
        Cama micama ;
                
        ejecutarConsulta();
        
        while (registros.next()) {
         
            String numero = registros.getString(1);
            String descripcion = registros.getString(2);
            boolean estado = registros.getBoolean(3);
            String codigo_Are = registros.getString(4);
            boolean dar_debaja = registros.getBoolean(5);
            
            micama = new Cama(descripcion,estado,numero,codigo_Are,dar_debaja);
            
            return micama;
            
            }
        
        return null;
    
    }
    
     public ArrayList <Cama> listarCamasLibres() throws SQLException{
    
        ArrayList <Cama> camas  = new ArrayList();
        
        sentenciaSql = "SELECT * FROM Cama WHERE estado = true;";
        
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
     
    public ArrayList <String []> listarCamasOcupadas() throws SQLException{
    
        ArrayList <String []> camas  = new ArrayList();
        
        sentenciaSql = "select distinct * from cama_paciente;";
        
        ejecutarConsulta();
        
        while(registros.next()){
        
            String numero_cama = registros.getString(1);
            String id_paciente = registros.getString(2);
            String f_asignacion = registros.getString(3);
            
            
            
            String [] camaPaciente = {numero_cama,id_paciente,f_asignacion};
            
            camas.add(camaPaciente);      
        
        }
        
        
       return camas;
        
       
    }
    
    
    public ArrayList<Cama> listarCamasActivas () throws SQLException {
        
        ArrayList<Cama> camillas = new ArrayList<>();
        
        sentenciaSql = "SELECT * FROM Cama where dardebaja = true ORDER BY estado";
        
        ejecutarConsulta();
        
        while (registros.next()) {
            
            String num_inv = registros.getString(1);
            String descr = registros.getString(2);
            boolean estado = registros.getBoolean(3);
            String area = registros.getString(4);
            boolean activo = registros.getBoolean(5);
            
            Cama camaInventario = new Cama(descr, estado, num_inv, area, activo);
            
            camillas.add(camaInventario);
            
        }
        
        return camillas;
        
    }
    
    
    public void actualizarInformacionCamas (Cama cama) throws SQLException {
        
        if (cama.getEstado()) {
            sentenciaSql = "UPDATE Cama SET descripcion = '" + cama.getDescripcion() + "', cod_area = '" + cama.getCod_area()
                    + "', dardebaja = " + cama.getActivoInventario() + " where numero = '" + cama.getNumeroInventario() + "';";
                
        }
        
        else sentenciaSql = "UPDATE Cama SET descripcion = '" + cama.getDescripcion() + "' where numero = '" +
                cama.getNumeroInventario() + "';";
        
        System.err.println(sentenciaSql);
        
        ejecutarUpdate();
    }
    
     
}

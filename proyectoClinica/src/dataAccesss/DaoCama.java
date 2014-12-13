/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
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
    
}

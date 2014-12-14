/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import logica.Empleado;

/**
 *
 * @author anderojas
 */
public class DaoEmpleado {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoEmpleado () {
        
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
    
    public void registrarEmpleado (Empleado empleado) throws SQLException {
        
        sentenciaSql = "INSERT INTO Paciente VALUES ('" + empleado.getIdentificacion() + "','" + empleado.getCod_area()+ "'"
                + "," + empleado.getSalario() + ",'" + empleado.getEmail()+ "','" + empleado.getCargo() + "',"
                + "'" + empleado.getJefe() + "');";
        
        ejecutarUpdate();
        
    }
}

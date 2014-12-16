/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
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
               
        sentenciaSql = "INSERT INTO Empleado VALUES ('" + empleado.getIdentificacion() + "','" + empleado.getCod_area()+ "'"
                + "," + empleado.getSalario() + ",'" + empleado.getEmail()+ "','" + empleado.getCargo() + "',"
                + "'" + empleado.getJefe() + "');";
        
        ejecutarUpdate();
        
    }
    
    public ArrayList<String[]> consultarEmpleadosArea(String codArea) throws SQLException{
    
        ArrayList<String[]> empleadosArea = new ArrayList<>();
        
        sentenciaSql = "SELECT identificacion, nombres, salario, apellido_uno, apellido_dos FROM empleado NATURAL JOIN persona WHERE cod_area = '"+codArea +"'; ";
    
        ejecutarConsulta();
        
        while(registros.next()){
        
            String ident = registros.getString(1);
            String nombre = registros.getString(2);
            String salario = registros.getString(3);
            String apellidos = registros.getString(4)+" "+ registros.getString(5);
            
            String [] empleado = {ident,nombre,apellidos,salario};
            
            empleadosArea.add(empleado);
        }
        
        return empleadosArea;
    }
    
    
    public ArrayList<String[]> consultarEmpleadosActivos (boolean buscar) throws SQLException {
        
        if (buscar) sentenciaSql = "SELECT e.identificacion, e.cod_area, e.cargo FROM Empleado as e NATURAL JOIN Persona as p "
                + "WHERE p.estado = TRUE;";
        
        else sentenciaSql = "SELECT e.identificacion, e.cod_area, e.cargo FROM Empleado as e NATURAL JOIN Persona WHERE estado = TRUE AND"
                + " identificacion IN (SELECT identificacion FROM Medico);";
        
        ejecutarConsulta();
        
        ArrayList<String[]> empleados = new ArrayList<>();
        
        while (registros.next()) {
            
            String identificacion = registros.getString(1);
            String cod_area = registros.getString(2);            
            String cargo = registros.getString(3);
            
            String [] datos = {identificacion, cod_area, cargo};
            
            empleados.add(datos);
            
        }
        
        return empleados;
        
    }
}

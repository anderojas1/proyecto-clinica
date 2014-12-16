/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
import logica.Paciente;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DaoPaciente {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoPaciente () {
        
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
    
    public void registrarPaciente (Paciente usuario) throws SQLException {
        
        sentenciaSql = "INSERT INTO Paciente VALUES ('" + usuario.getIdentificacion() + "','" + usuario.getActividadEconomica() + "'"
                + ",'" + usuario.getNumeroSeguridadSocial() + "','" + usuario.getFechaNacimiento() + "');";
        
        ejecutarUpdate();
        
    }
    
    public ArrayList <String[]> listarPacientes() throws SQLException{
        
        ArrayList <String[]> pacientes = new ArrayList();
        
        sentenciaSql = "SELECT DISTINCT identificacion, nombres, apellido_uno, apellido_dos  FROM Persona WHERE identificacion IN (SELECT identificacion FROM Paciente);";
              
        ejecutarConsulta();
               
        while(registros.next()){
        
            String identificacion = registros.getString(1);
            String nombre = registros.getString(2);
            String apellidoUno = registros.getString(3);
            String apellidoDos = registros.getString(4);
            
            String [] datos = {identificacion,nombre,apellidoUno,apellidoDos};
            
            pacientes.add(datos);
        
        }
        
       return pacientes;
    }
    
    /*public Paciente consultarPaciente(String identificacion) throws SQLException{
        Paciente usuario = new Paciente();
        
        String doc_id, tipo, nombre, apellido1, apellido2, direccion_residencia, num_seguridad, actividad, fecha_nac; 
        ArrayList<Telefono> num_telefonos; 
        boolean estado, activo;
        sentenciaSql = "SELECT * FROM Paciente WHERE identificacion = '"+identificacion+"'"; 
        
        while (registros.next()) {

            String nombre = registros.getString(2);
            String descripcion = registros.getString(3);
            boolean estado = registros.getBoolean(4);
            
            area = new Area(codigo, descripcion, nombre, estado);
            
            return area;

        }
            
        return area;
        return usuario;
    }*/
    
}

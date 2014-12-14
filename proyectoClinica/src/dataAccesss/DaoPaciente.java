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
                + ",'" + usuario.getNumeroSeguridadSocial() + "','" + usuario.getFechaNacimiento() + "'," + usuario.getActivoClinica()
                + ");";
        
        ejecutarUpdate();
        
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

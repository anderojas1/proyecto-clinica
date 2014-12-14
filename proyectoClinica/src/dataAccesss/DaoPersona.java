/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
import logica.Persona;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DaoPersona {
    
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoPersona () {

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
    
    public void crearPersona (Persona persona) throws SQLException {
        
        sentenciaSql = "INSERT INTO Persona VALUES ('" + persona.getIdentificacion() + "', '" + persona.getNombre() + "'"
                + ",'" + persona.getApellidoUno() + "','" + persona.getApellidoDos() + "','" + persona.getDireccion() + "'"
                + "," + persona.getEstado() + ");";
        
        ejecutarUpdate();
        
    }
    
    
    public void registrarTelefono (Persona persona, Telefono numero) throws SQLException {
        
        sentenciaSql = "INSERT INTO Telefonos_Persona VALUES ('" + persona.getIdentificacion() + "','" + numero.getNumero() + "'"
                + ",'" + numero.getTipo() + "');";
        
        ejecutarUpdate();
        
    }
    
    
    public String consultarUsuario (String username, String pass) throws SQLException {
        
        String perfil = "ninguno";
        
        sentenciaSql = "SELECT perfil FROM AccesoSistema WHERE username = '" + username + "' and pass = '" + pass + "';";
        ejecutarConsulta();
        
        if (registros.next() == true) perfil = registros.getString(1);
        
        return perfil;
        
    }
    
    
    public Persona consultarPersona (String identificacion) throws SQLException {
        
        sentenciaSql = "SELECT * FROM Persona where identificacion = '" + identificacion + "';";
        ejecutarConsulta();
        
        if (registros.next() == true) {
            
            String nombre = registros.getString(2);
            String apellido1 = registros.getString(3);
            String apellido2 = registros.getString(4);
            String direccion = registros.getString(5);
            boolean estado = registros.getBoolean(6);
            
            sentenciaSql = "SELECT * FROM Telefonos_Persona WHERE identificacion = '" + identificacion + "';";
            ejecutarConsulta();
            
            ArrayList<Telefono> numeros_tel = new ArrayList<>();
            
            while (registros.next()) {
                
                String numero = registros.getString(2);
                String tipo = registros.getString(3);
                
                Telefono tel = new Telefono(numero, tipo);
                
                numeros_tel.add(tel);
                
            }
            
            Persona persona = new Persona(identificacion, nombre, apellido1, apellido2, numeros_tel, direccion, estado);
            
            return persona;
            
        }
        
        return null;
        
    }
    
}
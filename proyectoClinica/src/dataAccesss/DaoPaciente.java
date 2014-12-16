/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
import logica.Medico;
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
        
        sentenciaSql = "SELECT DISTINCT identificacion, nombres, apellido_uno, apellido_dos  FROM Persona WHERE identificacion IN (SELECT identificacion FROM Paciente) AND identificacion not in (select identificacion from paciente inner join cama_paciente on paciente.identificacion = cama_paciente.id_paciente);";
        
        //sentenciaSql = "select identificacion, nombres, apellido_uno, apellido_dos from paciente where identificacion not in (select identificacion from paciente inner join cama_paciente on paciente.identificacion = cama_paciente.id_paciente);";
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
    
    
    public boolean consultarCitasPaciente (String id_paciente, String id_medico, String fecha) throws SQLException {
        
        sentenciaSql = "SELECT * FROM Agenda_cita WHERE id_medico = '" + id_medico + "' AND id_paciente = '" + id_paciente + "' "
                + "AND estado = 'asignada' AND fecha_hora = '" + fecha + "';";
        ejecutarConsulta();
        
        if (registros.next()) return true;
        
        return false;
    }
    
    public void AsignarCita(String id_medico, String id_paciente, String fecha)throws SQLException{
        
        sentenciaSql = "INSERT INTO Agenda_cita VALUES ('"+id_medico+"', '"+id_paciente+"', '"+fecha+"', 'asignada')";
        
        ejecutarUpdate();
        
    }
    
    public ArrayList<String> mostrarCitasFechas(String id_medico,String fecha)throws SQLException{
        
        ArrayList<String> fechas = new ArrayList();
        
        sentenciaSql ="SELECT fecha_hora FROM Agenda_cita WHERE id_medico = '"+id_medico+"' AND cast(fecha_hora as date) ='"+fecha+"';";
 
        ejecutarConsulta();
               
        while(registros.next()){
        
            String fechaCita = registros.getString(1).substring(11);
            System.out.println(fechaCita);
            fechas.add(fechaCita);
        
        }
        return fechas;
    }
    
    public ArrayList<String[]> ConsultarMedicoCita()throws SQLException{
        ArrayList<String[]> medicos = new ArrayList();
        
        sentenciaSql ="SELECT DISTINCT M.identificacion, P.nombres, P.apellido_uno, P.apellido_dos   FROM Medico M JOIN Persona P ON M.identificacion = P.identificacion;";
        
        
        ejecutarConsulta();
               
        while(registros.next()){
        
            String identificacion = registros.getString(1);
            String nombre = registros.getString(2)+" "+registros.getString(3)+" "+registros.getString(4);
       
            String [] datos = {identificacion,nombre};
            
            medicos.add(datos);
        
        }
        
        return medicos;
    }
    
    public ArrayList <String[]> listarPacientesIn(String id_campana) throws SQLException{
        
        ArrayList <String[]> pacientes = new ArrayList();
        
        sentenciaSql = "SELECT DISTINCT identificacion, nombres, apellido_uno, apellido_dos  FROM Persona WHERE identificacion IN (SELECT id_paciente FROM Campana_paciente WHERE cod_campana = '" + id_campana + "');";
              
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
    
     /*public static void main(String args[]) {
         DaoPaciente paciente = new DaoPaciente();
         try{
         paciente.mostrarCitasFechas("123", "13");
         }catch(SQLException e){
             
         }
     }*/
    
}

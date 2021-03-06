/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
 public ArrayList<String[]> mostrarCitasPacientes(String idPaciente) throws SQLException{
 
     ArrayList<String[]> citasPaciente = new ArrayList();

     sentenciaSql = "SELECT id_medico, fecha_hora, estado FROM agenda_cita WHERE (estado <> 'asistida' AND estado <> 'cancelada') AND id_paciente = '"+idPaciente+"' ;";

     //JOptionPane.showMessageDialog(null, sentenciaSql);
     
     ejecutarConsulta();
     
     while(registros.next()){
     
         String idMedico = registros.getString(1);
         String fecha_hora = registros.getString(2);
         String estado = registros.getString(3);
         
         String [] cita = {idMedico,fecha_hora,estado};
         
         citasPaciente.add(cita);
     }
 
        return citasPaciente;
 }   
 
 public void cancelarCita(String idPaciente, String idMedico, String hora_fecha) throws SQLException{
     
      sentenciaSql = "UPDATE agenda_cita SET estado = 'cancelada' WHERE id_paciente = '"+idPaciente+"' AND id_medico = '"+ idMedico+"' AND fecha_hora = '"+hora_fecha+"';";
 
      ejecutarUpdate();
 }
    
    public String consultarCitasPaciente (String id_paciente, String id_medico, String fecha) throws SQLException {
        
        sentenciaSql = "SELECT * FROM Agenda_cita WHERE id_medico = '" + id_medico + "' AND id_paciente = '" + id_paciente + "' "
                + "AND estado = 'asignada' AND fecha_hora >= '" + fecha + " 07:00:00' AND fecha_hora <= '" + fecha + " 18:00:00';";
        ejecutarConsulta();
        
        if (registros.next()) return registros.getString(3);
        
        return null;
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
    

    public String consultarPaciente(String identificacion)throws SQLException{
        String paciente = "";
        sentenciaSql = "SELECT identificacion FROM Paciente WHERE identificacion = '"+identificacion+"';";
        
        ejecutarConsulta();
               
        while(registros.next()){
        

            paciente = registros.getString(1);
        }
        return paciente;
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
    
        
    public void registrarFormulaMedicaPaciente (String id_medico, String id_paciente, ArrayList<Object[]>cod_medicamento, 
            String fecha_hora) throws SQLException {
        
        String codigosMedicamento = "";
        
        for (Object[] codigo : cod_medicamento) {
            
            codigosMedicamento += "('" + id_medico + "', '" + id_paciente + "', '" + codigo[0].toString() + "', '" + 
                    fecha_hora + "', " + codigo[1] + "),";
            
        }
        
        codigosMedicamento = codigosMedicamento.substring(0, codigosMedicamento.length() - 1);
        
        if (!codigosMedicamento.isEmpty()) {         
            
            sentenciaSql = "INSERT INTO Formula_Medica VALUES " + codigosMedicamento + ";";
            ejecutarUpdate();
        }
        
    }
    
    
    public void asistirCita (String id_paciente, String id_medico, String fecha_hora, String estado) throws SQLException {
        
        sentenciaSql = "UPDATE Agenda_cita SET estado = '" + estado + "' WHERE id_medico = '" + id_medico + "' AND id_paciente = '" 
                + id_paciente + "' AND fecha_hora = '" + fecha_hora + "';";
        
        ejecutarUpdate();
        
    }
    
    public ArrayList<String[]> consultarHistoria(String num_historia)throws SQLException{
         
        ArrayList<String[]> paciente = new ArrayList();
        
        sentenciaSql = "SELECT  L.nombres, L.apellido_uno, L.apellido_dos, C.nombre, L.fecha_hora FROM Causa C JOIN (\n" +
"SELECT P.nombres, P.apellido_uno, P.apellido_dos, R.codigo_causa, R.fecha_hora FROM Registro R \n" +
"JOIN Persona P ON R.id_medico = P.identificacion WHERE R.num_historia = '"+num_historia+"' AND R.estado = 'true') As L ON C.codigo = L.codigo_causa;";
              

        ejecutarConsulta();
               
        while(registros.next()){
        

            String medico = registros.getString(1)+" "+registros.getString(2)+" "+registros.getString(3);
            String causa = registros.getString(4);
            String fecha = registros.getString(5);
            
            String [] datos = {medico,causa,fecha};
            
            paciente.add(datos);
        
        }
        
       return paciente;
    }
    
     public ArrayList<String> consultarPaciente2(String identificacion) throws SQLException{
        ArrayList<String> persona = new ArrayList();
        
        sentenciaSql = "SELECT * FROM PERSONA NATURAL JOIN PACIENTE WHERE identificacion = '"+identificacion+"' AND estado = 'true';";
        
        ejecutarConsulta();
        
        while(registros.next()){
            
            persona.add(registros.getString(3));
            persona.add(registros.getString(4));
            persona.add(registros.getString(5));
            persona.add(registros.getString(6));
            persona.add(registros.getString(8));
            persona.add(registros.getString(9));
            persona.add(registros.getString(10));
        
        }
        
        return persona;
    }
     
     public boolean estaPaciente2(String identificacion) throws SQLException{
        boolean respuesta = false;
        
        sentenciaSql="SELECT identificacion FROM Paciente WHERE identificacion='"+identificacion+"';";
        ejecutarConsulta();
        
        while(registros.next()){
            respuesta = true;
        }
        
        return respuesta;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Paciente;
import logica.Telefono;

/**
 *
 * @author anderojas
 */
public class DriverPaciente {
    
    DaoPaciente paciente = new DaoPaciente();
    DaoPersona persona = new DaoPersona();
    DaoHistoriaClinica historia = new DaoHistoriaClinica();
    
    
    public void registrarPaciente (String doc_id, String tipo, String nombre, String apellido1, String apellido2, 
            ArrayList<Telefono> num_telefonos, String direccion_residencia, boolean estado, String num_seguridad, 
            String actividad, String fecha_nac, String tipoUsuario, String fechaRegistro) throws SQLException {
        
        Paciente nuevoPaciente = new Paciente(doc_id, tipo, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, 
                estado, num_seguridad, actividad, fecha_nac);
        
        persona.crearPersona(nuevoPaciente, tipoUsuario);
        persona.registrarTelefono(nuevoPaciente, num_telefonos);
        
        paciente.registrarPaciente(nuevoPaciente);
        historia.crearHistoriaClinica(nuevoPaciente, fechaRegistro);
        
    }
    
    public ArrayList <String []> listarPacientes() throws SQLException{
    
        ArrayList <String[]> pacientes = new ArrayList();
        
        try{
        pacientes = paciente.listarPacientes();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al asignar Paciente. Por favor intente nuevamente");
        }
        return pacientes;
    
    }
    
    public boolean consultarCitasPaciente (String id_paciente, String id_medico, String fecha) throws SQLException {
        
        return paciente.consultarCitasPaciente(id_paciente, id_medico, fecha);
        
    }
    
    public void AsignarCita(String id_medico, String id_paciente, String fecha){
        
        try{
            paciente.AsignarCita(id_medico, id_paciente, fecha);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al asignar cita. Por favor intente nuevamente");
        }
    }
    
    public ArrayList<String> horas(){
        ArrayList<String> horasF = new ArrayList();
        horasF.add("08:00:00");
        horasF.add("08:30:00");
        horasF.add("09:00:00");
        horasF.add("09:30:00");
        horasF.add("10:00:00");
        horasF.add("10:30:00");
        horasF.add("11:00:00");
        horasF.add("11:30:00");
        horasF.add("12:00:00");
        horasF.add("12:30:00");
        horasF.add("01:00:00");
        horasF.add("01:30:00");
        horasF.add("02:00:00");
        horasF.add("02:30:00");
        horasF.add("03:00:00");
        horasF.add("03:30:00");
        return horasF;
    }
    
    public ArrayList <String[]> listarPacientesIn(String id_campana) throws SQLException{
        
        ArrayList <String[]> pacientes = new ArrayList();
        
        pacientes = paciente.listarPacientesIn(id_campana);
        
        return pacientes;
    }
    
    public ArrayList<String []> consultarCitas(String fecha){
        
        ArrayList<String[]> medicos = new ArrayList();
        ArrayList<String> fechasM = new ArrayList();
        ArrayList<String[]> lista = new ArrayList();
        ArrayList<String> horasDia = horas();
        
        
         try{
            medicos = paciente.ConsultarMedicoCita();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar medicos para la cita. Por favor intente nuevamente");
        }
         
         if (medicos != null){
             int tam = medicos.size();
             
             for(int i =0 ; i < tam; i++){
                 
                 String [] datos = medicos.get(i);
                  try{
                 fechasM = paciente.mostrarCitasFechas(datos[0], fecha);
                 
                 for(int j = 0; j < 16; j ++){
                     if(fechasM.contains(horasDia.get(j))){
                         
                     }else{
                         String [] datosLista = {datos[0], datos[1], horasDia.get(j)};
                         System.out.println(datos[0]+" "+ datos[1]+" "+horasDia.get(j));
                         lista.add(datosLista);
                     }
                 }
                 
                  }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al consultar fechas disponibles para los medicos. Por favor intente nuevamente");
        }
                 
             }
         }
         
         return lista;
        
    }
    
    public void registrarFormulaMedicaPaciente (String id_medico, String id_paciente, ArrayList<Object[]>cod_medicamento, 
            String fecha_hora) throws SQLException {
        
        paciente.registrarFormulaMedicaPaciente(id_medico, id_paciente, cod_medicamento, fecha_hora);
        
    }
    
    
    
    public void guardarRegistro (String id_medico, String num_historia, ArrayList<String>causas, String fecha_hora,
            double valor) throws SQLException {
        
        historia.crearRegistroHistoriaClinica(id_medico, num_historia, causas, fecha_hora, valor);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import logica.Paciente;

/**
 *
 * @author jorgeaer
 */
public class DaoHistoriaClinica {
    
    private final Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    
    public DaoHistoriaClinica () {
        
        fachada = new Fachada();
        
    }
    
        
    public void ejecutarUpdate () throws SQLException {
                          
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
    
    public void crearHistoriaClinica (Paciente paciente, String fechaRegistro) throws SQLException {
        
        sentenciaSql = "INSERT INTO Historia_c VALUES ('" + fechaRegistro + "', '" + paciente.getIdentificacion() + "');";
        ejecutarUpdate();
        
    }
    
    public void crearRegistroHistoriaClinica (String id_medico, String num_historia, ArrayList<String>causas, String fecha_hora,
            double valor) throws SQLException {
        
        String codigosCausa = "";
        
        for (String codigo : causas) {
            
            codigosCausa += "('" + id_medico + "', '" + num_historia + "', '" + codigo + "', '" + fecha_hora + "', " + valor + ", true),";
            
        }
        
        codigosCausa = codigosCausa.substring(0, codigosCausa.length() - 1);
        
        if (!codigosCausa.isEmpty()) {         
            
            sentenciaSql = "INSERT INTO Registro VALUES " + codigosCausa + ";";
            
            System.err.println(sentenciaSql);
            ejecutarUpdate();
            
        }
    }
    
    public ArrayList<Object[]> consultarHistoria (String id) throws SQLException {
        
        sentenciaSql = "SELECT nombres, apellido_uno, apellido_dos, fecha_hora, valor FROM Persona INNER JOIN Registro "
                + "ON id_medico = identificacion WHERE num_historia = '" + id + "';";
        ejecutarConsulta();
        
        ArrayList<Object[]>historia = new ArrayList<>();
        
        while (registros.next()) {
            
            String nombres = registros.getString(1);
            String apellido1 = registros.getString(2);
            String apellido2 = registros.getString(3);
            String fecha = registros.getString(4);
            double costo = registros.getDouble(5);
            
            String nombre = nombres + " " + apellido1 + " " + apellido2;
            
            Object[] registros = {nombre , fecha, costo};
            
            historia.add(registros);
            
        }
        
        return historia;
    }
    
    public ArrayList<String> consultarCausasCita (String fecha, String id_paciente, String id_medico) throws SQLException {
        
        sentenciaSql = "SELECT nombre FROM Causa INNER JOIN Registro ON codigo = codigo_causa WHERE fecha_hora = "
                + "'" + fecha + "' AND num_historia = '" + id_paciente + "' AND id_medico = '" + id_medico + "';";
        ejecutarConsulta();
        
        ArrayList<String>causas = new ArrayList<>();
        
        while (registros.next()) {
            
            causas.add(registros.getString(1));
            
        }
        
        return causas;
    }
}

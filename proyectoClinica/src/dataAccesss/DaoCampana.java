/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;
import java.sql.*;
import logica.Campana;


/**
 *
 * @author Mariano
 */
public class DaoCampana {
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoCampana () {

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
    
    public void registrarCampana (Campana campana) throws SQLException {
        
        sentenciaSql = "INSERT INTO Medicamento VALUES ('"
                + campana.getCodigo()
                + "','"
                + campana.getObjetivo()
                + "','"
                + campana.getNombre()
                + "','"
                + campana.getF_realizacion()
                + "','"
                + campana.getId_medico()
                + "',"
                + "true"
                + ");";
        
        ejecutarUpdate();
        
    }
        
    public void eliminarCampana (String codigo) throws SQLException {
        
        sentenciaSql = "UPDATE Campana SET estado = " + false + " WHERE codigo = '" + codigo + "';";
        
        ejecutarUpdate();
        
    }
    
    public Campana consultarCampana (String codigo) throws SQLException {
        
        Campana campana = new Campana("","","","","");
        
        sentenciaSql = "SELECT * FROM Campana WHERE codigo = '" + codigo + "';";
        
        while (registros.next()) {
            
            campana.setCodigo(registros.getString(1));
            campana.setObjetivo(registros.getString(2));
            campana.setNombre(registros.getString(3));
            campana.setF_realizacion(registros.getString(4));
            campana.setId_medico(registros.getString(5));
        }
        
        return campana;
                
    }
    
}

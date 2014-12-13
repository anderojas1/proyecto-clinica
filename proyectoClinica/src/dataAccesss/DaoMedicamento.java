/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import logica.Medicamento;
/**
 *
 * @author Mariano
 */
public class DaoMedicamento {
    private Fachada fachada;
    private String sentenciaSql;
    private Connection conectar;
    private Statement sentencia;
    private ResultSet registros;
    
    public DaoMedicamento () {

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
    
        public void registrarMedicamento (Medicamento medicamento) throws SQLException {
        
        sentenciaSql = "INSERT INTO Cama VALUES ('" + medicamento.getCodigo() + "','" + medicamento.getNombre()+ "',"
                + medicamento.getCosto()+ ",'" + medicamento.getDescripcion()+ "'," + "true" + ");";
        
        ejecutarUpdate();
        
    }
        
    public void eliminarMedicamento (Medicamento medicamento) throws SQLException {
        
        sentenciaSql = "UPDATE Medicamento SET estado = " + false + " WHERE codigo = '" + medicamento.getCodigo()+ "';";
        
        ejecutarUpdate();
        
    }
    
    public Medicamento consultarMedicamento (String codigo) throws SQLException {
        
        Medicamento medicamento = new Medicamento("","",0,"");
        
        sentenciaSql = "SELECT * FROM Medicamento WHERE codigo = '" + codigo + "';";
        
        while (registros.next()) {
            
            medicamento.setCodigo(registros.getString(1));
            medicamento.setNombre(registros.getString(2));
            medicamento.setCosto(registros.getDouble(3));
            medicamento.setDescripcion(registros.getString(4));
        }
        
        return medicamento;
                
    }
    
    
}

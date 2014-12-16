/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesss;

import java.sql.*;
import java.util.ArrayList;
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
        
        sentenciaSql = "INSERT INTO Medicamento VALUES ('" + medicamento.getCodigo() + "','" + medicamento.getNombre()+ "',"
                + medicamento.getCosto()+ ",'" + medicamento.getDescripcion()+ "'," + "true" + ");";
        
        ejecutarUpdate();
        
    }
        
    public void estadoMedicamento (String codigo, boolean estado) throws SQLException {
        
        sentenciaSql = "UPDATE Medicamento SET estado = " + estado + " WHERE codigo = '" + codigo + "';";
        
        ejecutarUpdate();
        
    }
    
    public Medicamento consultarMedicamento (String codigo) throws SQLException {
        
        Medicamento medicamento = new Medicamento("","",0,"");
        
        sentenciaSql = "SELECT * FROM Medicamento WHERE codigo = '" + codigo + "';";
        
        ejecutarConsulta();
        
        while (registros.next()) {

            String nombre = registros.getString(2);
            Double costo = registros.getDouble(3);
            String descripcion = registros.getString(4);
            
            medicamento = new Medicamento(codigo,nombre,costo,descripcion);
        }
        return medicamento;
                
    }
    
        public void editarMedicamento(Medicamento medicamento)throws SQLException{
        
        sentenciaSql = "UPDATE Medicamento SET nombre = '"+medicamento.getNombre()+"', costo = "+ medicamento.getCosto() +", descripcion = '"+medicamento.getDescripcion()+"' WHERE codigo = '"+medicamento.getCodigo()+"';";
        ejecutarUpdate();
    }
    
    
    public ArrayList<Object[]> consultarMedicamentosDisponibles () throws SQLException {
        
        sentenciaSql = "SELECT codigo, nombre, costo FROM Medicamento WHERE estado = true;";
        ejecutarConsulta();
        
        ArrayList<Object[]> medicamentos = new ArrayList<>();
        
        while (registros.next()) {
            
            String codigo = registros.getString(1);
            String nombre = registros.getString(2);
            double costo = registros.getDouble(3);
            
            Object[] datos = {codigo, nombre, costo};
            
            medicamentos.add(datos);
            
        }
        
        return medicamentos;
    }
}

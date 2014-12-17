/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Medicamento;
import dataAccesss.DaoMedicamento;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Mariano
 */
public class DriverMedicamento {
    private DaoMedicamento daoMedicamento;

    public DriverMedicamento() {
        
        daoMedicamento = new DaoMedicamento();
        
    }
    
    public void registrarMedicamento (String codigo, String nombre, Double costo, String descripcion) throws SQLException {
        
        Medicamento medicamento = new Medicamento(codigo, nombre, costo, descripcion);
        
        daoMedicamento.registrarMedicamento(medicamento);
        
        
    }
    
    public Medicamento consultarMedicamento(String codigo){
        Medicamento medicamento = new Medicamento("","",0,"");
        try{
            medicamento = daoMedicamento.consultarMedicamento(codigo);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar medicamento. Por favor intente nuevamente");
        }
        
        return medicamento;
        
    }
    
    public void editarMedicamento(String codigo, String nombre, Double costo, String descripcion) throws SQLException{
        
        Medicamento medicamento = new Medicamento(codigo, nombre, costo, descripcion);
        
        daoMedicamento.editarMedicamento(medicamento);
        //daMedicamento.estadoMedicamento(codigo, true);
        
    }
    
    public void eliminarMedicamento(String codigo) throws SQLException{
        
        
        daoMedicamento.estadoMedicamento(codigo, false);
       
        
    }
    
    
    public ArrayList<Object[]> consultarMedicamentos () throws SQLException {
        
        return daoMedicamento.consultarMedicamentosDisponibles();
    }
    
    
    public ArrayList<Medicamento> consultarDatosMedicamentos () throws SQLException {
        
        return daoMedicamento.consultarMedicamentos();
        
    }
}

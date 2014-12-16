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
    
    public void registrarMedicamento (String codigo, String nombre, Double costo, String descripcion){
        
        Medicamento medicamento = new Medicamento(codigo, nombre, costo, descripcion);
        try{
        daoMedicamento.registrarMedicamento(medicamento);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar medicamento. Por favor intente nuevamente");
        }
        
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
    
    public void editarMedicamento(String codigo, String nombre, Double costo, String descripcion){
        
        Medicamento medicamento = new Medicamento(codigo, nombre, costo, descripcion);
        try{
        daoMedicamento.editarMedicamento(medicamento);
        daoMedicamento.estadoMedicamento(codigo, true);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al editar medicamento. Por favor intente nuevamente");
        }
    }
    
    public void eliminarMedicamento(String codigo){
        
        try{
        daoMedicamento.estadoMedicamento(codigo, false);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar medicamento. Por favor intente nuevamente");
        }
    }
    
    
    public ArrayList<Object[]> consultarMedicamentos () throws SQLException {
        
        return daoMedicamento.consultarMedicamentosDisponibles();
    }
}

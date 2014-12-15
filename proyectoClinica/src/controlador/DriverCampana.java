/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import logica.Campana;
import dataAccesss.DaoCampana;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
/**
 *
 * @author Mariano
 */
public class DriverCampana {
    private DaoCampana daoCampana;

    public DriverCampana() {
        
        daoCampana = new DaoCampana();
        
    }
    
    public void registrarCampana (String codigo, String objetivo, String nombre, String fecha, String id_m) throws ParseException{
        
        Campana campana = new Campana(codigo, objetivo, nombre, fecha, id_m);
        try{
        daoCampana.registrarCampana(campana);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar Campaña. Por favor intente nuevamente");
        }
        
    }
    
    public Campana consultarCampana(String codigo){
        Campana campana = new Campana("","","","","");
        try{
            campana = daoCampana.consultarCampana(codigo);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar campaña. Por favor intente nuevamente");
        }
        
        return campana;
        
    }
    
    public void editarCampana(String codigo, String objetivo, String nombre, String fecha, String id_m){
        
        Campana campana = new Campana(codigo, objetivo, nombre , fecha, id_m);
        try{
        daoCampana.editarCampana(campana);
        daoCampana.estadoCampana(codigo, true);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al editar Campaña. Por favor intente nuevamente");
        }
    }
    
    public void eliminarCampana(String codigo){
        
        try{
        daoCampana.estadoCampana(codigo, false);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar campaña. Por favor intente nuevamente");
        }
    }
}
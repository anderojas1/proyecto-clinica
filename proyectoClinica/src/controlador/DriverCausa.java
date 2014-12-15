/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Causa;
import dataAccesss.DaoCausa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class DriverCausa {
    private DaoCausa daoCausa;

    public DriverCausa() {
        
        daoCausa = new DaoCausa();
        
    }
    
    public void registrarCausa (String codigo, String nombre, String descripcion){
        
        Causa causa = new Causa(codigo, nombre, descripcion);
        try{
        daoCausa.registrarCausa(causa);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar causa. Por favor intente nuevamente");
        }
        
    }
    
    public Causa consultarCausa(String codigo){
        Causa causa = new Causa("","","");
        try{
            causa = daoCausa.consultarCausa(codigo);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar causa. Por favor intente nuevamente");
        }
        
        return causa;
        
    }
    
    public void editarCausa(String codigo, String nombre, String descripcion){
        
        Causa causa = new Causa(codigo, nombre, descripcion);
        try{
        daoCausa.editarCausa(causa);
        daoCausa.estadoCausa(codigo, true);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al editar causa. Por favor intente nuevamente");
        }
    }
    
    public void eliminarCausa(String codigo){
        
        try{
        daoCausa.estadoCausa(codigo, false);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar causa. Por favor intente nuevamente");
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Area;
import dataAccesss.DaoArea;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author anderojas
 */
public class DriverArea {
    
    DaoArea area = new DaoArea();
    
    
    public void registrarArea (String codigo, String nombre, String descripcion, boolean estado){
        
        Area areaClinica = new Area(codigo, descripcion, nombre, estado);
        try{
        area.crearArea(areaClinica);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar area. Por favor intente nuevamente");
        }
        
    }
    
    public Area consultarArea(String codigo){
        Area areaClinica = new Area();
        try{
            areaClinica = area.consultarArea(codigo);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar area. Por favor intente nuevamente");
        }
        
        return areaClinica;
        
    }
    
    public void editarArea(String codigo, String nombre, String descripcion, boolean estado){
        
        Area areaClinica = new Area(codigo, descripcion, nombre, estado);
        try{
        area.editarArea(areaClinica);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al editar area. Por favor intente nuevamente");
        }
    }
    
    public void habilitarArea(String codigo,  boolean estado){
        
        try{
        area.habilitarArea(codigo, estado);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al editar area. Por favor intente nuevamente");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Area;
import dataAccesss.DaoArea;
import java.sql.SQLException;

/**
 *
 * @author anderojas
 */
public class DriverArea {
    
    DaoArea area = new DaoArea();
    
    
    public void registrarArea (String codigo, String nombre, String descripcion, boolean estado) throws SQLException {
        
        Area areaClinica = new Area(codigo, descripcion, nombre, estado);
        
        area.crearArea(areaClinica);
        
    }
    
}

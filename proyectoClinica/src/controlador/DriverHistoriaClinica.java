/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.DaoHistoriaClinica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class DriverHistoriaClinica {
    
    private DaoHistoriaClinica historial = new DaoHistoriaClinica();
    
    public ArrayList<Object[]> consultarHistoriaClinica (String id) throws SQLException {
        
        return historial.consultarHistoria(id);
        
    }
    
    
    public ArrayList<String> consultarCausasCita (String fecha, String id_pac, String id_med) throws SQLException {
        
        return historial.consultarCausasCita(fecha, id_pac, id_med);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dataAccesss.DaoCamaPaciente;
import java.sql.SQLException;

/**
 *
 * @author julian
 */
public class DriverCamaPaciente {
   
    private DaoCamaPaciente daoCamaPaciente;

    public DriverCamaPaciente() {
    
        daoCamaPaciente = new DaoCamaPaciente();
    
    }
    
    public void registrarCamaPaciente(String idCama, String fecha, String idPaciente) throws SQLException{

        daoCamaPaciente.registrarCamaPaciente(idCama, fecha, idPaciente);    

        
    }
        
}

package controlador;

import logica.Cama;
import dataAccesss.DaoCama;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author anderojas
 */

public class DriverCama {
    
    private DaoCama daoCama;

    public DriverCama() {
        
        daoCama = new DaoCama();
        
    }
    
    public void guardarCama (String numeroInventario, String descripcion,String cod_area) throws SQLException {
        
        Cama camilla = new Cama(descripcion, true, numeroInventario, cod_area, true);
        
        daoCama.registrarCama(camilla);
        
    }
    
    public ArrayList <Cama> listarCamasLibres() throws SQLException{
    
            
        return daoCama.listarCamasLibres();
       
            
    }
    
    public ArrayList<Cama> listarCamasActivas () throws SQLException {
        
        return daoCama.listarCamasActivas();
    }
    
    
    public void actualizarInformacionCamas (Cama cama) throws SQLException {
        
        daoCama.actualizarInformacionCamas(cama);
    }
    
    
}
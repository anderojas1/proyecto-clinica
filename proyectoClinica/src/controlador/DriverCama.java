package controlador;

import logica.Cama;
import dataAccesss.DaoCama;
import java.sql.SQLException;

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
    
    
    
    
}
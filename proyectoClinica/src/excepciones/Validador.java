/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.util.ArrayList;

/**
 *
 * @author anderojas
 */
public class Validador {
    
    public void validarModulos (ArrayList <String> campos) throws ExcepcionCamposVacios {
        
        for (String campo : campos) {
            
            validarCampo(campo);
            
        }
    }
    
    
    public void validarCampo (String campo) throws ExcepcionCamposVacios {
        
        if (campo.equals("")) throw new ExcepcionCamposVacios("Hay campos requeridos sin llenar");
        
    }
    
}

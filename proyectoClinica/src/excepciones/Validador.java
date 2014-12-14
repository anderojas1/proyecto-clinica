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
    
    public void validarContraseñas (String pass1, String pass2) throws PasswordNoMatchException {
        
        if (!pass1.equals(pass2)) throw new PasswordNoMatchException();
        
    }
    
    public void validarTipoDocumento (String tipoDocumento, String categoria) throws CategoriaExcepcion {
        
        if (categoria.equals("Empleado")) {
            
            if (tipoDocumento.equalsIgnoreCase("tarjeta de identidad") || tipoDocumento.equalsIgnoreCase("registro civil")) {
                
                throw new CategoriaExcepcion("El tipo de documento es inválido");
                
            }
        }
    }
    
}

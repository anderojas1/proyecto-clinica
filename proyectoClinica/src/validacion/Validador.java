/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

/**
 *
 * @author anderojas
 */
public class Validador {
    
    public void validarCamposVacios (String [] datos) throws EmptyFieldsException {
        
        for (String dato : datos) {
            
            if (dato.isEmpty()) throw new EmptyFieldsException();
            
        }
        
    }
    
    
    public void validarContraseñas (String password1, String password2) throws PasswordNoMatchException {
        
        if (!password1.equals(password2)) throw new PasswordNoMatchException();
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author anderojas
 */
public class PasswordNoMatchException extends Exception {
    
    public PasswordNoMatchException () {
        
        super ("Las contraseñas no coinciden");
        
    }
    
}

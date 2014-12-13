/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author anderojas
 */
public class Telefono {
    
    private String numero;
    private String tipo;
    
    public Telefono (String num_tel, String tipo_tel) {
        
        numero = num_tel;
        tipo = tipo_tel;
        
    }
    
    
    public void setNumero (String num) {
        
        numero = num;
        
    }
    
    public void setTipo (String tipo) {
        
        this.tipo = tipo;
        
    }
    
    
    public String getNumero () {
        
        return numero;
        
    }
    
    public String getTipo () {
        
        return tipo;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author Santa Gutierrez
 */
public class HistoriaClinica {
    
    private String numero;
    private String f_apertura;
    private String identificacion;
    
    public HistoriaClinica(String numero, String f_apertura, String identificacion){
        
        this.numero = numero;
        this.f_apertura = f_apertura;
        this.identificacion = identificacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getF_apertura() {
        return f_apertura;
    }

    public void setF_apertura(String f_apertura) {
        this.f_apertura = f_apertura;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    
}

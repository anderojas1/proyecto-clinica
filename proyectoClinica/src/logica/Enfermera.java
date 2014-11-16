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
public class Enfermera extends Empleado{
    
    private int anios_exp;
    private String habilidad;
    
    public Enfermera(String nombre_completo, String doc_id, String direccion_residencia, String num_telefono, String cargo_emp, 
            String correo_e, double salario, int anios_exp, String habilidad){
        super(nombre_completo, doc_id, direccion_residencia, num_telefono, cargo_emp, correo_e, salario); 
     this.anios_exp = anios_exp;
     this.habilidad = habilidad;
    }

    public int getAnios_exp() {
        return anios_exp;
    }

    public void setAnios_exp(int anios_exp) {
        this.anios_exp = anios_exp;
    }
    
    
}

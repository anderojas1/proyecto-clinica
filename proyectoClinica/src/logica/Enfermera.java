/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;

/**
 *
 * @author Santa Gutierrez
 */
public class Enfermera extends Empleado{
    
    private int anios_exp;
    private ArrayList<String> habilidad;
    
    public Enfermera(String doc_id, String tipoID, String nombre, String apellido1, String apellido2, ArrayList<Telefono> num_telefonos, 
                String direccion_residencia, boolean estado, String cod_area, String cargo_emp, String correo_e, double salario, 
                String jefe, int anios_exp, ArrayList<String> habilidad){
       
        super(doc_id, tipoID, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, estado, cod_area, 
                cargo_emp, correo_e, salario, jefe); 
       
     this.anios_exp = anios_exp;
     this.habilidad = habilidad;
    }

    public int getAnios_exp() {
        return anios_exp;
    }

    public void setAnios_exp(int anios_exp) {
        this.anios_exp = anios_exp;
    }

    public ArrayList<String> getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(ArrayList<String> habilidad) {
        this.habilidad = habilidad;
    }

 
    
}

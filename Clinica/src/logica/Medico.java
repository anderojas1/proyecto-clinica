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
public class Medico extends Empleado{
    
    
    private String especialidad;
    private String universidad; 
    private String num_licencia;

    public Medico(String nombre_completo, String doc_id, String direccion_residencia, String num_telefono, String cargo_emp, 
            String correo_e, double salario, String especialidad, String universidad, String num_licencia){
       super(nombre_completo, doc_id, direccion_residencia, num_telefono, cargo_emp, correo_e, salario); 
       this.especialidad = especialidad;
       this.universidad = universidad;
       this.num_licencia = num_licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getNum_licencia() {
        return num_licencia;
    }

    public void setNum_licencia(String num_licencia) {
        this.num_licencia = num_licencia;
    }
    
    

    
    
}

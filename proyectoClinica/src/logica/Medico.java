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
public class Medico extends Empleado{
    
    
    private String especialidad;
    private String universidad; 
    private String num_licencia;

    public Medico(String doc_id, String tipo_id, String nombre, String apellido1, String apellido2, ArrayList<Telefono> num_telefonos, 
                String direccion_residencia, boolean estado, String cod_area, String cargo_emp, String correo_e, double salario, 
                String jefe, String especialidad, String universidad, String num_licencia){
       
        super(doc_id, tipo_id, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, estado, cod_area, 
                cargo_emp, correo_e, salario, jefe);
        
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

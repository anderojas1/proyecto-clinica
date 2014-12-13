package logica;

import java.util.ArrayList;

public class Paciente extends Persona {
	
	private String fechaNacimiento;
	private String numeroSeguridadSocial;
	private String actividadEconomica;
	
	
	public Paciente (String doc_id, String nombre, String apellido1, String apellido2, ArrayList<Telefono> num_telefonos, 
                String direccion_residencia, boolean estado, String num_seguridad, String actividad, String fecha_nac) {
							
		super (doc_id, nombre, apellido1, apellido2, num_telefonos, direccion_residencia, estado);
		
		numeroSeguridadSocial = num_seguridad;
		actividadEconomica = actividad;
		fechaNacimiento = fecha_nac;
		
	}

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }
	
        
}

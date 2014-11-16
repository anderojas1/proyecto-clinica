package logica;

public class Paciente extends Persona {
	
	private String fechaNacimiento;
	private String numeroSeguridadSocial;
	private String actividadEconomica;
	
	
	public Paciente (String nombre_completo, String doc_id, String direccion_residencia, String num_telefono, String num_seguridad,
						String actividad, String fecha_nac) {
							
		super (nombre_completo, doc_id, direccion_residencia, num_telefono);
		
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

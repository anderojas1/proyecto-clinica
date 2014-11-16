package logica;

public class Persona {
	
	private String nombre;
	private String identificacion;
	private String direccion;
	private String telefono;
	
	public Persona (String nombre_completo, String doc_id, String direccion_residencia, String num_telefono) {
		
		nombre = nombre_completo;
		identificacion = doc_id;
		direccion = direccion_residencia;
		telefono = num_telefono;
		
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
        
        
	
}

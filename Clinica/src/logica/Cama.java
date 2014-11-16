package logica;

public class Cama {
	
	private String descripcion;
	private String estado;
	private String numeroInventario;
	
	
	public Cama (String descripcion_cama, String estado_cama, String numero) {
		
		descripcion = descripcion_cama;
		estado = estado_cama;
		numeroInventario = numero;
		
	}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }
        
        
	
}

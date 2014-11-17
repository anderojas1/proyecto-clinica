package logica;

public class Cama {
	
	private String descripcion;
	private String estado;
	private String numeroInventario;
        private String cod_area;
	
	
	public Cama (String descripcion_cama, String estado_cama, String numero, String cod_area) {
		
		descripcion = descripcion_cama;
		estado = estado_cama;
		numeroInventario = numero;
                this.cod_area = cod_area;
		
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

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }
        
    
        
	
}

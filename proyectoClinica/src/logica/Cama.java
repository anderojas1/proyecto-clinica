package logica;

public class Cama {
	
    private String descripcion;
    private boolean estado;
    private String numeroInventario;
    private String cod_area;
    private boolean activoInventario;

    public Cama(String descripcion_cama, boolean estado_cama, String numero, String cod_area, boolean activo) {

        descripcion = descripcion_cama;
        estado = estado_cama;
        numeroInventario = numero;
        this.cod_area = cod_area;
        activoInventario = activo;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
    
    public void setActivoInventario (boolean revisarInventario) {
        
        activoInventario = revisarInventario;
        
    }
    
    
    public boolean getActivoInventario () {
        
        return activoInventario;
        
    }
        
    
        
	
}

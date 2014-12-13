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
public class Area {
    private String codigo;
    private String descripcion;
    private String nombre;
    private boolean estado;
    
    
    public Area(String codigo, String descripcion, String nombre, boolean estado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEstado (boolean estado) {
        
        this.estado = estado;
        
    }
    
    public boolean getEstado () {
        
        return estado;
        
    }
    
    
}

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
public class Campana {
    private String codigo;
    private String objetivo;
    private String nombre;
    private String f_realizacion;
    private String id_medico;
    
    public Campana(String codigo, String objetivo, String nombre, String f_realizacion, String id_medico){
        this.codigo= codigo;
        this.objetivo = objetivo;
        this.nombre = nombre;
        this.f_realizacion = f_realizacion;
        this.id_medico = id_medico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getF_realizacion() {
        return f_realizacion;
    }

    public void setF_realizacion(String f_realizacion) {
        this.f_realizacion = f_realizacion;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }
    
    
}

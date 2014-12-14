package logica;

import java.util.*;

public class Persona {
	
    private String apellido_uno;
    private String apellido_dos;
    private String nombre;
    private final String identificacion;
    private String tipoDocumento;
    private String direccion;
    private ArrayList<Telefono> telefonos;
    private boolean estadoSistema;

    public Persona(String doc_identidad, String tipo, String nombres, String apellido1, String apellido2, 
            ArrayList<Telefono> num_telefonos, String direccion_residencia, boolean estado) {

        identificacion = doc_identidad;
        tipoDocumento = tipo;
        nombre = nombres;
        apellido_uno = apellido1;
        apellido_dos = apellido2;
        telefonos = num_telefonos;
        direccion = direccion_residencia;
        estadoSistema = estado;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidoUno () {
        
        return apellido_uno;
        
    }
    
    public String getApellidoDos () {
        
        return apellido_dos;
        
    }

    public String getIdentificacion() {
        return identificacion;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
        
    public Telefono getTelefono (int indice) {
        
        return telefonos.get(indice);
        
    }
    
    public void añadirTelefono (Telefono num) {
        
        telefonos.add(num);
        
    }
    
    
    public void setEstado (boolean status) {
        
        estadoSistema = status;
        
    }
    
    public boolean getEstado () {
        
        return estadoSistema;
        
    }
    
    public String getTipoDocumento () {
        
        return tipoDocumento;
        
    }
}

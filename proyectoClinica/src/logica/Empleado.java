package logica;

public class Empleado extends Persona {
	
	private String cod_area;     
        private String cargo;
	private String email;
	private double salario;
        private String jefe;
	
	
	public Empleado (String nombre_completo, String doc_id, String direccion_residencia, String num_telefono, String cod_area, String cargo_emp, 
						String correo_e, double salario, String jefe) {
		
		super (nombre_completo, doc_id, direccion_residencia, num_telefono);
		
		cargo = cargo_emp;
		email = correo_e;
		this.salario = salario;
                this.cod_area = cod_area;
                this.jefe = jefe;
		
	}

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }
        
    
        
	
}

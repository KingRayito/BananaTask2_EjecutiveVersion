package objetosbasicos;

public class Empleado {
	private String identificador;
	private String contraseña;
	private String nombre;
	private String ocupacion;
	private boolean admin;
	private boolean trabajando;
	
	
	public Empleado() {
	}
	
	
	public Empleado(String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando) {
		this.identificador = identificador;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.ocupacion = ocupacion;
		this.admin = admin;
		this.trabajando = trabajando;
	}

	
	public String getIdentificador() {
		return identificador;
	}
	
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getOcupacion() {
		return ocupacion;
	}
	
	
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	public boolean isAdmin() {
		return admin;
	}
	
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public boolean isTrabajando() {
		return trabajando;
	}


	public void setTrabajando(boolean trabajando) {
		this.trabajando = trabajando;
	}
	
	
}

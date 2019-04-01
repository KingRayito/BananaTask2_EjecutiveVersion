package clasesbasicas;

public class Fase {
	private String nombre;
	private String descripcion; 
	private boolean completado;
	
	public Fase() {	//Constructores
	}
	
	public Fase(String nombre, String descripcion, boolean completado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.completado = completado;
	}
	
	public String getNombre() {			//Getters y setters
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isCompletado() {
		return completado;
	}
	
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
}

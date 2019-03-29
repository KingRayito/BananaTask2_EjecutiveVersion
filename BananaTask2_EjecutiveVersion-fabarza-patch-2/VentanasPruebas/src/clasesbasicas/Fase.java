package clasesbasicas;

public class Fase {
	private String descripcion;
	private boolean completado;
	
	public Fase() {	
	}
	
	public Fase(String descripcion, boolean completado) {
		this.descripcion = descripcion;
		this.completado = completado;
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

package aplicacion;

public class Proyecto {
	private String nombreProyecto;
	private boolean estadoProyecto;
	
	public void setNombreProyecto(String nomP) {
		nombreProyecto = nomP;
	}
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	
	public void setEstadoProyecto(Boolean estP) {
		estadoProyecto = estP;
	}
	
	public boolean getEstadoProyecto() {
		return estadoProyecto;
	}
}

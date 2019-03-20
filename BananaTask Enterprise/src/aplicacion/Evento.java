package aplicacion;

public class Evento {
	private String descripcionEvento;
	private boolean estadoEvento;
	
	public void setDescripcionEvento(String desE) {
		descripcionEvento = desE;
	}
	
	public String getDescripcionEvento() {
		return descripcionEvento;
	}
	
	public void setEstadoEvento(Boolean estE) {
		estadoEvento = estE;
	}
	
	public boolean getEstadoEvento() {
		return estadoEvento;
	}
}

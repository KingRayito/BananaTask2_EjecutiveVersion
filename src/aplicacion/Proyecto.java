package aplicacion;

import java.util.*;

public class Proyecto {
	private String nombreProyecto;
	private boolean estadoProyecto;
	private LinkedList <Evento> eventosProyecto;
	
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
	
	public void setEventosProyecto(LinkedList<Evento> eveP) {
		eventosProyecto = eveP;
	}
	
	public LinkedList<Evento> getEventosProyecto() {
		return eventosProyecto;
	}
}

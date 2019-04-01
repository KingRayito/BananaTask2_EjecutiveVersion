package clasesbasicas;

import clasesgenerales.ListaFases;

public class Proyecto {			
	private String nombre;
	private String cliente;		//Cliente para quien va destinado el proyecto
	private boolean terminado;
	private ListaFases listaFases;
	
	public Proyecto() {		//Constructor
	}

	public void agregarFase(String nombre, String descripcion, boolean completado) {
		listaFases.agregarFase(nombre, descripcion, completado);
	}
	public Proyecto(String nombre, String cliente, boolean terminado) {	//Constructor con parametros
		this.nombre = nombre;
		this.cliente = cliente;
		this.terminado = terminado;
	}

	public String getNombre() {			//Getter y setters
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public ListaFases getListaFases() {
		return listaFases;
	}

	public void setListaFases(ListaFases listaFases) {
		this.listaFases = listaFases;
	}
}

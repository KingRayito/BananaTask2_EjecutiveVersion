package clasesbasicas;

import clasesgenerales.ListaProyectos;

public class Integrante {
	private String identificador;
	private String contraseña;
	private String nombre;
	private String ocupacion;
	private boolean admin;
	private ListaProyectos listaProyectos;
	
	public Integrante() {
	}
	
	public Integrante(String identificador, String contraseña, String nombre, String ocupacion, boolean admin) {
		this.identificador = identificador;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.ocupacion = ocupacion;
		this.admin = admin;
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

	public ListaProyectos getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(ListaProyectos listaProyectos) {
		this.listaProyectos = listaProyectos;
	}
	
	
}

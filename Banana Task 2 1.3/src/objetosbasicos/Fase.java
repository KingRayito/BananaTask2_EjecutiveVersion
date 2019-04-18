package objetosbasicos;

import java.io.PrintWriter;

public class Fase {
	private String nombre;
	private String descripcion;
	private Empleado encargado;
	private boolean completado;
	
	
	/* Recibe el identificador del encargado el cual eliminara 
	 * y luego corrobora que sea el que esta buscando.
	 * En caso de que no sea el encargado este metodo retornara falso*/
	public boolean esEncargado(String identificador)
	{
		if(identificador.compareTo(encargado.getIdentificador()) == 0)
			return true;
		else
			return false;
	}
	
	
	
	/* Recibe los datos de un encargado y 
	 * sobreescribira los previos.*/
	public void editarEncargado(String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		encargado.setIdentificador(identificador);
		encargado.setContraseña(contraseña);
		encargado.setNombre(nombre);
		encargado.setOcupacion(ocupacion);
		encargado.setAdmin(admin);
		encargado.setTrabajando(trabajando);
	}
	
	
	
	/* Recibe el escritor del archivo con el cual guarda
	 * el identificador del encargado de una fase del proyecto.*/
	public void escribirArchivo(PrintWriter pw) 
	{
		pw.println(encargado.getIdentificador());
	}
	
	
	
	public Fase(String nombre, String descripcion, boolean completado, Empleado encargado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.completado = completado;
		this.encargado = encargado;
	}
	
	
	public Empleado getEncargado() {
		return encargado;
	}

	
	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}

	
	public String getNombre() {
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

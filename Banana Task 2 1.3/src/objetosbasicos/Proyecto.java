package objetosbasicos;

import conjuntosdeobjetos.MapaIntegrantes;

import java.io.PrintWriter;
import java.util.LinkedList;

import conjuntosdeobjetos.ListaFases;

public class Proyecto {
	private String nombre;
	private String cliente;
	private boolean terminado;
	private MapaIntegrantes integrantes;
	private ListaFases fases;
	
	
	/* Recibe el identificador de uno o mas integrantes los cuales
	 * seran agregados al proyecto en el que se encuentre.*/
	public boolean agregarIntegrantesAProyecto(LinkedList<Empleado> integrantesProyecto)
	{
		return integrantes.agregarIntegrantesAProyecto(integrantesProyecto);
	}
	
	
	/* Recibe el nombre de una fase la cual sera
	 * agregada al proyecto en el que se encuentre.*/
	public boolean agregarFaseAProyecto(String nombre, String descripcion, boolean estado, Empleado encargado)
	{
		return fases.agregarFase(nombre, descripcion, estado, encargado);
	}
	
	
	public boolean agregarEncargadoAFase(Empleado encargado, String nombreFase)
	{
		return fases.agregarEncargadoAFase(encargado, nombreFase);
	}
	

	
	/* Recibe el identificador de un empleado el cual utilizara para eliminar
	 * los integrantes y encargados de proyectos y fases respectivamente.*/
	public void eliminarEmpleado(String identificador)
	{
		integrantes.eliminarIntegrantesDeProyecto(identificador);
		fases.eliminarEmpleado(identificador);
	}
	
	
	/* Elimina todos los integrantes y encargados del proyecto
	 * en el que se encuentren.*/
	public void eliminarEmpleado()
	{
		integrantes.eliminarIntegrantesDeProyecto();
		fases.eliminarEmpleado();
	}
	
	
	public void eliminarProyecto(LinkedList<String> identificadorIntegrantes)
	{
		integrantes.obtenerIdentificadorDeIntegrantes(identificadorIntegrantes);
		integrantes.eliminarIntegrantesDeProyecto();
		fases.eliminarFase();
	}
	
	
	/* Elimina los integrantes y las fases del proyecto
	 * en el que se encuentren.*/
	public void eliminarProyecto()
	{
		integrantes.eliminarIntegrantesDeProyecto();
		fases.eliminarFase();
	}
	
	
	/* Recibe el identificador de uno o mas integrantes los cual seran
	 * eliminados del proyecto y fases en donde se encuentre.*/
	public void eliminarIntegrantesDeProyecto(LinkedList<String> identificadorIntegrantes) 
	{
		for(String identificador : identificadorIntegrantes)
		{
			integrantes.eliminarIntegrantesDeProyecto(identificador);
			fases.eliminarEmpleado(identificador);
		}
	}
	
	
	/* Recibe el nombre de una fase la cual sera
	 * eliminada del proyecto en donde se encuentre.*/
	public boolean eliminarFaseDeProyecto(String nombre)
	{
		return fases.eliminarFase(nombre);
	}
	

	/* Elimina todas las fases del proyecto
	 * en el que se encuentre.*/
	public void eliminarFaseDeProyecto()
	{
		fases.eliminarFase();
	}
	
	
	public boolean eliminarEncargadoDeFase(String identificadorEncargado)
	{
		return fases.eliminarEncargadoDeFase(identificadorEncargado);
	}
	
	
	public void eliminarEncargadoDeFase()
	{
		fases.eliminarEmpleado();
	}
	
	
	
	/* Recibe datos de un empleado para ser editados de los integrantes
	 * y de los encargados del proyecto y fases respectivamente..*/
	public void editarEmpleado(String identificadorAEditar, String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		integrantes.editarEmpleado(identificadorAEditar, identificador, contraseña, nombre, ocupacion, admin, trabajando);
		fases.editarEmpleado(identificadorAEditar, identificador, contraseña, nombre, ocupacion, admin, trabajando);
	}
	
	
	public boolean editarFaseDeProyecto(String nombreAEditar, String nombre, String descripcion, boolean completado, Empleado encargado)
	{
		return fases.editarFase(nombreAEditar, nombre, descripcion, completado, encargado);
	}
	
	
	public boolean editarEncargadoDeFase(Empleado encargado, String nombreFase)
	{
		return fases.editarEncargadoDeFase(encargado, nombreFase);
	}
	
	
	
	public void obtenerIdentificadorDeIntegrantes(LinkedList<String> identificadorIntegrantes)
	{
		integrantes.obtenerIdentificadorDeIntegrantes(identificadorIntegrantes);
	}
	
	
	/* Recibe el escritor del archivo con el cual guarda
	 * los datos de los integrante del proyecto.*/
	public void escribirArchivoIntegrantes(PrintWriter pw)
	{
		integrantes.escribirArchivo(pw);
	}
	
	
	/* Recibe el escritor del archivo con el cual guarda
	 * los datos de las fases del proyecto.*/
	public void escribirArchivoFases(PrintWriter pw)
	{
		fases.escribirArchivo(pw);
	}
	
	
	
	public Proyecto() {
		integrantes = new MapaIntegrantes();
		fases = new ListaFases();
	}
	
	
	public Proyecto(String nombre, String cliente, boolean terminado) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.terminado = terminado;
		integrantes = new MapaIntegrantes();
		fases = new ListaFases();
	}

	
	public String getNombre() {
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
	
	
	public MapaIntegrantes getIntegrantes() {
		return integrantes;
	}
	
	
	public void setIntegrantes(MapaIntegrantes integrantes) {
		this.integrantes = integrantes;
	}
	
	
	public ListaFases getFases() {
		return fases;
	}
	
	
	public void setFases(ListaFases fases) {
		this.fases = fases;
	}
	
	
}

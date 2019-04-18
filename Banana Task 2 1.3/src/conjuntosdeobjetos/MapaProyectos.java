package conjuntosdeobjetos;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import objetosbasicos.Empleado;
import objetosbasicos.Proyecto;

public class MapaProyectos {
	private HashMap<String, Proyecto> mapaProyectos;
	
	
	/* Recibe datos de un proyecto y lo agrega al sistema.
	 * En caso de que el proyecto ya se encuentre en el 
	 * sistema se retornara falso.*/
	public boolean agregarProyecto(String nombre, String cliente, boolean terminado) 
	{
		Proyecto proyecto = new Proyecto(nombre, cliente, terminado);
		
		if(mapaProyectos.containsKey(nombre))
			return false;
		else
		{
			mapaProyectos.put(nombre, proyecto);
			return true;
		}
	}
	
	
	/* Recibe una lista con al menos un empleado y el nombre del proyecto al cual 
	 * se agregaran esos empleados que pasaran a ser integrantes del proyecto.
	 * En caso de que el proyecto no se encuentre en el sistema se retornara falso.*/
	public boolean agregarIntegrantesAProyecto(LinkedList<Empleado> integrantesProyecto, String nombreProyecto) 
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).agregarIntegrantesAProyecto(integrantesProyecto);
			return true;
		}
		else
			return false;
	}
	
	
	/* Recibe datos de una fase y el nombre del proyecto al cual se agregaran esas fases.
	 * En caso de que el proyecto no se encuentre en el sistema se retornara falso.*/
	public boolean agregarFaseAProyecto(String nombre, String descripcion, boolean estado, Empleado encargado, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).agregarFaseAProyecto(nombre, descripcion, estado, encargado);
			return true;
		}
		else
			return false;
	}
	
	
	public boolean agregarEncargadoAFase(Empleado encargado, String nombreFase, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).agregarEncargadoAFase(encargado, nombreFase);
			return true;
		}
		else
			return false;
	}
	

	
	/* Recibe el identificador de un empleado y lo elimina
	 * de cada proyecto en el que este.*/
	public void eliminarEmpleado(String identificador)
	{
		for(Proyecto p : mapaProyectos.values()) 
			p.eliminarEmpleado(identificador);
	}	
	
	
	/* Elimina los integrantes y encargados de fases
	 * que se encuentren en cada proyecto de la empresa.*/
	public void eliminarEmpleado()
	{
		for(Proyecto p : mapaProyectos.values()) 
			p.eliminarEmpleado();
	}
	
	
	/* Recibe el nombre de un proyecto con el cual elimina 
	 * un proyecto en especifico de la empresa.
	 * En caso de que el proyecto no exista el metodo retornara falso.*/
	public boolean eliminarProyecto(String nombre, LinkedList<String> identificadorIntegrantes)
	{
		if(mapaProyectos.containsKey(nombre))
		{
			mapaProyectos.get(nombre).eliminarProyecto(identificadorIntegrantes);
			mapaProyectos.remove(nombre);
			return true;
		}
		else
			return false;
	}
	
	
	/* Elimina los integrantes y fases de cada proyecto
	 * para despues eliminar todos los proyectos de la empresa.
	 * En caso de no haber proyectos este metodo retornara falso.*/
	public boolean eliminarProyecto()
	{
		if(mapaProyectos.isEmpty())
			return false;
		else
		{
			for (Proyecto p : mapaProyectos.values())
				p.eliminarProyecto();
			mapaProyectos.clear();
			return true;
		}
	}
	
	
	/* Recibe el identificador de un o mas integrantes y el nombre de un proyecto con los
	 * que eliminara integrantes de un proyecto en especifico.
	 * En caso de que el proyecto no exista el metodo retornara falso.*/
	public boolean eliminarIntegrantesDeProyecto(LinkedList<String> identificadorIntegrantes, String nombreProyecto) 
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).eliminarIntegrantesDeProyecto(identificadorIntegrantes);
			return true;
		}
		else
			return false;
	}
	
	
	/* Elimina todos los integrantes y fases de un proyecto en especifico.
	 * En caso de no encontrar el proyecto este metodo retornara falso.*/
	public boolean eliminarIntegrantesDeProyecto(String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).eliminarEmpleado();
			return true;
		}
		else
			return false;
	}
	
	
	/* Recibe el nombre de una fase y el nombre de un proyecto con los
	 * que eliminara una fase de un proyecto en especifico.
	 * En caso de que el proyecto no exista el metodo retornara falso.*/
	public boolean eliminarFaseDeProyecto(String nombre, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).eliminarFaseDeProyecto(nombre);
			return true;
		}
		else
			return false;
	}
	

	/* Elimina todas las fases de un proyecto en especifico.
	 * En caso de no encontrar el proyecto este metodo retornara falso.*/
	public boolean eliminarFaseDeProyecto(String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).eliminarFaseDeProyecto();
			return true;
		}
		else
			return false;
	}
	
	
	public boolean eliminarEncargadoDeFase(String identificadorEncargado, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).eliminarEncargadoDeFase(identificadorEncargado);
			return true;
		}
		else
			return false;
	}
	
	
	public boolean eliminarEncargadoDeFase(String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).eliminarEncargadoDeFase();
			return true;
		}
		else
			return false;
	}
	
	
	
	/* Recibe datos de un empleado para ser editados de
	 * cada proyecto en el que se encuentre.*/
	public void editarEmpleado(String identificadorAEditar, String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		for(Proyecto p : mapaProyectos.values()) 
			p.editarEmpleado(identificadorAEditar, identificador, contraseña, nombre, ocupacion, admin, trabajando);
	}
	
	
	public boolean editarProyecto(String nombreAEditar, String nombre, String cliente, boolean terminado)
	{
		if(mapaProyectos.containsKey(nombreAEditar))
		{			
			Proyecto copiaProyecto = mapaProyectos.remove(nombreAEditar);
			copiaProyecto.setNombre(nombre);
			copiaProyecto.setCliente(cliente);
			copiaProyecto.setTerminado(terminado);
			mapaProyectos.put(nombre, copiaProyecto);
			return true;
		}
		else
			return false;
	}
	
	
	/* Recibe integrantes que editara de un proyecto en especifico,
	 * al hacer esto se reiniciaran a su vez todas las fases del proyecto.
	 * En caso de que no se encuentre el proyecto el metodo retornara falso.*/
	public boolean editarIntegrantesDeProyecto(LinkedList<String> identificadorIntegrantes, LinkedList<Empleado> integrantesProyecto, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			mapaProyectos.get(nombreProyecto).obtenerIdentificadorDeIntegrantes(identificadorIntegrantes);
			mapaProyectos.get(nombreProyecto).eliminarEmpleado();
			mapaProyectos.get(nombreProyecto).agregarIntegrantesAProyecto(integrantesProyecto);
			return true;
		}
		else
			return false;
	}
	
	
	public boolean editarFaseDeProyecto(String nombreAEditar, String nombre, String descripcion, boolean completado, Empleado encargado, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			return mapaProyectos.get(nombreProyecto).editarFaseDeProyecto(nombreAEditar, nombre, descripcion, completado, encargado);
		}
		else
			return false;
	}
	
	
	public boolean editarEncargadoDeFase(Empleado encargado, String nombreFase, String nombreProyecto)
	{
		if(mapaProyectos.containsKey(nombreProyecto))
		{
			return mapaProyectos.get(nombreProyecto).editarEncargadoDeFase(encargado, nombreFase);
		}
		else
			return false;
	}
	
	
	
	/* Recibe el escritor del archivo con el cual guarda 
	 * los datos de cada proyecto.*/
	public void escribirArchivo(PrintWriter pw)
	{
		for (String k : mapaProyectos.keySet()) 
		{
			pw.println(mapaProyectos.get(k).getNombre());
			pw.println(mapaProyectos.get(k).getCliente());
			pw.println(mapaProyectos.get(k).isTerminado());
			mapaProyectos.get(k).escribirArchivoIntegrantes(pw);
			pw.println(";");
			mapaProyectos.get(k).escribirArchivoFases(pw);
			pw.println(";");
		}
	}
	
	
	
	public MapaProyectos() {
		mapaProyectos = new HashMap<String, Proyecto>();
	}

	
	public HashMap<String, Proyecto> getMapaProyectos() {
		return mapaProyectos;
	}

	
	public void setMapaProyectos(HashMap<String, Proyecto> mapaProyectos) {
		this.mapaProyectos = mapaProyectos;
	}
	
	
}

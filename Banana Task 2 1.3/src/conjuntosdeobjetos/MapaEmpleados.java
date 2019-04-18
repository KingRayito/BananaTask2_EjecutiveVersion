package conjuntosdeobjetos;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import objetosbasicos.Empleado;

public class MapaEmpleados {
	private HashMap<String, Empleado> mapaEmpleados;
	
	
	public int cantidadDeEmpeladosTotal()
	{
		return mapaEmpleados.size() - 1;
	}
	
	
	
	/* Recibe datos de un empleado y lo agrega al sistema.
	 * En caso de que el empleado ya se encuentre en el 
	 * sistema se retornara falso.*/
	public boolean agregarEmpleado(String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando) 
	{
		Empleado empleado = new Empleado(identificador , contraseña, nombre, ocupacion, admin, trabajando);
		
		if(mapaEmpleados.containsValue(empleado))
			return false;
		else 
		{
			mapaEmpleados.put(identificador, empleado);
			return true;
		}
	}
	
	
	
	/* Recibe una lista vacia de empleados y un arreglo de nombres de los integrantes
	 * los cuales seran buscados en el mapa de empleados y se agregaran a la lista entregada.
	 * En caso de no encontrar ningun integrante este metodo retornara falso.*/
	public boolean buscarIntegrantesParaProyecto(LinkedList<Empleado> integrantesProyecto, LinkedList<String> identificadorIntegrantes) 
	{
		for (String identificador : identificadorIntegrantes) 
		{
			for (String k : mapaEmpleados.keySet()) 
			{
				if (identificador.compareTo(k) == 0) 
				{
					mapaEmpleados.get(k).setTrabajando(true);
					integrantesProyecto.add(mapaEmpleados.get(k));
					break;
				}
			}
		}
		return !integrantesProyecto.isEmpty();
	}
	
	
	public void ponerEmpleadosADescansar(LinkedList<String> identificadorIntegrantes)
	{
		for (String identificador : identificadorIntegrantes) 
		{
			for (String k : mapaEmpleados.keySet()) 
			{
				if (identificador.compareTo(k) == 0) 
				{
					mapaEmpleados.get(k).setTrabajando(false);
					break;
				}
			}
		}
	}
	
	
	public void ponerEmpleadosADescansar()
	{
		for (String k : mapaEmpleados.keySet()) 
			mapaEmpleados.get(k).setTrabajando(false);
	}

	
	/* Recibe un empleado sin datos y el nombre de un encargado el cual sera buscado
	 * en los empleados para luego actualizar los datos de ese empleado vacio.
	 * En caso de no encontrar al empleado este metodo retornara falso.*/
	public boolean buscarEncargadoParaFase(Empleado encargado, String identificadorEncargado) 
	{
		for (String k : mapaEmpleados.keySet()) 
		{
			if (identificadorEncargado.compareTo(k) == 0) 
			{
				encargado.setIdentificador(mapaEmpleados.get(k).getIdentificador());
				encargado.setContraseña(mapaEmpleados.get(k).getContraseña());
				encargado.setOcupacion(mapaEmpleados.get(k).getOcupacion());
				encargado.setNombre(mapaEmpleados.get(k).getNombre());
				encargado.setAdmin(mapaEmpleados.get(k).isAdmin());
				encargado.setTrabajando(mapaEmpleados.get(k).isTrabajando());
				return true;
			}
		}
		return false;
	}
	

	
	/* Recibe el identificador de un empleado y lo busca en los empleados de la empresa
	 * para luego eliminarlo en caso de encontrarlo.
	 * En caso de no encontrarlo este metodo retornara falso.*/
	public boolean eliminarEmpleado(String identificador)
	{
		if(mapaEmpleados.containsKey(identificador))
		{
			mapaEmpleados.remove(identificador);
			return true;
		}
		else
			return false;
	}	

	
	/* Elimina todos los empleados de la empresa.
	 * En caso de no haber empleados el metodo retornara falso.*/
	public boolean eliminarEmpleado()
	{
		if(mapaEmpleados.isEmpty())
			return false;
		else
		{
			mapaEmpleados.clear();
			return true;
		}
	}

	
	
	public boolean editarEmpleado(String identificadorAEditar, String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		if(mapaEmpleados.containsKey(identificadorAEditar))
		{
			Empleado copiaEmpleado = mapaEmpleados.remove(identificadorAEditar);
			copiaEmpleado.setIdentificador(identificador);
			copiaEmpleado.setContraseña(contraseña);
			copiaEmpleado.setNombre(nombre);
			copiaEmpleado.setOcupacion(ocupacion);
			copiaEmpleado.setAdmin(admin);
			copiaEmpleado.setTrabajando(trabajando);
			mapaEmpleados.put(identificador, copiaEmpleado);
			return true;
		}
		else 
			return false;			
	}
	
	
	
	/* Recibe el escritor del archivo con el cual guarda 
	 * los datos de cada empleado.*/
	public void escribirArchivo(PrintWriter pw) 
	{
		for (String k : mapaEmpleados.keySet()) 
		{
			pw.println(mapaEmpleados.get(k).getIdentificador());
			pw.println(mapaEmpleados.get(k).getContraseña());
			pw.println(mapaEmpleados.get(k).getNombre());
			pw.println(mapaEmpleados.get(k).getOcupacion());
			pw.println(mapaEmpleados.get(k).isAdmin());
			pw.println(mapaEmpleados.get(k).isTrabajando());
		}
	}
	
	
	
	public MapaEmpleados() {
		mapaEmpleados = new HashMap<String, Empleado>();
	}


	public HashMap<String, Empleado> getMapaEmpleados() {
		return mapaEmpleados;
	}


	public void setMapaEmpleados(HashMap<String, Empleado> mapaEmpleados) {
		this.mapaEmpleados = mapaEmpleados;
	}
	

}

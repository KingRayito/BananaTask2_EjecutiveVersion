package conjuntosdeobjetos;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import objetosbasicos.Empleado;

public class MapaIntegrantes {
	private HashMap<String, Empleado> mapaIntegrantes;
	
	
	/* Recibe un empleado que exista en el sistema y lo agrega a los integrantes de un proyecto.
	 * En caso de que todos los empleados que se le entregue ya
	 * estuviesen dentro de ese proyecto se retornara falso.*/
	public boolean agregarIntegrantesAProyecto(LinkedList<Empleado> empleados)
	{
        int contador = 0;
        
        for(Empleado colaborador : empleados)
        {
             mapaIntegrantes.putIfAbsent(colaborador.getIdentificador(), colaborador);
             contador++;
        }
        
        if(contador == 0) 
        	return false;
        else
        	return true;
	}


	
	/* Recibe el identificador de un integrante el cual eliminara del proyecto.
	 * En caso de no encontrar el integrante este metodo retornara falso.*/
	public boolean eliminarIntegrantesDeProyecto(String identificador)
	{
		if(mapaIntegrantes.containsKey(identificador))
		{
			mapaIntegrantes.remove(identificador);
			return true;
		}
		else
			return false;		
	}
	
	
	/* Elimina todos los integrantes de un proyecto.
	 * En caso de estar vacio este metodo retornara falso.*/
	public boolean eliminarIntegrantesDeProyecto() 
	{
		if(mapaIntegrantes.isEmpty())
			return false;
		else
		{
			mapaIntegrantes.clear();
			return true;
		}
	}
	

	
	/* Recibe los datos de un integrante que se editaran en caso
	 * de que el integrante se encuentre en el proyecto actual.*/
	public void editarEmpleado(String identificadorAEditar, String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		if(mapaIntegrantes.containsKey(identificadorAEditar))
		{
			Empleado copiaEmpleado = mapaIntegrantes.remove(identificadorAEditar);
			copiaEmpleado.setIdentificador(identificador);
			copiaEmpleado.setContraseña(contraseña);
			copiaEmpleado.setNombre(nombre);
			copiaEmpleado.setOcupacion(ocupacion);
			copiaEmpleado.setAdmin(admin);
			copiaEmpleado.setTrabajando(trabajando);
			mapaIntegrantes.put(identificador, copiaEmpleado);
		}
	}
	
	
	
	public void obtenerIdentificadorDeIntegrantes(LinkedList<String> identificadorIntegrantes)
	{
		for(Empleado e : mapaIntegrantes.values())
			identificadorIntegrantes.add(e.getIdentificador());
	}	
	
	
	/* Recibe el escritor del archivo con el cual guarda
	 * el nombre de cada integrante del proyecto.*/
	public void escribirArchivo(PrintWriter pw) 
	{
		for (String k : mapaIntegrantes.keySet())
			pw.println(mapaIntegrantes.get(k).getIdentificador());
	}
	
	
	
	public MapaIntegrantes() {
		mapaIntegrantes = new HashMap<String, Empleado>();
	}
	
	
	public HashMap<String, Empleado> getMapaIntegrantes() {
		return mapaIntegrantes;
	}

	
	public void setMapaIntegrantes(HashMap<String, Empleado> mapaIntegrantes) {
		this.mapaIntegrantes = mapaIntegrantes;
	}
	
	
}

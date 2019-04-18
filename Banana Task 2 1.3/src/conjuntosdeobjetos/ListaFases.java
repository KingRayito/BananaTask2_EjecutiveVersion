package conjuntosdeobjetos;

import java.io.PrintWriter;
import java.util.LinkedList;

import objetosbasicos.Empleado;
import objetosbasicos.Fase;

public class ListaFases {
	private LinkedList<Fase> listaFases;
	
	
	/* Recibe datos de una fase y la agrega a un proyecto.
	 * En caso de que la fase ya se encuentre en el
	 * proyecto se retornara falso.*/
	public boolean agregarFase(String nombre, String descripcion, boolean estado, Empleado encargado) 
	{
		Fase fase = new Fase(nombre, descripcion, estado, encargado);
		
		for (Fase f : listaFases)
			if(f.getNombre().equals(fase.getNombre()))
				return false;
		
		return listaFases.add(fase);
	}
	
	
	public boolean agregarEncargadoAFase(Empleado encargado, String nombreFase)
	{
		for (Fase f : listaFases)
		{
			if(f.getNombre().equals(nombreFase)) {
				if(f.esEncargado("Sin encargado"))
				{
					f.setEncargado(encargado);
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
	

	
	/* Recibe el identificador de un encargado y eliminara
	 * todas las fases en que se encuentre el encargado.*/
	public void eliminarEmpleado(String identificador) 
	{
		for(Fase f : listaFases)
			if(f.esEncargado(identificador))
				f.editarEncargado("Sin encargado", "Sin encargado", "Sin encargado", "Sin encargado", true, true);
	}
	
	
	public void eliminarEmpleado()
	{
		for(Fase f : listaFases)
			f.editarEncargado("Sin encargado", "Sin encargado", "Sin encargado", "Sin encargado", true, true);
	}
	
	
	/* Recibe el nombre de una fase la cual eliminara del proyecto.
	 * En caso de no encontrar la fase este metodo retornara falso.*/
	public boolean eliminarFase(String nombre) 
	{
		for(Fase f: listaFases)	
		{
			if(f.getNombre().compareTo(nombre) == 0) 
			{
				listaFases.remove(f);
				return true;
			}
		}
		return false;
	}
	
	
	/* Elimina todas las fases de un proyecto.
	 * En caso de estar vacio este metodo retornara falso.*/
	public boolean eliminarFase()
	{
		if(listaFases.isEmpty())
			return false;
		else
		{
			listaFases.clear();
			return true;
		}
	}
	
	
	public boolean eliminarEncargadoDeFase(String identificadorEncargado)
	{
		for (Fase f : listaFases)
		{
			if(f.esEncargado(identificadorEncargado))
			{
				f.editarEncargado("Sin encargado", "Sin encargado", "Sin encargado", "Sin encargado", true, true);
				return true;
			}
		}
		return false;
	}
	

	
	/* Recibe los datos de un encargado que editaran en caso
	 * de que el encargado se encuentre en la fase actual.*/
	public void editarEmpleado(String identificadorAEditar, String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		for(Fase f : listaFases)
			if(f.esEncargado(identificadorAEditar))
				f.editarEncargado(identificador, contraseña, nombre, ocupacion, admin, trabajando);
	}
	
	
	public boolean editarFase(String nombreAEditar, String nombre, String descripcion, boolean completado, Empleado encargado)
	{
		for(Fase f : listaFases)	
		{
			if(f.getNombre().compareTo(nombreAEditar) == 0) 
			{
				listaFases.remove(f);
				f.setNombre(nombre);
				f.setDescripcion(descripcion);
				f.setCompletado(completado);
				f.setEncargado(encargado);
				listaFases.add(f);
				return true;
			}
		}
		return false;
	}
	
	
	public boolean editarEncargadoDeFase(Empleado encargado, String nombreFase)
	{
		for(Fase f : listaFases)	
		{
			if(f.getNombre().compareTo(nombreFase) == 0) 
			{
				f.setEncargado(encargado);
				return true;
			}
		}
		return false;
	}
	
	

	/* Recibe el escritor del archivo con el cual guarda
	 * los datos de cada fase del proyecto.*/
	public void escribirArchivo(PrintWriter pw) 
	{
		for (Fase f : listaFases) 
		{
			pw.println(f.getNombre());
			pw.println(f.getDescripcion());
			pw.println(f.isCompletado());
			f.escribirArchivo(pw);			
		}
	}
	
	
	
	public ListaFases() 
	{
		listaFases = new LinkedList<Fase>();
	}
	
	
	public LinkedList<Fase> getListaFases() 
	{
		return listaFases;
	}

	
	public void setListaFases(LinkedList<Fase> listaFases) {
		this.listaFases = listaFases;
	}
	
	
}

package clasesgenerales;
import java.util.*;
import clasesbasicas.Fase;

public class ListaFases {
	
	private LinkedList<Fase> listaFases;
	
	public ListaFases()
	{
		listaFases = new LinkedList<Fase>(); //Crea espacio para la lista
	}
	
	public void agregarFase(Fase fase)
	{
		listaFases.add(fase); //agrega el dato pasado por parametros a la lista
	}
	
	public boolean eliminarFase(String nombreFase)
	{
		for (Fase  fase: listaFases) //recorre la lista
		{
			if(nombreFase.compareTo(fase.getNombre()) == 0) //compara el nombre entragado con todas las fases en la lista
			{
				listaFases.remove(fase); //una vez encontrado, lo elimina
				return true; //retorna verdadero para asegurar que la eliminacion del dato fue hecha con exito
			}
		}
			System.out.println("ERROR AL ELIMINAR"); //de lo contrario retorna un mensaje por pantalla
			return false; // y retorna falso
		}
	
	public void mostrarFases()
	{
		
	}
	
	public LinkedList<Fase> getListaFases()
	{
		return listaFases;
	}
	
	public void setListaFases(LinkedList<Fase> LF)
	{
		this.listaFases = LF;
	}
	
	

}

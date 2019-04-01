package clasesgenerales;
import java.util.*;
import clasesbasicas.Fase;

public class ListaFases {
	
	private LinkedList<Fase> listaFases;
	private Fase fase;
	public ListaFases()
	{
		listaFases = new LinkedList<Fase>(); //Crea espacio para la lista
	}
	
	public void agregarFase(String nombre, String descripcion, boolean completado)
	{
		fase = new Fase(nombre, descripcion, completado);
		listaFases.add(fase);
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
		for (Fase fase: listaFases) {
			System.out.println("Nombre: " + fase.getNombre());
			System.out.println("Descripcion: " + fase.getDescripcion());
			if(fase.isCompletado()) {
				System.out.println("Estado: Completado\n");
			} else {
				System.out.println("Estado: No completado\n");
			}
		}
	}
	
/*	public void editarFases(String nombre, String descripcion, boolean completo) 
	{
		for (Fase fase: listaFases) {
			if(fase.getNombre().compareTo(nombre) == 0) {
				
			}
		}
	}*/
	
	public LinkedList<Fase> getListaFases()
	{
		return listaFases;
	}
	
	public void setListaFases(LinkedList<Fase> LF)
	{
		this.listaFases = LF;
	}
	
	

}

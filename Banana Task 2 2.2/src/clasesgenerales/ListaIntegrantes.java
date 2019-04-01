package clasesgenerales;

import java.util.HashMap;
import clasesbasicas.Integrante;

public class ListaIntegrantes {
	private HashMap<String,Integrante> mapaIntegrantes;
	
	public ListaIntegrantes() {
		mapaIntegrantes = new HashMap<String,Integrante>();
	}
	
	public boolean agregarIntegrante(Integrante integrante) {
		if (mapaIntegrantes.isEmpty()) //si el mapa esta vacio
			mapaIntegrantes.put(integrante.getIdentificador(), integrante); //entonces coloca al integrante
		else { //de no ser así
			if (mapaIntegrantes.containsKey(integrante.getIdentificador())) // si el integrante ya exste no pone al integrante en el mapa
				return false;
			else 
				mapaIntegrantes.put(integrante.getIdentificador(), integrante); //pero si no existe, entonces si lo ingresa al mapa
		}
		return true;
	}
	
	public boolean removerIntegrante(String identificador) {
		if (mapaIntegrantes.isEmpty()) //si el mapa ya esta vacio
		{
			return false; //entonces restora falso porque no hay nada que borrar
		}
		else //si no está vacio
		{
			mapaIntegrantes.remove(identificador); //entonces remueve la casilla a la que le perenece la ID
		}
		return true;
	}
	
	public boolean editarIntegrante(Integrante integrante) {
		if (mapaIntegrantes.isEmpty()) //si el mapa está vacio
			return false; //no hay nada que editar
		else {//sino
			if (mapaIntegrantes.containsKey(integrante.getIdentificador())) //busca al integrante y retorna la casilla en la que se encuentra
				mapaIntegrantes.put(integrante.getIdentificador(), integrante); //a la casilla con la misma key le inserta un nuevo integrante
			else 
				return false; 
		}
		return true;
	}
	
	public boolean inicioSesion(String identificador, String contraseña){ //inicio de sesion en el hashmap
		for (String k : mapaIntegrantes.keySet()) //recorre el mapa
			if (k.compareTo(identificador) == 0) //compara cada contraseña del mapa con el ID que le entregan a la funcion
				if (mapaIntegrantes.get(k).getContraseña().compareTo(contraseña) == 0) //si el ID es igual a K
					return true; //enonces inicia sesion
		return false; //sino lo manda a laar
	}

		//getter y setter
	public HashMap<String, Integrante> getMapaIntegrantes() {
		return mapaIntegrantes;
	}

	public void setMapaIntegrantes(HashMap<String, Integrante> mapaIntegrantes) {
		this.mapaIntegrantes = mapaIntegrantes;
	}
	
	
}

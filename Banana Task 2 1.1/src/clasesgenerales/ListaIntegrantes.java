package clasesgenerales;

import java.util.HashMap;
import clasesbasicas.Integrante;

public class ListaIntegrantes {
	private HashMap<String,Integrante> mapaIntegrantes;
	
	public boolean agregarIntegrante(Integrante integrante) { //!
		if (mapaIntegrantes.isEmpty())
			mapaIntegrantes.put(integrante.getIdentificador(), integrante);
		else {
			if (mapaIntegrantes.containsKey(integrante.getIdentificador()))
				return false;
			else 
				mapaIntegrantes.put(integrante.getIdentificador(), integrante);
		}
		return true;
	}
	
	public boolean removerIntegrante(String identificador) {
		if (mapaIntegrantes.isEmpty())
			return false;
		else
			mapaIntegrantes.remove(identificador);
		return true;
	}
	
	public boolean editarIntegrante(Integrante integrante) {
		if (mapaIntegrantes.isEmpty())
			return false;
		else {
			if (mapaIntegrantes.containsKey(integrante.getIdentificador()))
				mapaIntegrantes.put(integrante.getIdentificador(), integrante);
			else 
				return false;
		}
		return true;
	}
	
}

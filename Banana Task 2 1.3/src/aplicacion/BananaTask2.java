package aplicacion;

import java.io.IOException;
import java.util.LinkedList;

public class BananaTask2 {

	public static void main(String[] args) throws IOException {
		Empresa empresa = new Empresa();
		LinkedList<String> identificadorIntegrantes = new LinkedList<String>();
		identificadorIntegrantes.add("basti");
		
		empresa.cargarArchivo();
		empresa.mostrarArchivo();
		empresa.editarIntegrantesDeProyecto(identificadorIntegrantes, "Pavimentacion de avenida");
		empresa.escribirArchivo();
		empresa.mostrarArchivo();
	}

}

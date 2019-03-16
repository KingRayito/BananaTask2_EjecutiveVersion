package aplicacion;

import java.io.*;
import java.util.*;


public class BananaTask2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Iniciando aplicacion...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		Proyecto aux;
		String key;
		HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
		for (int i = 0;i<3;i++) {
			aux = new Proyecto();
			System.out.print("Ingrese nombre de proyecto "+ (i+1) + ": ");
			key = lector.readLine();
			aux.setNombreProyecto(key);
			proyectos.put(key, aux);
		}
		
	}

}

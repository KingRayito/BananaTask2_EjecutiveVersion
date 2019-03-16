package aplicacion;

import java.io.*;
import java.util.*;


public class BananaTask2 {
	public static void main(String[] args) throws IOException {
		System.out.println("Iniciando aplicacion...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		Proyecto aux;
		String key;
		//HashMap para agregar los proyectos
		HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
		/*
		Este ciclo pregunta por el nombre de tres proyectos
		los cuales seran almazenados en el HashMap, a continuacion
		queria mostrarlos por pantalla, cosa que debes realizar con 
		los metodos y unos ciclos, la idea es acceder a los valores
		mediante una key, de esta manera accedemos a el valor que
		en nuestro caso sera un objeto "proyecto" con los atributos
		"nombreProyecto" y "estadoProyecto"(me falto rellenar el estado
		que es un boolean). Usando los metodos de esas clases podran
		extraer la info de proyecto.
		*/
		for (int i = 0;i<3;i++) {
			aux = new Proyecto();
			System.out.print("Ingrese nombre de proyecto "+ (i+1) + ": ");
			key = lector.readLine();
			aux.setNombreProyecto(key);
			proyectos.put(key, aux);
		}
		
	}

}

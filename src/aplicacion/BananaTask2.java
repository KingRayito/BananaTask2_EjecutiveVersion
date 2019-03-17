package aplicacion;

import java.io.*;
import java.util.*;


public class BananaTask2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Iniciando aplicacion...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		Proyecto aux1;
		LinkedList<Evento> aux2;
		Evento aux3;
		String key, buffer;
		int op1, op2;
		HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
		
		do {

			System.out.println("1.- Ingresar proyecto.");
			System.out.println("2.- Ingresar usuario.");
			System.out.println("3.- Salir");
			op1 = Integer.parseInt(lector.readLine());
			op2 = 0;

	        switch (op1){
	        
	            case 1:
	            	
	            	aux1 = new Proyecto();
	            	aux2 = new LinkedList<Evento>();
	            	
	            	System.out.println("Ingrese nombre del proyecto: ");
	            	key = lector.readLine();
	            	aux1.setNombreProyecto(key);
	            	aux1.setEstadoProyecto(false);
	            	
	            	do {
	            		
	            		System.out.println("1.- Ingresar nuevo evento.");
	            		System.out.println("2.- Listo.");
	            		op2 = Integer.parseInt(lector.readLine());
	            		switch (op2) {
	            
	            			case 1: 
	            				aux3 = new Evento();
	            				System.out.println("Ingrese descripcion del evento: ");
	            				buffer = lector.readLine();
	            				aux3.setDescripcionEvento(buffer);
	            				aux3.setEstadoEvento(false);
	            				
	            				aux2.add(aux3);
	            				break;
	            			
	            			case 2: break;
	            			
	            			default: break;
	            		}
	            		
	            	} while(op2 != 2);
	            	
	            	aux1.setEventosProyecto(aux2);
	            	
	            	proyectos.put(key, aux1);
	            	
	            	break;
	            
	            case 2: 
	            	
	            	for (String k : proyectos.keySet()) {
	            		System.out.println("Nombre del proyecto: " + proyectos.get(k).getNombreProyecto());
	            		if (proyectos.get(k).getEstadoProyecto())
	            			System.out.println("Estado del proyecto: TERMINADO");
	            		else
	            			System.out.println("Estado del proyecto: NO TERMINADO");
	            		for (Evento l : proyectos.get(k).getEventosProyecto()) {
	            			System.out.println("Descripcion del evento: " + l.getDescripcionEvento());
	            			if (l.getEstadoEvento())
		            			System.out.println("Estado del evento: COMPLETADO");
		            		else
		            			System.out.println("Estado del evento: NO COMPLETADO");
	            		}
	            	}
	            	
	            	break;
	            
	            case 3: break; 
	            
	            default: break;

	        }   

		} while(op1 != 3);  
		
	}
}

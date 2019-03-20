package aplicacion;

import java.io.*;
import java.util.*;


public class BananaTask2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Iniciando aplicacion...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		Proyecto aux1;
		Usuario usu1, usuarioAdministrador;
		LinkedList<Evento> aux2;
		LinkedList<Proyecto> auxList;
		Evento aux3;
		String key, buffer;
		int op1, op2;
		HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
		HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
		
		usuarioAdministrador = new Usuario();
		usuarioAdministrador.setAdministrador(true);
		usuarioAdministrador.setNombreUsuario("Administrador");
		usuarioAdministrador.setContraseñaUsuario("1234");
		usuarioAdministrador.setApellidos("Jefesito");
		usuarioAdministrador.setNombres("El");
		usuarioAdministrador.setOcupacion("Admin");
		usuarios.put("Administrador", usuarioAdministrador);
		do {
			System.out.println("Bienvenido a BananaTask Enterprise. Por favor inicie sesión para continuar.");
			System.out.println("Ingrese nombre de usuario.");
			key = lector.readLine();
			
			if(usuarios.containsKey(key)){
				
				System.out.println("Ingrese contraseña del usuario.");
				buffer = lector.readLine();
				do {
					if((usuarios.get(key).getContraseñaUsuario().compareTo(buffer)) == 0) {
						System.out.println("Inicio de sesion exitoso.");
						break;
					}
					else {
						System.out.println("Contraseña erronea. Intente nuevamente.");
					}
				}while(true);
				break;
			}
			else {
				System.out.println("Usuario no encontrado. Intente nuevamente");
			}
			
		}while(true);
		
		if(usuarios.get(key).isAdministrador()) {
			do {
	
				System.out.println("1.- Ingresar proyecto.");
				System.out.println("2.- Mostrar proyectos.");
				System.out.println("3-. Ingresar usuario");
				System.out.println("4-. Cerrar sesion");
				System.out.println("5-. Salir del programa.");
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
		            	
		            case 3:
		   
		            	usu1 = new Usuario();
		            	auxList = new LinkedList<Proyecto>();
		            	
		            	System.out.println("Ingrese nombre de usuario: ");
		            	key = lector.readLine();
		            	usu1.setNombreUsuario(key);
		              	System.out.println("Ingrese contraseña de usuario: ");
		            	buffer = lector.readLine();
		            	usu1.setContraseñaUsuario(buffer);
		              	System.out.println("Ingrese nombre: ");
		            	buffer = lector.readLine();
		            	usu1.setNombres(buffer);
		              	System.out.println("Ingrese apellido: ");
		            	buffer = lector.readLine();
		            	usu1.setApellidos(buffer);
		              	System.out.println("Ingrese oupacion del usuario: ");
		            	buffer = lector.readLine();
		            	usu1.setOcupacion(buffer);
		            	
		            	for (String k : proyectos.keySet()) {
	    					System.out.println("Desea agregar el proyecto: " + proyectos.get(k).getNombreProyecto() + "al usuario?");
	    					System.out.println("1.- Si.");
	    					System.out.println("2.- NO.");
	    					switch (Integer.parseInt(lector.readLine())) {
	    						
	    						case 1: 
	    							auxList.add(proyectos.get(k));
	    							break;
	    						case 2: break;
	    						default: break;
	    					}
		            	}
		            	
		            	usu1.setProyectosUsuario(auxList);
		            	usuarios.put(key, usu1);
		            	
		            	break;
		            	
		            case 4: 
		            	
		            	break; 
		            
		            case 5: break;
		            
		            default: break;
		            
		            
		            	
	
		        }   
	
			} while(op1 != 5);  
			
		}
		else {
			System.out.println("camese pofavo");
		}
	}
}

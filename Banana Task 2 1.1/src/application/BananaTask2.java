package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import clasesbasicas.Integrante;
import clasesgenerales.ListaIntegrantes;


public class BananaTask2 {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Iniciando aplicacion...");
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String key, buffer;
		int op1 = 4;
		ListaIntegrantes integrantes = new ListaIntegrantes();
		integrantes.agregarIntegrante(new Integrante("Bastian", "1905", true));
		integrantes.agregarIntegrante(new Integrante("Tifa", "1704", true));
		integrantes.agregarIntegrante(new Integrante("Felipe", "2904", true));
		do {
			System.out.println("Bienvenido a BananaTask Enterprise. Por favor inicie sesión para continuar.");
			do {
				System.out.println("Ingrese nombre de usuario.");
				key = lector.readLine();
				
				if(integrantes.getMapaIntegrantes().containsKey(key)){
					
					System.out.println("Ingrese contraseña del usuario.");
					do {
						buffer = lector.readLine();
						if((integrantes.getMapaIntegrantes().get(key).getContraseña().compareTo(buffer)) == 0) {
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
			
			if(integrantes.getMapaIntegrantes().get(key).isAdmin()) {
				do {
		
					System.out.println("1.- Proyectos.");
					System.out.println("2.- Integrantes.");
					System.out.println("3-. Cerrar sesion");
					System.out.println("4-. Salir del programa.");
					op1 = Integer.parseInt(lector.readLine());
		
			        switch (op1){
			        
			            case 1:
			            	
			            	
			            	
			            	break;
			            
			            case 2: 
			         
			            	Integrante integrante = new Integrante();
			            	System.out.println("Ingrese nombre de usuario: ");
			            	key = lector.readLine();
			            	integrante.setIdentificador(key);
			              	System.out.println("Ingrese contraseña de usuario: ");
			            	buffer = lector.readLine();
			            	integrante.setContraseña(buffer);
			              	System.out.println("Ingrese nombre: ");
			            	buffer = lector.readLine();
			            	integrante.setNombre(buffer);
			              	System.out.println("Ingrese oupacion del usuario: ");
			            	buffer = lector.readLine();
			            	integrante.setOcupacion(buffer);
			            	integrante.setAdmin(false);
			            	
			            	integrantes.getMapaIntegrantes().put(key, integrante);
			            	
			            	break;
			            	
			            case 3:
			            	
			            	System.out.println("Cerrando sesion...");
			            	break;
			            	
			            case 4: 
			            	
			            	break;
			            
			            default: break;
	
			        }   
		
				} while(op1 < 3);  
				
			}
			else {
				System.out.println("1-. Cerrar sesion");
				System.out.println("4-. Salir");
				op1 = Integer.parseInt(lector.readLine());
				switch(op1){
					
					case 1:
						System.out.println("Cerrando sesion...");
						break;
						
					case 4: 
						break;
					
					default: 
						break;
					
				}
			}
		} while(op1 != 4);
	}
}

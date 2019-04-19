package aplicacion;

import java.io.*;
import java.util.LinkedList;
import conjuntosdeobjetos.MapaEmpleados;
import conjuntosdeobjetos.MapaProyectos;
import objetosbasicos.Empleado;

public class Empresa {
	private MapaProyectos proyectos;
	private MapaEmpleados empleados;
	
	
	public double porcentajeDeEmpleadosDesocupados()
	{
		return (double)empleados.cantidadDeEmpleadosDesocupados()/(double)empleados.cantidadDeEmpleadosTotal();
	}
	
	public double porcentajeDeEmpleadosOcupados()
	{
		return (double)empleados.cantidadDeEmpleadosOcupados()/(double)empleados.cantidadDeEmpleadosTotal();
	}
	
	
	public double porcentajeAvanceDeFases()
	{
		return proyectos.porcentajeAvanceDeFases();
	}
	
	
	// Agrega un empleado a la empresa.
	public boolean agregarEmpleados(String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando) 
	{
		return empleados.agregarEmpleado(identificador, contraseña, nombre, ocupacion, admin, trabajando);
	}
		
	
	// Agrega un proyecto a la empresa.
	public boolean agregarProyecto(String nombre, String cliente, boolean terminado) 
	{
		return proyectos.agregarProyecto(nombre, cliente, terminado);
	}
	
	
	// Agrega integrantes a un proyecto en especifico.
	public boolean agregarIntegrantesAProyecto(LinkedList<String> identificadorIntegrantes, String nombreProyecto) 
	{
		LinkedList<Empleado> integrantesProyecto = new LinkedList<Empleado>();
		
		if(empleados.buscarIntegrantesParaProyecto(integrantesProyecto, identificadorIntegrantes))
			return proyectos.agregarIntegrantesAProyecto(integrantesProyecto, nombreProyecto);
		else
			return false;
	}
	
	
	// Agrega una fase a un proyecto en especifico.
	public boolean agregarFaseAProyecto(String nombre, String descripcion, boolean completado, String identificadorEncargado, String nombreProyecto)
	{
		Empleado encargado = new Empleado();
		
		if(empleados.buscarEncargadoParaFase(encargado, identificadorEncargado))
			return proyectos.agregarFaseAProyecto(nombre, descripcion, completado, encargado, nombreProyecto);
		else
			return false;
	}
	
	
	public boolean agregarEncargadoAFase(String identificadorEncargado, String nombreFase, String nombreProyecto)
	{
		Empleado encargado = new Empleado();
		
		if(empleados.buscarEncargadoParaFase(encargado, identificadorEncargado))
			return proyectos.agregarEncargadoAFase(encargado, nombreFase, nombreProyecto);
		else
			return false;
	}
	

	
	// Elimina un empleado de la empresa.
	public boolean eliminarEmpleado(String identificador)
	{
		if(empleados.eliminarEmpleado(identificador)) 
		{
			proyectos.eliminarEmpleado(identificador);
			return true;
		}
		else
			return false;
	}
	
	
	// Elimina todos los empleados de la empresa.
	public boolean eliminarEmpleado() 
	{

		if(empleados.eliminarEmpleado()) 
		{
			proyectos.eliminarEmpleado();
			return true;
		}
		else
			return false;
	}
	
	
	// Elimina un proyecto de la empresa.
	public boolean eliminarProyecto(String nombre)
	{
		LinkedList<String> identificadorIntegrantes = new LinkedList<String>();
		
		if(proyectos.eliminarProyecto(nombre, identificadorIntegrantes))
		{
			empleados.ponerEmpleadosADescansar(identificadorIntegrantes);
			return true;
		}
		else
			return false;
	}
	
	
	// Elimina todos los proyectos de la empresa.
	public boolean eliminarProyecto()
	{
		if(proyectos.eliminarProyecto())
		{
			empleados.ponerEmpleadosADescansar();
			return true;
		}
		else
			return false;
	}
	
	
	// Elimina los integrantes de un proyecto.
	public boolean eliminarIntegrantesDeProyecto(LinkedList<String> identificadorIntegrantes, String nombreProyecto)
	{
		if(proyectos.eliminarIntegrantesDeProyecto(identificadorIntegrantes, nombreProyecto))
		{
			empleados.ponerEmpleadosADescansar(identificadorIntegrantes);
			return true;
		}
		else
			return false;
	}
	
	
	// Elimina todos los integrantes de un proyecto.
	public boolean eliminarIntegrantesDeProyecto(String nombreProyecto)
	{
		LinkedList<String> integrantesPreviosEnProyecto = new LinkedList<String>();
		
		proyectos.obtenerIdentificadorDeIntegrantes(integrantesPreviosEnProyecto, nombreProyecto);
		
		if(proyectos.eliminarIntegrantesDeProyecto(nombreProyecto))
		{
			empleados.ponerEmpleadosADescansar(integrantesPreviosEnProyecto);
			return true;
		}
		else
			return false;
	}
	
	
	// Elimina una fase de un proyecto.
	public boolean eliminarFaseDeProyecto(String nombre, String nombreProyecto)
	{
		return proyectos.eliminarFaseDeProyecto(nombre, nombreProyecto);
	}
	

	// Elimina todas las fases de un proyecto.
	public boolean eliminarFaseDeProyecto(String nombreProyecto)
	{
		return proyectos.eliminarFaseDeProyecto(nombreProyecto);
	}
	
	
	public boolean eliminarEncargadoDeFase(String identificadorEncargado, String nombreProyecto)
	{
		return proyectos.eliminarEncargadoDeFase(identificadorEncargado, nombreProyecto);
	}
	
	
	public boolean eliminarEncargadoDeFase(String nombreProyecto)
	{
		return proyectos.eliminarEncargadoDeFase(nombreProyecto);
	}

	
	
	// Edita un empleado de la empresa.
	public boolean editarEmpleado(String identificadorAEditar, String identificador, String contraseña, String nombre, String ocupacion, boolean admin, boolean trabajando)
	{
		/* Al editar un empleado, primero se elimina y luego se vuelve 
		 * a agregar por si existe un cambio en el identificador.*/
		if(empleados.editarEmpleado(identificadorAEditar, identificador, contraseña, nombre, ocupacion, admin, trabajando))
		{
			proyectos.editarEmpleado(identificadorAEditar, identificador, contraseña, nombre, ocupacion, admin, trabajando);
			return true;
		}
		else
			return false;
	}
	
	
	// Edita un proyecto de la empresa.
	public boolean editarProyecto(String nombreAEditar, String nombre, String cliente, boolean terminado)
	{
		return proyectos.editarProyecto(nombreAEditar, nombre, cliente, terminado);
	}
	
	
	// Edita los integrantes de un proyecto.
	public boolean editarIntegrantesDeProyecto(LinkedList<String> identificadorIntegrantes, String nombreProyecto)
	{
		LinkedList<Empleado> integrantesProyecto = new LinkedList<Empleado>();
		LinkedList<String> integrantesPreviosEnProyecto = new LinkedList<String>();
		
		/* Al editar los integrantes del proyecto, primero se eliminan y 
		 * luego se vuelven a agregar por si se agregaron o quitaron integrantes.
		 * Esto a su vez elimina las fases del proyecto en el que estaba.*/
		
		proyectos.obtenerIdentificadorDeIntegrantes(integrantesPreviosEnProyecto, nombreProyecto);
		empleados.ponerEmpleadosADescansar(integrantesPreviosEnProyecto);
		
		if(empleados.buscarIntegrantesParaProyecto(integrantesProyecto, identificadorIntegrantes))
			return proyectos.editarIntegrantesDeProyecto(identificadorIntegrantes, integrantesProyecto, nombreProyecto);
		else
			return false;
	}
	
	
	// Edita las fases de un proyecto.
	public boolean editarFaseDeProyecto(String nombreAEditar, String nombre, String descripcion, boolean completado, String identificadorEncargado, String nombreProyecto)
	{
		Empleado encargado = new Empleado();
		
		if(empleados.buscarEncargadoParaFase(encargado, identificadorEncargado))
		{
			/* Al editar una fase, primero se elimina y luego se vuelve 
			 * a agregar por si existe un cambio en el identificador.*/
			return proyectos.editarFaseDeProyecto(nombreAEditar, nombre, descripcion, completado, encargado, nombreProyecto);
		}
		else
			return false;
	}
	
	
	public boolean editarEncargadoDeFase(String identificadorEncargado, String nombreFase, String nombreProyecto)
	{
		Empleado encargado = new Empleado();
		
		if(empleados.buscarEncargadoParaFase(encargado, identificadorEncargado)) 
		{
			return proyectos.editarEncargadoDeFase(encargado, nombreFase, nombreProyecto);
		}
		else
			return false;
	}
	
	
	
	// Carga desde un archivo todos los datos de la empresa.
	public void cargarArchivo() throws FileNotFoundException, IOException 
	{
		String identificador, contraseña, nombreEmpleado, ocupacion, nombreProyecto, cliente, nombreFase, descripcion;
        boolean admin, trabajando, terminado, completado;
		FileReader archivoEmpleados = new FileReader("Empleados.txt");
        FileReader archivoProyectos = new FileReader("Proyectos.txt");
        BufferedReader lectorEmpleados = new BufferedReader(archivoEmpleados);
        BufferedReader lectorProyectos = new BufferedReader(archivoProyectos);
        
        // Recorro obteniendo datos de cada empleado.
        while((identificador = lectorEmpleados.readLine()) != null) 
        {         	
        	contraseña = lectorEmpleados.readLine();
        	nombreEmpleado = lectorEmpleados.readLine();
        	ocupacion = lectorEmpleados.readLine();
        	admin = Boolean.parseBoolean(lectorEmpleados.readLine());
        	trabajando = Boolean.parseBoolean(lectorEmpleados.readLine());
        	
        	agregarEmpleados(identificador, contraseña, nombreEmpleado, ocupacion, admin, trabajando);
        }
        
        LinkedList<String> identificadorIntegrantes;
        
        // Recorro obteniendo datos de cada proyecto.
        while((nombreProyecto = lectorProyectos.readLine()) != null) 
        { 	
        	cliente = lectorProyectos.readLine();
        	terminado = Boolean.parseBoolean(lectorProyectos.readLine());
        	
        	agregarProyecto(nombreProyecto, cliente, terminado);
        	
        	identificadorIntegrantes = new LinkedList<String>();
        	
        	// Recorro obteniendo los nombres de los integrantes del proyecto.
        	while((identificador = lectorProyectos.readLine()).compareTo(";") != 0)
        		identificadorIntegrantes.add(identificador);

        	
        	agregarIntegrantesAProyecto(identificadorIntegrantes, nombreProyecto);
        	
        	// Recorro obteniendo los datos de cada fase del proyecto.
        	while((nombreFase = lectorProyectos.readLine()).compareTo(";") != 0) 
        	{
        		descripcion = lectorProyectos.readLine();
        		completado = Boolean.parseBoolean(lectorProyectos.readLine());
        		identificador = lectorProyectos.readLine();
        		
        		agregarFaseAProyecto(nombreFase, descripcion, completado, identificador, nombreProyecto);
        	}
        }
        
        archivoEmpleados.close();
        archivoProyectos.close();
	}
	
	
	// Muestra por consola los datos actuales de la empresa.
	public void mostrarArchivo() throws FileNotFoundException, IOException 
	{
		String cadena;
        FileReader archivoEmpleados = new FileReader("Empleados.txt");
        FileReader archivoProyectos = new FileReader("Proyectos.txt");
        BufferedReader lectorEmpleados = new BufferedReader(archivoEmpleados);
        BufferedReader lectorProyectos = new BufferedReader(archivoProyectos);
        
        while((cadena = lectorEmpleados.readLine()) != null) 
        {
            System.out.println(cadena);
        }
        
        System.out.println();
        
        while((cadena = lectorProyectos.readLine())!=null) 
        {
            System.out.println(cadena);
        }
        
        archivoEmpleados.close();
        archivoProyectos.close();
    }


	// Guarda en un archivo todos los datos actuales de la empresa.
	public void escribirArchivo() throws IOException 
	{
        FileWriter archivoEmpleados = new FileWriter("Empleados.txt");
        FileWriter archivoProyectos = new FileWriter("Proyectos.txt");
        PrintWriter pwEmpleados = new PrintWriter(archivoEmpleados);
        PrintWriter pwProyectos = new PrintWriter(archivoProyectos);
        
        System.out.println("Escribiendo en el Empleados.txt");
        
        empleados.escribirArchivo(pwEmpleados);
        
        System.out.println("Escribiendo en el Proyectos.txt");
        
        proyectos.escribirArchivo(pwProyectos);
        
        archivoEmpleados.close();
        archivoProyectos.close();
	}
	
	
	
	public Empresa() {
		proyectos = new MapaProyectos();
		empleados = new MapaEmpleados();
	}
	
	
	public MapaProyectos getProyectos() {
		return proyectos;
	}
	
		
	public void setProyectos(MapaProyectos proyectos) {
		this.proyectos = proyectos;
	}
	
		
	public MapaEmpleados getEmpleados() {
		return empleados;
	}
	
		
	public void setEmpleados(MapaEmpleados empleados) {
		this.empleados = empleados;
	}
	
		
}

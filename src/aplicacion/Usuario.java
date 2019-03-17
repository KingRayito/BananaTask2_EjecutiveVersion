package aplicacion;

public class Usuario {
	private String nombreUsuario;
	private String contraseñaUsuario;
	private String nombres;
	private String apellidos;
	private int rut;
	
	public void setNombreUsuario(String nomU) {
		nombreUsuario = nomU;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setContraseñaUsuario(String conU) {
		contraseñaUsuario = conU;
	}
	
	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}
	
	public void setNombres(String nom) {
		nombres = nom;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setApellidos(String ape) {
		apellidos = ape;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setRutUsuario(int rutU) {
		rut = rutU;
	}
	
	public int getRutUsuario() {
		return rut;
	}
}

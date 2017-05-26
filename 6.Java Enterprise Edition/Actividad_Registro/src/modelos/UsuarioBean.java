package modelos;

import java.io.Serializable;

/**
 * Modela un usuario registrado
 * 
 * @author Jose
 *
 */
public class UsuarioBean implements Serializable{
	public static final long serialVersionUID=1L; // Numero de version del objeto. Necesario si implementa Serializable.
	
	/**
	 * Nombre de usuario con el que hace login
	 */
	private String nombre;
	
	/**
	 * Edad del usuario
	 */
	private int edad;
	
	/**
	 * 
	 * @param nombre Nombre del usuario con el que hace login
	 * @param edad Edad del usuario
	 */
	public UsuarioBean(String nombre,int edad){
		this.nombre=nombre;
		this.edad=edad;
	}
	
	/**
	 * Constructor vacio para que funcione como bean
	 */
	public UsuarioBean(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
}

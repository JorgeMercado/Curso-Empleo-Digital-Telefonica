package modelo;
/**
 * @author Mario
 * 
 * Personas de la aplicacion Agenda
 */
public class Persona {
	
	private String nombre;
	private String number;
	
	public Persona(String nombre, String number){
		this.nombre = nombre;
		this.number = number;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getNumber() {
		return number;
	}
	
}

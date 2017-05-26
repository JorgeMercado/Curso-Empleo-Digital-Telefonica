package modelos;


/**
 * Usuario del diario
 * @author Jose
 *
 */
public class Usuario {

	/**
	 * Nombre de login de usuario
	 */
	private String nombre;
	
	public Usuario(String nombre){
		this.nombre=nombre;
	}
	
	public Usuario(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

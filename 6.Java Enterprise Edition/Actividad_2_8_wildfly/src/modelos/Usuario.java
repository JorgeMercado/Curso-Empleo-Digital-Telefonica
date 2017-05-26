package modelos;


/**
 * 
 * @author Jose
 *
 * Un usuario de la aplicacion
 */
public class Usuario {

	/**
	 * Identificador del usuario
	 */
	private String id;
	
	/**
	 * 
	 * @param id Identificador del usuario
	 */
	public Usuario(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}
	
	
}

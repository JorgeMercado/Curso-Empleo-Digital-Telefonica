package modelos;


/**
 * 
 * Bean peticion de soporte
 * 
 * @author Jose
 *
 */
public class PeticionSoporteBean {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Email del que hace la peticion
	 */
	private String email;
	/**
	 * Sistema operativo del equipo
	 */
	private String so;
	/**
	 * Software para el que se hace la peticion
	 */
	private String sw;
	/**
	 * Problema informadp
	 */
	private String problema;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getSw() {
		return sw;
	}

	public void setSw(String sw) {
		this.sw = sw;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

}

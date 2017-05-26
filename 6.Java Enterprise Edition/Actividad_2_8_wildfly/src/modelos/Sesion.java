package modelos;


/**
 * 
 * @author Jose
 *
 * Representa una sesion
 */
public class Sesion {

	/**
	 * Identificador de la sesion. Coincide con el identificdor del objeto Session
	 */
	private String id;
	
	/**
	 * Numero de accesos a la sesion
	 */
	private int n;
	
	/**
	 * 
	 * @param id identificador de la sesion
	 */
	public Sesion(String id){
		this.id=id;
		n=0;
	}
	
	public Sesion(String id,int n){
		this.id=id;
		this.n=n;
	}

	public String getId() {
		return id;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	@Override
	public String toString(){
		return "Sesion: "+id;
	}
	
	
}

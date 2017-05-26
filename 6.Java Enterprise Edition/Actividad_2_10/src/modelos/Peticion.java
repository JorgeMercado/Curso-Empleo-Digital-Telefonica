package modelos;

import java.io.Serializable;

/**
 * 
 * @author Jose
 *
 * Representa uns peticion de una pagina
 *
 */
public class Peticion implements Serializable{

	public static final int id=1;
	
	/**
	 * Numero de peticiones
	 */
	private int n;
	
	/**
	 * Inicializa n a 0
	 */
	public Peticion(){
		this.n=0;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}

package modelos;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Objeto DTO que adem�s "escucha" cuando se le vincula a una sesion y mantiene una cuenta 
 * de usuarios vinculados a una sesion. El numero de usuarios vinculados a una sesion
 * ser� el mismo que los que se han logado co �xito, de eso se encarga el servlet Index.
 * @author Jose
 *
 */
public class Usuario implements HttpSessionBindingListener {
	private static int numeroLogados=0;
	
	/**
	 * Nombre del usuario
	 */
	private String nombre;

	/**
	 * 
	 * @param nombre Nombre del usurio
	 */
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

	/**
	 * Se incrementa la cuenta de usuarios vinculados a una sesion
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		incLogados(1);
	}

	/**
	 * Se decrementala cuenta de usuarios logados a una sesi�n.
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		incLogados(-1);
	}
	
	/**
	 * Metodo thread-safe que incrementa/decrementa la cuenta de usuarios vinculados a una sesion
	 * @param n
	 */
	public synchronized void incLogados(int n){
		numeroLogados+=n;
	}
	
	/**
	 * Devuelve el n�mero de usuarios vinculados a una sesion. 
	 * No es necesario que sea "sinchronized" porque la lectura del int es at�mica.
	 * 
	 * @return Numero de usuarios vinculados a una sesion.
	 */
	public static int getNumeroLogados(){
		
		return numeroLogados;
	}
	
	
	
}

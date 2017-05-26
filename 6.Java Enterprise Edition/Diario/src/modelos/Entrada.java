package modelos;

import java.util.Date;

/**
 * Entrada del diario
 * @author Jose
 *
 */
public class Entrada {

	/**
	 * Identificador
	 */
	private int id;
	
	/**
	 * Usuario propietario de la entrada
	 */
	private Usuario usuario;
	
	
	/**
	 * Texto de la entrada
	 */
	private String texto;
	
	/**
	 * fecha en que se publicó la entrada
	 */
	private Date fecha;
	
	
	public Entrada(int id,Usuario usuario,String texto,Date fecha){
		this.id=id;
		this.usuario=usuario;
		this.texto=texto;
		this.fecha=fecha;
	}
	
	public Entrada(Usuario usuario,String texto){
		this.id=-1;
		this.usuario=usuario;
		this.texto=texto;
		this.fecha=null;
	}
	
	public Entrada(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}

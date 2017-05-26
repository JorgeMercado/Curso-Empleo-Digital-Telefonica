package modelo;

import java.util.Date;

public class Diario extends Usuario {
	//Datos o propiedades
	private int id;
	private Date fecha;
	private String comentario;
	
	//Constructores
	public Diario (){
		
	}
	
	public Diario (int id, String nombreUsuario, Date fecha,String comentario){
		super(nombreUsuario);
		this.id= id;
		this.fecha= fecha;
		this.comentario= comentario;
	}

	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}

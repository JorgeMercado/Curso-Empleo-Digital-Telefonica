package modelo;

public class Usuario {
	//Datos o propiedades
	private String nombreUsuario;
	
	//Constructores
	public Usuario(){
		
	}
	public Usuario(String nombreUsuario){
		this.nombreUsuario=nombreUsuario;
	}
	
	//Getters y setters
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}

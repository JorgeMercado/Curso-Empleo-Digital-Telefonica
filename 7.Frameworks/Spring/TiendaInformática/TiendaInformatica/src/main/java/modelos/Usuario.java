package modelos;

public class Usuario {
	//DATOS O PROPIEDADES
	private String nombre;
	
	//CONSTRUCTORES
	//constructor vacio
	public Usuario(){
		
	}
	//constructor con parametros
	public Usuario(String nombre){
		this.nombre= nombre;
	}
	
	//METODOS
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

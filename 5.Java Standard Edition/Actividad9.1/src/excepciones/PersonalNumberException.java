package excepciones;

public class PersonalNumberException extends Exception {
	//Datos,propieedades
	private static final long serialVersionUID = 1L;//Al crear da un problema, se añade add default serial version
	private String comentario;
	
	//Constructores
	public PersonalNumberException(String comentario){
		this.comentario = comentario;
	}
	
	//Metodos
	@Override
	public String toString(){
		return comentario +" "+ super.toString();
	}
}

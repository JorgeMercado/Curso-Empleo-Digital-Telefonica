package modelos;

public class Sesion {
	
	//Datos o propiedades
	private int n;
	private String id;

	//Contstructores
	public Sesion(String id){
		this.id=id;
	}
	public Sesion(String id,int n){
		this.id=id;
		this.n=n;
	}

	//Getters y setters
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Sesion [id=" + id + "]";
	}
	
}

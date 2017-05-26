package modelo;

public class Avion {
	//Datos o propiedades
	private int idAvion;
	private String descripcion;
	private double peso;
	
	//Constructores
	//Constructor tres parametros
	public Avion(int idAvion,String descripcion,double peso){
		this.idAvion = idAvion;
		this.descripcion = descripcion;
		this.peso=peso;
	}
	//Constructor con dos parametros
	public Avion(String descripcion,double peso){
		this.descripcion = descripcion;
		this.peso=peso;
	}

	//Getters y setters
	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	//ToString
	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", descripcion=" + descripcion + ", peso=" + peso + "]";
	}
	
}

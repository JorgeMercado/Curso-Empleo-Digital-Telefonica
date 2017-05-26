package modelo;

import java.util.Date;

public class Coche {
	//DATOS O PROPIEDADES
	private String matricula;
	private String modelo;
	private Date fechamatriculacion;
	private int km;
	private double precio;
	
	//CONSTRUCTORES
	//vacio
	public Coche(){
		
	}
	
	//con parametros
	public Coche(String matricula,String modelo,Date fechamatriculacion,int km, double precio){
		this.matricula= matricula;
		this.modelo= modelo;
		this.fechamatriculacion= fechamatriculacion;
		this.km= km;
		this.precio = precio;
	}


	//METODOS
	//getters y setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getFechamatriculacion() {
		return fechamatriculacion;
	}

	public void setFechamatriculacion(Date fechamatriculacion) {
		this.fechamatriculacion = fechamatriculacion;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}

package modelos;

public class Pajaro {
	//Datos o propiedades
	private int id;
	public enum Superorden{
		PALEOGNATA,IMPENNES,NEOGNATA;
	}
	private Superorden superorden;
	private String familia;
	private String especie;
	private int numero;
	
	//Constructores
	//Constructor vacio
	public Pajaro(){
		
	}
	//Con parametros
	public Pajaro(int id,Superorden superorden, String familia,String especie, int numero){
		this.id = id;
		this.superorden= superorden;
		this.familia= familia;
		this.especie= especie;
		this.numero = numero;
	}
	public Pajaro(Superorden superorden, String familia,String especie, int numero){
		this.superorden= superorden;
		this.familia= familia;
		this.especie= especie;
		this.numero = numero;
	}
	//Metodos
	public String getSOString(){
		return superorden.toString();		
	}
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Superorden getSuperorden() {
		return superorden;
	}
	public void setSuperorden(Superorden superorden) {
		this.superorden = superorden;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}

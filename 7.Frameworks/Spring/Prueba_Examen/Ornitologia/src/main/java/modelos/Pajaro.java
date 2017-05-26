package modelos;

public class Pajaro {
	//Enumeracion de SuperOrden 
	public enum SO{
		PALEOGNATA, IMPENNES, NEOGNATA
	}
	
	
	
	//Propiedades
	private int id;
	private String especie;
	private String familia;
	private SO superorden;
	
	public Pajaro(){}
	public Pajaro(int id, String especie, String familia, SO superorden){
		this.id = id;
		this.especie = especie;
		this.familia = familia;
		this.superorden = superorden;
	}
	public Pajaro(String especie, String familia, SO superorden){
		this.especie = especie;
		this.familia = familia;
		this.superorden = superorden;
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public String getEspecie() {
		return especie;
	}
	public String getFamilia() {
		return familia;
	}
	public SO getSuperorden() {
		return superorden;
	}
	public String getSuperordenString(){
		return superorden.toString();
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public void setSuperorden(SO superorden) {
		this.superorden = superorden;
	}
	
	

}

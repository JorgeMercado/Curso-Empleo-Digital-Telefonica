package modelos;

import java.util.Date;

public class Equipo {
	//DATOS O PROPIEDADES
	public enum Tipo{
		ORDENADOR, MONITOR,IMPRESORA
	}
	private int id;
	private Tipo tipo;
	private String modelo;
	private String ubicacion;
	private Date fechaInstalacion;
	
	//CONSTRUCTORES
	//constructor vacio
	public Equipo(){
		
	}
	//construcor vacio
	public Equipo(Tipo tipo,String modelo,String ubicacion,Date fechaInstalacion){
		this.tipo= tipo;
		this.modelo= modelo;
		this.ubicacion=ubicacion;
		this.fechaInstalacion=fechaInstalacion;
	}
	
	//METODOS
	public String getTipoString(){
		String tipoString = "";
		
		if(tipo.name().equals("ORDENADOR")){
			tipoString = "ordenador";
		}
		if(tipo.name().equals("MONITOR")){
			tipoString = "monitor";			
		}
		if(tipo.name().equals("IMPRESORA")){
			tipoString = "impresora";			
		}
		
		return tipoString;
	}
	//Getters y setters
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
	

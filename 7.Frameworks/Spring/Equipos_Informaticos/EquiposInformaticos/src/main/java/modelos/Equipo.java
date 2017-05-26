package modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Equipo {
	
	public enum Tipo{
		ORDENADOR, MONITOR, IMPRESORA;
		
		@Override
		public String toString(){
			String r="";
					
			switch(this){
			case ORDENADOR: r="Ordenador"; break;
			case IMPRESORA: r="Impresora"; break;
			case MONITOR: r="Monitor"; break;
			}
			return r;
		}
	}
	private int id;
	private Tipo tipo;
	private String modelo;
	private String ubicacion;
	
	//@DateTimeFormat(iso = ISO.DATE)
	private Date fecha;
	
	public Equipo(){}
	public Equipo(Tipo tipo, String modelo, String ubicacion, Date fecha){
		this.tipo = tipo;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
		this.fecha = fecha;	
	}
	public Equipo(int id, Tipo tipo, String modelo, String ubicacion, Date fecha){
		this.id = id;
		this.tipo = tipo;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
		this.fecha = fecha;		
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getTipoString(){
		String tipoString = null;
		if(tipo.name().equals("ORDENADOR")){
			tipoString = "Ordenador";
		}else if(tipo.name().equals("MONITOR")){
			tipoString = "Monitor";
		}else if(tipo.name().equals("IMPRESORA")){
			tipoString = "Impresora";
		}
		return tipoString;
	}
}

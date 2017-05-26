package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name ="numero")
@SessionScoped
public class Numero {
	//Datos o propiedades 
	private int paridad;
	
	//Constructores
	//Vacio
	public Numero(){
		
	}
	//Con parametros
	public Numero(int paridad){
		this.paridad = paridad;
	}
	
	//Metodos
	//getters y setters
	public int getParidad() {
		return paridad;
	}
	public void setParidad(int paridad) {
		this.paridad = paridad;
	}
	
	//Comprobar que es par
	public String comprobarParidad(){
		if (paridad % 2 == 0){
			return "par";
		}
		else{
			return "impar";
		}
	}
}

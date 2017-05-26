package modelos;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import utilidades.BundleUtils;
import utilidades.EnumUtils;

@ManagedBean(name = "usuario")
@SessionScoped
public class UsuarioBean {

	
	
	public enum Comida{
		CARNES,PESCADOS,LEGUMBRES,CEREALES;
		
		@Override
		public String toString(){
			return BundleUtils.get("msjs",this.name());
		}
	}
	
	public enum Aficion{
		LECTURA,CINE,DEPORTE;
		
		@Override
		public String toString(){
			return BundleUtils.get("msjs",this.name());
		}
	}
	
	
	private String nombre;
	private String password;
	private ArrayList<Comida> comida;
	private ArrayList<Aficion> aficiones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nuevoValor) {
		nombre = nuevoValor;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String nuevoValor) {
		password = nuevoValor;
	}

	
	
	public ArrayList<Comida> getComida() {
		return comida;
	}

	public void setComida(ArrayList<Comida> comida) {
		this.comida = comida;
	}

	public ArrayList<SelectItem> getComidaItems(){
		return EnumUtils.getSelectItems(Comida.values(), "msjs");
	}
	
	
	
	public ArrayList<Aficion> getAficiones() {
		return aficiones;
	}

	public void setAficiones(ArrayList<Aficion> aficiones) {
		this.aficiones = aficiones;
	}

	public ArrayList<SelectItem> getAficionesItems(){
		return EnumUtils.getSelectItems(Aficion.values(), "msjs");
	}
	
	public String conocerUsuario() {
		if (nombre.equals("Juan")) {
			return "conocido";//outcome
		}
		return "noconocido";
	}

}

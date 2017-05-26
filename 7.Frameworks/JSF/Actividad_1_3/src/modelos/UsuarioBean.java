package modelos;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name = "usuario")
@SessionScoped
public class UsuarioBean {

	public enum Comida{
		CARNES,PESCADOS,LEGUMBRES,CEREALES;
		
		@Override
		public String toString(){
			FacesContext context=FacesContext.getCurrentInstance();
			ResourceBundle bndl=context.getApplication().evaluateExpressionGet(context,"#{msjs}", ResourceBundle.class);
			
			return bndl.getString(this.name());
		}
	}
	
	
	private String nombre;
	private String password;
	private ArrayList<Comida> comida;

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
		FacesContext context=FacesContext.getCurrentInstance();
		ResourceBundle bndl=context.getApplication().evaluateExpressionGet(context,"#{msjs}", ResourceBundle.class);
		
		ArrayList<SelectItem> lista=new ArrayList<SelectItem>();
		
		for(Comida c : Comida.values()){
			lista.add(new SelectItem(c.name(),bndl.getString(c.name())));
		}
		
		
		return lista;
	}
	
	public String conocerUsuario() {
		if (nombre.equals("Juan")) {
			return "holaConocido";
		}
		return "holaNoConocido";
	}

}

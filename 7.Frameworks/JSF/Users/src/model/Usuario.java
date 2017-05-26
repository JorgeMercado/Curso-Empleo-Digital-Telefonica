package model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.DAOUsuario;

@ManagedBean(name="usuario")
@SessionScoped
public class Usuario {
	
	private String dni;
	private String nombre;
	private String password;
	
	public Usuario(){
		
	}
	public Usuario(String dni, String nombre, String password){
		this.dni = dni;
		this.nombre = nombre;
		this.password = password;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String insert(Usuario u){
		
		if(dni.trim().equals("")||nombre.trim().equals("")||password.trim().equals("")){
			dni= "";
			nombre = "";
			password = "";
			return "noCreado.xhtml";
		}
		DAOUsuario dao = new DAOUsuario();
		boolean opcion = dao.create(u);
		dni= "";
		nombre = "";
		password = "";
		if(opcion){
			return "creado.xhtml";
		}else{
			return "noCreado.xhtml";
		}
		
	}
	
	public ArrayList<Usuario> listar(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		DAOUsuario dao = new DAOUsuario();
		lista = dao.lista();
		return lista;
	}
	
	public String delete(Usuario u){
		DAOUsuario dao = new DAOUsuario();
		dao.delete(u);
		return "listado.xhtml";
	}
}

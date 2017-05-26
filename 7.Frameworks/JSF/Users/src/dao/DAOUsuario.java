package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import model.Usuario;


public class DAOUsuario {
	public  DAOUsuario(){}
	
	public boolean create(Usuario u){
		String sql = "INSERT INTO usuarios (dni, nombre, password) VALUES (?,?,?);";
		
		try(Connection con = DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,u.getDni());
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getPassword());
			ps.executeUpdate();
			ps.close();
			return true;
		}catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	public ArrayList<Usuario> lista(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = "select * from usuarios order by nombre";
		
		try(Connection con = DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Usuario u = new Usuario(rs.getString("dni"), rs.getString("nombre"), rs.getString("password"));
				lista.add(u);
			}
			
			rs.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	}
	public void delete(Usuario u){
		String sql = "delete from usuarios where dni = ?";
		try(Connection con = DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getDni());
			ps.executeUpdate();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
}

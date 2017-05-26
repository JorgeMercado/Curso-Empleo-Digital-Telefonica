package dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import modelos.Entrada;
import modelos.Usuario;

public class DAOEntrada {

	/**
	 * Lista las entradas de ese usuario
	 * @param u Usuario del que se quiere recuperar la lista de entradas
	 * @return Listado de las entradas del usuario
	 */
	public ArrayList<Entrada> listar(Usuario u){
		ArrayList<Entrada> lista=new ArrayList<Entrada>();
		
		String sql="select * from diario where usuario=? order by fecha desc";
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1, u.getNombre());
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				java.sql.Date aux=rs.getDate("fecha"); // devuelve java.sql.Date
				java.util.Date d=new java.util.Date(aux.getTime());
				Entrada e=new Entrada(
						rs.getInt("id"),
						u,
						rs.getString("texto"),
						d);
				
				lista.add(e);
			}
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	}
	
	/**
	 * Insertar la entrada
	 * @param e Entrada a insertar
	 * @return
	 */
	public boolean crear(Entrada e){
		boolean r=false;
		
		String sql="insert into diario (usuario,texto,fecha) values (?,?,curdate())";
		try(Connection con=DB.getConexion();
		    PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1, e.getUsuario().getNombre());
			ps.setString(2, e.getTexto());
			
			ps.executeUpdate();
			r=true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return r;
	}
	
	
	/**
	 * Borrar entrada
	 * @param id identificador de la entrada a borrar
	 * @return true si se ha borrado y false si no
	 */
	public boolean borrar(int id){
		boolean r=false;
		
		String sql="delete from diario where id=?";
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1,id);
			ps.executeUpdate();
			r=true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return r;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import modelos.Anuncio;

public class DAOAnuncio {

	
	public ArrayList<Anuncio> listar(){
		ArrayList<Anuncio> lista=new ArrayList<Anuncio>();
		
		String sql="select * from anuncios";
		try(Connection con=DB.getConexion();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);){
			
			while(rs.next()){
				Anuncio v=new Anuncio(rs.getInt("id"),rs.getString("texto"));
				lista.add(v);
			}
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Anuncio> buscar(String palabra){
		ArrayList<Anuncio> lista=new ArrayList<Anuncio>();
		
		String sql="select * from anuncios where texto like ?";
		
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,"%"+palabra+"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Anuncio v=new Anuncio(rs.getInt("id"),rs.getString("texto"));
				lista.add(v);
			}
			
			rs.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	
	}
	
	public Anuncio getAnuncio(int id){
		Anuncio v=null;
		
		String sql="select texto from anuncios where id=?";
		
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				v=new Anuncio(id,rs.getString("texto"));
			}
			
			rs.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return v;
	}
}

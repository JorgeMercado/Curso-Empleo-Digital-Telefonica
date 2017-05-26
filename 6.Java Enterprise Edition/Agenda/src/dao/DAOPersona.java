package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import modelo.Persona;

public class DAOPersona {

	public void Create (Persona p) throws SQLException{
		
		String sql = "insert into entradas (nombre, number) values (?,?)";
		
		try(Connection con = DB.getConexion()){
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, p.getNombre());
			stm.setString(2, p.getNumber());
			stm.executeUpdate();
			 
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}



	public ArrayList<Persona> getPersonas(){
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		String sql = "select * from entradas order by nombre"; 
		
		try(Connection con = DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Persona p = new Persona(rs.getString("nombre"), rs.getString("number"));
				personas.add(p);
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return personas;
	}






}

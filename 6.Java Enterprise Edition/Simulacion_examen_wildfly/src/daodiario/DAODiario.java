package daodiario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import modelo.Diario;

public class DAODiario {
	public ArrayList<Diario> listar(String nombre_usuario){
		ArrayList<Diario> entradas = new ArrayList<Diario>();
		
		String sql = "select * from diario where nombre_usuario = ? ";
		
		try(Connection con = DB.getConexion(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, nombre_usuario);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Diario d = new Diario(rs.getInt("id"), nombre_usuario, rs.getDate("fecha"),rs.getString("comentario"));			
				entradas.add(d);
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return entradas;
	}
}

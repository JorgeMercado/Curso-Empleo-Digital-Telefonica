package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import modelos.Usuario;

/**
 * Bean que realiza operaciones CRUD sobre Usuario
 * 
 * @author Jose
 *
 */
public class DAOUsuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lee un usuario de la base de datos
	 * @param nombre del usuario
	 * @param password password del usuario
	 * @return Usuario leido
	 */
	public Usuario leer(String nombre,String password){
		Usuario u=null;
		
		String sql="select nombre from usuarios where nombre=? and password=?";
		try(Connection con=DB.getConexion();
			PreparedStatement pstm=con.prepareStatement(sql)){
			
			pstm.setString(1,nombre);
			pstm.setString(2,password);
			
			ResultSet rs=pstm.executeQuery();
			if(rs.next()){
				u=new Usuario(nombre);
			}
			rs.close();
			
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return u;
	}
}

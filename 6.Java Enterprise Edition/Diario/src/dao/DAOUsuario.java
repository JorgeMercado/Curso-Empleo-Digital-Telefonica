package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import modelos.Usuario;

public class DAOUsuario {

	/**
	 * Autentica un usuari en la base de datos
	 * @param u Usuario que hay que autenticar
	 * @param password Contraseña
	 * @return true si se ha autenticado con exito y false si no
	 */
	public boolean autenticar(Usuario u,String password){
		boolean r=false;
		
		String sql="select nombre from usuarios where nombre=? and password=?";
		try(Connection con=DB.getConexion();
		    PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1, u.getNombre());
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
			r=rs.next();
			
			rs.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return r;
	}
	
	
}

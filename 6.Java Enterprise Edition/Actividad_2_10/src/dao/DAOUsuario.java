package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import modelos.Usuario;


/**
 * 
 * @author Jose
 *
 * Operaciones CRUD y similares para Usuario
 */
public class DAOUsuario {

	public DAOUsuario(){
		
	}
	
	/**
	 * Comprueba si el usuario con esa contraseña existen en la base de datos
	 * @param u Usuario a comprobar
	 * @param password Su contraseña
	 * 
	 * @return Resultado de la operacion . OK= usuario y contraseña correctos, NO_EXISTE= Usuario y/o contraseña incorrectos, ERROR= error en el acceso a la BD
	 */
	public ResultadoCRUD comprobar(Usuario u,String password){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="select id from usuarios where id=? and password=?";
		try(Connection con=DB.getConexion();
		    PreparedStatement stm=con.prepareStatement(sql);){
			
			stm.setString(1,u.getId());
			stm.setString(2,password);
			ResultSet rs=stm.executeQuery();
			
			if(rs.next()){
				r=ResultadoCRUD.OK;
			}
			else{
				r=ResultadoCRUD.NO_EXISTE;
			}
			
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return r;
	}
}

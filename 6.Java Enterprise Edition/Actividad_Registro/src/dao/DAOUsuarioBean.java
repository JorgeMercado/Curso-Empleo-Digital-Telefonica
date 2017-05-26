package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import modelos.UsuarioBean;

/**
 * Clase de acceso a objetos UsuarioBean
 * @author Jose
 *
 */
public class DAOUsuarioBean {

	
	/**
	 * Inserta el usuario en la base de datos.
	 * 
	 * @param u UsuarioBean a insertar
	 * @param password Contraseña que se establece para ese usuario
	 * @return true si se ha insertado (o no porque ya existia) y false si ha fallado la conexion a la base de datos.
	 */
	public ResultadoCRUD create(UsuarioBean u,String password){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="insert ignore into usuarios (nombre,password,edad) values (?,?,?)";
		try(Connection con=DB.getConexion();
		    PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,u.getNombre());
			ps.setString(2, password);
			ps.setInt(3,u.getEdad());
			int n=ps.executeUpdate();
			if(n>0){
				r=ResultadoCRUD.OK;
			}
			else{
				r=ResultadoCRUD.YA_EXISTE;
			}
			
		}
		catch(SQLException sqle){
			System.out.println("Fallo en la conexion a la BD");
		}
		
		return r;
	}
	
	/**
	 * Devuelve una lista con todos los usuarios insertados
	 * 
	 * @return ArrayList conteniendo los UsuarioBean
	 */
	public ArrayList<UsuarioBean> listar(){
		ArrayList<UsuarioBean> r=new ArrayList<UsuarioBean>();
		
		String sql="select nombre,edad from usuarios";
		try(Connection con=DB.getConexion();
			Statement stm=con.createStatement();){
			
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				UsuarioBean u=new UsuarioBean(rs.getString("nombre"),rs.getInt("edad"));
				r.add(u);
			}
			rs.close();
			
		}
		catch(SQLException sqle){
			System.out.println("Fallo en el acceso a BD");
		}
		
		return r;
	}
}

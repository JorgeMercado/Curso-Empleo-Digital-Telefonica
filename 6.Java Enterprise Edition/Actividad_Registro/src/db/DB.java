package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Statement;

/**
 * Mantiene conexiones a la bse de datos
 * @author Jose
 *
 */
public class DB {
	
	/**
	 * Devuelve una conexion a la base de datos
	 * @return Conexion a la base de datos
	 */
	public static Connection getConexion(){
		Connection con=null;
		try {
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/Actividad_Registro_DB");
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		System.out.println(con);
		return con;
		
		
		
	}
	
	/**
	 * Comprueba si se puede acceder a la base de datos
	 * @return true=se puede acceder, false=no se puede acceder
	 */
	public static boolean estaOK(){
		boolean r=false;
		
		String sql="select curdate()";
		try(Connection con=getConexion();
			Statement stm=con.createStatement()){
			
			ResultSet rs=stm.executeQuery(sql);
			r=rs.next();
			rs.close();
			
		}
		catch(SQLException sqle){
			System.out.println("Fallo en la conexion a la base de datos.");
		}
		catch(NullPointerException npe){
			System.out.println("Fallo en la conexion a la base de datos.");
		}
		
		return r;
	}
}

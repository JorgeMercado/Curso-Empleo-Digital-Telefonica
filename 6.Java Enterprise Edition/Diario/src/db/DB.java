package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author Jose
 * 
 * Maneja ls conexiones a la base de datos
 *
 */
public class DB {

	/**
	 * DEvuelve una conexión a la base de datos.
	 * @return Conexion a la base de datos
	 */
	public static Connection getConexion(){
		Connection con=null;
		try {
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/Diario_DB");
			con=dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return con;
		
		
		
	}
}

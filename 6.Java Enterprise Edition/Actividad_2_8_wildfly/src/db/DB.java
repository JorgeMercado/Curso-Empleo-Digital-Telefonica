package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
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
			dataSource = (DataSource)initContext.lookup("MySql");//Aqui le cambiamos el nombre por el del DataSource que hayamos creado en el wildfly
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return con;
		
		
		
		/*Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/actividad_2_8","actividades","zsexdr");
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return con;
		*/
	}
}

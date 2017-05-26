package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {
	public static Connection getConexion(){
		Connection con=null;
		try {
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			dataSource = (DataSource)initContext.lookup("Users");
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

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {
	
	public static Connection getConexion() throws SQLException{
		Connection con = null;
		
		try{
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/Agenda_DB");
			con = dataSource.getConnection();
		}
		catch(NamingException e){
			e.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		
		return con;
	}
}

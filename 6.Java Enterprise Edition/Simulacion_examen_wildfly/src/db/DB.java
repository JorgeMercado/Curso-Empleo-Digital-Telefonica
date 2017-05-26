package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {
	public static Connection getConexion(){
		Connection con =null;
		
		try{
			DataSource dataSource;
			
			Context contextoInicial = new InitialContext();
			//Context envContext = (Context)contextoInicial.lookup("java:/comp/env");
			dataSource = (DataSource)contextoInicial.lookup("libro_diario");
			con=dataSource.getConnection();
			
		}catch(NamingException ne){
			ne.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return con;
	}

}

package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

	private static final String password="Eco_Admin";
	private static final String user="root";
	private static final String url="jdbc:mysql://localhost:3306/cursojdbc";
	private static Connection conexion;
	
	
	
	public static boolean init(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(url,user,password);
			return true;
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver jdbc no encontrado");
			return false;
		}
		catch(SQLException sqle){
			System.out.println("No se puede conectar a la base de datos");
			return false;
		}
		
	}
	
	public static Connection getConexion(){
		return conexion;
	}
	
	public static void cerrar(){
		try{
			conexion.close();
		}
		catch(SQLException sqle){
			
		}
	}
}

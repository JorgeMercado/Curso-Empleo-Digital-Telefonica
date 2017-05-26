package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
private static Connection con;
	
	//ABRIMOS LA CONEXION
	public static void init(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Busca el driver en la biblioteca importada
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aeronaves","root",""); 
			
		}
		catch(ClassNotFoundException cnfe){ //Si hay algun problema con el driver lanzara este objeto de error.
			System.out.println("No se puede conectar con la base de datos. Por favor consulte a su administrador del sistema.");
		}
		catch(SQLException sqle){//Si hay problemas con la base de datos, dara este objeto como error
			System.out.println("Base de datos inexistente o no se puede conectar. Por favor contacte con el administrador de la base de datos.");
		}
	}
	//CERRAMOS LA CONEXION
	public static void close(){
		try{
			con.close();
		}
		catch(SQLException sqle){
			
		}
	}
	public static Connection getConexion(){
		return con;
	}
}

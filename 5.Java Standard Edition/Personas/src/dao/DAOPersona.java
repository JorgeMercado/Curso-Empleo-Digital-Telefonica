package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.Db;
import modelos.Persona;

//LA CLASE DAO ES LA QUE ACCEDE A LOS DATOS
public class DAOPersona {

	//Carga la conexion con la base de datos
	private Connection con=Db.getConexion();
	
	public boolean create(Persona p){
		
		String sql="insert into personas (dni,nombre) values (?,?)";//Se introducen las interrogaciones para evitar aatques de inyeccion de sql
				
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,p.getDni());
			ps.setString(2,p.getNombre());
			ps.executeUpdate();
			ps.close();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		
	}
	
	public Persona read(String dni){
		Persona p=null;
		
		String sql="select nombre from personas where dni=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,dni);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){//Va leyendo las filas de la base de datos y devolviendo TRUE. Cuando no, devulve FALSE y se sale
				p=new Persona(dni,rs.getString("nombre"));
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return p;
	}
	
	public boolean update(Persona p){
		String sql="update personas set"
				+ " nombre=?"
				+ " where dni=?";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,p.getNombre());
			ps.setString(2,p.getDni());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Persona p){
		String sql="delete from personas where dni=?";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,p.getDni());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Persona> listar(){
		ArrayList<Persona> personas=new ArrayList<Persona>();
		
		String sql="select * from personas order by nombre";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Persona p=new Persona(rs.getString("dni"),rs.getString("nombre"));
				personas.add(p);
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return personas;
	}
	
}

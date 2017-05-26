package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.db;
import modelo.Avion;

public class DAOAvion {


	//Carga la conexion con la base de datos
	private Connection con=db.getConexion();
	
	//OPERACIONES CRUD
	//CREAMOS EL AVION
	public boolean create(Avion a){
		
		String sql="insert into avion (idAvion,descripcion,peso) values (?,?,?)";
				
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,a.getIdAvion());
			ps.setString(2,a.getDescripcion());
			ps.setDouble(3,a.getPeso());
			ps.executeUpdate();
			ps.close();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	//BUSCAMOS EL AVION SEGUN LA ID
	public Avion read(int idAvion){
		Avion a=null;
		
		String sql="select descripcion,peso from avion where idAvion=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,idAvion);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){//Va leyendo las filas de la base de datos y devolviendo TRUE. Cuando no, devulve FALSE y se sale
				a=new Avion(idAvion,rs.getString("descripcion"),rs.getDouble("peso"));
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return a;
	}
	
	//BUSCAMOS EL AVION SEGUN LA DESCRIPCION
	public Avion read(String descripcion){
		Avion a=null;
		
		String sql="SELECT * FROM avion WHERE descripcion LIKE ?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			descripcion = "%" + descripcion + "%";
			ps.setString(1,descripcion);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){//Va leyendo las filas de la base de datos y devolviendo TRUE. Cuando no, devulve FALSE y se sale
				a=new Avion(rs.getInt("idavion"),rs.getString("descripcion"),rs.getDouble("peso"));
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return a;
	}
	//MODIFICAMOS EL AVION
	public boolean update(Avion a){
		String sql="update avion set descripcion=?, peso=? where idAvion=?";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,a.getDescripcion());
			ps.setDouble(2,a.getPeso());
			ps.setInt(3,a.getIdAvion());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	//BORRAMOS EL AVION
	public boolean delete(Avion a){
		String sql="delete from avion where idAvion=?";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,a.getIdAvion());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	//LISTAMOS LOS AVIONES
	public ArrayList<Avion> listar(){
		ArrayList<Avion> personas=new ArrayList<Avion>();
		
		String sql="select * from avion order by idAvion";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Avion a=new Avion(rs.getInt("idAvion"),rs.getString("descripcion"),rs.getDouble("peso"));
				personas.add(a);
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return personas;
	}
}

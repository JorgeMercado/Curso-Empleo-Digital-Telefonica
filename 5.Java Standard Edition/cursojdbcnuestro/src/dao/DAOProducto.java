package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import datos.Db;
import modelo.Producto;

public class DAOProducto {

	Connection con = Db.getConexion();

	public boolean insertar(Producto p) {

		String sql = "insert into producto (nombre,precio) values (?,?)";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Fallo al insertar producto");
			return false;
		}
	}

	public boolean actualizar(Producto p) {
		String sql = "update producto set nombre=? ,precio=? where idproducto=?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.setInt(3, p.getIdproducto());
			ps.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Fallo al insertar producto");
			return false;
		}
	}

	
	public boolean borrar(int idproducto){
    	String sql="delete from producto where idproducto=?";
    	try(PreparedStatement ps=con.prepareStatement(sql)){
    		ps.setInt(1,idproducto);
    		ps.executeUpdate();
    		return true;
    	}
    	catch(SQLException sqle){
    		System.out.println("Fallo al borrar producto");
    		return false;
    	}
    }
	
	public Producto read(int idproducto){
		Producto p=null;
		String sql="select nombre,precio from producto where idproducto=?";
		try(PreparedStatement ps=con.prepareStatement(sql);){
			ps.setInt(1,idproducto);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p=new Producto(idproducto,rs.getString("nombre"),rs.getDouble("precio"));
			}
			rs.close();
		}
		catch(SQLException sqle){
			System.out.println("Fallo al recuperar producto");
		}
		
		return p;
	}
	
	public ArrayList<Producto> listar(){
    	ArrayList<Producto> listado=new ArrayList<Producto>();
    	
    	String sql="select * from producto order by nombre asc";
    	try(PreparedStatement ps=con.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();){
    		
    		while(rs.next()){
    			Producto p=new Producto(rs.getInt("idproducto"),rs.getString("nombre"),rs.getDouble("precio"));
    			listado.add(p);
    		}
    		
    	}
    	catch(SQLException sqle){
    		System.out.println("No se puede leer de la base de datos");
    	}
    	
    	return listado;
    }
	
	
}

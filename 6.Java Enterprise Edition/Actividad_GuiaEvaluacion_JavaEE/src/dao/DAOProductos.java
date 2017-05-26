package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import modelos.Producto;

public class DAOProductos {	
	//LISTAMOS TODOS LOS PRODUCTOS
	public ArrayList<Producto> getTodos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		String sql = "select * from productos";
		
		try(Connection con=DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()){
				Producto p=new Producto(rs.getInt("id_producto"), rs.getString("descripcion"), rs.getDouble("precio"));
				productos.add(p);
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return productos;
	}
	
	//LISTAMOS UN LIBRO
	public Producto getProducto(int idProducto){
		Producto p = null;
		String sql = "Select * from productos where id_producto = ?";
		try(Connection con=DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idProducto);
			ResultSet rs = ps.executeQuery(sql);
			p = new Producto(idProducto,rs.getString("descripcion"),rs.getDouble("precio"));
			rs.next();
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return p;
	}
}

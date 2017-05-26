package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.DB;
import modelo.Libro;

public class DAOLibro {
	//Carga la conexion con la base de datos
	private Connection con=DB.getConexion();
	
	//CREAMOS EL LIBRO
	public boolean create(Libro l){
		
		String sql="insert into libro (isbn,titulo,autor,paginas) values (?,?,?,?)";
				
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,l.getIsbn());
			ps.setString(2,l.getTitulo());
			ps.setString(3,l.getAutor());
			ps.setInt(4,l.getPaginas());
			ps.executeUpdate();
			ps.close();
			return true;
		}
		catch(SQLException sqle){
			return false;
		}
	}
	//ELIMINAMOS EL LIBRO
	public int delete(Libro l){
		String sql="delete from libro where isbn=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,l.getIsbn());
			int c = ps.executeUpdate();
			if (c==0) {
				return 0;
			}else{
				return 1;
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return 2;
		}	
	}
	//BUSCAMOS EL LIBRO SEGUN El TÍTULO O PARTE DE ÉL
		public ArrayList<Libro> read(String titulo){
			ArrayList<Libro> libros=new ArrayList<Libro>();
			String sql="select * from libro where titulo like ?";
			try{
				PreparedStatement ps=con.prepareStatement(sql);
				titulo = "%" + titulo + "%";
				ps.setString(1,titulo);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					Libro l=new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("paginas"));
					libros.add(l);
				}
				rs.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
			return libros;
		}
	//LISTAMOS LOS LIBROS
	public ArrayList<Libro> listar(){
		ArrayList<Libro> libros=new ArrayList<Libro>();
		
		String sql="select * from libro order by isbn";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Libro l=new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("paginas"));
				libros.add(l);
			}
			rs.close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return libros;
	}
}

package dao;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DB;
import modelos.Peticion;

public class DAOPeticion {
	//Instera una peticion en la BD o actualiza el numero de accesos si ya existe
	//Metodo update
	public ResultadoCRUD update(Peticion p){
		ResultadoCRUD r = ResultadoCRUD.ERROR;
		
		String sql = "insert into peticiones (id,n) values ("+Peticion.id+",1)" + "on duplicate key update n=n+1";
		try(Connection con=DB.getConexion(); Statement stm=con.createStatement();){
			r=read(p);
		}	
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return r;
	}
	//Lee de la BD la peticion cuyo id tiene p y rellena su cuenta con el dato obtenido de la BD
	
	//Metodo read
	public ResultadoCRUD read (Peticion p){
		ResultadoCRUD r = ResultadoCRUD.ERROR;
		
		String sql ="select n from peticiones where id="+Peticion.id;
		try(Connection con = DB.getConexion(); Statement stm = con.createStatement();){
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()){
				p.setN(rs.getInt("n"));
			}
			rs.close();
			r=ResultadoCRUD.OK;
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return r;
	}
}

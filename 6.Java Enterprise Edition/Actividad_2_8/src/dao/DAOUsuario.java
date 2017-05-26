package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import modelos.Usuarios;

public class DAOUsuario {
	//Metodo comprobar
	public ResultadoCRUD comprobar (Usuarios u,String password){
		ResultadoCRUD r = ResultadoCRUD.ERROR;
		
		String sql ="select id from usuarios where id=? and passwor=?";
		try(Connection con = DB.getConexion(); PreparedStatement stm = con.prepareStatement(sql);){
			
			stm.setString(1, u.getId());
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			
			if (rs.next()){
				r=ResultadoCRUD.OK;
			}
			else{
				r=ResultadoCRUD.NO_EXISTE;
			}
			rs.close();
		}
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return r;
	}
}

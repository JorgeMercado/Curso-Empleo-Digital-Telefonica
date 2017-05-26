package dao;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import modelos.PeticionSoporteBean;


/**
 * Bean que proporciona operaciones CRUD y similares para PeticionSoporteBean
 * @author Jose
 *
 */
public class DAOPeticionSoporteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea en la base de datos la peticion de soporte
	 * @param p Peticion de soporte
	 * @return Resultado de la operacion
	 */
	public ResultadoCRUD create(PeticionSoporteBean p){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
		
		String sql="insert into peticiones_soporte (email,so,sw,problema)"
				+ "values (?,?,?,?)";
		try(Connection con=DB.getConexion();
		    PreparedStatement pstm=con.prepareStatement(sql);){
			
			pstm.setString(1,p.getEmail());
			pstm.setString(2,p.getSo());
			pstm.setString(3,p.getSw());
			pstm.setString(4, p.getProblema());
			pstm.executeUpdate();
			r=ResultadoCRUD.OK;
		}
		catch(SQLException sqle){
			
		}
		return r;
	}
	
}

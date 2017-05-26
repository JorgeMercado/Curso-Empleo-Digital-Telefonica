package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Usuario;

public class DAOUsuario {

	class RowMapperUsuario implements RowMapper<Usuario>{	
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
			Usuario usuario = new Usuario(rs.getString("nombre"));
			return usuario;
		}
	}
	
	//Datos publicos
	private DataSource dataSource;
	
	//Metodos
	//getters y setters
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//Login
	public boolean login(Usuario u, String contraseña){
		Usuario usuario = null;
		JdbcTemplate jdbc = new JdbcTemplate();
		
		try{
			usuario = jdbc.queryForObject("select nombre from usuarios where nombre = ? and contraseña = ?", new Object[]{u.getNombre(), contraseña},new RowMapperUsuario());
			return true;
		}catch(DataAccessException dae){
			dae.printStackTrace();
			return false;
		}
	}
}

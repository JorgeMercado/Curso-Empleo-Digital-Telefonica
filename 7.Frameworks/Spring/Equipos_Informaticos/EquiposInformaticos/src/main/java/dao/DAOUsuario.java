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
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public boolean login(Usuario u, String pass){
		String sql = "select nombre from usuarios where nombre = ? and password = ?";
		Usuario us = null;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		try{
			us = jdbc.queryForObject(sql, new Object[]{u.getNombre(), pass}, new RowMapperUsuario());
			return true;
		}catch(DataAccessException dae){
			dae.printStackTrace();
			return false;
		}

	}

}

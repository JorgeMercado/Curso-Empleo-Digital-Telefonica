package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelo.Coche;

public class DAOCocheImp implements DAOCoche  {
	
	//DATASOURCE
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	//MAPEO DEL OBJETO COCHE QUE RECOGE EN LA BASE DE DATOS
	class CocheRowMapper implements RowMapper<Coche>{
		public Coche mapRow(ResultSet rs, int numRow) throws SQLException{
			Coche c = new Coche(
					rs.getString("matricula"),
					rs.getString("modelo"),
					rs.getDate("fechamatriculacion"),
					rs.getInt("km"),
					rs.getDouble("precio")
					);
			return c;
		}	
	}
	
	//METODOS
	//crear coche
	public boolean create(Coche c) {
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		boolean result = false;
		
		String sql = "insert into coches (matricula, modelo, fechamatriculacion, km, precio)"
				+ "values (?,?,?,?,?)";
		
		try{
			jdbc.update(sql, new Object[]{c.getMatricula(),c.getModelo(),c.getFechamatriculacion(),c.getKm(),c.getPrecio()});
			result = true;
		}catch(DataAccessException dae){
			dae.printStackTrace();
		}
		return result;
	}
	
	//listar coches
	public List<Coche> listar() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		List<Coche> lista;
		String sql = "select * from coches";
		
		lista = jdbc.query(sql, new CocheRowMapper());		
		
		return lista;
	}

	public boolean update(Coche c) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		boolean result = false;
		String sql = "update coches set "
				+"modelo = ?,"
				+"fechamatriculacion = ?,"
				+"km = ?,"
				+"precio = ? "
				+"where matricula = ?";
		
		try{
			jdbc.update(sql,new Object[]{c.getModelo(),c.getFechamatriculacion(),c.getKm(),c.getPrecio(),c.getMatricula()});
			result = true;
		}catch(DataAccessException dae){
			dae.printStackTrace();
		}
		return result;
	}

	
}

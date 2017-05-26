package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import modelos.Pajaro;
import modelos.Pajaro.SO;

@Service
public class DAOPajaroImpl implements DAOPajaro {
	
	//DataSource
	private DataSource dataSource;
	
	public DataSource getDataSource(){
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	
	//Mapeo del Objeto Pajaro recogido de la base de datos.
	class PajaroRowMapper implements RowMapper<Pajaro>{
		public Pajaro mapRow(ResultSet rs, int numRow) throws SQLException{
			SO superorden = null;
			if(rs.getInt("superorden") == 0){
				superorden = SO.PALEOGNATA;
			}else if(rs.getInt("superorden") == 1){
				superorden = SO.IMPENNES;
			}else if(rs.getInt("superorden") == 2){
				superorden = SO.NEOGNATA;
			}
			
			Pajaro p = new Pajaro(
					rs.getInt("id"),
					rs.getString("especie"),
					rs.getString("familia"),
					superorden
					);
			return p;
		}
	}
	
	
	
	public boolean create(Pajaro p){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		boolean result = false;
		
		String sql = "insert into pajaros (especie, familia, superorden)"
				+ "values (?,?,?)";
		
		int so;
		if (p.getSuperorden() == SO.PALEOGNATA){
			so = 0;
		}else if(p.getSuperorden() == SO.IMPENNES){
			so = 1;
		}else{so = 2;}
		
		try{
			jdbc.update(sql, new Object[]{p.getEspecie(), p.getFamilia(), so});
			result = true;
		}catch(DataAccessException dae){
			dae.printStackTrace();
		}
		return result;
	}
	
	public Pajaro read(int id){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		Pajaro p = null;
		
		String sql = "select * from pajaros where id = ?";
		
		try{
			p = jdbc.queryForObject(sql, new Object[]{id}, new PajaroRowMapper());
		}catch(IncorrectResultSizeDataAccessException ics){
			ics.printStackTrace();
		}
		return p;
	}
	
	public boolean update(Pajaro p){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		boolean result = false;
		
		String sql = "update pajaros set "
				+ "especie = ?,"
				+ "familia = ?,"
				+ "superorden = ? "
				+ "where id = ?";
		
		int so;
		if (p.getSuperorden() == SO.PALEOGNATA){
			so = 0;
		}else if(p.getSuperorden() == SO.IMPENNES){
			so = 1;
		}else{so = 2;}
		
		
		try{
			int n = jdbc.update(sql,
					new Object[]{
							p.getEspecie(),
							p.getFamilia(),
							so, p.getId()});
			result = n>0;
		}catch(DataAccessException dae){
			dae.printStackTrace();
		}
		return result;
	}

	public boolean delete(int id) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		boolean result = false;
		String sql = "delete from pajaros where id = ?";
		int n = jdbc.update(sql, new Object[]{id});
		result = n>0;
		return result;
	}

	public List<Pajaro> listar() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		List <Pajaro> lista;
		String sql = "select * from pajaros";
		lista = jdbc.query(sql, new PajaroRowMapper()); 
		return lista;
	}

}

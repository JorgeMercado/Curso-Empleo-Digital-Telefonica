package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Pajaro;
import modelos.Pajaro.Superorden;

public class DAOPajaroImp implements DAOPajaro {
	
	//Creamos la tipica clase rowmapper a usar en todo el dao
	class RowMapperPajaro implements RowMapper<Pajaro>{
		public Pajaro mapRow(ResultSet rs, int rowNum) throws SQLException{
			int SOInt = rs.getInt("superorden");
			Superorden superorden = null;
			if (SOInt == 0){
				superorden = Superorden.PALEOGNATA;
			}else if (SOInt == 1){
				superorden = Superorden.IMPENNES;
			}else if (SOInt == 2){
				superorden = Superorden.NEOGNATA;
			}
			Pajaro pajaro = new Pajaro(rs.getInt("id"),superorden,rs.getString("familia"), rs.getString("especie"), rs.getInt("numero"));
			return pajaro;
		}
	}
	
	//Creamos la conexion con la base de datos
	private DataSource dataSource;

	//Getters y setters
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	//CRUD
	//Create
	public boolean create (Pajaro p){
		//Creamos la conexion con la bbdd
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		//Creamos el pajaro
		String sql = "insert into pajaros (superorden,familia,especie,numero) values (?,?,?,?)";
		int i = jdbc.update(sql, new Object[]{p.getSOString(),p.getFamilia(),p.getEspecie(),p.getId()});
		
		return i>0;
	}
	
	//Read
	public Pajaro read(int id) {
		String sql = "select * from pajaros where id = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		Pajaro p = jdbc.queryForObject(sql, new Object[]{id}, new RowMapperPajaro());
		
		return p;
	}
	
	//Update
	public boolean update(Pajaro p) {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String sql = "update pajaros set superorden = ?, familia = ?, especie = ?, numero = ? where equipos.id = ?";
		
		int i = jdbc.update(sql, new Object[]{p.getSOString(),p.getFamilia(),p.getEspecie(),p.getNumero(),p.getId()});
		
		return i>0;
	}
	
	//Delete
	public boolean delete(int id) {
		JdbcTemplate jdbc = new JdbcTemplate (dataSource);
		String sql = "delete from pajaros where pajaros.id=?";
		
		int i = jdbc.update(sql, new Object[]{id});
		
		return i>0;
	}
	
	//Listar
	public List<Pajaro> listar() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		List<Pajaro> lista = null;
		
		lista = jdbc.query("select * from pajaros", new RowMapperPajaro());
		return lista;
	}

	
	
}

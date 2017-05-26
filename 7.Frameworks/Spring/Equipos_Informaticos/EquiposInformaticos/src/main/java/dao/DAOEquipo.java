package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Equipo;
import modelos.Equipo.Tipo;

public class DAOEquipo {
	
	class RowMapperEquipo implements RowMapper<Equipo>{
		public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException{
			String tipoS = rs.getString("tipo");
			Tipo tipo = null;
			if (tipoS.equals("ordenador")||tipoS.equals("Ordenador")){
				tipo = Tipo.ORDENADOR;
			}else if(tipoS.equals("monitor")||tipoS.equals("Monitor")){
				tipo = Tipo.MONITOR;
			}else if(tipoS.equals("impresora")||tipoS.equals("Impresora")){
				tipo = Tipo.IMPRESORA;
			}
			Equipo equipo = new Equipo(rs.getInt("id"),tipo, rs.getString("modelo"), rs.getString("ubicacion"), rs.getDate("fecha"));
			return equipo;
		}
	}
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public boolean create(Equipo e){
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		String sql = "insert into equipos (tipo, modelo, ubicacion, fecha) values (?,?,?,?)";
		int i = jdbc.update(sql,
				new Object[]{e.getTipoString(), e.getModelo(), e.getUbicacion(), e.getFecha()});
		if (i == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<Equipo> listar(){
		List<Equipo> lista = null;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		lista = jdbc.query("select * from equipos", new RowMapperEquipo());
		return lista;
	}
	
	public boolean update(Equipo e){
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String sql = "update equipos set tipo = ?, modelo = ?, ubicacion = ?, fecha = ? where equipos.id = ?";
		int i = jdbc.update(sql, new Object[]{e.getTipoString(), e.getModelo(), e.getUbicacion(), e.getFecha(), e.getId()});
		if (i == 0){
			return false;
		}else{return true;}
		
	}
	
	public boolean delete(int id){
		String sql = "delete from equipos where equipos.id = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		int i = jdbc.update(sql, new Object[]{id});
		if (i == 0){
			return false;
		}else{return true;}
	}
	
	public Equipo read(int id){
		String sql= "select * from equipos where id = ?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		Equipo e = jdbc.queryForObject(sql, new Object[]{id}, new RowMapperEquipo());
		
		return e;
	}
	
	
}

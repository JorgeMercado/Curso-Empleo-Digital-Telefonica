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
	
	//Como vamos a implemetar rowmapper varias veces lo declaramos como clase publica y nos lo ahorramos en las siguientes
		//Le decimos mediante el mapeo que fila de cada tabla es cual en nuestra base de datos
		class RowMapperEquipo implements RowMapper<Equipo>{
			public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException{
				String tipoS = rs.getString("tipo");
				Tipo tipo = null;
				if(tipoS.equals("ordenador")){
					tipo = Tipo.ORDENADOR;
				}
				else if(tipoS.equals("monitor")){
					tipo = Tipo.MONITOR;			
				}
				else if(tipoS.equals("impresora")){
					tipo  = Tipo.IMPRESORA;			
				}
				Equipo equipo = new Equipo(tipo,rs.getString("modelo"),rs.getString("ubicacion"),rs.getDate("fechainstalacion"));
				return equipo;
			}
		}
	
	//DATOS O PROPIEDADES
	private DataSource dataSource;
	
	//METODOS
	//getters y setters
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//Operaciones CRUD
	//Recuperamos un listado completo
	public List<Equipo> listar(){
		List<Equipo> lista= null;
		JdbcTemplate jdbc = new JdbcTemplate (dataSource);
		
		lista = jdbc.query("select * from equipos",new RowMapperEquipo());
		
		return lista;
	}
	
	//Creamos un equipo nuevo
	public boolean crear(Equipo e){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int i = jdbc.update("insert into equipos (tipo,modelo,ubicacion,fechainstalacion) values (?,?,?,?)",
				new Object[]{e.getTipoString(),e.getModelo(),e.getUbicacion(),e.getFechaInstalacion()});
		
		if (i==0){
			return false;
		}else
		return true;
	}
	
	//Modificamos el equipo
	public boolean modificar(Equipo e){
		JdbcTemplate jdbc = new JdbcTemplate (dataSource);
		
		int i = jdbc.update("update equipos set tipo=?, modelo=?, ubicacion=?, fechainstalacion=?", new Object[]{e.getTipoString(), e.getModelo(), e.getUbicacion(), e.getFechaInstalacion(), e.getId()});
		if (i == 0){
			return false;
		}else{
			return true;
		}
	}
	
	//Eliminamos el equipo 
	public boolean borrar (Equipo e){
		JdbcTemplate jdbc = new JdbcTemplate (dataSource);
		
		int i = jdbc.update("delete * from equipos where id = ?", new Object[]{e.getId()});
		if (i == 0){
			return false;
		}else{
			return true;
		}
	}
}

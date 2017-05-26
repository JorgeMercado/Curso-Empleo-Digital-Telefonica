package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Cliente;

public class DAOCliente {
	//Como vamos a implemetar rowmapper varias veces lo declaramos como clase publica y nos lo ahorramos en las siguientes
	//Le decimos mediante el mapeo que fila de cada tabla es cual en nuestra base de datos
	class RowMapperCliente implements RowMapper<Cliente>{
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException{
			Cliente cliente=new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellidos"));
			return cliente;
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
	
	//OPERACIONES CRUD
	//recuperamos el cliente segun su id
	public Cliente read(int id){
		Cliente c = null;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource); //Te hace la conexion con la bas de datos
		
		c=jdbc.queryForObject(
				"select * from clientes where id=?",
				new Object[]{new Integer(id)},
				new RowMapperCliente());
		return c;
	}
	
	//Recuperamos el listado comppleto de los clientes
	public List <Cliente> listar(){ //JdbcTemplate devuelve un list
		List<Cliente> lista;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		lista = jdbc.query("select * from clientes",new RowMapperCliente());
		
		return lista;
	}
	
	//buscamos clientes por su nombre
	public List<Cliente> buscar (String palabra){
		List<Cliente> lista;
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		String c = "%"+palabra+"%";
		lista = jdbc.query(
				"select * from clientes where nombre like ?",
				new Object[]{c},new RowMapperCliente());
		
		return lista;
	}
	
}

package dao;

import java.util.List;

import modelo.Coche;

public interface DAOCoche {
	
	public boolean create (Coche c);
	public List<Coche> listar();
	public boolean update (Coche c);
	
}

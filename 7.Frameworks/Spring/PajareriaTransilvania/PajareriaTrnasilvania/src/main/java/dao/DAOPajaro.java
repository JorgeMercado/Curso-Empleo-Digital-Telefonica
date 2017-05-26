package dao;

import java.util.List;

import modelos.Pajaro;

public interface DAOPajaro {
	public boolean create(Pajaro p);
	public Pajaro read(int id);
	public boolean update (Pajaro p);
	public boolean delete (int id);
	public List<Pajaro> listar();
	
}

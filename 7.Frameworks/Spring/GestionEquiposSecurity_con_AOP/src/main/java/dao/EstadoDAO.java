package dao;

public class EstadoDAO {

	public enum Estado{
		OK,DOWN
	}
	
	
	
	private Estado estado=Estado.OK;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}

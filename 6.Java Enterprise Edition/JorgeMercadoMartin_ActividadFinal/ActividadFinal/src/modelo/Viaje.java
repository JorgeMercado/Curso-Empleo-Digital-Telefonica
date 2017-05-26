package modelo;


public class Viaje {
	//Datos o propiedades
	private int idViaje;
	private String destino;
	private int duracion;
	private double precio;
	
	//Constructores
	//Constructor vacio
	public Viaje(){
		
	}
	//Constructores con parametros
	public Viaje(String destino,int duracion, double precio){
		this.destino= destino;
		this.duracion= duracion;
		this.precio = precio;
	}
	public Viaje(int idViaje,String destino,int duracion, double precio){
		this.idViaje=idViaje;
		this.destino= destino;
		this.duracion= duracion;
		this.precio = precio;
	}

	//Metodos
	//getters y setters
		public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//EQUALS
	@Override
	public boolean equals(Object o){
		if(o==null ) return false;
		else if(!(o instanceof Viaje))return false;
		else{
			Viaje v=(Viaje)o;
			return v.idViaje==idViaje;
		}
	}
	
}

package general;

public abstract class Inmueble implements ConPropietario {
	//Datos,propiedades
	protected double superficie;
	protected boolean edificable;
	protected String direccion;
	protected String propietario;
	
	//Constructores
	//Constructor vacío
	public Inmueble(){
		
	}
	//Contructor copia
	public Inmueble(Inmueble inm){
		superficie = inm.superficie;
		edificable = inm.edificable;
		direccion = inm.direccion;
	}
	//Constructor con 3 datos
	public Inmueble(double superficie, boolean edificable, String direccion){
		this.superficie = superficie;
		this.edificable = edificable;
		this.direccion = direccion;
	}
	//Constructor con 3 datos y propietario
	public Inmueble(double superficie, boolean edificable, String direccion,String propietario){
		this.superficie = superficie;
		this.edificable = edificable;
		this.direccion = direccion;
		this.propietario = propietario;
	}

	//Getters y setters
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public boolean isEdificable() {
		return edificable;
	}
	public void setEdificable(boolean edificable) {
		this.edificable = edificable;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	//Metodos
	@Override
	public String toString() {
		return	"\nSuperficie: "+superficie+
				"\nEdificable: "+edificable+
				"\nDireccion: "+direccion ;
	}
	
	public abstract double getTipoIva();
	
	public abstract double getPrecio();
	
	public double getPrecioTotal(){
		return getTipoIva()*getPrecio()/100+getPrecio();
	}
	public abstract void setPrecio(double p);
	
}

package general;
import java.text.DecimalFormat;

public class InmuebleEnAlquiler extends Inmueble {
	//datos
	DecimalFormat formato = new DecimalFormat("#.00");//Para que muestre solo dos decimales
	private double precioAlquiler;
	
	//Constructores
	//Constructor vacío
		public InmuebleEnAlquiler(){
			
		}
		//Contructor copia
		public InmuebleEnAlquiler(InmuebleEnAlquiler inm){
			super(inm);
			this.precioAlquiler = inm.precioAlquiler;
		}
		//Constructor con 3 datos
		public InmuebleEnAlquiler(double superficie, boolean edificable, String direccion,double precioAlquiler){
			super(superficie,edificable,direccion);
			this.precioAlquiler = precioAlquiler;
		}
		//Constructor con 3 datos y propietario
		public InmuebleEnAlquiler(double superficie, boolean edificable, String direccion,double precioAlquiler,String propietario){
			super(superficie,edificable,direccion);
			this.precioAlquiler = precioAlquiler;
			this.propietario= propietario;
		}
		
	//Getters y setters
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}	
	
	//Metodos
	//Metodos
	@Override
	public String toString(){
		return "------INMUEBLE ALQUILER------"+"\nPropietario inmueble: "+propietario+super.toString()+
			"\nPrecio de alquiler: "+formato.format(precioAlquiler);
	}
	
	@Override
	public double getTipoIva() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return precioAlquiler;
	}
	
	public void setPrecio(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
}

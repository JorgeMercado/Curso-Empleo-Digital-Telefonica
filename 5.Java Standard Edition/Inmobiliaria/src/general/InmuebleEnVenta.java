package general;
import java.text.DecimalFormat;

public class InmuebleEnVenta extends Inmueble {
	//datos
	DecimalFormat formato = new DecimalFormat("#.00");//Para que muestre solo dos decimales
	private double precioVenta;
	
	//Constructores
	//Constructor vacío
		public InmuebleEnVenta(){
			
		}
		//Contructor copia
		public InmuebleEnVenta(InmuebleEnVenta inm){
			super(inm);
			this.precioVenta = inm.precioVenta;
		}
		//Constructor con 3 datos
		public InmuebleEnVenta(double superficie, boolean edificable, String direccion,double precioVenta){
			super(superficie,edificable,direccion);
			this.precioVenta = precioVenta;
		}
		//Constructor con 3 datos y propietario
		public InmuebleEnVenta(double superficie, boolean edificable, String direccion,double precioVenta,String propietario){
			super(superficie,edificable,direccion);
			this.precioVenta = precioVenta;
			this.propietario = propietario;
		}
		
	//Getters y setters
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	//Metodos
	@Override
	public String toString(){
		return "------INMUEBLE VENTA------"+"\nPropietario inmueble: "+propietario+super.toString()+
			"\nPrecio de venta: "+formato.format(precioVenta);
	}
		
	@Override
	public double getTipoIva() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return precioVenta;
	}
	
	public void setPrecio(double precioVenta) {
		this.precioVenta = precioVenta;
	}
}

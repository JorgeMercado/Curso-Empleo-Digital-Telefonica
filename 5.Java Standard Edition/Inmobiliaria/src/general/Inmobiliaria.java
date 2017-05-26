package general;

public class Inmobiliaria implements ConPropietario {
	
	//Datos propiedades
	private Inmueble array[]= new Inmueble[500];
	private int cont = 0;
	private String propietario;
	
	//Constructores
	public Inmobiliaria(String propietario) {
		super();
		this.propietario = propietario;
	}
	//Getters y setters
	public Inmueble[] getArray() {
		return array;
	}
	public void setArray(Inmueble[] array) {
		this.array = array;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	//Metodos
	//Añadimos un inmueble al aray
	public void add(Inmueble inm){
		array[cont] = inm;
		cont++;
	}
	
	//Buscamos un inmueble en el array de inmuebles
	public Inmueble get(int i){
		return array[i];
	}
	//Devuelve la cantidad de inmuebles de nuestra inmobiliaria
	public int size(){
		return cont;
	}
	@Override
	public String toString(){
		String texto= "Nuestra inmobiliaria tiene "+cont+" inmuebles:\n";
		for (int i = 0; i < cont; i++) {
			texto += array[i].toString()+"\n"+"Propietario inmobiliaria: "+propietario+"\n"; //Para que se refiera a nuestro toString
		}
		return texto;
	}
	
}

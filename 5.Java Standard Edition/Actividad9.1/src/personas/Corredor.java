package personas;

public class Corredor extends Persona {
	//comprobar que accede a los datos de clase persona
	public void prueba(){
		System.out.println(nombre);//Al pasar por encima el raton vemos que accede a persona
	}
	
	//Datos
	private float distancia;
	
	//Constructores
	public Corredor(Persona p,float distancia){
		nombre=p.nombre;
		edad = p.edad;
		sexo = p.sexo;
		dni = p.dni;
		bCasado =p.bCasado;
		this.distancia= distancia;
	}
	public Corredor(String nombre, byte edad, char sexo, String dni, boolean bCasado,float distancia){
		super(nombre, edad,sexo,dni,bCasado);
		this.distancia= distancia;
	}
	
	//Getters y setters
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	//Metodos
	public void pintar(){
		String s = "Corredor"+"\nNombre: "+nombre+"\nEdad: "+edad+"\nSexo: "+sexo+"\nDNI: "+dni+"\nCasado: "+bCasado+"\nDistancia: "+distancia;
		System.out.println("--------------------");
		System.out.println(s);		
		System.out.println("--------------------");

	}
	
}

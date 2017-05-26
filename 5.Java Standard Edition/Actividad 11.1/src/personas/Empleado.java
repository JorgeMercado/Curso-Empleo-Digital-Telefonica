package personas;


public abstract class Empleado extends Persona{
	//Datos
	String idPersonal;
	float sueldo;
	//--------------------------------------------------
	//Construcores
	//constructor vacio
	public Empleado(){
	}
	//Persona persona
	public Empleado (Empleado emp){
		nombre=emp.nombre;
		edad = emp.edad;
		sexo = emp.sexo;
		dni = emp.dni;
		bCasado =emp.bCasado;
		idPersonal = emp.idPersonal;
		sueldo = emp.sueldo;
	}
	//Empleado con los datos de una persona y sus datos de empleado
	public Empleado(Persona p,String idPersonal,float sueldo){
		nombre=p.nombre;
		edad = p.edad;
		sexo = p.sexo;
		dni = p.dni;
		bCasado =p.bCasado;
		this.idPersonal = idPersonal;
		this.sueldo = sueldo;
	}
	//Con un parametro para cada dato heredado de Persona y un parametro para cada
	//dato de la propia clase
	public Empleado(String nombre, byte edad, char sexo, String dni, boolean bCasado,String idPersonal, float sueldo){
		super(nombre, edad, sexo, dni,bCasado);
		this.idPersonal = idPersonal;
		this.sueldo = sueldo;
	}

	//Getters y setters
	public String getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	//---------------------------------------------------
	//Sobreescribir
	@Override
	public String toString() {
		return "Empleado\nidPersonal: " + idPersonal +
				" \nNombre: " + nombre +  
				"\nSueldo: " + sueldo + 
				"\nEdad: " + edad+ 
				"\nSexo: " + sexo + 
				"\nDni: " + dni + 
				"\nbCasado: " + bCasado;
	}
	public void pintar(){
		System.out.println(this);		
		System.out.println("--------------------");

	}
	
	//METODODS 6.3
	public abstract float calcularAntiguedadMensual();
	public abstract float calcularSueldoBrutoMensual();
	public abstract float calcularComplementosMensuales();
	public abstract void incrementoSueldo(float inc);

	
}

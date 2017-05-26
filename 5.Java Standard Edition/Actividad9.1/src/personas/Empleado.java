package personas;

import excepciones.PersonalNumberException;

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
	public Empleado (Empleado emp)throws PersonalNumberException{
		nombre=emp.nombre;
		edad = emp.edad;
		sexo = emp.sexo;
		dni = emp.dni;
		bCasado =emp.bCasado;
		comprobarPersonalId(idPersonal);
		idPersonal = emp.idPersonal;
		sueldo = emp.sueldo;
	}
	//Empleado con los datos de una persona y sus datos de empleado
	public Empleado(Persona p,String idPersonal,float sueldo)throws PersonalNumberException{
		nombre=p.nombre;
		edad = p.edad;
		sexo = p.sexo;
		dni = p.dni;
		bCasado =p.bCasado;
		comprobarPersonalId(idPersonal);
		this.idPersonal = idPersonal;
		this.sueldo = sueldo;
	}
	//Con un parametro para cada dato heredado de Persona y un parametro para cada
	//dato de la propia clase
	public Empleado(String nombre, byte edad, char sexo, String dni, boolean bCasado,String idPersonal, float sueldo) throws PersonalNumberException{
		super(nombre, edad, sexo, dni,bCasado);
		comprobarPersonalId(idPersonal);
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

	//METODOS 9.1
	private void  comprobarPersonalId(String personalId) throws PersonalNumberException{
		boolean lanzar = false;
		String comentario="";
		
		if ((personalId.length())!=8){
			lanzar =true;
		}else{
			for (int i = 0; i < 3; i++) {
				char c = personalId.charAt(i);
				if(c<'A' || c>'Z'){
					lanzar = true;
					comentario="Los 3 primeros caracteres de la id personal no son letras.";
					break;
				}
			}
			if (!lanzar){
				for (int i = 3; i < 8; i++) {
					char c = personalId.charAt(i);
					if(c<'0' || c>'9'){
						lanzar = true;
						comentario="Los 5 ultimos caracteres de la id personal no son numeros.";
						break;
					}
				}
			}
		
		}if(lanzar){
			PersonalNumberException pe=new PersonalNumberException(comentario);
			throw pe;
		}
	}
	
}

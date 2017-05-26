package personas;

public class PruebaPersona {

	public static void main(String[] args) {
		//Creacion objetos
		//Personas
		Persona personaVacia = new Persona();
		Persona persona1 = new Persona("Javier",23,'m',"03930971H",false);
		Persona persona2 = new Persona("Jorge",23,'m',"03930971g",true);
		Persona persona3 = new Persona(persona1);
		//Empleados
		/*Como ahora la clase empleados es abstract no deja crear objetos en ella pero sirve como plantilla 
		Empleado empleadoVacio = new Empleado();
		Empleado empleado1 = new Empleado("Mario",(byte)23,'m',"0393g135g",false,"empl1",1500);
		Empleado empleado2 =new Empleado(persona1,"eouifgwiwi",(float)4.234);
		Empleado empleado3 = new Empleado(empleado2);
		*/
		//Corredores
		Corredor corredor1= new Corredor(persona2,20000);
		
		//Pintar
		personaVacia.pintar();
		persona1.pintar();
		persona2.pintar();
		persona3.pintar();
		/*Lo mismo que arriba. No se pueden objetos en abstract
		empleadoVacio.pintar();
		empleado1.pintar();
		empleado2.pintar();
		empleado3.pintar();
		*/
		corredor1.pintar();


		//Equals
		if(persona1.equals(persona2)){
			System.out.println("Las personas son iguales");
		}else{
			System.out.println("Las personas son distintas");
		}
		
		//Probando el 6.3
		//Queremos hacer los metodos que no estan en empleados pero que son de tecnicos
		//Para eso copiamos las funciones que queremos que nos haga el principal a la 
		//clase empleados, y las llamamos abstract y a su vez, a cada funcion de cada clase
		//tecnicos y empleados la llamamos @override para que sobreescriba la funcion
		
		Empleado empleado4 = new Tecnico("Mario",(byte)23,'m',"0393g135g",false,"empl1",1500,(byte)2,2);
		
		System.out.println(empleado4.calcularSueldoBrutoMensual());		
		
	}

}

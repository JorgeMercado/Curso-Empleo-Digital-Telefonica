package personas;


public class Tecnico extends Empleado {
	//Datos o propiedades
	private float complemento;
	private byte quinquenios;
	
	//Constructores
	public Tecnico(){
		
	}
	public Tecnico(String nombre, byte edad, char sexo, String dni, boolean bCasado,String idPersonal, float sueldo, byte quinquenios, float complemento) {
		super(nombre,edad, sexo,dni,bCasado,idPersonal,sueldo);
		this.complemento = complemento; 
		this.quinquenios = quinquenios;
	}
	
	//metodos
	//
	@Override
	public float calcularAntiguedadMensual(){
		return 0.05f*quinquenios;
	}
	//
	@Override
	public float calcularComplementosMensuales(){
		return 0.01f*getSueldo()*complemento;
	}
	//
	@Override
	public float calcularSueldoBrutoMensual(){
		return getSueldo()+calcularAntiguedadMensual()+calcularComplementosMensuales();
	}
	//
	@Override
	public void incrementoSueldo(float inc){
		float s=getSueldo();
		s=s*inc/100;
		setSueldo(s);
	}
	@Override
	public String toString(){
		return super.toString()+"\nEs un tecnico\n"+ "Su sueldo bruto es: "+ calcularSueldoBrutoMensual();
	}
	@Override
	public void pintar(){
		System.out.println(this);		
		System.out.println("--------------------");

	}
}

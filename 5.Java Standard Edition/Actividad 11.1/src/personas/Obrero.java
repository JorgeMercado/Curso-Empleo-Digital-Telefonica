package personas;


public class Obrero extends Empleado {
	//Datos o propiedades
	private char turno;
	private byte trienio;
	
	//Constructores
	public Obrero(){
		
	}
	public Obrero(String nombre, byte edad, char sexo, String dni, boolean bCasado,String idPersonal, float sueldo,char turno, byte trienio){
		super(nombre,edad, sexo,dni,bCasado,idPersonal,sueldo);
		this.turno = turno;
		this.trienio = trienio;
	}
	
	//metodos
	//
	@Override
	public float calcularAntiguedadMensual(){
		return 0.03f*trienio;
	}
	//
	@Override
	public float calcularComplementosMensuales(){
		float plus;
		switch(turno){
			case 'S' :
				plus=3;
				break;
			case 'M' :
				plus=5;
				break;
			case 'T' :
				plus=10;
				break;
			case 'N' :
				plus=15;
				break;
			default:plus=0;
		}
		return 0.01f*getSueldo()*plus;
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
		return super.toString()+"\nEs un obrero\n"+ "Su sueldo bruto es: "+ calcularSueldoBrutoMensual();
	}
	@Override
	public void pintar(){
		System.out.println(this);		
		System.out.println("--------------------");

	}
}

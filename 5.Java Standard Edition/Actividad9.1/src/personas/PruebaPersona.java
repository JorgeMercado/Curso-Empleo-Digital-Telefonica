package personas;

import excepciones.PersonalNumberException;

public class PruebaPersona {

	public static void main(String[] args) {
		
		//Actividad9.1
		try{
			Empleado empleado4 = new Tecnico("Jorge",(byte)23,'M',"03930971H",true,"abc12345",2,(byte)12,1);
			System.out.println(empleado4);
		}
		catch(PersonalNumberException pe){
			System.out.println(pe);
			System.out.println("saliendo controladamente");
		}
		finally{
			System.out.println("Adios");
		}
	}

}

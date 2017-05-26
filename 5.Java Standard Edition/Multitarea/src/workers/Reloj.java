package workers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


public class Reloj extends Thread {
	private static char siguienteID='A';
	private char id;
	boolean seguir = true;
	
	//CONSTRUCTOR
	//Construcotr vacio con el que vamos asignando una letra nueva por cada reloj nuevo
	public Reloj(){
		id = siguienteID;
		siguienteID++;
	}
	
	public void run(){
		
		//Reloj funciona de forma aleatoria unos segundos y luego para
		Random rnd = new Random();
		int s = rnd.nextInt(15);
		System.out.println("El reloj "+id+" parara despues de "+s+" segundos");
		long t0 = System.currentTimeMillis();
		
		while (seguir){
			/*Date d = new Date(System.currentTimeMillis());
			System.out.println(d+""+d.getTime());*/
		
			GregorianCalendar c = new GregorianCalendar();
			System.out.println("RELOJ "+id+" "+c.get(Calendar.HOUR_OF_DAY)
					+":"+c.get(Calendar.MINUTE)
					+":"+c.get(Calendar.SECOND));
			
			try{
				sleep(1000);
			}
			catch(InterruptedException ie){
				System.out.println("T2¡ME han despertado a malas!");
			}
			
			long t1=System.currentTimeMillis();
			if(t1-t0>=s*1000){
				seguir = false;
			}
		}
	}
	
		public void parar(){
		seguir = false;
	}
}

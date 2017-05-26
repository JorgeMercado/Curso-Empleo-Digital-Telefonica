package tictac;

public class Tic_Tac extends Thread{
	//DATOS O PROPIEDADES
	private static String estado;
	
	//METODOS
	public void tic(boolean andando) {
		if (!andando) {
			estado = "EN TIC";
			notify(); 
			return;
		}
		System.out.print("TIC ");
		estado = "EN TIC"; 
		notify(); 
		try{
			while(!estado.equals("EN TAC"))
				wait(); //esperar a que termine TAC
		}catch(InterruptedException e){
			System.out.println("Subproceso interrumpido");
		}
	}
	public void tac(boolean andando) {
		if (!andando) {
			estado = "EN TAC";
			notify(); //notificar a los subprocesos en espera
			return;
		}
		System.out.print("TAC ");
			estado = "EN TAC"; //establecer el estado actual EN TAC
			notify(); //ejecutar TIC
		try{
		while(!estado.equals("EN TIC"))
			wait(); //esperar a que termine TIC
		}catch(InterruptedException e){
			System.out.println("Subproceso interrumpido");
		}
	}
}

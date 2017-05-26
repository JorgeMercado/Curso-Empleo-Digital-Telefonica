package ui;

import workers.Reloj;
//import workers.T1;
//import workers.T2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*T1 t1 = new T1();
		T2 t2 = new T2();
		
		t1.start();//El start es para que los haga a la vez
		t2.start();*/
		
		Reloj c1 = new Reloj();
		c1.start();
		Reloj c2 = new Reloj();
		c2.start();
		Reloj c3 = new Reloj();
		c3.start();
		
		
		try{
			c1.join();
			c2.join();
			c3.join();
		}
		catch(InterruptedException ie){
			System.out.println("Algo ha pasado y me han desperado sin que se paren los cronometros");
		}
		System.out.println("Los tres relojes han parado");

	}

}

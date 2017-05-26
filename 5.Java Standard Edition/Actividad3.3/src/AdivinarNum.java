

//Esta es la clase que genera números aleatorios.
import java.util.Random;
import java.util.Scanner;

public class AdivinarNum {
	

	//Función que te dice si el número es mayor o menor y que devuelve un boolean.
	//--FUNCIÓN TERMINADA
	static boolean jugarPartida (int menor, int mayor){
		int numeroUsuario = decirNumero(1,100);
		int r = resultadoJugada(aleatorio,numeroUsuario);
		if (r<0){
			System.out.println("El número secreto es mayor");
		}
		else if (r>0){
			System.out.println("El número secreto es menor");
		}else{
			System.out.println("Acertaste");
		}
		return r==0;
	}
	
	//Función generar número --- FUNCIÓN TERMINADA;
	static int generarNumero (int menor, int mayor){
		//Generamos la variable a adivinar.
		int l = mayor-menor+1;
		//Como el ordenador genera pseudo-aleatorios. Para hacer números casi
		//aleatorios usamos la función System.currentTimeMillis();
		Random num = new Random (System.currentTimeMillis());
	    int variableControl = num.nextInt(l);
		
	    return variableControl;
	}
	
	//Función que ide el número.
	static int decirNumero (int menor, int mayor){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		int n = 0;
		do {
			System.out.println("Introduce un número: ");
			n=sc.nextInt();
			sc.nextLine();
			
		} while (n<menor || n>mayor);
		
		return n;
		
		
		/*int variableComparar = 0;
		int cont = 0;
		do {
			do {
				//Pedimos que introduzca un número para compararlo.
				System.out.println("Adivina el número aleatorio:");
				Scanner scan = new Scanner (System.in);
				variableComparar = scan.nextInt();
				//Que me avise si me he pasado del rango.
				
				if ((variableComparar>100)||(variableComparar<1)){
					System.out.println("Introduzca un número que no esté fuera de rango");
				}
			} while ((variableComparar>0)||(variableComparar<101));
			cont++;
			System.out.println("Le quedan "+ (5-cont) + " oportunidades." );
			
			//Le pregunto al usuario si quiere seguir jugando.
			boolean seguir = seguirJugando();
		} while ((seguir == false)||(variableAleatoria == variableComparar)||(cont==5));
		*/
	}
	
	//Función para conocer el resultado de la jugada. -- FUNCIÓN TERMINADA.
	static int resultadoJugada (int  num_oculto, int num_jugada){
		int resultado = 0;
		if (num_oculto>num_jugada){
			resultado = -1;
		} else if (num_jugada>num_oculto){
			resultado = 1;
		}
		return resultado;
		}
	
	//Es una función para ver si quieres seguir jugando -- FUNCIÓN TERMINADA.
	static boolean seguirJugando() {
		/*boolean seguir = false;
		System.out.println("¿Seguir jugando esta partida (S/N)?");
		Scanner scan = new Scanner (System.in);
		
	    Char letra = scan.next().charAt(0);
		
		if ((letra.equals("s"))||(letra.equals("S")){
			seguir = true;
		}*/
		System.out.println("¿Deseas seguir jugando (S=si/otra tecla=no)?");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		String s = "";
		s = sc.nextLine();
		return (s.equals("S")|| s.equals("s"));
	}

	//Creamos una variabe aleatoria estática.
	static int aleatorio;
	
	public static void main(String[] args) {
		
		aleatorio = generarNumero(1,100);
		int  intentosRestantes = 5;
		boolean seguir = true;
		do {
			boolean r=jugarPartida (1,100);
			intentosRestantes--;
			if (r){
				seguir = false;
			}else {
				seguir = seguirJugando();
			}
			System.out.println("Te quedan " + intentosRestantes + "intentos restantes");
		} while (seguir && intentosRestantes>0);
	}

}

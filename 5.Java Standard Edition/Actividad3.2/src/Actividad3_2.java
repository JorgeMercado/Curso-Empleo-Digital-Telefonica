import java.util.Random;

public class Actividad3_2 {

	public static void main(String[] args) {
		Random rnd = new Random();
		
		//Numero aleatorio entre 0(por defecto) y 20
		int a=rnd.nextInt(20);
		int b;
		System.out.println("Generaremos "+a+" numeros aleatorios entre 18 y 65\n"); //"\n" genera salto de linea
		
		for (int i = 0; i < a; i++) {
			b = (rnd.nextInt(47)+18);
			System.out.println(b);
		}
		
		//Probando numeros negativos
		int c=rnd.nextInt(20);
		int d;
		System.out.println("Generaremos "+c+" numeros aleatorios entre -20 y 10\n");
		
		for (int i = 0; i < c; i++) {
			d = (rnd.nextInt(30)-20);
			System.out.println(d);
		}
	}
}

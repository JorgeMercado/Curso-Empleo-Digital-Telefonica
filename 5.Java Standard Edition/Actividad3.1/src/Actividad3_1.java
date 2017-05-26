import java.util.Scanner;
public class Actividad3_1 {

	public static void main(String[] args) {
		/*Cuando hay numeros pares entre los dos numeros la formula es
		Suma = LimMayor + limMenor * (limmayor/2)
		por ejemplo, entre 1 y 4 la suma es 10; suma = (1+4)*(4/2) = 10.
		*
		*
		*1 y 6
		*suma = 1+2+3+4+5+6=21
		*suma = (6+1)*((6+1/2))
		*
		*3 y 8
		*suma = 33
		*suma = NumMayor + numMenor) * (
		*
		*Numeros impares entremedias
		*5 y 11
		*suma = 56
		*suma = (11-5+1) * ((11+5/2) =56
		*
		*1 y 5
		*suma = 1+2+3+4+5=15
		*suma = (5-1+1)*((5+1)/2) =15
		*/
		
		int a,b,NumMayor,NumMenor,suma;
		Scanner entero = new Scanner(System.in);
		System.out.println("Introduzca el primer numero");
		a = entero.nextInt();
		System.out.println("Introduzca el segundo numero");
		b = entero.nextInt();
				
		if (a>b) {
			NumMayor = a;
			NumMenor = b;
		}else{
			NumMayor = b;
			NumMenor = a;
		}
		
		if ((NumMayor - NumMenor) % 2 != 0) {
			suma = ((NumMayor + NumMenor) * ((NumMayor-NumMenor+1)/2));
			System.out.println("La suma de los intermedios pares es "+ suma);

		}
		if ((NumMayor - NumMenor) % 2 == 0) {
			suma = (NumMayor-NumMenor+1) * ((NumMayor+NumMenor)/2);
			System.out.println("La suma de los intermedios impares es "+ suma);
		}

	}

}

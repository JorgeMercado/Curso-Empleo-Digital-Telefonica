import java.util.Scanner;
public class actividad4_3 {

	public static void main(String[] args) {
		char letras[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',	'D', 'X', 'B', 'N', 'J', 'Z', 'S',
				'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

		int Dni = pedirDni();
		System.out.println("La letra de su DNI es "+ letras[Dni]);
		
	}
	
	public static int pedirDni(){
		int Dni;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduzca sus 8 numeros del DNI");
		Dni = scan.nextInt();
		int letraDni= Dni % 23;
		return letraDni;
	}
}

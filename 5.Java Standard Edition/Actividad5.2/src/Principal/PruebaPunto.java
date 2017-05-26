package Principal;
import java.util.Random;

public class PruebaPunto {

	public static void main(String[] args) {
		//Punto con constructor vacio
		Punto p1 = new Punto();
		
		//Punto con dos coordenadas
		Punto p2 = new Punto(3.2,6.8);
		
		//Punto copiado
		Punto p3 = new Punto(p2);
		
		//Pintamos los puntos
		p1.pintar();
		p2.pintar();
		p3.pintar();
		
		//Crear un array....
		Random random = new Random();
		int dimension = random.nextInt(20);
		
		Punto arrayPuntos[]=new Punto[dimension];
		System.out.println();
		
		//Escribe en el array punto cada punto
		for (int i = 0; i < dimension; i++) {
			double x,y;
			x = random.nextDouble()*400;
			y = random.nextDouble()*500;
			arrayPuntos[i] = new Punto(x,y);
		}
		
		//Escribe en el array punto cada punto
		for (Punto p :arrayPuntos){
			p.pintar();			
			System.out.println(p.esValido() ? "Punto valido\n" : "No es valido\n");
		}
	}

}

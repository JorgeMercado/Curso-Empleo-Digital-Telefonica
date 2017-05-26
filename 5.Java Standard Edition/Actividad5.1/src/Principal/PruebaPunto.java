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
		
		for (int i = 0; i < dimension; i++) {
			double x,y;
			x = random.nextDouble()*100;
			y = random.nextDouble()*100;
			arrayPuntos[i] = new Punto(x,y);
			arrayPuntos[i].pintar();
		}
		
	}
}

package Principal;
/**
 * Representa un punto en el plano
 * @author admin
 *
 */
public class Punto {
	//Propiedades
	private double x;
	private double y;	
	//Contador que cuenta las veces que se crea n punto 
	private static int numeroPuntos = 0;
	//Limites de las coordenadas de los puntos
	public static final int MIN_X= 0;
	public static final int MAX_X= 300;
	public static final int MIN_Y= 0;
	public static final int MAX_Y= 300;
	//True si las coordenadas estan en los limites
	private boolean correcto = false;
	
	//Creamos los constructores
	//Constructor vacio
	public Punto(){
		numeroPuntos++;
	}
	//Constructor con dos double
	public Punto(double x, double y){
		this.x=x;//Como los parametros tienen el mismo nombre se 
		this.y=y;//especifica que son las de la instancia.
		numeroPuntos++;
		correcto = esCorrecto();
	}
	//Constructor con un punto existente
	public Punto(Punto p){
		x=p.x;
		y=p.y;
		numeroPuntos++;
		correcto = esCorrecto();
	}
	
	//Metodos
	//Metodo pintar
	public void pintar(){
		System.out.println("("+x+","+y+")"); //(5,3)
	}
	
	//Metodo numero de puntos
	public static int getNumeroPuntos(){
		return numeroPuntos;
	}
	//Metodo que duevuelve si las coordenadas del punto estabn en el rango permitido
	//true = estan, false =no están
	private boolean esCorrecto(){
		return x>= MIN_X && x<=MAX_X && y>=MIN_Y && y<=MAX_Y;
	}
	public boolean esValido(){
		return correcto;
	}
}

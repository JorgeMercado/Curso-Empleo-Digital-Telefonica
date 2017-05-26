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
	
	//Creamos los constructores
	//Constructor vacio
	public Punto(){
		
	}
	//Constructor con dos double
	public Punto(double x, double y){
		this.x=x;//Como los parametros tienen el mismo nombre se 
		this.y=y;//especifica que son las de la instancia.		
	}
	//Constructor con un punto existente
	public Punto(Punto p){
		x=p.x;
		y=p.y;
	}
	
	//Metodos
	//Metodo pintar
	public void pintar(){
		System.out.println("("+x+","+y+")"); //(5,3)
	}
	
}

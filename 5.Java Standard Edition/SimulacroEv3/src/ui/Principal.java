package ui;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOAvion;
import datos.db;
import modelo.Avion;

public class Principal {
		private static Scanner teclado=new Scanner(System.in);			

	public static void main(String[] args) {

			//Inicializamos la base de datos
			db.init();
			
			boolean continuar=true;
			while(continuar){
				imprimirMenu();
				System.out.println("\nIntroduzca la opcion");
				String s=teclado.nextLine();
				s=s.trim(); //Elimina los espacios, tabuladores y saltos de linea al principio y al final de la cadena
				if(s.length()>0){
					char o=s.charAt(0); //Obtiene el primer caracter de la cadena
					switch(o){
					case '1':
						crearAvion();
						break;
					case '2':
						buscarAvion();
						break;
					case '3':
						modificarAvion();
						break;
					case '4':
						borrarAvion();
						break;
					case '5':
						listarAviones()
						;
						break;
					case '6':
						System.out.println("Adios. Gracias por utilizar nuestra aplicación");
						continuar=false;
						db.close();
						break;
					default:
						System.out.println("Introduzca una opcion valida por favor.");
					}
				}
			}
	}
	//CREAMOS EL MENU	
	private static void imprimirMenu(){
		System.out.println("-----MENU-----");
		System.out.println("1.- Crear avion");
		System.out.println("2.- Buscar avion");
		System.out.println("3.- Modificar avion");
		System.out.println("4.- Borrar avion");
		System.out.println("5.- Listar aviones");
		System.out.println("6.- Salir");
	}
	//CR1EAMOS EL AVION
	private static void crearAvion(){
		System.out.print("Introduzca la id del avion: \n");
		int idAvion=teclado.nextInt();
		teclado.nextLine();

		System.out.print("Introduzca la descripcion del avion: \n");
		String descripcion=teclado.nextLine();
		System.out.print("Peso del avion: \n");
		double peso=teclado.nextDouble();
		teclado.nextLine();
		
		Avion a=new Avion(idAvion,descripcion,peso);
		DAOAvion dao=new DAOAvion();
		if(!dao.create(a)){
			System.out.println("Fallo en la insercion. ¿El avion ya está insertado?");
		}
	}
	//BUSCAMOS EL AVION
	private static void buscarAvion(){
		System.out.print("Introduzca el ID del avion a buscar\n");
		int idAvion=teclado.nextInt();
		teclado.nextLine();
		
		DAOAvion dao=new DAOAvion();
		Avion a=dao.read(idAvion);
		if(a!=null){
			System.out.println(a);
		}
		else{
			System.out.println("El id del avion introducido no consta en la base de datos.");
		}
	}
	//BUSCAMOS EL AVION SEGUN LA DESCRIPCION
		private static void buscarAvionDescripcion(){
			System.out.print("Introduzca la descripcion del avion o parte de ella a buscar\n");
			String descripcion=teclado.nextLine();
			
			DAOAvion dao=new DAOAvion();
			Avion a=dao.read(descripcion);
			if(a!=null){
				System.out.println(a);
			}
			else{
				System.out.println("El id del avion introducido no consta en la base de datos.");
			}
		}
	//MODIFICAMOS EL AVION
	private static void modificarAvion(){
		System.out.print("ID a modificar avion:\n");
		int idAvion=teclado.nextInt();
		teclado.nextLine();
		
		System.out.print("Nueva descripcion:\n");
		String descripcion=teclado.nextLine();
		
		System.out.print("Nuevo peso:\n");
		double peso=teclado.nextDouble();
		teclado.nextLine();

		Avion a=new Avion(idAvion,descripcion,peso);
		DAOAvion dao=new DAOAvion();
		if(!dao.update(a)){
			System.out.println("Fallo en la modificacion");
		}
	}
	//BORRAMOS EL AVION
	public static void borrarAvion(){
		System.out.print("ID Avion: \n");
		int idAvion = teclado.nextInt();
		teclado.nextLine();
		
		DAOAvion dao=new DAOAvion();
		Avion a=new Avion(idAvion,"",0);
		if(!dao.delete(a)){
			System.out.println("Fallo al borrar el avion.");
		}
	}
	//LISTAMOS AVIONES
	private static void listarAviones(){
		System.out.println("LISTADO DE AVIONES");
		DAOAvion dao=new DAOAvion();
		ArrayList<Avion> a=dao.listar();
		
		for(Avion p : a){
			System.out.println(p);
		}
	}

}

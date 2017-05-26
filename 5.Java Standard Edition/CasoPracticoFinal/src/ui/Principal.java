package ui;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOLibro;
import datos.DB;
import modelo.Libro;

public class Principal {
	private static Scanner teclado=new Scanner(System.in);			

	public static void main(String[] args) {

			//Inicializamos la base de datos
			DB.init();
			
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
						crearLibro();
						break;
					case '2':
						eliminarLibro();
						break;
					case '3':
						buscarLibroDescripcion();
						break;
					case '4':
						listarLibros()
						;
						break;
					case '5':
						System.out.println("Adios. Gracias por utilizar nuestra aplicación");
						continuar=false;
						DB.close();
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
		System.out.println("1.- Crear libro");
		System.out.println("2.- Eliminar libro");
		System.out.println("3.- Buscar libro por titulo");
		System.out.println("4.- Listar libros");
		System.out.println("5.- Salir");
	}
	//CREAMOS EL LIBRO
	private static void crearLibro(){
		System.out.print("Introduzca la ISBN del libro: \n");
		int isbn=teclado.nextInt();
		teclado.nextLine();

		System.out.print("Introduzca el titulo del libro: \n");
		String titulo=teclado.nextLine();
		
		System.out.print("Introduzca el autor del libro: \n");
		String autor=teclado.nextLine();
		
		System.out.print("Introduzca las paginas del libro: \n");
		int paginas=teclado.nextInt();
		teclado.nextLine();
		
		Libro l=new Libro(isbn,titulo,autor,paginas);
		DAOLibro dao=new DAOLibro();
		if(!dao.create(l)){
			System.out.println("Fallo en la insercion. ¿El Libro ya está insertado?");
		}
	}
	//BORRAMOS EL LIBRO
	public static void eliminarLibro(){
		System.out.print("Introduzca el ISBN del libro a eliminar: \n");
		int isbn = teclado.nextInt();
		teclado.nextLine();
		
		DAOLibro dao=new DAOLibro();
		Libro l=new Libro(isbn,"","",0);
		int a = dao.delete(l);
		if(a == 0){
			System.out.println("No se ha borrado ningun libro");
		}
		if(a == 1){
			System.out.println("Se ha borrado el libro con ISBN: " +isbn);
		}
		if(a == 2){
			System.out.println("Fallo en la base de datos");
		}
	}
	//BUSCAMOS EL LIBRO SEGUN LA DESCRIPCION
		private static void buscarLibroDescripcion(){
			System.out.print("Introduzca titulo del Libro o parte de él a buscar\n");
			String titulo=teclado.nextLine();
			
			DAOLibro dao=new DAOLibro();
			ArrayList<Libro> l=dao.read(titulo);
			if(l!=null){
				for(Libro p : l){
					System.out.println(p);
				}
				
			}
			else{
				System.out.println("El titulo del libro introducido no consta en la base de datos.");
			}
		}
	
	//LISTAMOS LIBROS
	private static void listarLibros(){
		System.out.println("LISTADO DE LIBROS");
		DAOLibro dao=new DAOLibro();
		ArrayList<Libro> l=dao.listar();
		
		for(Libro p : l){
			System.out.println(p);
		}
	}

}
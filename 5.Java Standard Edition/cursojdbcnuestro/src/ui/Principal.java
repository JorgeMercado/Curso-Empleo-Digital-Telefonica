package ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.DAOProducto;
import datos.Db;
import modelo.Producto;

public class Principal {

	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args){
		
		if(Db.init()){
			boolean seguir=true;
			
			while(seguir){
				
				imprimirMenu();
				System.out.println();
				System.out.println("Por favor introduzca la opcion");
				
				String s=sc.nextLine();
				s=s.trim();
				if(s.length()>0){
					char o=s.charAt(0);
					switch(o){
					case '1':
						listarProductos();
						break;
					case '2':
						mostrarProducto();
						break;
						
					case '3':
						modificarProducto();
						break;
						
					case '4':
						borrarProducto();
						break;
					
					case '5':
						insertarProducto();
						break;
					case '6':
						seguir=false;
						Db.cerrar();
	
						break;
					
					}
				}
			}
		}
	}
	
	public static void imprimirMenu(){
		System.out.println("MENU");
		System.out.println();
		System.out.println("1.- Listar productos");
		System.out.println("2.- Mostrar producto");
		System.out.println("3.- Modificar producto");
		System.out.println("4.- Borrar producto");
		System.out.println("5.- Insertar nuevo producto");
		System.out.println("6.- Salir");
		
	}
	
	private static void listarProductos(){
		DAOProducto dao=new DAOProducto();
		ArrayList<Producto> listado=dao.listar();
		
		for(Producto  p : listado){
			System.out.println(p);
		}
		
	}
	
	private static int pedirIdentificador(){
		boolean hecho=false;
		int idproducto=0;
		while(!hecho){
			try{
				System.out.println("Identificador del producto: ");
				idproducto=sc.nextInt();
				sc.nextLine();
				hecho=true;
			}
			catch(InputMismatchException e){ //Excepcion que se produce cuando el usuario no introduce un numero
				System.out.println("Por favor introduce un numero valido");
			}
		}
		return idproducto;
	}
	
	private static void mostrarProducto(){
		
		int idproducto=pedirIdentificador();
		DAOProducto dao=new DAOProducto();
		Producto p=dao.read(idproducto);
		System.out.println(p);
	}
	
	
	private static void modificarProducto(){
		
		int idproducto=pedirIdentificador();
		System.out.println("Nombre del producto: ");
		String nombre=sc.nextLine();
		
		boolean hecho=false;
		double precio=0;
		while(!hecho){
			try{
				System.out.println("Precio del producto: ");
				precio=sc.nextDouble();
				sc.nextLine();
				hecho=true;
			}
			catch(InputMismatchException e){ //Excepcion que se produce cuando el usuario no introduce un numero
				System.out.println("Por favor introduce un numero decimal valido");
			}
		}
		
		Producto p=new Producto(idproducto,nombre,precio);
		DAOProducto dao=new DAOProducto();
		dao.actualizar(p);
		
		
	}
	
	private static void borrarProducto(){
		int idproducto=pedirIdentificador();
		
		DAOProducto dao=new DAOProducto();
		dao.borrar(idproducto);
		
	}
	
	private static void insertarProducto(){
		
		System.out.println("Nombre del producto: ");
		String nombre=sc.nextLine();
		
		boolean hecho=false;
		double precio=0;
		while(!hecho){
			try{
				System.out.println("Precio del producto: ");
				precio=sc.nextDouble();
				sc.nextLine();
				hecho=true;
			}
			catch(InputMismatchException e){ //Excepcion que se produce cuando el usuario no introduce un numero
				System.out.println("Por favor introduce un numero decimal valido");
			}
		}
		
		Producto p=new Producto(-1,nombre,precio);
		DAOProducto dao=new DAOProducto();
		dao.insertar(p);
	}
	
}

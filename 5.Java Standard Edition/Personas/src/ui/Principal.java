package ui;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOPersona;
import datos.Db;
import modelos.Persona;

public class Principal {

	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Inicializamos la base de datos
		Db.init();
		
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
					insertarPersona();
					break;
				case '2':
					buscarPersona();
					break;
				case '3':
					modificarPersona();
					break;
				case '4':
					borrarPersona();
					break;
				case '5':
					listarPersonas();
					break;
				case '6':
					System.out.println("Adios. Gracias por utilizar nuestra aplicación");
					continuar=false;
					Db.close();
					break;
				default:
					System.out.println("Introduzca una opcion valida por favor.");
				}
			}
		}
		
	}
	
	private static void imprimirMenu(){
		System.out.println("MENU");
		System.out.println();
		System.out.println("1.- InsertarPersona");
		System.out.println("2.- BuscarPersona");
		System.out.println("3.- Modificar persona");
		System.out.println("4.- Borrar persona");
		System.out.println("5.- Listar todas las personas");
		System.out.println();
		System.out.println("6.- Salir");
	}
	
	private static void insertarPersona(){
		
		System.out.print("D.N.I.:");
		String dni=teclado.nextLine();
		System.out.print("Nombre:");
		String nombre=teclado.nextLine();
		
		Persona p=new Persona(dni,nombre);
		DAOPersona dao=new DAOPersona();
		if(!dao.create(p)){
			System.out.println("Fallo en la insercion. ¿La persona ya está insertada?");
		}
	}
	
	private static void buscarPersona(){
		System.out.print("D.N.I.:");
		String dni=teclado.nextLine();
		
		DAOPersona dao=new DAOPersona();
		Persona p=dao.read(dni);
		if(p!=null){
			System.out.println(p);
		}
		else{
			System.out.println("El D.N.I. introducido no consta en la base de datos.");
		}
	}

	private static void modificarPersona(){
		System.out.print("D.N.I.:");
		String dni=teclado.nextLine();
		System.out.print("Nuevo nombre:");
		String nombre=teclado.nextLine();
		
		Persona p=new Persona(dni,nombre);
		DAOPersona dao=new DAOPersona();
		if(!dao.update(p)){
			System.out.println("Fallo en la modificacion");
		}
	}
	
	private static void listarPersonas(){
		System.out.println("LISTADO DE TODAS LAS PERSONAS");
		System.out.println();
		DAOPersona dao=new DAOPersona();
		ArrayList<Persona> a=dao.listar();
		
		for(Persona p : a){
			System.out.println(p);
		}
	}
	
	public static void borrarPersona(){
		System.out.print("DNI: ");
		String dni = teclado.nextLine();
		DAOPersona dao=new DAOPersona();
		Persona p=new Persona(dni,null);
		if(!dao.delete(p)){
			System.out.println("Fallo al borrar la persona.");
		}
	}
}

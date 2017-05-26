package com.juan.actividades.programapuntos;

import java.util.Scanner;

import com.juan.actividades.arraypuntos.ArrayPuntos;
import com.juan.actividades.punto.Punto;

public class ProgramaPuntos {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayPuntos almacen = new ArrayPuntos();
		
		boolean seguir = true;
		char opcion = 'X';
		do {
			opcion = pintarMenu();
			if (opcion == 'X')
				seguir = false;
			else {
				switch (opcion) {
				case 'C':
					almacen.crearPunto();
					break;
				case 'B':
					int n=pedirPunto();
					if(n<almacen.getN()){
						Punto p=almacen.buscarPunto(n);
						System.out.println(p);
					}
					else{
						System.out.println("No hay tantos puntos en el almacen.");
					}
					break;
				case 'D':
					almacen.borrarPunto();
					break;
				case 'V':
					almacen.listarPuntos();
					break;
				case 'G':
					almacen.guardarPuntos();
					break;
				case 'L':
					almacen.leerPuntos();
					break;
				}
			}
		} while (seguir);
		System.out.println("======= FIN DE almacen ======");

	}
	
	private static int pedirPunto(){
		int n=0;
		System.out.println("Posicion del punto: ");
		boolean correcto=false;
		do{
			try{
				n=teclado.nextInt();
				teclado.nextLine();
				correcto=true;
			}
			catch(Exception e){
				System.out.println("Formato de numero no valido. Por favor reintente.");
				teclado=new Scanner(System.in);
			}
		}while(!correcto);
		return n;
	}

    public static char pintarMenu() {
	char opcion = 'X';

	boolean erroneo = false;
	do {
		erroneo = false;
		System.out.println("====MENU PUNTOS====");
		System.out.println("C: Crear un punto");
		System.out.println("B: Buscar un punto");
		System.out.println("D: Borrar un punto");
		System.out.println("V: Listar puntos");
		System.out.println("G: Guardar puntos");
		System.out.println("L: Leer puntos");
		System.out.println("X: Salir");
		System.out.println("===================");
		System.out.print("Teclea opcion (C, B, D, V, G, L, X)");
		opcion = teclado.next().charAt(0);
		if (opcion != 'C' && opcion != 'B' && opcion != 'D' && opcion != 'V' && opcion != 'G' && opcion != 'L'
				&& opcion != 'X')
			erroneo = true;

	} while (erroneo);

	return opcion;
}

}

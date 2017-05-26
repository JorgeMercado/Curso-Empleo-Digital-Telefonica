package com.juan.actividades.arraypuntos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

import com.juan.actividades.punto.Punto;

public class ArrayPuntos {

	
	private static Random aleatorio = new Random();
	private final static int CAPACIDAD = 10;

	private int n; // posicion de siguiente punto a insertar

	private Punto[] losPuntos;

	public ArrayPuntos() {
		losPuntos = new Punto[CAPACIDAD];
	}

	public int getN() {
		return n;
	}

	public Punto[] getLosPuntos() {
		return losPuntos;
	}

	

	public void guardarPuntos() {
		File file = new File("puntos.dat"); // Definimos el archivo
		if (file.exists()) // Si el archivo ya existe lo borramos
			file.delete();
		try (RandomAccessFile fichero = new RandomAccessFile(file, "rw");) { // Creacion
																				// del
																				// recurso
			int i = 0;
			fichero.seek(0);
			for (i = 0; i < losPuntos.length; i++) {
				if (losPuntos[i] == null) {
					break;
				}
				fichero.writeDouble(losPuntos[i].getX());
				fichero.writeDouble(losPuntos[i].getY());
			}
			System.out.println("===Guardados " + i + " puntos");
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void leerPuntos() {
		n=0;
		Arrays.fill(losPuntos, null);
		File file = new File("puntos.dat");
		try (RandomAccessFile fichero = new RandomAccessFile(file, "r");) {
			fichero.seek(0);
			while (true) {// Bucle infinito . Se saldrá de él cuando se llegue al final del archivo y en la siguiente línea se produzca una excepcion
				losPuntos[n] = new Punto(fichero.readDouble(), fichero.readDouble());
				n++;
			}
		} catch (IOException ex) {
			System.out.println("===Leídos " + n + " puntos");
		}
	}
	
	public void crearPunto(){
		losPuntos[n]=new Punto(aleatorio.nextDouble()*Punto.MAX_X,aleatorio.nextDouble()*Punto.MAX_Y);
		n++;
	}
	
	public void borrarPunto(){
		losPuntos[n-1]=null;
		n--;
	}
	
	public void listarPuntos(){
		for(int i=0;i<n;i++){
			System.out.println(losPuntos[i]);
		}
	}
	
	public Punto buscarPunto(int n){
		return losPuntos[n];
	}

}

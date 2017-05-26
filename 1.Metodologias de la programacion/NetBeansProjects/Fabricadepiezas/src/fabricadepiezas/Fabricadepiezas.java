/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricadepiezas;

import java.util.Scanner;

class fabricaPiezas {
    //Argumentos
    String arrayPiezas[] = new String [5];
    
    //Metodos
    //Escribimos la pieza en el array de piezas
    public void escribirPiezas(String pieza, int pos){
        arrayPiezas[pos] = pieza;
    }
    
    //Eliminamos pieza 
    public void eliminarPiezas(int buscarpieza, int pos){
        for (int i=buscarpieza-1; i<pos-1; i++){
            arrayPiezas[i] = arrayPiezas[i+1];
        }    
    }
    
    //Mostramos el array de piezas
    public void mostrarPiezas (int pos){
        for (int i=0; i<pos; i++){
            System.out.println("Pieza " + (i+1) + ": " + arrayPiezas[i]);
        }
    }
    
    //Buscamos en el array de piezas
    public void obtenerPieza (int buscarpieza){
        System.out.println("En la posicion " + buscarpieza + " esta : " + arrayPiezas[buscarpieza-1]);
    }
}

public class Fabricadepiezas {

    public static void main(String[] args) {
        int opcion, pos = 0, buscarpieza;
        String pieza;
        
        Scanner scanNum = new Scanner(System.in);
        Scanner scanCar = new Scanner(System.in);
        fabricaPiezas n = new fabricaPiezas();
        
        do{
        
        System.out.println("----MENU----");
        System.out.println("1.Añadir pieza");
        System.out.println("2.Eliminar pieza");
        System.out.println("3.Buscar pieza");
        System.out.println("4.Mostrar piezas");
        System.out.println("5.Salir");
        System.out.println("------------");
        
        System.out.println("Introduzca la opción deseada");
        opcion = scanNum.nextInt();
        
        switch(opcion){
            case 1:
                if (pos == 5){
                    System.out.println("Ha llenado la fabrica de piezas. No puede añadir más");
                    break;
                }
                do{
                System.out.println("Introduzca el nombre de la pieza");
                pieza = scanCar.nextLine();
                n.escribirPiezas(pieza, pos);
                pos ++;
                break;
                }while (pos<6);
            break;
            case 2:
                System.out.println("Introduzca la posición que desea eliminar");
                buscarpieza = scanNum.nextInt();
                if (buscarpieza > pos || buscarpieza < 1){
                do{
                    System.out.println("La posición que desea eliminar es errónea. Introduzca otra posición");
                    buscarpieza = scanNum.nextInt();
                } while (buscarpieza > pos || buscarpieza < 1);
                }
                if (buscarpieza == pos){
                    pos --;
                }
                if (buscarpieza<pos){
                    n.eliminarPiezas(buscarpieza,pos);                
                    pos--;
                }
            break;
            case 3:
                System.out.println("Introduzca la posición de la que desea saber la pieza");
                buscarpieza = scanNum.nextInt();
                if (buscarpieza > pos || buscarpieza < 1){
                do{
                    System.out.println("La posición que desea buscar es errónea. Introduzca otra posición");
                    buscarpieza = scanNum.nextInt();
                } while (buscarpieza > pos || buscarpieza < 1);
                }
                n.obtenerPieza(buscarpieza);
            break;
            case 4:
                n.mostrarPiezas(pos);
            break;  
        }    
        }while (opcion != 5);  
    } 
}

package algoritmo.pkg12.pkg1.pkg2;

import java.util.Scanner;

public class Algoritmo1212 {


    public static void main(String[] args) {
        System.out.println("----MENU----");
        System.out.println("1.Añadir nota");
        System.out.println("2.Mostrar media");
        System.out.println("3.Total aprobados");
        System.out.println("4.Mostrar notas introducidas");
        System.out.println("5.Salir");
        System.out.println("------------");
        
        System.out.println("Introduzca la opcion deseada");
        Scanner scan = new Scanner (System.in);
        int opcion = scan.nextInt();
         
        while ((opcion > 5) || (opcion < 1)){
            System.out.println("El numero no es valido. Introduzca otro numero");
            opcion = scan.nextInt();
        }
        
        switch (opcion){
            case 1:
                System.out.println("Añada una nota");
            case 2:
                
            case 3:
                
            case 4:
                
                
            case 5:
                    break;
            
        }
              
        
       
    }
    
}

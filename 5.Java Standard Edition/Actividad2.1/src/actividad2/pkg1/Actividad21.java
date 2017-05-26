package actividad2.pkg1;
import java.util.Scanner;

public class Actividad21 {

    public static void main(String[] args) {
        System.out.println("Introduzca el primer entero");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduzca el segundo entero");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Introduzca un numero con decimales");
        Scanner fl = new Scanner(System.in);
        float dec = fl.nextFloat();
        fl.nextLine();
        
        System.out.println("Inttroduzca el primer string");
        Scanner st = new Scanner(System.in);
        String pal1 = st.nextLine();
        System.out.println("Inttroduzca el primer string");
        String pal2 = st.nextLine();
        
        //Muestra la suma
        float suma = n + m + dec;
        System.out.println("La suma de los tres numeros es " + suma);
        
        //Muestra el mayor de los enteros
        if (m>n){
            int mayor = m;
            System.out.println("El numero mayor es " + mayor); 
        }
        if (n>m){
            int mayor = n;
            System.out.println("El numero mayor es " + mayor); 
        }
           
        //Division del float con el resto de los dos enteros
        int resto = m % n;
        System.out.println(resto);
        
        float div = dec  / resto;
        System.out.println("El resultado de la division es " + div);
        
        //Se visualiza la concatenación de las dos cadenas leídas.
        System.out.println("Concatenacion = " + pal1+pal2);

    }
    
}

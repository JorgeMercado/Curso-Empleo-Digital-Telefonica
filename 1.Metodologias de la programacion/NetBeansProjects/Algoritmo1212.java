
package algoritmo.pkg12.pkg1.pkg2;

import java.util.Scanner;

public class Algoritmo1212 {

    public static class agendaNotas{
        //Propiedades
        double numNotas[] = new double[10];
        double media;
        double suma;
        int aprobados;
        
        //Metodos
        public void introducirNotas (double nota, int pos){
            numNotas[pos]= nota;
        }
        public double mediaNotas (){
            for (int i=0; i<10; i++){
                suma = numNotas[i] + suma;
            }
            media = suma / 10;
            return media;
        }
        public int numAprobados(){
            for (int i=0; i<10; i++){
                if (numNotas[i] > 4.99999){
                    aprobados = aprobados + 1;          
                }
            }
            return aprobados;
        }
        public void mostrarNotas(){
            for (int i=0; i<10; i++){
            System.out.println(("Nota " + (i+1) + " " ) + numNotas[i]);
            }
        }
    }
   
    public static void main(String[] args) {
        int pos = 0, opcion;
        double nota;
        Scanner leer = new Scanner (System.in);
        agendaNotas n = new agendaNotas(); //Se crea el objeto n que apunta a nuestra agenda
        
        do {
        System.out.println("----MENU----");
        System.out.println("1.Añadir nota");
        System.out.println("2.Mostrar media");
        System.out.println("3.Total aprobados");
        System.out.println("4.Mostrar notas introducidas");
        System.out.println("5.Salir");
        System.out.println("------------");
        
        System.out.println("Introduzca la opcion deseada");
        opcion = leer.nextInt();        
        switch (opcion){
            case 1:
                do {                
                    if (pos == 10){
                    System.out.println("Ha introducido el maximo numero de notas");
                    break;
                }
                System.out.println("Añada una nota");
                nota = leer.nextDouble();
                    while (nota <0 || nota >10){
                        System.out.println("La nota no es correcta.Introduzca una nota");
                        nota = leer.nextDouble();   
                    }
                    n.introducirNotas(nota,pos);       //Se realiza el primer metodo
                    pos ++;
                }while (pos < 10);
                break;
            case 2: 
                System.out.println("La media de las notas es " + n.mediaNotas());
                break;
            case 3:
                System.out.println("El numero de aprobados es " +n.numAprobados());
                break;
            case 4: 
                n.mostrarNotas();
                break;
        }       
        }while (opcion != 5); 
    }
}
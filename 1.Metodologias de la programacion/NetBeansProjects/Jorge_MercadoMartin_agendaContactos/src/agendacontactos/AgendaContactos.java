
package agendacontactos;

import java.util.Scanner;

class Agenda {
    //Argumentos
    String arrayContactos[] = new String [20];
    
    //Metodos
    //Escribimos el contacto en el array de contactos
    public void escribirContactos(String contacto, int pos){
        arrayContactos[pos] = contacto;
    }
    
    //Eliminamos contacto 
    public void eliminarContactos(int buscarcont, int pos){
        for (int i=buscarcont-1; i<pos-1; i++){
            arrayContactos[i] = arrayContactos[i+1];
        }    
    }
    
     //Buscamos en el array de contactos
    public void obtenerContacto (int buscarcont){
        System.out.println("En la posicion " + buscarcont + " esta el contacto : " + arrayContactos[buscarcont-1]);
    }
    
    //Mostramos el array de contactos
    public void mostrarContactos (int pos){
        for (int i=0; i<pos; i++){
            System.out.println("Contacto " + (i+1) + ": " + arrayContactos[i]);
        }
    }
    
   
}
public class AgendaContactos {


    public static void main(String[] args) {

        int opcion, pos = 0, buscarcont;
        String contacto;
        
        Scanner scanNum = new Scanner(System.in);
        Scanner scanCar = new Scanner(System.in);
        Agenda n = new Agenda();
        
        do{
        
        System.out.println("----MENU----");
        System.out.println("1.Añadir contacto");
        System.out.println("2.Eliminar contacto");
        System.out.println("3.Buscar contacto");
        System.out.println("4.Mostrar contactos");
        System.out.println("5.Salir");
        System.out.println("------------");
        
        System.out.println("Introduzca la opción deseada");
        opcion = scanNum.nextInt();
        
        switch(opcion){
            case 1:
                if (pos == 20){
                    System.out.println("Ha llenado la agenda de contactos. No puede añadir más");
                    break;
                }
                do{
                System.out.println("Introduzca el nombre del contacto");
                contacto = scanCar.nextLine();
                n.escribirContactos(contacto, pos);
                pos ++;
                break;
                }while (pos<21);
            break;
            case 2:
                System.out.println("Introduzca la posición del contacto que desea eliminar");
                buscarcont = scanNum.nextInt();
                if (buscarcont > pos || buscarcont < 1){
                do{
                    System.out.println("La posición que desea eliminar es errónea. Introduzca otra posición");
                    buscarcont = scanNum.nextInt();
                } while (buscarcont > pos || buscarcont < 1);
                }
                if (buscarcont == pos){
                    pos --;
                }
                if (buscarcont<pos){
                    n.eliminarContactos(buscarcont,pos);                
                    pos--;
                }
            break;
            case 3:
                System.out.println("Introduzca la posición del contacto que desea saber");
                buscarcont = scanNum.nextInt();
                if (buscarcont > pos || buscarcont < 1){
                do{
                    System.out.println("La posición que desea buscar es errónea. Introduzca otra posición");
                    buscarcont = scanNum.nextInt();
                } while (buscarcont > pos || buscarcont < 1);
                }
                n.obtenerContacto(buscarcont);
            break;
            case 4:
                n.mostrarContactos(pos);
            break;  
        }    
        }while (opcion != 5);  
    }     
}

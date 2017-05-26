package empresa;

import personas.Empleado;
import personas.Obrero;
import personas.Tecnico;

import java.util.Random;

public class Empresa {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int l = random.nextInt(10);
		System.out.println(l);
		
		Empleado[] empleados= new Empleado[l];
		
		crearEmpleados(empleados);
		visualizarEmpleados(empleados);

	}
	
	public static void crearEmpleados(Empleado[] empleados){
				
		for (int i = 0; i < empleados.length; i++) {
			Random random = new Random();
			int n = random.nextInt(4);
			if (n==3){
				empleados[i]= new Tecnico();
			}
			else{
				empleados[i] = new Obrero();
			}
		}
	}
	public static void visualizarEmpleados(Empleado[] empleados){
		for(Empleado e:empleados){
			e.pintar();
		}
	}
 
}

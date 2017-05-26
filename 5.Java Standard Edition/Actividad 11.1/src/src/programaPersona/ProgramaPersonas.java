package src.programaPersona;

import java.util.ArrayList;
import java.util.Random;

import personas.Obrero;
import personas.Persona;
import personas.Tecnico;

public class ProgramaPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ArrayList<Persona> personas = new ArrayList<Persona>();
			Random random = new Random();
			
			int numeroPersonas = random.nextInt(5)+1;
			
			for (int i=0; i<numeroPersonas;i++){
				
				int n= random.nextInt(4)+1;
				Persona p=null;
				switch(n){
				case 1:
					p=new Persona();
				break;
				case 4:
					p=new Obrero();
				break;
				case 3:
					p=new Tecnico();
				break;
				}
				personas.add(p);
			}
			
		for (Persona q: personas){
			System.out.println(personas);
		}
	}
}
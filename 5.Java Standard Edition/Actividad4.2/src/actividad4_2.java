public class actividad4_2 {

	public static void main(String[] args) {
		int[] numeros;
		numeros = new int[args.length];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i]=Integer.parseInt(args[i]);
		}
		
		int[] comprobar = comprobarNumeros(numeros);
		//Cantidad numeros introducidos
		System.out.println("Hay "+comprobar[0]+" numeros escritos");
		
		//Numeros introducidos
		System.out.println("Los numeros introducidos son: ");
		for(int j:numeros){
			System.out.println(j);
		}
		
		//Numeros repetidos
		System.out.println("Hay "+comprobar[1]+" numeros repetidos");

		
	}
	
	public static int[] comprobarNumeros(int numeros[]){
		int []array;
		array = new int[2];
		int contRepetidos = 0;
		
		//Contamos los numeros introducidos
		int cantidadNumeros = numeros.length;
		array[0]= cantidadNumeros;
		
		//Contamos los repetidos
		for (int i = 0; i < cantidadNumeros; i++) {
			int cont = 0;
			for (int j = 0; j < cantidadNumeros; j++) {
				if (numeros[i] == numeros [j]){
					cont++;
				}			
			}if(cont>1){
				contRepetidos++;	
				}
		}
		array[1] = contRepetidos;
		return array;
	}

}

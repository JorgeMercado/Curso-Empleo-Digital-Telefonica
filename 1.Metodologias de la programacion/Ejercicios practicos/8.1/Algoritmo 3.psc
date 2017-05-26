//Diseñar un algoritmo para la lectura de 20
//números y que nos muestre la media de
//todos los números leídos y cuál ha sido el
//más pequeño

Algoritmo Algoritmo3
	Definir i, j, n, suma, media, nummen Como real
	suma = 0
	nummen = 1000000
	
	Escribir "Escriba la cantidad de numeros a sumar"
	leer n
	
	Para i=1 Hasta n Con Paso 1 Hacer
		Escribir "Escriba el " i " numero"
		leer j
		
		//Otra manera para que el primero sea siempre el menor, es hacer que el primero sea siempre el menor y luego compararlos.
		//No haria falta inicializar numen
		
		//si i == 1
			//nummen = j
		//FinSi
		
		suma = suma + j
		media = suma/n
		si j < nummen
			nummen = j
		FinSi
	Fin Para
	
	Escribir "La media de los numeros sumados es " media
	Escribir "El numero mas pequeño de todos es " nummen
FinAlgoritmo
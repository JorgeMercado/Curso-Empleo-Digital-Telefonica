//Realizar un algoritmo para un programa que lea 10 numeros
//y los guarde en un array. Posteriormente, se pedira otro 
//numero y el programa nos indicara cuantos elementos del 
//array son ese numero

Algoritmo algoritmo1
	definir num, array, dim,i, cont, num1 como entero
	
	Escribir "Escriba la cantidad de numeros"
	leer dim
	dimension array[dim]
	cont = 0
	
	Para i=0 Hasta dim-1 Con Paso 1 Hacer //Siempre empieza en 0 y lo cuenta, con lo cual hay que restar 1 al maximo donde llegue
		Escribir "Escriba el " i+1 " numero"
		leer num
		array[i] = num
	Fin Para
	
	Escribir "introduzca el numero a buscar en el array"
	leer num1
	
	Para i=0 Hasta dim-1 Con Paso 1 Hacer
		si array[i] == num1
			cont = cont + 1	
		FinSi
	Fin Para
	
	Escribir "El numero " num1 " aparece " cont " veces en el array"
FinAlgoritmo
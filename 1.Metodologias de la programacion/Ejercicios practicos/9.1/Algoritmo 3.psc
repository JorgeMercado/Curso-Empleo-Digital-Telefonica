//Tenemos un array de enteros de tama�o
//20. Realizar un algoritmo que vaya leyendo
//n�meros y los guarde en el array, pero si
//la suma de los n�meros le�dos alcanza o
//supera 100, se dejar�n de leer n�meros y
//rellenar� con 0 las posiciones que queden
//libres. 

Algoritmo Algoritmo3
	
	Definir suma, array, dim, num, i como entero
	Escribir "introduzca la dimension del array"
	Leer dim
	Dimension array[dim]
	suma = 0
	
	Para i=0 Hasta dim-1 Con Paso 1 Hacer
		Si suma <= 100 Entonces
			Escribir "introduzca el " i+1 " numero" 
			leer num
			suma = suma + num
			array[i] = num
		Sino
			array[i] = 0
		Fin Si
	Fin para
	
	Para i=0 Hasta dim-1 Con Paso 1 Hacer
		Escribir array[i]
	Fin Para

FinAlgoritmo
//Realizar un algoritmo que lea un número,
//si es positivo, lo guardará en un array, sino
//volverá a leer un nuevo número, así hasta
//conseguir rellenar el array, que tendrá
//5 elementos. Tras rellenar el array, nos
//mostrará su contenido en orden inverso a
//como han sido leídos los números

Algoritmo Algoritmo2
	Definir num, i, dim, array Como Entero
	
	Escribir "Introduzca la dimension del array"
	leer dim	
	dimension array[dim]
	
	Para i=0 Hasta dim-1 Con Paso 1 Hacer //Siempre empieza en 0 y lo cuenta, con lo cual hay que restar 1 al maximo donde llegue
		Escribir "Introduzca un numero"
		leer num
		Mientras num < 0
			Escribir "Vuelva a escribir un numero positivo"
			leer num
		FinMientras
		array[i] = num
	Fin Para
	
	Para i=dim-1 Hasta 0 Con Paso -1 Hacer
		Escribir array[i]
	Fin Para
FinAlgoritmo
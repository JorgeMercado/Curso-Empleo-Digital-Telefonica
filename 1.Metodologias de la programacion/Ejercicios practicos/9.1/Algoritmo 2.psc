//Realizar un algoritmo que lea un n�mero,
//si es positivo, lo guardar� en un array, sino
//volver� a leer un nuevo n�mero, as� hasta
//conseguir rellenar el array, que tendr�
//5 elementos. Tras rellenar el array, nos
//mostrar� su contenido en orden inverso a
//como han sido le�dos los n�meros

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
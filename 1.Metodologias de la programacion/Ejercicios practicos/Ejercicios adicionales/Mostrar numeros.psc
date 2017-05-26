//Hacer un programa que lea numeros uno por uno hasta que el
//usuario decida que no quiera introducir mas.
//A continuacion el programa mostrara el mayor y el menor de los
//leidos

Algoritmo MostrarNumeros
	Definir men, may, n como entero
	Definir q como texto
	may = -100000000
	men = 100000000 
	
	Repetir
		Escribir "Introduzca un numero" 
		leer n
		Si n > may Entonces
			may = n
		Fin Si
		Si n < men Entonces
			men = n
		FinSi
		Escribir "¿desea introducir mas numeros s/n?"
		leer q
	Hasta Que q == "n"
	
	Escribir "El numero mayor de los introducidos es " may
	Escribir "El numero menor de los introducidos es " men
	
FinAlgoritmo
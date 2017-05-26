//Algoritmo 4
//Realizar un algoritmo para un programa que lea numero de muestra. 
//A continucion, leera 20 numeros y nos mostrara la suma de todos los 
//numeroes de este grupo que sean mayores al numero de muestra

Algoritmo Algoritmo4
	Definir n, i , j, num, suma como entero
	suma = 0
	
	Escribir "Introduzca el numero de muestra"
	Leer n
	
	Escribir "Introduzca la cantidad de numeros a introducir"
	Leer j
	Mientras j<= 0 Hacer
		Escribir "Numero no valido. Escriba de nuevo"
		Leer j
	Fin Mientras
	
	Para i=1 Hasta j Con Paso 1 Hacer
		Escribir "Escriba el " i " numero"
		leer num
		
		Si num > n Entonces
			suma = suma + num
		Fin Si
	Fin Para
	
	Escribir "La suma de los numeros mayores al de muestra es " suma
	
FinAlgoritmo
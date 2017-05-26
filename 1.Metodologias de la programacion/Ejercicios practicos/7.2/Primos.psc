//Realiza el algoritmo correspondiente a un programa que lea un número y
//muestre un texto indicando si el número es o no primo

Algoritmo Algoritmo1
	
	Definir n, cont, m Como Entero
	Escribir "Introduzca un número entero"
	Leer n
	cont = 1
	m = 0
	Mientras cont<=n Hacer
		Si n%cont == 0
			m = m + 1
			mostrar "Uno de los divisores del numero es ", cont
		FinSi
		cont = cont + 1
	Fin Mientras
	
	escribir "El numero tiene " m " divisores "
	
	si m = 2
		Escribir "El numero es primo "
	sino 
		Escribir "El numero no es primo "
	FinSi

FinAlgoritmo
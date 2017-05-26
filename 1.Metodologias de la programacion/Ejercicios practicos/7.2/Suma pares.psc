//Diseñar un algoritmo que lea dos números y realice la suma de todos los
//números pares comprendidos entre ambos números.

Algoritmo Algoritmo2
	Definir n, m, suma Como Entero
	Escribir "Introduzca el primer numero"
	Leer n
	Escribir "Introduzca el segundo numero"
	Leer m 
	suma = 0
	si n < m 
		Mientras n <= m Hacer
			si n%2 == 0
				suma = n + suma
				n = n + 2
			sino 
				n = n + 1
			FinSi
		Fin Mientras
		Escribir " El resultado de la suma de los pares es " , suma
	Sino
		Mientras m <= n Hacer
			si m%2 == 0
				suma = m + suma
				m = m + 2
			sino 
				m = m + 1
			FinSi
			Fin Mientras
		Escribir " El resultado de la suma de los pares es " , suma
	FinSi
FinAlgoritmo
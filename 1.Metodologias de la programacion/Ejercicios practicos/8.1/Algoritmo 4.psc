//Realizar un algoritmo para un programa
//que lea 15 números y nos diga cuántos
//de ellos son primos. De cara a la lectura
//de los números, si el número introducido
//es negativo se le deberá volver a pedir de
//nuevo el número hasta que se introduzca
//uno positivo.

Funcion primo = funcprimo ( num )
	Definir cont, m Como Entero
	Definir primo como logico
	cont = 1
	m = 0
	Mientras cont<=num Hacer
		Si num%cont == 0
			m = m + 1
		FinSi
		cont = cont + 1
	Fin Mientras
	si m <= 2
		primo = verdadero
	sino 
		primo = falso
	FinSi
Fin Funcion


Algoritmo Algoritmo4
	Definir j, i, num, count como entero
	definir primo como logico
	Escribir "Escriba la cantidad de numeros"
	leer j
	Mientras n<= 0 Hacer
		Escribir "Numero no valido. Escriba de nuevo"
		Leer n
	Fin Mientras
	count = 0
	
	Para i=1 Hasta j Con Paso 1 Hacer
		Escribir "Escriba el " i " numero"
		leer num
		Mientras num <=0 Hacer
			Escribir "El numero no es valido. Introduzca un numero positivo" 
			leer num
		Fin Mientras
		primo = funcprimo (num)
		si primo == verdadero 
			count = count + 1 
		FinSi
	Fin Para
	
	Escribir "El numero de primos de los numeros introducidos son " count
FinAlgoritmo
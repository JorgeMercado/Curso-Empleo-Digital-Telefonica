//Diseña un algoritmo para la lectura de 20 números 
//y que nos muestre la suma de los pares por un lado 
//y la de los impares por otro.

Algoritmo Algoritmo1
	definir i,j,sumpares,sumimpares,n como enteros
	sumpares = 0
	sumimpares = 0
	
	Escribir "Escriba la cantidad de numeros a sumar"
	leer n
	
	Mientras n<= 0 Hacer
		Escribir "Numero no valido. Escriba de nuevo"
		Leer n
	Fin Mientras
	
	Para i=1 Hasta n Con Paso 1 Hacer
		escribir "Introduzca el " i " numero"
		leer j
		si j%2 == 0
			sumpares = sumpares + j
		Sino
			sumimpares = sumimpares + j
		FinSi
	Fin Para
	
	Escribir "la suma de los pares es " sumpares
	Escribir "la suma de los impares es " sumimpares
FinAlgoritmo
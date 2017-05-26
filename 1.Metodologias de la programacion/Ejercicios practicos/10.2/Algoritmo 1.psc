//Realizar un algoritmo basado en un program que solicite 10 números y los guarde en un array.
//Posteriormente, el programa solicitará otro número y nos indicará:
	//• Cuantos números del array son mayores que el número leído
	//• La suma de todos los números del array que sean menores que el número leído
	//• Los números del array que sean múltiplos del número leído
//Para resolver este ejercicio, utilizaremos programación modular con separación en capas, es decir, el módulo principal
//se encargará de la lectura de datos y presentación de resultados y la realización de los cálculos se harán en procedimientos y/o
//funciones independientes. También vamos a considerar que los arrays disponen de una propiedad llamada length con la que podemos
//conocer el número de elementos que tienen en todo momento, y que se utilizaría: variablearray.length

//Funcion comprobar cuantos mayores
funcion mayores = numerosMayores (array,cant,numComp)
	Definir mayores,i como entero
	mayores = 0
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		si array[i]>numComp
			mayores = mayores + 1
		FinSi
	Fin Para
	
FinFuncion

//Funcion sumar numeros menores
funcion sumaNumMen = sumaNumerosMenores (array, cant, numComp)
	Definir sumaNumMen,i Como Entero
	sumaNumMen = 0
	
	para i=0 Hasta cant-1 Con Paso 1
		si array[i]<numComp
			sumaNumMen = sumaNumMen + array[i]
		FinSi
	FinPara
	
FinFuncion

//Los numeros del array multiplos del leido
Funcion comparar(array, cant, numComp)
	Definir i como entero
	
	para i=0 Hasta cant-1 Con Paso 1
		si array[i]%numComp == 0 
			mostrar array[i] " es multiplo de " numComp
		FinSi
	FinPara
	
FinFuncion


Algoritmo Algoritmo1
	Definir num,array,i,mayores,menores, cant,numComp Como Entero
	
	Escribir "Introduzca la cantidad de numeros"
	Leer cant
	dimension array[cant]
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		Escribir "Introduzca el " i+1  " numero"
		Leer num 
		array[i] = num
	Fin Para
	
	Escribir "Introduzca el numero a comprobar"
	Leer numComp
	
	//Compobamos cuantos numeros del array son mayores
	mayores = numerosMayores (array,cant,numComp)
	Escribir "Hay " mayores " numeros mayores que " numComp
	//La suma de todos los numeros del array menores que el numero leido
	menores = sumaNumerosMenores(array,cant,numComp)
	Escribir "La suma de los numeros menores es " menores
	//Escribimos los multiplos
	comparar(array,cant,numComp)
	
FinAlgoritmo

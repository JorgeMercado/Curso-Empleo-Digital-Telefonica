//Hacer un programa que te lea un texto, cuente las vocales y te mueste la cantidad de vocales

Funcion voc = vocales(text,long) //El text y el long son las variables que la funcion coge de fuera
	definir i, voc como entero
	definir leervoc como texto
	voc = 0
	Para i=0 Hasta long-1 Con Paso 1 Hacer
		leerVoc = SubCadena(text,i,i)
		si leerVoc == "a" o leerVoc== "e" o leerVoc == "i" o leerVoc == "o" o leerVoc == "u" o leerVoc == "A" o leerVoc== "E" o leerVoc == "I" o leerVoc == "O" o leerVoc == "U"
			voc = voc + 1
		FinSi
	Fin Para
Fin Funcion

Algoritmo Leervocales1
	Definir long,numvocales como entero
	Definir text como texto
	
	Escribir "Escriba el texto a leer"
	leer text
	long = longitud(text)
	numvocales = vocales(text,long)
	
	Mostrar "El numero de vocales es " numvocales
FinAlgoritmo
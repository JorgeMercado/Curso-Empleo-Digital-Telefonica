Funcion palabramayor = vocales (text1, text2,long1, long2)
	definir i,j, cont1, cont2 como entero
	definir leerVoc,palabramayor como texto
	
	cont1 = 0
	cont2 = 0
	
	Para i=0 Hasta long1-1 Con Paso 1 Hacer
		leerVoc = SubCadena(text1,i,i)
		si leerVoc == "a" o leerVoc== "e" o leerVoc == "i" o leerVoc == "o" o leerVoc == "u" o leerVoc == "A" o leerVoc== "E" o leerVoc == "I" o leerVoc == "O" o leerVoc == "U"
			cont1 = cont1 + 1
		FinSi
	Fin Para
	Para j=0 Hasta long2-1 Con Paso 1 Hacer
		leerVoc = SubCadena(text2,j,j)
		si leerVoc == "a" o leerVoc== "e" o leerVoc == "i" o leerVoc == "o" o leerVoc == "u" o leerVoc == "A" o leerVoc== "E" o leerVoc == "I" o leerVoc == "O" o leerVoc == "U"
			cont2 = cont2 + 1
		FinSi
	Fin Para
	
	si cont1 > cont2
		palabramayor = text1
	Sino
		palabramayor = text2
	FinSi
Fin Funcion

//Hacer un programa que te lea dos textos, y muestre el que tenga el mayor numero de vocales


Algoritmo TextoMayorNumeroVocales
	Definir numText, long1, long2 Como Entero
	Definir text1,text2, mayorpalabra como texto
	
	Escribir "Escriba el primer texto"
	leer text1
	long1 = longitud(text1)
	Escribir "Escriba el segundo texto"
	leer text2
	long2 = longitud(text2)
	mayorpalabra = vocales(text1,text2,long1,long2)
	
	mostrar "El texto con myor numero de vocales es " mayorpalabra
FinAlgoritmo

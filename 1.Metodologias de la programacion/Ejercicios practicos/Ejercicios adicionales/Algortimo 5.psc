//Algoritmo 5
//Realizar un algoritmo para que un programa que lea un numero 
//y nos indique cantas cifras tiene dicho numero

Algoritmo Algoritmo5
	Definir num, cantNum Como Caracter
	definir longNum, i, cont, count como entero
	definir fallo como logico
	
	Escribir "Introduzca un numero"
	Leer num
	longNum = longitud(num)
	cont = 0
	count = 0
	fallo = falso
	
	Para i=0 Hasta longNum-1 Con Paso 1 Hacer
	cantNum = SubCadena(num,i,i)
		Segun cantNum Hacer
			"1":
				cont = cont + 1
			"2":
				cont = cont + 1
			"3":
				cont = cont + 1
			"4":
				cont = cont + 1
			"5":
				cont = cont + 1
			"6":
				cont = cont + 1
			"7":
				cont = cont + 1
			"8":
				cont = cont + 1
			"9":
				cont = cont + 1
			"0":
				cont = cont + 1
			De Otro Modo:
				fallo = verdadero
				count = count + 1
		Fin Segun
	Fin Para
	
	si fallo == verdadero
		Escribir "Hay algunos caracteres distintos a numeros en el numero, imbecil"
	FinSi
	
	Escribir "La cantidad de numeros es " cont
	Escribir "Hay " count " caracteres que no son numeros"
	
FinAlgoritmo
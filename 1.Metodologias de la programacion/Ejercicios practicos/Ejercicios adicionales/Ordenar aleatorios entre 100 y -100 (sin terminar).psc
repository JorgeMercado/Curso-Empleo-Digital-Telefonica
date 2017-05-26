//Array de 6 numeros aleatorios entre -100 y 100: Ordenarlos teniendo en cuenta
//que los negativos tienen que estar en orden inverso

Algoritmo sin_titulo
	definir num, array,arrayOrdenado, i,j,k,l, absol1, absol2,aux, cont como entero
	dimension array[6]
	dimension arrayOrdenado[6]
	
	//Creamos la aleatoria
	Para i=0 Hasta 5 Con Paso 1 Hacer
		array[i] = aleatorio (-100, 100)
	Fin Para
	
	Para i=0 Hasta 5 Con Paso 1 Hacer
		arrayOrdenado[i] = 0
	Fin Para
	
	//Mostramos el array
	Mostrar array[0] " " array[1] " " array[2] " " array[3] " " array[4] " " array[5]
	
	//Ordenamos los negativos
	cont = 0
	Para j = 0 hasta 5 con paso 1
		Si (array[j] < 0)
			arrayOrdenado[cont] = array[j]
			cont = cont + 1
		FinSi
	FinPara
	
	//Mostramos el array
	Mostrar arrayOrdenado[0] " " arrayOrdenado[1] " " arrayOrdenado[2] " " arrayOrdenado[3] " " arrayOrdenado[4] " " arrayOrdenado[5]
	
	//Ordenamos los positivos
	Para k = 0 hasta 5 con paso 1
		Si (array[k] > 0)
			Hasta Que cont = 1
		FinSi
	FinPara
	
	//Mostramos el array
	Mostrar arrayOrdenado[0] " " arrayOrdenado[1] " " arrayOrdenado[2] " " arrayOrdenado[3] " " arrayOrdenado[4] " " arrayOrdenado[5]
FinAlgoritmo

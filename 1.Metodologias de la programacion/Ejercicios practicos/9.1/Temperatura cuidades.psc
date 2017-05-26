//sacar la temperatura media anual de 7 ciudades
//temperaturas generadas entre 10 y 30

Algoritmo tempciudades
	
	definir array, i, j, cont  como entero
	definir media como real
	dimension array[7,11]
	
	Para i=0 Hasta 6 Con Paso 1 Hacer
		para j=0 Hasta 10 Con paso 1 Hacer
			array[i,j] = aleatorio(10,30)
		FinPara
	Fin Para
	
	Para i=0 Hasta 6 Con Paso 1 Hacer
		cont = 0
		para j=0 Hasta 10 Con paso 1 Hacer
			cont = cont + array[i,j]
		FinPara
		media = cont / 11
		Mostrar "La media de la " i+1 " ciudad es " media
	Fin Para
	
FinAlgoritmo

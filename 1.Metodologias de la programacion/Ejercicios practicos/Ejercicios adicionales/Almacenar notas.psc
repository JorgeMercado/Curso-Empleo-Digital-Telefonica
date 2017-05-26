//Almacenar 10 notas y calcular su media, calcular los suspensos y los aprobados

//Funcion de la media
Funcion med = medianotas(array,cant)
	definir suma,i Como Entero
	definir med Como Real
	suma = 0
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		suma = suma + array[i]
	Fin Para
	
	med = suma/cant 
FinFuncion

//funcion suspensos
Funcion cantSus = notasSusp(array,cant)
	Definir cantSus,i como entero
	cantSus = 0
	
	para i=0 Hasta cant-1 Con Paso 1
		si array[i]<5
			cantSus = cantSus + 1
		fin si
	fin para

FinFuncion

//Funcion aprobados
Funcion cantApr = notasApr(array,cant)
	Definir cantApr,i como entero
	cantApr = 0
	
	para i=0 Hasta cant-1 Con Paso 1
		si array[i]>4
			cantApr = cantApr + 1
		fin si
	fin para

FinFuncion

Algoritmo AlmacenarNotas
	Definir notas,i,nota,array,cant,sus,apr como Entero
	Definir media Como Real
	
	Escribir "Introduzca el numero de notas"
	Leer cant
	Dimension array[cant]
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		Escribir "Escriba la " i+1 " nota"
		Leer nota
		Mientras nota<0 o nota>10 Hacer
			Escribir "Nota no valida. Introduzca una nota entre 0 y 10"
			leer nota
		Fin Mientras
		array[i] = nota 
	Fin Para
	
	//Funcion de la media
	media = medianotas(array,cant)
	Escribir "La media de las notas es " media	
	//Funcion suspensos
	sus = notasSusp (array,cant)
	Escribir "Hay " sus " suspenso/s"
	//Funcion aprobados
	apr = notasApr (array,cant)
	Escribir "Hay " apr " aprobado/s"
	
FinAlgoritmo
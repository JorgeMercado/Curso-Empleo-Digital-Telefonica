Algoritmo Buscaminas
	definir array,array1,h, i ,j,k,l,m,n,ñ, fila, columna, contAgua, contMinas, ContMinasEx Como Entero
	dimension array[3,3]
	dimension array1[3,3]
	contAgua = 0
	contMinas = 0
	contMinasEx = 0
	
	//hacemos la matriz aleatoria con las minas
	Para i=0 Hasta 2 Con Paso 1 Hacer
		Para j=0 Hasta 2 Con Paso 1 Hacer
			array[i,j] = aleatorio (0,1)
		Fin Para
	Fin Para
	
	//hacemos la matriz de 0 en la que vas a escribir
	para h=0 hasta 2 con paso 1 Hacer
		para k = 0 Hasta 2 con paso 1 Hacer
			array1[h,k] = 0
		FinPara
	FinPara

	Para l=0 Hasta 2 Con Paso 1 Hacer
		Para m=0 Hasta 2 Con Paso 1 Hacer
			si array[l,m] == 1
				contMinasEx = contMinasEx + 1
			FinSi
		Fin Para
	Fin Para
	
	Mostrar "BUSCAMINAS"
	Mostrar " " array1[0,0] " " array1[0,1] " " array1[0,2] 
	Mostrar " " array1[1,0] " " array1[1,1] " " array1[1,2] 
	Mostrar " " array1[2,0] " " array1[2,1] " " array1[2,2]
	
	Repetir		
		Escribir "Escriba la fila"
		leer fila
		Escribir "Escriba la columna"
		leer columna
		
		Repetir
			si fila != 1 y fila != 2 y fila != 3
				Escribir "Fila erronea. Vuelva a escribir la fila"
				Leer fila
			FinSi
			Si columna != 1 y columna != 2 y columna != 3
				Escribir "Columna erronea. Vuelva a escribir la columna"
				leer columna
			Fin si
		Hasta Que fila == 1 o fila == 2 o fila == 3 y columna == 1 o columna == 2 o columna == 3
		
		si array[fila-1,columna-1] == 1
			contMinas = 1
			Escribir "Has encontrado una mina. Has perdido "
		Sino
			Escribir "Esta a salvo. Continue buscando"
			contAgua = contAgua + 1
			para n=fila-1 hasta fila-1 con paso 1 Hacer
				para ñ=columna-1 Hasta columna-1 con paso 1 Hacer
					array1[n,ñ] = 2
				FinPara
			FinPara
			
			Mostrar "BUSCAMINAS"
			Mostrar " " array1[0,0] " " array1[0,1] " " array1[0,2] 
			Mostrar " " array1[1,0] " " array1[1,1] " " array1[1,2] 
			Mostrar " " array1[2,0] " " array1[2,1] " " array1[2,2]
		FinSi
		
		si contAgua == 9-contMinasEx
			Escribir "No ha encontrado ninguna mina. Ha ganado"
		FinSi
		
	Hasta Que contAgua==9-contMinasEx o contMinas==1
	
	Mostrar "SOLUCION"
	Mostrar " " array[0,0] " " array[0,1] " " array[0,2] 
	Mostrar " " array[1,0] " " array[1,1] " " array[1,2] 
	Mostrar " " array[2,0] " " array[2,1] " " array[2,2]

	
FinAlgoritmo

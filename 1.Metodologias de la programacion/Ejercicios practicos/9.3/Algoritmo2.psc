Algoritmo prueba
	Definir matrix, array, i , j, k, filas, columnas, aux Como Entero
	filas = 4
	columnas = 6
	
	Dimension matrix[filas, columnas]
	Dimension array[filas*columnas]
	
	//Creación de la matriz con nº aleatorios
	Para i = 0 hasta 3 con paso 1
		para j = 0 hasta 5 con paso 1
			matrix[i, j] = Aleatorio(1,50)
		FinPara
	FinPara
	
	//Conversión matriz a super array
	k = 0 
	para i = 0 hasta filas - 1 con paso 1
		para j = 0 hasta columnas - 1 con paso 1
			array[k] = matrix[i, j]
			k = k + 1
		FinPara
	FinPara
	
	//Ordenación del super array
	Para i = 0 hasta (filas*columnas - 1) con paso 1
		Para k = (i + 1) hasta (filas*columnas - 1) con paso 1
			Si(array[k] < array[i])
				//realización del intercambio
				aux = array[i]
				array[i] = array[k]
				array[k] = aux
			FinSi
		FinPara
	FinPara
	
	//Reconversión de super array a matriz
	k = 0 
	para i = 0 hasta filas - 1 con paso 1
		para j = 0 hasta columnas - 1 con paso 1
			matrix[i,j] = array[k]
			k = k + 1
		FinPara
	FinPara
	
	//Mostramos
	
	Mostrar matrix[0,0] " " matrix[0,1] " " matrix[0,2] " " matrix[0,3] " " matrix[0,4] " " matrix[0,5]
	Mostrar matrix[1,0] " " matrix[1,1] " " matrix[1,2] " " matrix[1,3] " " matrix[1,4] " " matrix[1,5]
	Mostrar matrix[2,0] " " matrix[2,1] " " matrix[2,2] " " matrix[2,3] " " matrix[2,4] " " matrix[2,5]
	Mostrar matrix[3,0] " " matrix[3,1] " " matrix[3,2] " " matrix[3,3] " " matrix[3,4] " " matrix[3,5]
FinAlgoritmo

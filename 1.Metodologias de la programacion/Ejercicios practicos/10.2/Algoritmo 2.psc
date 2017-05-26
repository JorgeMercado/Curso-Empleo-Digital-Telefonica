//Realizar un algoritmo para un programa que solicitará un texto y lo almacenará en un array,
//siempre que el texto no esté repetido, en cuyo caso volverá a solicitar uno nuevo, así hasta
//completar 10 textos. Después, se solicitará la introducción de dos letras y el programa
//nos mostrará, de todos los textos guardados, aquellos cuya primera y última letra coincidan
//con las dos letras leídas, respectivamente. Se pueden utilizar las funciones Longitud y
//ObtenerLetra utilizadas en otros ejercicios.

//Funcion que compara el texto anterior
funcion compara = compararTextos(array,text,cant,pos)
	Definir i Como Entero
	definir compara como logico
	compara = falso
	
	Para i=0 Hasta pos-1 Con Paso 1 Hacer
		si array[i] == text
			compara = verdadero
		FinSi
	Fin Para
	
FinFuncion

//Funcion para buscar segun la letra inicial y final
funcion buscarPalabraSegunLetra (cant,long,array,arrayNum,letraInicial,letraFinal)
	Definir i,cont como entero
	definir leerLetra como texto
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		cont = 0
		leerLetra = subcadena(array[i],0,0)
		si leerLetra == letraInicial
			cont = cont + 1
		FinSi
		leerLetra = subcadena(array[i],arrayNum[i]-1,arrayNum[i]-1)
		si leerLetra == letraFinal
			cont = cont + 1
		FinSi
		si cont == 2
			Escribir array[i] " tiene las misma letras inicial y final " //letraIncial " y final: " letraFinal
		FinSi
	Fin Para
	
FinFuncion

Algoritmo Algoritmo2
	Definir cant,i,pos,arrayNum,long como entero
	Definir text, array,letraInicial,letraFinal como texto
	Definir comp como logico
	
	Escribir "Introduzca el numero de textos a escribir"
	Leer cant
	dimension array[cant]
	dimension arrayNum[cant]
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		pos = i
		Escribir "Introduzca el " i+1 " texto"
		Leer text
		si i > 0
			//Comprobamos en una fucnion si el texto es igual al anterior
			comp = compararTextos(array,text,cant,pos)
			Mientras comp == verdadero Hacer
				Escribir text " esta repetido. Introduzca un nuevo texto"
				leer text
				comp = compararTextos(array,text,cant,pos)
			Fin Mientras 
		FinSi
		array[i] = text
		long = longitud(text)
		arrayNum[i] = long
	Fin Para
	
	//buscamos las palabras que coincidan con las letras inicial y final
	Escribir "introduzca la letra inicial de palabra a buscar"
	leer letraInicial
	Escribir "introduzca la letra final de palabra a buscar"
	leer letraFinal
	buscarPalabraSegunLetra(cant,long,array,arrayNum,letraInicial,letraFinal)
FinAlgoritmo
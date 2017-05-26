//Funcion que cuenta las vocales de cada texto
Funcion voc = vocales (text,long,numText)
	definir i,voc,aux como entero
	definir leervoc como texto
	voc = 0
	//Cuenta las vocales de cada texto
	Para i=0 Hasta long-1 Con Paso 1 Hacer
		leerVoc = SubCadena(text,i,i)
		si leerVoc == "a" o leerVoc== "e" o leerVoc == "i" o leerVoc == "o" o leerVoc == "u" o leerVoc == "A" o leerVoc== "E" o leerVoc == "I" o leerVoc == "O" o leerVoc == "U"
			voc = voc + 1
		FinSi
	Fin Para
Fin Funcion

//Funcion ordena de menor a mayor
Funcion ord = ordenar (array, arraytext,numtext,arrayLong)
	definir j,k,l,m como entero
	definir aux como texto
	Para j = 0 hasta numText-1 con paso 1
		Para k = j+1 hasta numtext-1 con paso 1
			Si(arrayLong[k] < arrayLong[j])
				//realización del intercambio
				aux = arrayText[j]
				arrayText[j] = arrayText[k]
				arrayText[k] = aux
			FinSi
			
		FinPara
	FinPara
	para  l = 0 hasta numText-1 con paso 1
		para  m =l+1 hasta numText-1 con paso 1
			Si(arrayLong[m] = arrayLong[l])
				Si (array[m] > array[l]) 
				aux = arrayText[l]
				arrayText[l] = arrayText[m]
				arrayText[m] = aux
				FinSi
			fin si
		FinPara
	FinPara
	
FinFuncion


Algoritmo OrdenarSegunVocales
	Definir numText,cont, array,arrayLong, i,j,long, voc como entero
	Definir text, arrayText,ord como texto
	
	Escribir "Escriba el numero de textos"
	Leer numText
	
	Dimension array[numText]
	Dimension arrayText[numText]	
	Dimension arrayLong[numText]
	
	Para i=0 Hasta numText-1 Con Paso 1 Hacer
		Escribir "Escriba el " i+1 " texto"
		leer text
		long = longitud(text)
		voc = vocales (text,long,numText)
		array[i] = voc
		arrayText[i] = text
		arrayLong[i] = long
		si i == numText-1 
			ord = ordenar (array, arrayText, numText,arrayLong)
		FinSi
	Fin Para
	
	//Mostramos el array de la cantidad de vocales
	Para j=0 Hasta numText-1 Con Paso 1 Hacer
		Mostrar arrayText[j]
	Fin Para
	
FinAlgoritmo
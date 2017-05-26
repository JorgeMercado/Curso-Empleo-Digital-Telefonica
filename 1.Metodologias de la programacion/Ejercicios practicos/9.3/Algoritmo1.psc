Algoritmo Algoritmo1
	definir array,dim,i,j,k,l,longText,cant,aux, cont Como Entero
	Definir text, arrayText, auxText,leerLetra como texto
	
	Escribir "Escriba la cantidad de textos a leer"
	Leer cant
	dimension array[cant]
	dimension arrayText[cant]
	
	Para i=0 Hasta cant-1 Con Paso 1 Hacer
		Escribir "Escriba el " i+1 " texto"
		Leer text
		longText = longitud(text)
		array[i] = longText
		arrayText[i] = text
	Fin Para

	
	Para j=0 Hasta cant-1 con paso 1 Hacer
		Para k=j+1 Hasta cant -1 con paso 1 Hacer
			Si array[k] < array[j]
				aux = array[j]
				array[j] = array[k]
				array[k] = aux
				
				auxText = arrayText[j]
				arrayText[j] = arrayText[k]
				arrayText[k] = auxText
			fin si
			Si	array[k] = array[j]
				leerLetra = SubCadena(arrayText[k],0,1) //va leyendo desde i hasta i cada posicion, En este caso lee la i letra
				Segun leerLetra Hacer
					'a':
						cont = cont+1
					'e':
						cont = cont+1
					'i':
						cont = cont+1
					'o':
						cont = cont+1
					'u':
						cont = cont+1
				Fin Segun
				auxText = arrayText[j]
				arrayText[j] = arrayText[k]
				arrayText[k] = auxText
			fin si
		FinPara
	FinPara
	
	Para l=0 Hasta cant-1 Con Paso 1 Hacer
		Mostrar arrayText[l]
	Fin Para
FinAlgoritmo

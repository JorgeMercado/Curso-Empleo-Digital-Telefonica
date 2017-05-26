Algoritmo Algoritmo1
	//Realizar un algoritmo para un programa que se encargue de leer 10 textos y,
	//posteriormente, nos muestre los textos ordenados de menor a mayor número
	//de caracteres. En caso de que dos textos tengan el mismo número de caracteres,
	//se pondrá primero el que tenga mayor número de vocales.
	
	Definir i, k, j, aux, numcar, vocalesi, vocalesk como entero
	Definir text, notas, notaux como texto
	Definir letrai, letrak como caracter
	Definir dim como entero
	Mostrar "Introduce el número de textos a introducir"
	Leer dim
	Dimension notas[dim]
	Dimension numcar[dim]
	vocalesi = 0
	vocalesk = 0
	Para i = 0 hasta (dim - 1) con paso 1
		Mostrar "Introduce un texto"
		Leer text
		notas[i] = text
		numcar[i] = Longitud(text)
	FinPara
	
	Para i = 0 hasta (dim - 1) con paso 1
		Para k = (i + 1) hasta (dim - 1) con paso 1
			Si numcar[i] = numcar[k]
				Para j = 0 hasta numcar[i] con paso 1
					letrai = Subcadena(notas[i], j, j)
					Si letrai == "a" o letrai == "e" o letrai == "i" o letrai == "o" o letrai == "u"
						vocalesi = vocalesi + 1
					FinSi
					letrak = Subcadena(notas[k], j, j)
					Si letrak == "a" o letrak == "e" o letrak == "i" o letrak == "o" o letrak == "u"
						vocalesk = vocalesk + 1
					FinSi
				FinPara
				
			FinSi
			Si(numcar[k] < numcar[i]) o vocalesk > vocalesi entonces
				//realización del intercambio
				aux = numcar[i]
				numcar[i] = numcar[k]
				numcar[k] = aux
				//intercambio de notas
				notaux = notas[i]
				notas[i] = notas[k]
				notas[k] = notaux
				vocalesi = 0
				vocalesk = 0
			FinSi
		FinPara
	FinPara
	

	Para i = 0 hasta (dim - 1) con paso 1
		Mostrar notas[i]
	FinPara


	
FinAlgoritmo

//Realizar un algortimo que genere una
//combinación de la lotería primitiva. El
//objetivo es generar 6 números aleatorios
//entre 1 y 49 que no se repitan. Puedes
//utilizar la función GenerarAleatorio utilizada
//en los ejemplos del manual

Algoritmo Algoritmo4
	
	definir arrayComp, i,h,j,k,num,cont, num1 como entero
	dimension array[5]
	dimension arrayComp[5]
	
	Para h=0 Hasta 4 Con Paso 1 Hacer
		arrayComp[h] = 0
	Fin Para
	
	Para j=0 Hasta 4 Con Paso 1 Hacer
		num = azar(5)+1
		si arrayComp[j] == 0
			arrayComp[j] = num
			cont = 0
			Para k=0 Hasta 4 Con Paso 1 Hacer
				Si arrayComp[k] == num Entonces
					cont = cont + 1
					Si cont > 1 Entonces
						num1 = azar(5)+1
						Mientras num1==arrayComp[k] Hacer
							num1 = azar(5)+1
						Fin Mientras
						arrayComp[j] = num1 
					Fin Si
				Fin Si
			Fin Para
		FinSi
	Fin Para
	
	Para i=0 Hasta 4 Con Paso 1 Hacer
		Mostrar arrayComp[i]
	Fin Para
	
FinAlgoritmo

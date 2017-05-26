//Realizar el diseño de un algoritmo para
//un programa que lea un texto y una letra,
//para, posteriormente indicarnos el número
//de veces que la letra aparece en el texto.
//Puedes emplear la función ObtenerLetra
//utilizada en los ejercicios de ejemplo del
//manual del alumno.

Algoritmo Algoritmo5
	definir palabra, leerletra, letra como texto
	definir numcar, i, cont como entero
	
	Escribir "Escriba el texto a leer"
	leer palabra
	numcar = Longitud(palabra) //lee la longitud de la palabra
	Escribir "Escriba la letra a buscar"
	Leer letra
	cont = 0
	
	Para i=0 Hasta numcar-1 Con Paso 1 Hacer
		leerletra = SubCadena(palabra,i,i) //va leyendo desde i hasta i cada posicion, En este caso lee la i letra
		Si leerletra = letra
			cont = cont + 1
		FinSi
	Fin Para
	
	Segun cont Hacer
	1:
		Escribir "La letra " letra " aparece 1 vez"
	De Otro Modo:
		Escribir "La letra " letra " aparece " cont " veces "
	Fin Segun
	
FinAlgoritmo
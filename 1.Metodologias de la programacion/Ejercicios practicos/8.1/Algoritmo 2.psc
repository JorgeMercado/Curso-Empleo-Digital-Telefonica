//Dise�a un algoritmo para un programa
//que lea 10 textos y nos muestre aquel que
//tenga el mayor n�mero de caracteres. Si
//hay m�s de un texto con el mismo n�mero
//de caracteres, mostrar� el �ltimo de ellos.
//Puedes utilizar la funci�n Longitud para este
//ejercicio.

Algoritmo Algoritmo2
	definir i, numcar, may, n como entero
	definir palabra, palabramayor como texto
	may = 0
	
	Escribir "Escriba la cantidad texto a escribir"
	leer n
	Mientras n<= 0 Hacer
		Escribir "Numero no valido. Escriba de nuevo"
		Leer n
	Fin Mientras
	
	Para i=1 Hasta n Con Paso 1 Hacer
		Escribir "Escriba el " i " texto"
		leer palabra
		numcar = Longitud(palabra)
		Si numcar >= may Entonces
			may = numcar
			palabramayor = palabra
		Fin Si
	Fin Para
	
	Escribir "El texto mayor de todos es " palabramayor
FinAlgoritmo
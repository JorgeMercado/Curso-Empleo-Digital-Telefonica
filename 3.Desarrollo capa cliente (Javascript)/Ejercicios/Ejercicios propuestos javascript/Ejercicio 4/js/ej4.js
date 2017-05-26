function ejecutar() {
	var numeros = [];
	numeros[0] = document.getElementById('numero1').value;
	numeros[1] = document.getElementById('numero2').value;
	numeros[2] = document.getElementById('numero3').value;
	
	//Comprobamos cual es el mayor
	var mayor = numeros.sort();
	mayor = numeros.reverse();
	alert("El numero mayor es " + mayor[0]);

	//Negativo, cero o positivo
	var comprobarValor = prompt("Introduzca un numero a comprobar su valor");
	if (comprobarValor < 0) {
		alert("El numero es negativo");
	}
	if (comprobarValor == 0) {
		alert("El numero es 0");
	}
	if (comprobarValor > 0) {
		alert("El numero es positivo");
	}

	//Positivo entero de 3 cifras
	do{
		var enteroPos = prompt("Introduzca un numero positivo entero de hasta tres cifras");
		if (enteroPos != Number(enteroPos)) {
			alert("No ha introducido un numero");
		}
		if (enteroPos < 0) {
			alert("El numero es negativo");
		}
		if (enteroPos > 999) {
			alert("El numero tiene mas de 3 cifras");
		}
	}while (enteroPos != Number(enteroPos) || (enteroPos > 999) || (enteroPos < 0))
	alert("El numero tiene " + enteroPos.length + " cifras");
}
	
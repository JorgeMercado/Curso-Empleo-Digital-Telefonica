function ejecutar(){
	var texto = document.getElementById('texto').value;
	var palabrasSeparadas = texto.split(" ");
	var palabrasSeparadas1 = texto.split(" ");
	var palabrasSeparadas2 = texto.split(" ");
	
	var numPalabras = palabrasSeparadas.length;
	var primeraPalabra = palabrasSeparadas[numPalabras - numPalabras];
	var ultimaPalabra = palabrasSeparadas[numPalabras - 1];
	var palabrasInverso = palabrasSeparadas.reverse();
	//Asi se me habia ocurrido sin encontrar la funcion
	/*var cont = 0;
	var palabrasInverso[];
	for (var i = numPalabras - 1; i = 0; i--) {
		palabrasSeparadas[i] = palabrasInverso[cont];
		cont++;
	}*/
	var ordenarAZ = palabrasSeparadas1.sort();
	var ordenarZA = palabrasSeparadas2.sort();
	ordenarZA = palabrasSeparadas2.reverse();

	//Hacer que se muestre en la misma página
	/*var div = document.getElementById("resultado");
    div.innerHTML += ("----------------------------------------------------------" + "<br/>");
    div.innerHTML += ("Numero de palabras: " + numPalabras + "<br/>");
    div.innerHTML += ("Primera palabra: " + primeraPalabra + "<br/>");
    div.innerHTML += ("Ultima palabra: " + ultimaPalabra + "<br/>");
    div.innerHTML += ("Palabras en inverso: " + palabrasInverso + "<br/>");
    div.innerHTML += ("Palabras ordenadas de la A a la Z: " + ordenarAZ + "<br/>");
    div.innerHTML += ("Palabras ordenadas de la Z a la A: " + ordenarZA + "<br/>");    
    div.innerHTML += ("----------------------------------------------------------" + "<br/>");*/

    document.writeln("Numero de palabras: " + numPalabras + "<br/>");
    document.writeln("Primera palabra: " + primeraPalabra + "<br/>");
    document.writeln("Ultima palabra: " + ultimaPalabra + "<br/>");
    document.writeln("Palabras en inverso: " + palabrasInverso + "<br/>");
    document.writeln("Palabras ordenadas de la A a la Z: " + ordenarAZ + "<br/>");
    document.writeln("Palabras ordenadas de la Z a la A: " + ordenarZA + "<br/>");
}
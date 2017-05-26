function ejecutar(){
	var numeros = [];
	numeros[0] = document.getElementById('numero1').value;
	numeros[1] = document.getElementById('numero2').value;
	numeros[2] = document.getElementById('numero3').value;

	var cont = 0;
	
	if (numeros[0] != "" && numeros[1] != "" && numeros[2] != ""){
		for (var i = 0; i < 3; i++) {
			if (numeros[i] < 10){
				cont++;
			}
		}

		if (cont < 4 && cont > 0){
			if (cont >= 2){
				alert(cont + " de los números ingresados son menores que 10");
			}
			if (cont == 1){
				alert(cont + " número es menor que 10");
			}	
		}else{
			alert("Ninguno de los números es menor que 10");
		}
	}else{
		alert("Uno o más de los campos esta/n vacios. Rellénelos todos")
	}
}

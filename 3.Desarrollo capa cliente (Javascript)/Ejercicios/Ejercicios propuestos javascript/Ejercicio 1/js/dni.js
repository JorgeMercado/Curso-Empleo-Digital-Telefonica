var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 
'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 
'L', 'C', 'K', 'E', 'T'];

var restoDiv = 23;

function pedirDni(){
	var numeroDni = prompt("Introduza su numero de DNI");
	numeroDni = Number(numeroDni);
	while (numeroDni != Number(numeroDni)){
		var numeroDni = prompt("Su numero debe tener SÓLO numeros. Introduzca su numero de nuevo");
	}
	if (numeroDni<0 || numeroDni>99999999) {
		alert("El numero introducido no existe");
	} 
	
	var letraDni = prompt("Introduza su letra de DNI en mayuscula");
	letraDni = letraDni.toUpperCase();
	
	var resto = numeroDni % restoDiv; 

	if (letraDni == letras[resto]){
		alert("Las letras coinciden")
	}else{
		alert("Las letras no coinciden. Su letra de Dni introducida deberia ser "+ letras[resto])
	}
}
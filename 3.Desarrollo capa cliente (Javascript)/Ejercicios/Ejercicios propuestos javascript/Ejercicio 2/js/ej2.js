function comprobarParidad(){
	var num = document.getElementById('numero').value;

	if (num%2 == 0) {
		alert("El numero es par");
	}
	else{
		alert("El numero es impar");
	}
}
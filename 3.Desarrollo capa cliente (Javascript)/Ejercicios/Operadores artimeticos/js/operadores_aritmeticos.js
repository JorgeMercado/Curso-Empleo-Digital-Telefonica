function primerNumero(){
	var a = prompt("Escribe el 1er número");
	a = Number(a);
	if (a != Number (a)){
		do{
			var a = prompt("Vuelva a escribir un numero");
			a = Number(a);
		}while (a != Number(a));
	}
	return a;
}
function segundoNumero(){
	var b = prompt("Escribe el 2do número");
	b = Number(b);
	if (b != Number (b)){
		do{
			var b = prompt("Vuelva a escribir otro numero");
			b = Number(b);
		}while (b != Number(b));
	}
	return b;
}
function operar(a,b){
	var suma = a + b ;
    var resta = a - b;
    var multiplicacion = a * b;
    var division = a / b;
    var modulo = a % b;
	var div = document.getElementById("resultado");
    div.innerHTML += ("----------------------------------------------------------" + "<br/>");
    div.innerHTML += ("Suma: " + a +" + " +  b + " = " + suma + "<br/>");
    div.innerHTML += ("Resta: " + a +" - " +  b + " = " + resta + "<br/>");
    div.innerHTML += ("Multiplicación: " + a + " * " +  b + " = " + multiplicacion + "<br/>");
    div.innerHTML += ("División: " + a + " / " +  b + " = " + division + "<br/>");
    div.innerHTML += ("Módulo: " + a + " mod. " +  b + " = " + modulo + "<br/>");
    div.innerHTML += ("----------------------------------------------------------" + "<br/>");
}
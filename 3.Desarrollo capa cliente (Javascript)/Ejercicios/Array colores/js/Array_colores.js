
function mouseOut(){
	var texto = document.getElementById("respuesta");
	texto.innerHTML = colores[0];
	document.getElementById("respuesta").style.color = "black";
	document.getElementById("rojo").style.opacity = "0.1";
	document.getElementById("amarillo").style.opacity = "0.1";
	document.getElementById("verde").style.opacity = "0.1";
	document.getElementById("azul").style.opacity = "0.1";
}

function mouseOverRojo(){
	var texto = document.getElementById("respuesta");
	texto.innerHTML = colores[1];
	document.getElementById("respuesta").style.color = "red";
	document.getElementById("rojo").style.opacity = "1";
}

function mouseOverAmarillo(){
	var texto = document.getElementById("respuesta");
	texto.innerHTML = colores[2];
	document.getElementById("respuesta").style.color = "yellow";
	document.getElementById("amarillo").style.opacity = "1";
}

function mouseOverVerde(){
	var texto = document.getElementById("respuesta");
	texto.innerHTML = colores[3];
	document.getElementById("respuesta").style.color = "green";
	document.getElementById("verde").style.opacity = "1";
}

function mouseOverAzul(){
	var texto = document.getElementById("respuesta");
	texto.innerHTML = colores[4];
	document.getElementById("respuesta").style.color = "blue";
	document.getElementById("azul").style.opacity = "1";
}
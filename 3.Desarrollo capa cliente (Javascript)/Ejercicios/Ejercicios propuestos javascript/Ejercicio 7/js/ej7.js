function mouseOverEntremeses(){
	document.getElementById('entremeses').style.opacity = "1";
}
function mouseOverPrimerosPlatos (){
	document.getElementById('primerosPlatos').style.opacity = "1";
}
function mouseOverSegundosPlatos(){
	document.getElementById('segundosPlatos').style.opacity = "1";
}
function mouseOverPostres(){
	document.getElementById('postres').style.opacity = "1";
}
function mouseOut(){
	document.getElementById('entremeses').style.opacity = "0.5";
	document.getElementById('primerosPlatos').style.opacity = "0.5";
	document.getElementById('segundosPlatos').style.opacity = "0.5";
	document.getElementById('postres').style.opacity = "0.5";
}
function paginaPrincipal(){
	location.href="Ejercicio_7.html";
}
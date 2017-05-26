var cont = 0;

function pasarImagenDerecha(){
	cont = Math.abs(cont);
	if (cont == 0){
		var foto0 = document.getElementById(cont);
		foto0.className = "oculta";
		var foto1 = document.getElementById(cont+1);
		foto1.className = "visible";
	}
	if (cont == 1){
		var foto1 = document.getElementById(cont);
		foto1.className = "oculta";
		var foto2 = document.getElementById(cont+1);
		foto2.className = "visible";
	}
	if (cont == 2){
		var foto2 = document.getElementById(cont);
		foto2.className = "oculta";
		var foto0 = document.getElementById(cont-2);
		foto0.className = "visible";
		cont = -1;
	}
	cont++;
	return cont;
}
function pasarImagenIzquierda(){
	cont = Math.abs(cont);
	if (cont == 0){
		var foto2 = document.getElementById(cont+2);
		foto2.className = "visible";
		var foto0 = document.getElementById(cont);
		foto0.className = "oculta";
		cont = 3;
	}
	if (cont == 1){
		var foto1 = document.getElementById(cont);
		foto1.className = "oculta";
		var foto0 = document.getElementById(cont-1);
		foto0.className = "visible";
	}
	if (cont == 2){
		var foto2 = document.getElementById(cont);
		foto2.className = "oculta";
		var foto1 = document.getElementById(cont-1);
		foto1.className = "visible";
	}
	cont--;
	return cont;
}
//diaSemana utiliza CAMELCASE, es decir, primera letra de la nueva palabra en mayúscula
diaSemana = ["Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo","Ya no hay mas"];
elemento = document.getElementById("texto")
contador = 0;

function poner_Dia(){
	if (contador<8){
		elemento.innerHTML += diaSemana[contador];
		contador ++;
	}
}
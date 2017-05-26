function ejecutar(){
	var preguntasRealizadas = document.getElementById('preguntasRealizadas').value;
	var respuestasCorrectas = document.getElementById('respuestasCorrectas').value;
	var nombreAlumno = document.getElementById('nombre').value;

	if (preguntasRealizadas == "" || respuestasCorrectas == "" || nombreAlumno == ""){
		alert("Uno o más de los campos esta vacio. Rellénelo/s por favor");
	}

	if (preguntasRealizadas != "" && respuestasCorrectas != "") {
		if (nombreAlumno == ""){
			alert("Se procede al calculo del porcentaje a pesar de no tener el nombre del alumno")
		}
		var porcentaje = ((respuestasCorrectas / preguntasRealizadas) * 100);
		porcentaje = Math.round(porcentaje);
		if (porcentaje <= 100){
			if (porcentaje > 90) {
				alert("El porcentaje de " + nombreAlumno + " es un " + porcentaje + " % que corresponde con el nivel superior");
			}
			if (porcentaje >= 75 && porcentaje < 90){
				alert("El porcentaje de " + nombreAlumno + " es un " + porcentaje + " % que corresponde con el nivel medio");		
			}
			if (porcentaje >= 50 && porcentaje < 75){
				alert("El porcentaje de " + nombreAlumno + " es un " + porcentaje + " % que corresponde con el nivel regular");		
			}
			if (porcentaje < 50){
				alert("El porcentaje de " + nombreAlumno + " es un " + porcentaje + " % con lo que está fuera de nivel");		
			}
		}else{
			alert("El numero de preguntas correctas es mayor que el de preguntas realizadas. Valor incorrecto");
		}
	}
}
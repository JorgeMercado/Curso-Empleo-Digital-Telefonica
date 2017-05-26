function mouseOut(){
	document.getElementById("uno").style.opacity = "0.5";
	document.getElementById("dos").style.opacity = "0.5";
	document.getElementById("tres").style.opacity = "0.5";
	document.getElementById("cuatro").style.opacity = "0.5";
}

function mouseOverUno(){
	document.getElementById("uno").style.opacity = "1";
}

function mouseOverDos(){
	document.getElementById("dos").style.opacity = "1";
}

function mouseOverTres(){
	document.getElementById("tres").style.opacity = "1";
}

function mouseOverCuatro(){
	document.getElementById("cuatro").style.opacity = "1";	
}

$(document).ready(function(){
    $("#uno").click(function (){
    	$(".modal").fadeIn("slow");
    	$(".velo").fadeIn("slow");
   	});
   	$("#dos").click(function (){
    	$(".modal").fadeIn("slow");
    	$(".velo").fadeIn("slow");
   	});
   	$("#tres").click(function (){
    	$(".modal").fadeIn("slow");
    	$(".velo").fadeIn("slow");
   	});
   	$("#cuatro").click(function (){
    	$(".modal").fadeIn("slow");
    	$(".velo").fadeIn("slow");
   	});
   	$("#cerrar").click(function(){
   		$(".modal").fadeOut("slow");
   		$(".modal1").fadeOut("slow");
    	$(".velo").fadeOut("slow");
    	$(".velo1").fadeOut("slow");
   	});
   	$(".reservar").click(function(){
   		$(".velo1").fadeIn("slow");
   		$(".modal1").fadeIn("slow");
   	})
   	$("#cerrar1").click(function(){
   		$(".modal1").fadeOut("slow");
    	$(".velo1").fadeOut("slow");
    	$(".modal").fadeOut("slow");
    	$(".velo").fadeOut("slow");
   	});
   	$("#aceptar").click(function(){
   		alert("Fecha reservada correctamente");
   		$(".modal1").fadeOut("slow");
    	$(".velo1").fadeOut("slow");
    	$(".modal").fadeOut("slow");
    	$(".velo").fadeOut("slow");
   	})
   	$(".comprar").click(function(){
   		$("")
   	});
});
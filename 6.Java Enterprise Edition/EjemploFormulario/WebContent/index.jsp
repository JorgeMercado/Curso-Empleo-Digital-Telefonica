<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX</title>
</head>
<body>
	<div><jsp:include page="header.html"></jsp:include></div><br>
	
	<%
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		String telefono = request.getParameter("telefono");
		String sNumero = request.getParameter("numero");
		
	try{	
		int numero = Integer.parseInt(sNumero);
	%>
	
	<div class="tablaMuestra">
	<table>
		<tr>
			<td>Nombre: <%=nombre%><br></td>
		</tr>	
		<tr>
			<td>Primer apellido: <%=primerApellido%><br></td>
		</tr>
		<tr>
			<td>Segundo apellido: <%=segundoApellido%><br></td>
		</tr>
		<tr>
			<td>Telefono: <%=telefono%><br></td>
		</tr>
		<tr>
			<td>Numero: <%=numero%><br></td>
		</tr>
	</table>
	</div>
	
	
	<%	if(numero % 2 == 0){%>
			<jsp:include page="multiplo2.html"></jsp:include>
	<%	}if(numero % 3 == 0){%>
			<jsp:include page="multiplo3.html"></jsp:include>
	<%  }if(numero % 5 == 0){%>
			<jsp:include page="multiplo5.html"></jsp:include>
	<%  }%>
	
	<div><a href="Formulario.html"><button>Volver a escribir datos</button></a></div>
	<%}catch(NumberFormatException nfe){%>
		<p>NUMERO MAL ESCRITO</p>
	<%} %>
	
	
	
	<div><jsp:include page="footer.html"></jsp:include></div>
</body>
</html>
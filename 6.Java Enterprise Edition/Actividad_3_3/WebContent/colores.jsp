<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos introducidos</title>
	<% 
		String nombre = request.getParameter("nombre");	
		String color = request.getParameter("color");
		color = color.replace('#',' ');
		color = color.trim();
	%>
</head>
<style>
	html{
		background-color:#<%=color%>;
	}
</style>
<body>
	
	<p>NOMBRE: <%=nombre%></p>
	<p>COLOR: <%=color%></p>

	<a href="FormularioColores.html"><button>Volver</button></a>
</body>
</html>
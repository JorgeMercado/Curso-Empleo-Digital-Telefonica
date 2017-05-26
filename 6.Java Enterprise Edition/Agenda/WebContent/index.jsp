<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, modelo.Persona" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Login</title>

<style type="text/css">
	html{text-align:center}
	table{text-align:center;background-color: lightblue; margin-left: 45%}
  	td{border:1px solid black}
  	th {border:1px solid black;background-color: yellow}
  	label{font-weight:bold}
</style>
</head>
<body>
<% ArrayList<Persona> lista=(ArrayList<Persona>)request.getAttribute("listado"); %>


	<form action="ControlAgenda" method="POST">
		<label for="usuario">Nombre:</label> 
		<input type="text" id="nombre"
			name="nombre" placeholder="Escriba el nombre del contacto" /> 
		<label for="number">Número:</label> 
		<input type="text"
			id="number" name="number" placeholder="Número de teléfono" />
		<p><button type="submit">Nuevo Contacto</button></p>
	</form>
	
	<table>
	<tr>
		<th>Nombre</th>
		<th>Teléfono</th>
	</tr>
	<% for(Persona p:lista){ %>
	<tr>
		<td><%=p.getNombre() %></td>
		<td><%=p.getNumber() %></td>
	</tr>
	<% } %>
	</table>
</body>
</html>
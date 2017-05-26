<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Nuevo</title>
</head>
<body>
<form action="addNew" method="POST">

<h1 style="text-align: center;">Añadir un nuevo pajaro</h1>
	<table style="margin: auto;">
		<tr>
			<td><label for="superorden">Superorden: </label></td>
			<td><select name="superorden">
				<option value="0">Paleognata</option>
				<option value="1">Impennes</option>
				<option value="2">Neognata</option>
			</select></td>
		</tr>
		<tr>
			<td><label for="familia">Familia: </label></td>
			<td><input type="text" name="familia"></td>
		</tr>
		<tr>
			<td><label for="especie">Especie: </label></td>
			<td><input type="text" name="especie"></td>
		</tr>
		<tr>
			<td><label for="numero">Numero: </label></td>
			<td><input type="number" name="numero"></td>
		</tr>		
		<tr>
			<td colspan="2" style="text-align: center;"><button type="submit">Añadir</button></td>
		</tr>
	</table>	
</form>
</body>
</html>


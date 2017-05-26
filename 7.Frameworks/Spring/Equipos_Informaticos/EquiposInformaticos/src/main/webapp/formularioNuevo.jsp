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

<h1 style="text-align: center;">Añadir un nuevo Equipo</h1>
	<table style="margin: auto;">
		<tr>
			<td><label for="tipo">Tipo: </label></td>
			<td><select name="tipo">
				<option value="ORDENADOR">Ordenador</option>
				<option value="MONITOR">Monitor</option>
				<option value="IMPRESORA">Impresora</option>
			</select></td>
		</tr>
		<tr>
			<td><label for="modelo">Modelo: </label></td>
			<td><input type="text" name="modelo"></td>
		</tr>
		<tr>
			<td><label for="ubicacion">Ubicación: </label></td>
			<td><input type="text" name="ubicacion"></td>
		</tr>
		<tr>
			<td><label for="fecha">Fecha de instalación: </label></td>
			<td><input type="date" name="fecha"></td>
		</tr>		
		<tr>
			<td colspan="2" style="text-align: center;"><button type="submit">Añadir</button></td>
		</tr>
	</table>	
</form>
</body>
</html>


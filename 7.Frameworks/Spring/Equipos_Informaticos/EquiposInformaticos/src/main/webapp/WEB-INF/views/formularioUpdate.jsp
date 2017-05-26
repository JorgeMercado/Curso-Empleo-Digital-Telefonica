<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar</title>
</head>
<body>
<h1 style="text-align: center;">Modificar Equipo</h1>

<form action="update" method="POST">
<input type="hidden" value="${equipo.id}" name="idS">
	<table style="margin: auto;">
		<tr>
			<td><label for="tipo">Tipo: </label></td>
			<td><select name="tipo">
			<c:forEach items="${tipos}" var="tipo">		
				<option value="${tipo.name()}" ${tipo == equipo.tipo ? 'selected' : ''}>${tipo.toString()}</option>
			</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label for="modelo">Modelo: </label></td>
			<td><input type="text" name="modelo" value="${equipo.modelo}"></td>
		</tr>
		<tr>
			<td><label for="ubicacion">Ubicación: </label></td>
			<td><input type="text" name="ubicacion" value="${equipo.ubicacion}"></td>
		</tr>
		<tr>
			<td><label for="fecha">Fecha de instalación: </label></td>
			<td><input type="date" name="fecha" value="${equipo.fecha}"></td>
		</tr>		
		<tr>
			
			<td colspan="2" style="text-align: center;"><button type="submit">Modificar</button></td>
		</tr>
	</table>	
</form>
</body>
</html>


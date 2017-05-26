<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viajes disponibles</title>
</head>
<body>
	<table>
		<tr>
			<td>Destino</td>
			<td>Duracion(dias)</td>
			<td>Precio</td>
		</tr>
		<c:forEach items="${listado}" var="viajes">
			<tr>
				<td>${viajes.destino}</td>
				<td>${viajes.duracion}</td>
				<td>${viajes.precio}</td>
				<td><a href="AddFavoritos?id=${viajes.idViaje}"><button>Añadir favorito</button></a></td>
			</tr>
		</c:forEach>
	</table>
		<a href="Inicio"><button>Inicio</button></a>
</body>
</html>
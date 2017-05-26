<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viajes Favoritos</title>
</head>
<body>
<div>Viaje favorito guardado con éxito</div>
	<div>
		<table>
			<tr><td colspan="3">LISTA DE FAVORITOS</td></tr>
			<tr>
				<td>Destino</td>
				<td>Duracion(dias)</td>
				<td>Precio</td>
			</tr>
			<c:forEach items="${sessionScope.favoritos}" var="viajes">
				<tr>
					<td>${viajes.destino}</td>
					<td>${viajes.duracion}</td>
					<td>${viajes.precio}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="Inicio">Inicio.</a>
</body>
</html>
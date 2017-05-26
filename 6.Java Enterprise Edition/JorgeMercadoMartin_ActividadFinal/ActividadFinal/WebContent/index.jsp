<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a nuestra agencia de viajes</title>
</head>
<body>
	<div><p>Numero de usuarios en el sito web:	${applicationScope.numeroUsuarios}</p></div>
	<table>
	<tr><td colspan="4">VIAJE EN OFERTA: <td></tr>
		<tr>
			<td>Destino</td>
			<td>Duracion(dias)</td>
			<td>Precio</td>
		</tr>
			<tr>
				<td>${oferta.destino}</td>
				<td>${oferta.duracion}</td>
				<td>${oferta.precio}</td>
				<td><a href="AddFavoritos?id=${oferta.idViaje}"><button>Añadir favorito</button></a></td>
			</tr>
		<tr>
			<td><a href="ListarViajes">Viajes disponibles</a></td>
		</tr>
		<tr>
			<td><a href="formulario.jsp">Buscar destinos</a></td>
		</tr>
	</table>
</body>
</html>
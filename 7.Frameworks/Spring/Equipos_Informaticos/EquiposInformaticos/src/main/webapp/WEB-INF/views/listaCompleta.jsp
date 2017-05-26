<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table tr td{border: 1px solid black}
#sinBorde{border:inherit;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista completa de Equipos</title>
</head>
<body>
<h1 style="text-align: center;">Lista Completa de Equipos</h1>

<table style="margin: auto;">
	<tr>
		<td>Tipo</td>
		<td>Modelo</td>
		<td>Ubicación</td>
		<td>Fecha</td>
		<td id="sinBorde"></td>
		<td id="sinBorde"></td>	
	</tr>
	<c:forEach items="${lista}" var="equipo">
		<tr>
			<td>${equipo.tipoString}</td>		
			<td>${equipo.modelo}</td>
			<td>${equipo.ubicacion}</td>
			<td><fmt:formatDate value="${equipo.fecha}"/></td>
			<td id="sinBorde"><a href="borrar?idS=${equipo.id}"><button>Borrar</button></a></td>
			<td id="sinBorde"><a href="check?idS=${equipo.id}"><button>Modificar</button></a></td>
			
		</tr>
	</c:forEach>
</table>

<p style=" margin: auto;margin-top: 2%; text-align: center;"><a href="formularioNuevo.jsp"><button>+ Añadir Equipo Nuevo +</button></a></p>
</body>
</html>
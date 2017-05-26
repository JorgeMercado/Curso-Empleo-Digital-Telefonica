<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<title>INSERT</title>
</head>
<body>
	<%
		Random aleatorio = new Random();
		float precio = aleatorio.nextFloat() * 0.1F;
		int num = aleatorio.nextInt(99000) + 1000;
		String nombre = "Nombre " + Integer.toString(num);
		pageContext.setAttribute("nombre", nombre);
		pageContext.setAttribute("precio", precio);
	%>

	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/comercio" user="actividades"
		password="zsexdr" />
	<sql:update dataSource="${snapshot}" var="result">
INSERT INTO producto (nombre, precio)VALUES ('${nombre}','${precio}')
</sql:update>
	<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM producto
</sql:query>
	<div>
		<h4>Producto insertado</h4>
		<table border="2" width="100%">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Precio</th>
			</tr>
			<tr>
				<td><c:out value="${idproducto}" /></td>
				<td><c:out value="${nombre}" /></td>
				<td><c:out value="${precio}" /></td>
			</tr>
			</div>
			<table border="1" width="100%">
				<tr>
					<th>IDI</th>
					<th>Nombre</th>
				</tr>
				<c:forEach var="row" items="${result.rows}">
					<tr>
						<td><c:out value="${row.idproducto}" /></td>
						<td><c:out value="${row.nombre}" /></td>
						<td><c:out value="${row.precio}" /></td>
					</tr>
				</c:forEach>
			</table>
			<a href="<c:url value="index.html"/>">Volver a inicio</a>
			<!--<a href="index.html">Volver a inicio</a>-->
</body>
</html>
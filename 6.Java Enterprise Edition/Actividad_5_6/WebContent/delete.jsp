<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<title>DELETE</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/comercio" user="actividades"
		password="zsexdr" />
	<sql:update dataSource="${snapshot}" var="count">
 DELETE FROM producto WHERE idproducto = ?
 <sql:param value="${idproducto}" />
	</sql:update>

	<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM producto
</sql:query>
	<div>
		<c:if test="${idproducto == null}">
			<h3>No se ha borrado a ningún producto, no se ha insertado a
				ninguno en esta sesión</h3>
		</c:if>
	</div>
	<table border="1" width="100%">
		<tr>
			<th>Id Producto</th>
			<th>Nombre</th>
			<th>Precio</th>
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
>

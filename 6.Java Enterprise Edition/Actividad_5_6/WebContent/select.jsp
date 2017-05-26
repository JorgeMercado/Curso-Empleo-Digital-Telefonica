<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>SELECT</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/comercio" user="actividades"
		password="zsexdr" />
	<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM producto
</sql:query>

	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.idproducto}" /></td>
				<c:set var="elnombre" value="${row.nombre}" />
			    <c:set var="mayusnombre" value="${fn:toUpperCase(elnombre)}" />
    			<td><c:out value=" ${mayusnombre}"/></td>
				<td><c:out value="${row.precio}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="index.html"/>">Volver a inicio</a>
	<!--<a href="index.html">Volver a inicio</a>-->
</body>
</html>
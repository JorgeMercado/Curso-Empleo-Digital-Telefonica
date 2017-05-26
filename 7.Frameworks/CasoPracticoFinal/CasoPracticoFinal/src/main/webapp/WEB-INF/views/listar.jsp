<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
<title><spring:message code ="principal"/></title>
<link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>

<h1><spring:message code ="catalogo"/></h1>
<div>
<table>
	<tr>
		<td><spring:message code ="matricula"/></td>
		<td><spring:message code ="modelo"/></td>
		<td><spring:message code ="fechamatriculacion"/></td>
		<td><spring:message code ="km"/></td>
		<td><spring:message code ="precio"/></td>
		<td></td>
	</tr>
	<c:forEach items="${lista}" var="coche">
		<tr>
			<td><c:out value="${coche.matricula}"/></td>
			<td><c:out value="${coche.modelo}"/></td>
			<td><c:out value="${coche.fechamatriculacion}"/></td>
			<td><c:out value="${coche.km}"/></td>
			<td><c:out value="${coche.precio}"/></td>
			<td><a href="formEditar?matricula=${coche.matricula}"><spring:message code ="editar"/></a></td>
		</tr>
	</c:forEach>
</table>

<table>
	<tr>
		<td><a href="formInsertar"><button><spring:message code ="crear"/></button></a></td> 
	</tr>
</table>
</div>

</body>
</html>
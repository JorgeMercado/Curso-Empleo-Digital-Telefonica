<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
<title><spring:message code="principal" /></title>
<link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>

<h1><spring:message code="catalogo"/></h1>
<div>
<table>
	<tr>
		<td class="header" id="borderOff"><spring:message code="especie"/> </td>
		<td class="header" id="borderOff"><spring:message code="familia"/></td>
		<td class="header" id="borderOff"><spring:message code="superorden"/></td>
		<td id="borderOff"></td>
	</tr>
	<c:forEach items="${lista}" var="pajaro">
		<tr>
			<td><c:out value="${pajaro.especie}"/></td>
			<td><c:out value="${pajaro.familia}"/></td>
			<td><spring:message code="${pajaro.superordenString}"/></td>
			<td id="borderOff"><a href="formModif?id=${pajaro.id}"><button><spring:message code="modificar"/></button></a></td>
			<td id="borderOff"><a href="borrar?id=${pajaro.id}"><button><spring:message code="borrar"/></button></a></td>
		</tr>
	</c:forEach>
</table>
</div>

<div id="insertar">
	<form action="formInsertar"><button><spring:message code="insertar"/></button></form>
</div>

</body>
</html>
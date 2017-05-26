<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table tr td{border: 1px solid black}
#sinBorde{border:inherit;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista completa de pajaros</title>
</head>
<body>
<h1 style="text-align: center;">Lista Completa de pajaros</h1>

<table style="margin: auto;">
	<tr>
		<td>Superorden</td>
		<td>Familia</td>
		<td>Especie</td>
		<td>Numero</td>
	</tr>
	<c:forEach items="${lista}" var="pajaro">
		<tr>
			<td><spring:message code="${pajaro.SOString}"/></td>		
			<td>${pajaro.familia}</td>	
			<td>${pajaro.especie}</td>		
			<td>${pajaro.numero}</td>
		</tr>
	</c:forEach>
</table>

<form action="formNuevo"><button>Añada uno nuevo</button></form>

</body>
</html>
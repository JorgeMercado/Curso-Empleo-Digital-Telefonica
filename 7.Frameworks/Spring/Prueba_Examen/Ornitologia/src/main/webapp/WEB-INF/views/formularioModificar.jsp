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

<h1><spring:message code="modificar"/></h1>
<div>
<form action="modificar">
<input type="hidden" name="id" value="${id}">
<table>
	<tr>
		<td><label for="especie"><spring:message code="especie"/></label></td>
		<td><input type="text" name="especie"></td>
	</tr>
	<tr>
		<td><label for="familia"><spring:message code="familia"/></label></td>
		<td><input type="text" name="familia"></td>
	</tr>
	<tr>
		<td><label for="superorden"><spring:message code="especie"/></label></td>
		<td>
			<select name="superorden">
				<option value="PALEOGNATA"><spring:message code="PALEOGNATA"/></option>
				<option value = "IMPENNES"><spring:message code = "IMPENNES"/> </option>
				<option value = "NEOGNATA"><spring:message code = "NEOGNATA"/> </option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="3"><button><spring:message code="modificar"/></button></td>
	</tr>
</table>

</form>
</div>

</body>
</html>
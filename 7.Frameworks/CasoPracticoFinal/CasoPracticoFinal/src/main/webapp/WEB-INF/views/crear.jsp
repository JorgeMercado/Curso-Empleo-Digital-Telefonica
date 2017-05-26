<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
<title><spring:message code ="crear"/></title>
<link href="resources/css/style.css" rel="stylesheet"/>
</head>
<body>

<h1><spring:message code ="creando"/></h1>
<div>
<form action="crear">
<table>
	<tr>
		<td><label for="matricula"><spring:message code ="matricula"/></label></td>
		<td><input type="text" name="matricula"></td>
	</tr>
	<tr>
		<td><label for="modelo"><spring:message code ="modelo"/></label></td>
		<td><input type="text" name="modelo"></td>
	</tr>
	<tr>
		<td><label for="fechamatriculacion"><spring:message code ="fechamatriculacion"/></label></td>
		<td><input type="date" name="fechamatriculacion"></td>
	</tr>
	<tr>
		<td><label for="km"><spring:message code ="km"/></label></td>
		<td><input type="number" name="km"></td>
	</tr>
	<tr>
		<td><label for="precio"><spring:message code ="precio"/></label></td>
		<td><input type="number" name="precio"></td>
	</tr>
	<tr>
		<td colspan="3"><button><spring:message code ="crear"/></button></td>
	</tr>
</table>

</form>
</div>

</body>
</html>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceso a la aplicación</title>
</head>
<body>
<h1 style="text-align: center;">Bienvenido a la Aplicación</h1>
<form action="login" method="POST">
	<table style="margin: auto;">
		<tr>
			<td><label for="nombre">Nombre: </label></td>
			<td><input type="text" name="nombre"></td>
		</tr>
		<tr>
			<td><label for="password">Password</label></td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><button type="submit">Acceso</button></td>
		</tr>
	</table>	
</form>
</body>
</html>


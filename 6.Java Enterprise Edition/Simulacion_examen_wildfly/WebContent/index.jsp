<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletDiario" method="POST">
		<label for="nombreUsuario">Nombre de usuario</label>
		<input type="text" name="nombreUsuario"/>
		<label for="contrase�a">Contrase�a</label>
		<input type="password" name="contrase�a"/>
		<button type="submit">LOG IN</button>
	</form>
</body>
</html>
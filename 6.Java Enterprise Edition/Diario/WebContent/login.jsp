<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="HacerLogin" method="POST">
		<label for="nombre">Nombre: </label>
		<input type="text" name="nombre" placeholder="Nombre de usuario"/>
		<br/>
		<label for="password">Contrase�a: </label>
		<input type="password" name="password" placeholder="Contrase�a aqu�" />
		<br/>
		<button type="submit">Hacer login</button>
	</form>
</body>
</html>
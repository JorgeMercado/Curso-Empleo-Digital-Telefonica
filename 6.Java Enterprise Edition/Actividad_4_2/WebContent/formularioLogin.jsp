<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		Numero de usuarios conectados:<%=request.getAttribute("numeroUsuarios")%></div>
	<div>
		Numero de usuarios logados:
		<%=request.getAttribute("numeroLogados")%></div>
	<div>
		<form action="Index" method="POST">
			<label for="nombre">Usuario:</label> 
			<input type="text" name="nombre"
				id="nombre" placeholder="Nombre de usuario" /> 
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" placeholder="Contraseña"/>
			<button type="submit">Hacer Login</button>
		</form>
	</div>
</body>
</html>
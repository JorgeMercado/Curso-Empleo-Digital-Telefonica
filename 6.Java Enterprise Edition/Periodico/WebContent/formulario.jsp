<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda de viajes</title>
<link rel="stylesheet" type="text/css" href="css/miestilo.css" />
</head>
<body>
	<div id="rotulo">Busqueda de viajes</div>
	<div>
		<form action="Buscar" method="POST">
			<label for="palabra">Palabra a buscar: </label> <input type="text"
				name="palabra" placeholder="Palabra aquí" />
			<button type="submit">Buscar</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido al periodico</title>
<link rel="stylesheet" type="text/css" href="css/miestilo.css" />
</head>
<body>
	<div id="cabecera">Anuncios por palabras</div>
	<div>Numero de usuarios en el sito web:
		${applicationScope.numeroUsuarios}
	</div>

	
	<div>
		<table>
			<tr>
				<td><a href="Listar">Listado de anuncios</a></td>
			</tr>
			<tr>
				<td><a href="formulario.jsp">Buscar anuncios</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
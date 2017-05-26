<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Anuncios favoritos</title>
<link rel="stylesheet" type="text/css" href="css/miestilo.css" />
</head>
<body>
	<div>Anuncio favorito guardado con éxito</div>
	<div id="rotulo">Lista de tus anuncios favoritos</div>
	<div>
		<table>
			<c:forEach items="${sessionScope.favoritos}" var="anuncio">
				<tr>
					<td>${anuncio.texto}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="Inicio">Inicio.</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Simula un chat</title>
</head>
<body>
	<c:if test="${pageContext.request.method=='POST'}">
		<c:choose>
			<c:when test="${param.enviar!=null}">
				<c:set var="chat"
					value="${chat}<b>${param.identificacion}:
 </b>${param.texto}<br />"
					scope="application" />
			</c:when>
			<c:when test="${param.vaciar!=null}">
				<c:set var="chat" value="" scope="session" />
			</c:when>
		</c:choose>
	</c:if>
	<table border="0">
		<tbody>
			<tr>
				<td>
					<h3>
						Usuario:
						<c:out value="${param.identificacion}" />
					</h3>
					<hr />
				</td>
			</tr>
			<tr>
				<td><c:out value="${chat}" escapeXml="false" /></td>
			</tr>
			<tr>
				<td>
					<hr />
					<form method="post" action="#">
						Mensaje: <input type="text" name="texto" size="20" /> 
						<input type="submit" name="enviar" value="Enviar" /> 
						<input type="submit" name="borrar" value="Borrar" /> 
						<input type="submit" name="vaciar" value="Vaciar" /> 
						<input type="hidden" name="identificacion" 
						value="<c:out value="${param.identificacion}"/>" /> 
						<br />
					</form>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="<c:url value="index.html"/>">Volver a inicio</a>
</body>
</html>
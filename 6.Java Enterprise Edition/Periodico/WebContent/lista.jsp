<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="eS_ES"/>
<div>
	<table>
		<c:forEach items="${lista}" var="anuncio">
			<tr>
				<td><a href="AnyadirFavorito?id=${anuncio.id}">${anuncio.texto}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
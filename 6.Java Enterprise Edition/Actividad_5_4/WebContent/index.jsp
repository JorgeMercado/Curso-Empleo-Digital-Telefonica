<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<c:if test="${pageContext.request.method=='POST'}">--%>
<%-- Cada elemento de una colección (lista) es un String --%>
<%-- El delimitador de los elementos de la colección es , --%>
<c:choose>
	<c:when test="${param.add!=null}">
		<%--Añadir elemento a la lista: item1,item2,item3--%>
		<c:if test="${lista!=null}">
			<c:set var="lista" value="${lista}," scope="session" />
		</c:if>
		<c:set var="lista" value="${lista}${param.elemento}" scope="session" />
	</c:when>
	<c:when test="${param.borrar!=null}">
		<%--Borrar elemento a la lista: item1,item2,item3--%>
		<%--Se forma lista_aux con todos los elementos menos el == a
param--%>
		<c:set var="lista_aux" value="" />
		<c:forEach var="elemento" items="${lista}">
			<c:if test="${elemento!=param.elemento}">
				<c:if test="${lista_aux!=''}">
					<c:set var="lista_aux" value="${lista_aux}," />
				</c:if>
				<c:set var="lista_aux" value="${lista_aux}${elemento}" />
			</c:if>
		</c:forEach>
		<c:set var="lista" value="${lista_aux}" scope="session" />
		<c:remove var="lista_aux" />
	</c:when>
</c:choose>
<%--</c:if>--%>
<html>
<head>
<title>${titulo="Añadir y borrar elementos a una
lista"}</title>
</head>
<body>
	<h3>\${lista}: ${lista}</h3>
	<h3>\${param.elemento}: ${param.elemento}</h3>
	<table border="0">
		<%--<form method="get" action="newjsp.jsp">--%>
		<form method="get" action="#">
			<tr bgcolor="blue">
				<td colspan="2"><font color="white">${titulo}</font></td>
			</tr>
			<tr>
				<td valign="top"><select name="choice" size="10" width="20">
						<c:forEach var="elemento" items="${lista}">
							<option>
								<c:out value="${elemento}" />
							</option>
						</c:forEach>
				</select></td>
				<td valign="top">Pon el elemento a añadir o borrar.<br /> <input
					width="20" maxwidth="20" name="elemento" size="20" /><br /> 
					<input type="submit" name="add" value="Add" /> 
					<input type="submit" name="borrar" value="Borrar" />
				</td>
			</tr>
		</form>
	</table>
</body>
</html>
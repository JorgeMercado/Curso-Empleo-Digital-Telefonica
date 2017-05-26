<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leyendo cookies</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Nombre de la cookie</td>
				<td>Valor de la cookie</td>
			</tr>
		</thead>
		<%
			Cookie[] cookies = request.getCookies();
			for (Cookie c :cookies){
		%>
			<tr>
				<td><%=c.getName()%></td>
				<td><%=c.getValue()%></td>
			</tr>
		<%
			}
		%>
	</table>

	<a href="index.jsp">Volver</a>
</body>
</html>
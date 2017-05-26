<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
td{
	border:solid;
	border-width:1px;
	border-color:black;
}
</style>
</head>
<body>
	<table>
		<%
			Integer n = (Integer) request.getAttribute("n");
		%>
		<thead>
		<td colspan="10">Tabla de multiplicar del <%= n %></td>
		</thead>
		<tr>
			<%
				for (int i = 1; i <= 10; i++) {
			%>
			<td><%=i%></td>
			<%
				}
			%>
		</tr>
		<tr>
			<%
				for (int i = 1; i <= 10; i++) {
			%>
			<td><%=(i * n)%></td>
			<%
				}
			%>
		</tr>
	</table>
    <a href="index.html">Volver</a>
</body>
</html>>
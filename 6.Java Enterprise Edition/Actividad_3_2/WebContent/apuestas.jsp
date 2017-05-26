<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generador de series</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<h1>APUESTAS</h1>
	<%@page import="java.util.Random"%>
	<%
		String sNapuestas = request.getParameter("apuestas");
			int nApuestas = Integer.parseInt(sNapuestas);
			Random rnd = new Random(System.currentTimeMillis());
	%>
	<table>
		<%
			for (int i = 0; i < nApuestas; i++) {
		%>
		<tr>
			<td class="cabFila">Apuesta numero: <%=i+1%></td>
			<%
				for (int j = 0; j < 6; j++) {
					int n=rnd.nextInt(49)+1;
			%>
			<td class="celda"><%= n %></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
		<tr>
		<td class="pie" colspan="7"><a href="index.html">Volver al inicio</a></td>
		</tr>
	</table>
</body>
</html>
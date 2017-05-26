<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.Random"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Saludo</title>
<style type="text/css">
hr {
	border-style: inset;
	border-width: 2px;
	border-color: #FE2E2E
}

h1 {
	background: #CEF6D8;
	font-family: Georgia, Times New Roman, Serif
}
{
color


:

 

gray


;
font-family


:

 

Verdana


;
font-size


:

 

10
pt

 

}
</style>
</head>
<body>
	<% Random aleatorio = new Random();%>
	<%
		int veces = aleatorio.nextInt(12) + 2;
	%>
	<%
		for (int i = 1; i <= veces / 2; i++) {
	%>
	<hr>
	<%
		}
	%>
	<h1>Hola Mundo !!!</h1>
	<p>Este es un JSP sencillo</p>
	<%
		for (int i = 1; i <= veces / 2; i++) {
	%>
	<hr>
	<%
		}
	%>
	<p>
		<a href="index.jsp">Recargar index.jsp</a>
	</p>
</body>
</html>
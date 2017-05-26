<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="mistags" prefix="facil"%>
<html>
<head>
<title>JSP Page</title>
</head>
<body>
	<h1>
		<facil:doble numero="1.5" />
	</h1>
	<h3>
		<facil:doble numero="3.5">
			<h2>Calculo hecho</h2>
		</facil:doble>
	</h3>
</body>
</html>
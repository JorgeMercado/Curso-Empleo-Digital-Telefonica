<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		Numero de usuarios conectados:<%=request.getAttribute("numeroUsuarios")%></div>
	<div>
		Numero de usuarios logados:
		<%=request.getAttribute("numeroLogados")%></div>
	<script>
		window.setTimeout("window.location='Index';", 3000);
	</script>
</body>
</html>
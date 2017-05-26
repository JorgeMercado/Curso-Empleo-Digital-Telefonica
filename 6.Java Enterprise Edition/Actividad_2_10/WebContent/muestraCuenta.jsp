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
		Sesion:
		<%=request.getAttribute("id")%>
		Numero de peticiones en esta sesioin:
		<%=request.getAttribute("nSesion")%>
	</div>
	<div>
		Numero de peticiones total:
		<%=request.getAttribute("totalPeticiones")%>
	</div>
	<div>
		Numero de accesos al servlet desde su instanciacion:
		<%=request.getAttribute("numeroAccesosServlet")%>
	</div>
	<div>
		<a href="CuentaAccesos">Recargar</a>
	</div>
	<div>
		<a href="CerrarSesion">Cerrar sesion</a>
	</div>
</body>
</html>
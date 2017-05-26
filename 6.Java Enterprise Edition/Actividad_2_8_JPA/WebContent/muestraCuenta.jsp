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
		Sesion: ${id}
		Numero de peticiones en esta sesioin: ${nSesion}
	</div>
	<div>
		Numero de peticiones total: ${totalPeticiones}
	</div>
	<div>
	<a href="CuentaAccesos">Recargar</a>
	</div>
	<div>
	<a href="CerrarSesion">Cerrar sesion</a>
	</div>
</body>
</html>
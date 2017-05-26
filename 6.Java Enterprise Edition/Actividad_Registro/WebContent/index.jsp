<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecera.jsp">
	<jsp:param name="tituloPagina" value="Los Javatos - Formulario registro" />
</jsp:include>

<form action="registro.jsp" method="POST">
	<label for="nombre">Nombre: </label>
	<input type="text" name="nombre" id="nombre" placeholder="Nombre aquí">
	<br/>
	<label for="password">Password: </label>
	<input type="password" name="password" id="password" placeholder="Contraseña aquí">
	<br/>
	<label for="edad">Edad: </label>
	<input type="text" name="edad" id="edad" placeholder="Edad aquí">
	<br/>
	<button type="submit">Efectuar registro</button>
</form>
<jsp:include page="pie.jsp"/>
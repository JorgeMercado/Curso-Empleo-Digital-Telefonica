<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp">
	<jsp:param name="tituloPagina" value="Pagina prrincipal" />
</jsp:include>

<form action="informe.jsp" method="POST">
	<label for="nombre">Nombre: </label> <input type="text" name="nombre"
		placeholder="Nombre aqui"> <br /> <label for="apellidos">Apellidos:
	</label> <input type="text" name="apellidos" placeholder="Apellidos aqui">
	<br /> <label for="telefono">Telefono: </label> <input type="text"
		name="telefono" placeholder="Telefono aqui"> <br /> <label
		for="numero">Numero: </label> <input type="number" name="numero"
		placeholder="Numero aqui"> <br />
	<button type="submit">Enviar</button>
</form>

<jsp:include page="footer.jsp" />
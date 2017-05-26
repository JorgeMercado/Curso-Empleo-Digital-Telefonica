<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="errores.jsp" %> 
<jsp:include page="header.jsp">
	<jsp:param name="tituloPagina" value="Resultado" />
</jsp:include>
<%-- <jsp:param name="tituloPagina" value="Resultado" /> esto es una accion --%>
<%
String nombre=request.getParameter("nombre");
String apellidos=request.getParameter("apellidos");
String telefono=request.getParameter("telefono");
String stNumero=request.getParameter("numero");
int numero=0;

numero=Integer.parseInt(stNumero);
if(!nombre.trim().isEmpty() && !apellidos.trim().isEmpty() 
		&& !telefono.trim().isEmpty() ){ %>
		
	<table>
		<tr>
			<td>Nombre: </td>
			<td><%= nombre %></td>
		</tr>
		<tr>
			<td>Apellidos: </td>
			<td><%= apellidos %></td>
		</tr>
		<tr>
			<td>Telefono:</td>
			<td><%= telefono %></td>
		</tr>
	</table>
	<div style="font-size:2em;color:blue;">
	El numero introducido ha sido <%= numero %>
	</div>
	<%
	if(numero%2==0){ %>
		<jsp:include page="par.html"/>
	<% }
	
	if(numero%3==0){ %>
		<jsp:include page="mul3.html"/>
	<% }
	
	if(numero%5==0){ %>
		<jsp:include page="mul5.html"/>
	<% }
	%>
<% }
else{ 
	throw new NullPointerException("Faltan datos");
}


	

%>

<jsp:include page="footer.jsp"/>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true" %>

<%
	if(exception instanceof NumberFormatException){ %>
		<div style="font-size:3em;color:red;">
Atencion. Numero mal formado.
</div>
<script>window.setTimeout("window.location='index.jsp';",3000);</script>
	<% }
	else{ %>
		<div style="font-size:3em;color:red;">
		Atencion. Faltan datos en el formulario

		</div>
		<script>window.setTimeout("window.location='index.jsp';",3000);</script>
	<% }
%>
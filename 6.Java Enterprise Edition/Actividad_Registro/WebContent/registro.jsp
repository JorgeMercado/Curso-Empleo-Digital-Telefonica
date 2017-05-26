<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="dao.ResultadoCRUD,java.util.ArrayList,modelos.UsuarioBean"%>
<jsp:include page="cabecera.jsp">
	<jsp:param name="tituloPagina" value="Los Javatos - Usuario registrado" />
</jsp:include>

<jsp:useBean id="usuario" class="modelos.UsuarioBean" scope="request">
	<jsp:setProperty name="usuario" property="nombre" />
	<jsp:setProperty name="usuario" property="edad" value="${edad}"/>
</jsp:useBean>

<jsp:useBean id="dao" class="dao.DAOUsuarioBean" scope="application" />

<%
	if (dao.create(usuario, request.getParameter("password")) == ResultadoCRUD.OK) {
		ArrayList<UsuarioBean> lista = dao.listar();
%>
<div>Usuarios registrados hasta ahora</div>
<table>
	<tr>
		<td>Nombre</td>
		<td>Edad</td>
	</tr>
	<%
		for (UsuarioBean u : lista) {
	%>
	<tr>
		<td><%=u.getNombre()%></td>
		<td><%=u.getEdad()%></td>
	</tr>
	<%
		}
	%>
</table>


<%
	} else {
%>
<div>Usuario ya existe.</div>
<%
	}
%>

<jsp:include page="volver.jsp"/>
<jsp:include page="pie.jsp" />
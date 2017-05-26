<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.ResultadoCRUD"%>
<jsp:useBean id="PeticionSoporteBeanId" scope="request"
	class="modelos.PeticionSoporteBean">
	<jsp:setProperty name="PeticionSoporteBeanId" property="email"
		param="email"/>
	<jsp:setProperty name="PeticionSoporteBeanId" property="so"
		param="so"/>
	<jsp:setProperty name="PeticionSoporteBeanId" property="sw"
		param="sw"/>
	<jsp:setProperty name="PeticionSoporteBeanId" property="problema"
		param="problema"/>
</jsp:useBean>
<jsp:useBean id="DAOPeticionSoporteBeanId" scope="request"
	class="dao.DAOPeticionSoporteBean" />"
<%
	if (DAOPeticionSoporteBeanId.create(PeticionSoporteBeanId) == ResultadoCRUD.OK) {
%>
<jsp:forward page="Registrado.html" />

<%
	} else {
%>
<jsp:forward page="NoRegistrado.html" />
<%
	}
%>
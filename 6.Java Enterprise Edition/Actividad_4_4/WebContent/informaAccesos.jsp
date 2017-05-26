<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <div>
	Numero de accesos totales:<%=request.getAttribute("nAccesosPaginas")%>
</div>
<div>
	Numero de usuarios conectados:<%=request.getAttribute("numeroUsuarios")%></div>
<div>
	Numero de usuarios logados:
	<%=request.getAttribute("numeroLogados")%>
</div>
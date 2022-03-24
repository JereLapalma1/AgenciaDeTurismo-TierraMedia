<!-- Inicio proteccion anti usuarios sin sesion activa -->
<%
if (session.getAttribute("usuario") == null) {
%>
<jsp:forward page="login.jsp" />
<%
}
%>
<!-- Fin proteccion anti usuarios sin sesion activa -->
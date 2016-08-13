<%-- 
    Document   : eliminarProfesor
    Created on : Aug 13, 2016, 1:40:24 AM
    Author     : Gianfranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/prueba.js" type="text/javascript"></script>
    </head>
    <body>
        <div><jsp:include page="cabecera.jsp"/></div>
        <div><jsp:include page="menuAdministrador.jsp"/></div>

        <c:if test="${requestScope.error != null}">
            <p><h4>${requestScope.error}</h4></p>
        </c:if>
    <br>
    <h3>Haga click en el alumno para escogerlo</h3>
    <table id="tablaAlum" border="1">
        <thead>
            <TR><TH colspan="4">Tabla Alumno</TH></TR>
            <tr>
                <th>
                    Email
                </th>
                <th>
                    Usuario
                </th>
                <th>
                    Nombres 
                </th>
                <th>
                    Apellidos
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="r" items="${listaAlum}">
                <tr>
                    <td id="usuario" >${r.usuario}</td>
                    <td id="nombre">${r.nombres}</td>
                    <td id="apellidos">${r.apellidos}</td>
                    <td id="email">${r.email}</td>
                </tr>
            </c:forEach>
        </tbody> 
    </table>
    <br>
    <div>
        <form method="post" action="ElimAlum2">
            <input type="text" readonly="true" id="nomAlum" name="ALUMNO">
            <input type="submit" value=Eliminar> 
        </form>
    </div>
</body>
</html>

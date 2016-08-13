<%-- 
    Document   : registroProfesor.jsp
    Created on : 11/08/2016, 01:01:09 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="cabecera.jsp"/></div>
        <div><jsp:include page="menuAdministrador.jsp"/></div>
        <h1>Registro Profesor</h1>
        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
    <c:if test="${requestScope.error != null}">
        <p>${requestScope.error}</p>
    </c:if>
    <form action="ProfesorRegistro" method="post">
        <table>
            <tr>
                <td>Usuario:</td>
                <td><input type="text" name="usuario" value="${requestScope.usuario}" required/> </td>
            </tr>
            <tr>
                <td>Nombre Completo:</td>
                <td><input type="text" name="nombres" value="${requestScope.nombres}" required/> </td>
            </tr>
            <tr>
                <td>DNI:</td>
                <td><input type="text" name="dni" value="${requestScope.dni}" required/> </td>
            </tr>
            <tr>
                <td>Estudios:</td>
                <td><input type="text" name="estudios" value="${requestScope.estudios}" required/> </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required/> </td>
            </tr>
            <tr>
                <td>Confirmar Password:</td>
                <td><input type="password" name="confirm-password" required/> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Registrar"/> </td>
            </tr>
        </table>
    </form>
</body>
</html>

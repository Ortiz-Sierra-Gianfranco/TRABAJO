<%-- 
    Document   : registroAlumno
    Created on : 10/08/2016, 11:12:23 AM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
    </head>
    <body>
        <div><jsp:include page="cabecera.jsp"/></div>
        <div><jsp:include page="menuAdministrador.jsp"/></div>
        <h1>Registro Alumno</h1>
        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
        <form action="AlumnoRegistro" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td>
                        <input type="text" name="usuario" value="<c:if test='${requestScope.usuario != null}'>${requestScope.usuario}</c:if>" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>Nombres:</td>
                        <td>
                            <input type="text" name="nombres" value="<c:if test='${requestScope.usuario != null}'>${requestScope.nombres}</c:if>" required=""/> </td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td>
                            <input type="text" name="apellidos" value="${requestScope.apellidos}<c:if test='${requestScope.apellidos != null}'>${requestScope.apellidos}</c:if>" required=""/> 
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input type="email" name="email" value="<c:if test='${requestScope.email != null}'>${requestScope.email}</c:if>" required/>
                    </td>
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

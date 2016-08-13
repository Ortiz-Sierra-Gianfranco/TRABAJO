<%-- 
    Document   : configuracionAlumno
    Created on : 10/08/2016, 03:36:19 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
    </head>
    <body>
        <div><jsp:include page="cabecera.jsp"/></div>  
        <div><jsp:include page="menuAlumno.jsp"/></div>
        <h1>CAMBIAR CONTRASEÑA</h1>
        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
        <form action="AlumnoContraseña" method="post">
            <table>
                <tr>
                    <td>Nueva Contraseña:</td>
                    <td><input type="password" name="password" required/> </td>
                </tr>
                <tr>
                    <td>Confirmar contraseña:</td>
                    <td><input type="password" name="confirm-password" required/> </td>
                </tr>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario" value="${sessionScope.usuario.usuario}" readonly="readonly"/> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cambiar Contraseña"/> </td>
                </tr>
            </table>
        </form>

    </body>
</html>

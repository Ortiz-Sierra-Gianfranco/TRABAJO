<%-- 
    Document   : actualizaAlumno
    Created on : 10/08/2016, 01:21:55 PM
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
        <h1>Actualizar Datos</h1>
        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
        <form method="post" action="AlumnoActualizar">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario" value="${sessionScope.usuario.usuario}" readonly="readonly"/> </td>
                </tr>
                <tr>
                    <td>Nombres:</td>
                    <td><input type="text" name="nombres" value="${sessionScope.usuario.nombres}" required/> </td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellidos" value="${sessionScope.usuario.apellidos}" required/> </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" value="${sessionScope.usuario.email}" required/> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar"/> </td>
                </tr>
            </table>
        </form>
    </body>
</html>

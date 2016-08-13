<%-- 
    Document   : matriculaAlumno
    Created on : 11/08/2016, 04:54:16 PM
    Author     : USUARIO
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="seguro.jsp"/>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
    </head>
    <body>
        <div><jsp:include page="cabecera.jsp"/></div>
        <div><jsp:include page="menuAlumno.jsp"/></div>
        <h1>Matricular Alumno</h1>
        <%
            Date dNow = new Date();
            int anio = Integer.parseInt(String.valueOf(dNow.getYear()));
            anio=anio+1900;
        %>

        <%
            if (request.getAttribute("info") != null) {
                out.print("<p>" + request.getAttribute("info").toString() + "</p>");
            }
        %>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
        <form method="post" action="AlumnoMatricular">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario" value="${sessionScope.usuario.usuario}" readonly="readonly"/> </td>
                </tr>
                <tr>
                    <td>Codigo Matricula:</td>
                    <td><input type="text" name="codigo"/> </td>
                </tr>
                <tr>
                    <td>Grado:</td>
                    <td><select name="grado">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Año:</td>
                    <td><input type="text" name="anio" value="<%=anio%>" readonly="readonly"/> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Matricularse"/> </td>
                </tr>
            </table>
        </form>
    </body>
</html>

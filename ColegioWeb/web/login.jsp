<%-- 
    Document   : login
    Created on : Aug 11, 2016, 8:21:49 PM
    Author     : Gianfranco
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${requestScope.error != null }">
            <p>${requestScope.error}</p>
        </c:if>
        <form action="login.do" method="post">
            <center> 
                <table border="1" 
                       style="
                       position:absolute;
                       top: 35%;
                       left: 40%;
                       ">
                    <tbody>
                        <tr>
                            <td rowspan="4"><img src="img/user_login.png" /></td>
                            <td colspan="2">
                                <select name="NIVELUSUARIO">
                                    <option>Alumno</option>
                                    <option>Profesor</option>
                                    <option>Administrador</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Usuario</td>
                            <td><input type="text" name="usuario"></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit"></td>
                        </tr>
                    </tbody>
                </table>
            </center>
        </form>
    </body>
</html>

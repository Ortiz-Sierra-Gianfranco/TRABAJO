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
        <h3>Haga click en el profesor para escogerlo</h3>
        <table id="tablaProfElim" border="1">
            <thead>
                <TR><TH colspan="4">Tabla Profesores</TH></TR>
                <tr>
                    <th>
                        Usuario
                    </th>
                    <th>
                        Nombres y Apellidos
                    </th>
                    <th>
                        DNI
                    </th>
                    <th>
                        Estudios
                    </th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="r" items="${listaProf}">
                <tr>
                    <td class ="prof" id="usuario" >${r.usuario}</td>
                    <td class="prof">${r.nombres}</td>
                    <td class="prof">${r.dni}</td>
                    <td class="prof">${r.estudios}</td>
                </tr>
            </c:forEach>
        </tbody> 
    </table>
    <br>
    <div>
        <form method="post" action="ElimProf2">
            <input type="text" readonly="true" id="nomProf" name="PROFESOR" required="true">
            <input type="submit" value=Eliminar> 
        </form>
    </div>
</body>
</html>

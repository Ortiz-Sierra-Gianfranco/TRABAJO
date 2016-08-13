<%-- 
    Document   : modificarProfeCurso
    Created on : Aug 13, 2016, 9:19:39 AM
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
            <p>${requestScope.error}</p>
        </c:if>
        <h3>Haga click en una clase para modificarla</h3>
        <table id="tablaModif" border="1">
            <thead>
                <tr>
                    <th>
                        Profesor
                    </th>
                    <th>
                        Curso
                    </th>
                    <th>
                        Grado
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${listaProfCurso}">
                    <tr>
                        <td hidden="">${r.codCurProf}</td>
                        <td hidden="">${r.codigoProfesor}</td>
                        <td>${r.nombreProfesor}</td>
                        <td>${r.codigoCurso}</td>
                        <td>${r.grado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <form method="post" action="ModifProfCurso2">
            <p><h3>Haga click en un nuevo profesor para escogerlo</h3></p>
        <table id="tablaProf" border="1">
            <thead>
                <TR><TH colspan="4">Tabla Profesores</TH></TR>
                <tr>
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
                        <td class="prof" hidden="">${r.usuario}</td>
                        <td class="prof">${r.nombres}</td>
                        <td class="prof">${r.dni}</td>
                        <td class="prof">${r.estudios}</td>
                    </tr>
                </c:forEach>
            </tbody> 
        </table>
        <p>
            Profesor: <input type="text" name="usuarioProf" readonly id="profUSUARIO" hidden="">
            <input type="text" readonly=true id="PROFESOR" required="true">
            Curso: <input type="text" name="codigoCurso" readonly id="cursoCODIGO" hidden="" >
            <input type="text" readonly=true id="CURSO" required="true">
            Grado: 
            <input id=GRADO name="GRADO" readonly="true" required="true">
            <input type="submit" value="MODIFICAR">
        </p>
    </form>
</body>
</html>

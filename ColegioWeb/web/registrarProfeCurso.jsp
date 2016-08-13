<%-- 
    Document   : RegistrarProfeCurso
    Created on : Aug 11, 2016, 11:42:41 PM
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
        <form method="post" action="AsigProfCurso2">
            <p><h3>Haga click en un profesor para escogerlo</h3></p>
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
        <p>Grado: 
            <select name="GRADO">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
            </select>
        </p>
        <p>
            Curso: <select name="CURSO">
                <c:forEach var="curso" items="${listaCurso}">
                    <option>${curso.codigo}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            Profesor: <input type="text" name="usuarioProf" readonly id="profUSUARIO" >
            <input type="text" readonly=true id="PROFESOR">
        </p> 
        <input type="submit" value="REGISTRAR CURSO">
    </form>
</body>
</html>

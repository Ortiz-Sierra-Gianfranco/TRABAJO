<%-- 
    Document   : verCursos
    Created on : Aug 13, 2016, 10:17:25 AM
    Author     : Gianfranco
--%>

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
        <div><jsp:include page="menuProfesor.jsp"/></div>

        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
        <table border="1">
            <thead>
                <tr>
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
                        <td>${r.codigoCurso}</td>
                        <td>${r.grado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

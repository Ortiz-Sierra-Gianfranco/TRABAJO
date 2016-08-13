<%-- 
    Document   : notasAlumno
    Created on : Aug 11, 2016, 11:26:13 PM
    Author     : Gianfranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
    </head>
    <body>
        <div><jsp:include page="cabecera.jsp"/></div>
        <div><jsp:include page="menuAlumno.jsp"/></div>
    
        <table border="1">
            <thead>
                <tr>
                    <th rowspan="2">
                        Curso:
                    </th>
                    <th colspan="3">
                        Notas
                    </th>
                </tr>
                <tr>
                    <th>Ex. Par</th>
                    <th>Ex. Fin</th>
                    <th>Prom. Prác</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Computación
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        <a href="#">Editar</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        Ciencia y Ambiente
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        <a>Editar</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        Matemáticas
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        12
                    </td>
                    <td>
                        <a>Editar</a>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>

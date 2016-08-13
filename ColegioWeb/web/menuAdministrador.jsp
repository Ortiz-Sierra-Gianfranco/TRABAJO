<%-- 
    Document   : menuAdministrador
    Created on : 11/08/2016, 03:09:42 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
        <link rel="stylesheet" type="text/css" href="css/estilosAdministrador.css">
    </head>
    <body>
        <ul>
            <li><a href="administrador.jsp">Inicio</a></li>
            <li class="dropdown"><a href="#" class="dropbtn">Clases</a>
                <div class="dropdown-content">
                    <a href="AsigProfCurso">Asignar Profesores</a>
                    <a href="ModifProfCurso">Modificar</a>
                </div>
            </li>
            <li class="dropdown"><a href="#" class="dropbtn">Profesores</a>
                <div class="dropdown-content">
                    <a href="registroProfesor.jsp">Registrar</a>
                    <a href="ElimProf">Eliminar</a>
                </div>
            </li>
            <li class="dropdown"><a href="#" class="dropbtn">Alumnos</a>
                <div class="dropdown-content">
                    <a href="registroAlumno.jsp">Registrar</a>
                    <a href="ElimAlum">Eliminar</a>
                </div>
            </li>
            <li class="dropdown"><a href="#" class="dropbtn">Reportes</a>
                <div class="dropdown-content">
                    <a href="#">Alumnos</a>
                    <a href="#">Alumnos Matriculados</a>
                    <a href="#">Profesores</a>
                    <a href="#">Cursos</a>
                </div>
            </li>
        </ul>

    </body>
</html>

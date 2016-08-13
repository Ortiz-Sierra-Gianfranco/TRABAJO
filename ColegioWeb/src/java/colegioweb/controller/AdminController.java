/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.controller;

import colegioweb.service.AlumnoService;
import colegioweb.service.CursoProfesorService;
import colegioweb.service.CursoService;
import colegioweb.service.ProfesorService;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet()
public class AdminController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() == null) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        String path = request.getServletPath();
        switch (path) {
            case "/AsigProfCurso":
                asignarProfe(request, response);
                break;
            case "/AsigProfCurso2":
                registrarDatosProfe(request, response);
                break;
            case "/ModifProfCurso":
                modifProfeCurso(request, response);
                break;
            case "/ModifProfCurso2":
                modifProfCursoDatos(request, response);
                break;
            case "/ElimProf":
                eliminarProfesor(request, response);
                break;
            case "/ElimProf2":
                eliminarProfesorDatos(request, response);
                break;
            case "/ElimAlum":
                EliminarAlumno(request, response);
                break;
            case "/ElimAlum2":
                EliminarAlumnoDatos(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void asignarProfe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object listaProf;
        ProfesorService profServ = new ProfesorService();
        listaProf = profServ.getProfesores();
        Object listaCurso;
        CursoService cursoServ = new CursoService();
        listaCurso = cursoServ.readAll();
        try {
            HttpSession session = request.getSession();
            if (listaCurso != null) {
                request.setAttribute("listaCurso", listaCurso);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
            if (listaProf != null) {
                request.setAttribute("listaProf", listaProf);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("registrarProfeCurso.jsp");
            rd.forward(request, response);
        }

    }

    private void eliminarProfesor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Object listaProf;
        ProfesorService profServ = new ProfesorService();
        listaProf = profServ.getProfesores();
        try {
            HttpSession session = request.getSession();
            if (listaProf != null) {
                request.setAttribute("listaProf", listaProf);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("eliminarProfesor.jsp");
            rd.forward(request, response);
        }
    }

    private void EliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object listaAlum;
        AlumnoService alumServ = new AlumnoService();
        listaAlum = alumServ.getAlumnos();
        try {
            HttpSession session = request.getSession();
            if (listaAlum != null) {
                request.setAttribute("listaAlum", listaAlum);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("eliminarAlumno.jsp");
            rd.forward(request, response);
        }
    }

    private void registrarDatosProfe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CursoProfesorService cps = new CursoProfesorService();
        try {
            if (request.getParameter("usuarioProf") == null) {
                throw new IllegalArgumentException("Ingrese un Profesor a Registrar");
            }
            cps.registrarDatos(request.getParameter("GRADO"), request.getParameter("usuarioProf"), request.getParameter("CURSO"));
        } catch (IllegalArgumentException | SQLException e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/AsigProfCurso");
            rd.forward(request, response);
        }
    }

    private void eliminarProfesorDatos(HttpServletRequest request, HttpServletResponse response) {
        boolean eliminar;
        ProfesorService prServ = new ProfesorService();
        try {
            prServ.delete(request.getParameter("PROFESOR"));

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/ElimProf");
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void EliminarAlumnoDatos(HttpServletRequest request, HttpServletResponse response) {
        AlumnoService alServ = new AlumnoService();
        try {
            String del = request.getParameter("ALUMNO");
            if (alServ.delete(del)) {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/ElimAlum");
                rd.forward(request, response);
            }
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void modifProfeCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Object listaProfCurso;
        CursoProfesorService csp = new CursoProfesorService();
        listaProfCurso = csp.readAll();
        Object listaProf;
        ProfesorService profServ = new ProfesorService();
        listaProf = profServ.getProfesores();
        try {
            HttpSession session = request.getSession();
            if (listaProf != null) {
                request.setAttribute("listaProf", listaProf);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
            if (listaProfCurso != null) {
                request.setAttribute("listaProfCurso", listaProfCurso);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("modificarProfeCurso.jsp");
            rd.forward(request, response);
        }
    }

    private void modifProfCursoDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CursoProfesorService cps = new CursoProfesorService();
        try {
            cps.modificarProfesor(request.getParameter("codigoCurso"), request.getParameter("usuarioProf"));
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/ModifProfCurso");
            rd.forward(request, response);
        }
    }
}

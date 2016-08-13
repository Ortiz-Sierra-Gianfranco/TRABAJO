/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.controller;

import colegioweb.domain.Profesor;
import colegioweb.service.CursoProfesorService;
import colegioweb.service.ProfesorService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ProfesorRegistro", "/ProfesorActualizar", "/ProfesorContraseña", "/VerCursos"})
public class ProfesorController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() == null) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

        String path = request.getServletPath();
        switch (path) {
            case "/ProfesorRegistro":
                profesorRegistro(request, response);
                break;
            case "/ProfesorActualizar":
                profesorActualizar(request, response);
                break;
            case "/VerCursos":
                verCursos(request, response);
                break;
            case "/ProfesorContraseña":
                profesorCambiarContraseña(request, response);
                break;
            default:
                break;
        }

    }

    private void profesorRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta, usuario = "", nombres = "", dni = "", estudios = "";
        try {
            //Verifica password
            String password = request.getParameter("password");
            String confirmpass = request.getParameter("confirm-password");
            //Datos
            usuario = request.getParameter("usuario");
            nombres = request.getParameter("nombres");
            dni = request.getParameter("dni");
            estudios = request.getParameter("estudios");
            if (password.equals(confirmpass)) {
                //Proceso
                ProfesorService service = new ProfesorService();
                Profesor bean = new Profesor(usuario, nombres, dni, estudios, password);
                HttpSession session = request.getSession();
                //Insertar Alumno
                rpta = service.insertar(bean);
                if (rpta.equals("OK")) {
                    request.setAttribute("info", "Profesor registrado correctamente.");
                }
            } else {
                request.setAttribute("error", "Las constraseñas no coinciden");
                request.setAttribute("usuario", usuario);
                request.setAttribute("nombres", nombres);
                request.setAttribute("dni", dni);
                request.setAttribute("estudios", estudios);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("usuario", usuario);
            request.setAttribute("nombres", nombres);
            request.setAttribute("dni", dni);
            request.setAttribute("estudios", estudios);
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("registroProfesor.jsp");
        rd.forward(request, response);
    }

    private void profesorActualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta, usuario = "", nombres = "", dni = "", estudios = "";
        try {
            //Datos
            usuario = request.getParameter("usuario");
            nombres = request.getParameter("nombres");
            dni = request.getParameter("dni");
            estudios = request.getParameter("estudios");
            //Proceso
            ProfesorService service = new ProfesorService();
            Profesor bean = new Profesor();
            bean.setUsuario(usuario);
            bean.setNombres(nombres);
            bean.setDni(dni);
            bean.setEstudios(estudios);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", bean);
            //Actualizar Alumno
            rpta = service.actualizar(bean);
            if (rpta.equals("OK")) {
                request.setAttribute("info", "Alumno actualizado correctamente.");
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("actualizaProfesor.jsp");
        rd.forward(request, response);
    }

    private void profesorCambiarContraseña(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpta = "";
        try {
            //Datos
            String pass = request.getParameter("password");
            String confpass = request.getParameter("confirm-password");
            String usuario = request.getParameter("usuario");
            if (pass.equals(confpass)) {
                //Proceso
                ProfesorService service = new ProfesorService();
                rpta = service.cambiarContraseña(pass, usuario);
                if (rpta.equals("OK")) {
                    request.setAttribute("info", "Se actualizo correctamente la contraseña");
                }
            } else {
                request.setAttribute("error", "Las contraseñas no coinciden");
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("configuracionProfesor.jsp");
        rd.forward(request, response);
    }

    private void verCursos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object listaProfCurso;
        CursoProfesorService csp = new CursoProfesorService();
        Profesor bean = (Profesor) request.getSession().getAttribute("usuario");
        String usuario;
        usuario = bean.getUsuario();
        listaProfCurso = csp.verCursos(usuario);
        try {
            if (listaProfCurso != null) {
                request.setAttribute("listaProfCurso", listaProfCurso);
            } else {
                throw new IllegalArgumentException("No hay profesores registrados");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("verCursos.jsp");
            rd.forward(request, response);
        }

    }

}

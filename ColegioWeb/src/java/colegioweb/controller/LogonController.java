/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.controller;

import colegioweb.service.LogonService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet()
public class LogonController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {
            case "/login.do":
                loginUsuario(request, response);
                break;
            case "/registrar.do":
                resgistrarUsuario(request, response);
                break;
            case "/logout.do":
                logonSalir(request, response);
                break;
            default:
                break;
        }

    }

    private void logonSalir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response) {
        try {
            String destino;
            try {

                // Datos
                String usuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                // Proceso
                LogonService service = new LogonService();
                String tipoUsuario = request.getParameter("NIVELUSUARIO");
                Object bean = null;
                switch (tipoUsuario) {
                    case "Administrador":
                        destino = "administrador.jsp";
                        bean = service.validarAdmi(usuario, password);
                        break;
                    case "Alumno":
                        destino = "alumno.jsp";
                        bean = service.validarAlumno(usuario, password);
                        break;
                    case "Profesor":
                        destino = "profesor.jsp";
                        bean = service.validarProfesor(usuario, password);
                        break;
                    default:
                        destino = "login.jsp";
                }
                if (bean == null) {
                    throw new IllegalArgumentException("EL BEAN ES NULL");
                }
                // Guardar usuario en session
                HttpSession session = request.getSession();
                session.setAttribute("usuario", bean);
                //session.setMaxInactiveInterval(60);
                System.err.println("Time out:" + session.getMaxInactiveInterval());
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                destino = "login.jsp";
            }
            RequestDispatcher rd;
            rd = request.getRequestDispatcher(destino);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LogonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void resgistrarUsuario(HttpServletRequest request, HttpServletResponse response) {
        String tipoUsuario = request.getParameter("");
        if (tipoUsuario.equals("")) {
        }
    }

}

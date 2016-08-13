/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Administrador;
import colegioweb.domain.Alumnos;
import colegioweb.domain.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogonService {

    private static final AccesoDB cn = AccesoDB.saberEstado();

    public Alumnos validarAlumno(String usuario, String password) {
        Alumnos bean = null;
        try {
            String sql = "select * from alumnos "
                    + "where usuario = ? "
                    + "and password = ?";
            try (PreparedStatement pstm = cn.getCnn().prepareStatement(sql)) {
                pstm.setString(1, usuario);
                pstm.setString(2, password);
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        bean = new Alumnos();
                        bean.setUsuario(rs.getString("usuario"));
                        bean.setNombres(rs.getString("nombres"));
                        bean.setApellidos(rs.getString("apellidos"));
                        bean.setEmail(rs.getString("email"));
                        bean.setPassword(rs.getString("password"));
                        bean.setMatriculado(rs.getString("matriculado"));
                    } else {
                        throw new RuntimeException("Datos incorrectos.");
                    }
                }
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return bean;
    }

    public Profesor validarProfesor(String usuario, String password) {
        Profesor bean = null;

        try {

            String sql = "select * from profesor "
                    + "where usuario = ? "
                    + "and password = ?";
            try (PreparedStatement pstm = cn.getCnn().prepareStatement(sql)) {
                pstm.setString(1, usuario);
                pstm.setString(2, password);
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        bean = new Profesor();
                        bean.setUsuario(rs.getString("usuario"));
                        bean.setNombres(rs.getString("nombres"));
                        bean.setDni(rs.getString("dni"));
                        bean.setEstudios(rs.getString("estudios"));
                        bean.setPassword(rs.getString("password"));
                    } else {
                        throw new RuntimeException("Datos incorrectos.");
                    }
                }
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return bean;
    }

    public Administrador validarAdmi(String usuario, String password) {
        Administrador bean = null;
        try {
            String sql = "select * from administrador "
                    + "where usuario = ? "
                    + "and password = ?";
            try (PreparedStatement pstm = cn.getCnn().prepareStatement(sql)) {
                pstm.setString(1, usuario);
                pstm.setString(2, password);
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        bean = new Administrador();
                        bean.setUsuario(rs.getString("usuario"));
                        bean.setNombres(rs.getString("nombres"));
                        bean.setPassword(rs.getString("password"));
                    } else {
                        throw new RuntimeException("Datos incorrectos.");
                    }
                }
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return bean;
    }
}

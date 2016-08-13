/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class ProfesorService {

    private static final AccesoDB cn = AccesoDB.saberEstado();
    private static final String SQL_DELETE = "DELETE FROM profesor WHERE usuario=?";
    private static final String SQL_VER_CURSOS = "SELECT * FROM profesorcursosvista";

    public String insertar(Profesor bean) {
        String rpta = "";

        try {

            String sql = "INSERT INTO profesor (usuario,nombres,dni,estudios"
                    + ",password) VALUES (?,?,?,?,?)";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, bean.getUsuario());
            psd.setString(2, bean.getNombres());
            psd.setString(3, bean.getDni());
            psd.setString(4, bean.getEstudios());
            psd.setString(5, bean.getPassword());
            int n1 = psd.executeUpdate();
            if (n1 > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public String actualizar(Profesor bean) {
        String rpta = "";

        try {

            String sql = "UPDATE profesor SET nombres=?,dni=?,estudios=? WHERE usuario=?";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, bean.getNombres());
            psd.setString(2, bean.getDni());
            psd.setString(3, bean.getEstudios());
            psd.setString(4, bean.getUsuario());
            int n1 = psd.executeUpdate();
            if (n1 > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public String cambiarContraseña(String pass, String usuario) {
        String rpta = "";

        try {

            String sql = "UPDATE profesor SET password=? WHERE usuario=?";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, pass);
            psd.setString(2, usuario);
            int n = psd.executeUpdate();
            if (n > 0) {
                rpta = "OK";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

    public List<Profesor> getProfesores() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Profesor> profesores = new ArrayList();
        try {
            ps = cn.getCnn().prepareStatement("select * from profesor");
            rs = ps.executeQuery();
            while (rs.next()) {
                profesores.add(new Profesor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
        return profesores;
    }

    public boolean delete(Object key) {
        try {
            PreparedStatement psd = cn.getCnn().prepareStatement(SQL_DELETE);
            psd.setString(1, key.toString());
            if (psd.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.cerrarConexion();
        }
        return false;
    }

}

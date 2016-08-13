/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Horarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Gianfranco
 */
public class CursoProfesorService {

    private static final AccesoDB cn = AccesoDB.saberEstado();

    private static final String SQL_INSERTAR_UNA_FILA = "INSERT INTO profesorcurso (codigoProfesor,codigoCurso,grado) VALUES(?,?,?);";
    private static final String SQL_UPDATE_BY_PROFESOR = "UPDATE profesorcurso set codigoProfesor=? where idProfesorCurso=?";
    private static final String SQL_READ_BY_CURSO_GRADO = "SELECT idProfesorCurso FROM profesorcurso where codigoCurso=? and grado=?";
    private static final String SQL_READALL = "SELECT * FROM CursosAsignados";
    private static final String SQL_VER_CURSOS = "SELECT * FROM CursosAsignados WHERE codigoProfesor=?";

    public boolean registrarDatos(Object grado, Object profUsuario, Object curso) throws SQLException {
        PreparedStatement ps;
        try {
            ps = cn.getCnn().prepareStatement(SQL_INSERTAR_UNA_FILA);
            ps.setString(1, profUsuario.toString());
            ps.setString(2, curso.toString());
            ps.setString(3, grado.toString());
            ps.executeUpdate();
            return true;
        } finally {
            cn.cerrarConexion();
        }
    }

    public boolean modificarProfesor(Object idProfCur, Object profUsuario) throws SQLException {
        PreparedStatement ps;
        try {
            ps = cn.getCnn().prepareStatement(SQL_UPDATE_BY_PROFESOR);
            ps.setString(1, profUsuario.toString());
            ps.setString(2, idProfCur.toString());
            ps.executeUpdate();
            return true;
        } finally {
            cn.cerrarConexion();
        }
    }

    public ArrayList<Horarios> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Horarios> lista = new ArrayList();
        try {
            ps = cn.getCnn().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Horarios(
                        rs.getString(1),
                        rs.getString(5),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.cerrarConexion();
        }
    }

    public ArrayList<Horarios> verCursos(Object codProf) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Horarios> lista = new ArrayList();
        try {
            ps = cn.getCnn().prepareStatement(SQL_VER_CURSOS);
            ps.setString(1, codProf.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Horarios(
                        rs.getString(1),
                        rs.getString(5),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cn.cerrarConexion();
        }
    }

    public int GetIdCursoProf(Object grado, Object curso) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.getCnn().prepareStatement(SQL_READ_BY_CURSO_GRADO);
            ps.setString(2, grado.toString());
            ps.setString(1, curso.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new Exception("Error al obtener el id");
            }
        } finally {
            rs.close();
            ps.close();
            cn.cerrarConexion();
        }
    }
}

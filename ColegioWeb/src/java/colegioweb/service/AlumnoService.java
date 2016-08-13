package colegioweb.service;

import colegioweb.db.AccesoDB;
import colegioweb.domain.Alumnos;
import colegioweb.domain.Cursos;
import colegioweb.domain.Matriculados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoService {

    private static final AccesoDB cn = AccesoDB.saberEstado();
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE usuario=?";

    public String insertar(Alumnos bean) {
        String rpta = "";

        try {

            String sql = "INSERT INTO alumnos (usuario,nombres,apellidos,email"
                    + ",password,matriculado) VALUES (?,?,?,?,?,?)";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, bean.getUsuario());
            psd.setString(2, bean.getNombres());
            psd.setString(3, bean.getApellidos());
            psd.setString(4, bean.getEmail());
            psd.setString(5, bean.getPassword());
            psd.setString(6, "no");
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

    public String actualizar(Alumnos bean) {
        String rpta = "";
        try {
            String sql = "UPDATE alumnos SET nombres=?,apellidos=?,email=? WHERE usuario=?";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, bean.getNombres());
            psd.setString(2, bean.getApellidos());
            psd.setString(3, bean.getEmail());
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

            String sql = "UPDATE alumnos SET password=? WHERE usuario=?";
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

    public String EstaMatriculado(String usuario) {

        String matriculado = "";
        try {

            String sql = "Select * from alumnos where usuario=?";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, usuario);
            ResultSet rs = psd.executeQuery();
            rs.next();
            matriculado = rs.getString("matriculado");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return matriculado;
    }

    public void matricularse(Matriculados bean) {

        try {

            String sql = "INSERT INTO matriculados (codigoMatricula,usuario,grado,anio)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, bean.getCodigo());
            psd.setString(2, bean.getUsuario());
            psd.setString(3, bean.getGrado());
            psd.setString(4, bean.getAnio());
            int n1 = psd.executeUpdate();
            if (n1 > 0) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.cerrarConexion();
            } catch (Exception e) {
            }
        }
    }

    public void matricularseCurso(String codigo) {

        ResultSet rs;
        Statement st = null;
        try {
            String sql = "Select * from curso";
            rs = st.executeQuery(sql);
            PreparedStatement psd;
            while (rs.next()) {
                String codigoCurso = rs.getString("codigo");
                try {
                    psd = cn.getCnn().prepareStatement("Insert into matriculadoscurso(codigoMatricula,codigoCurso,registroNotas) values (?,?,?)");
                    psd.setObject(1, codigo);
                    psd.setObject(2, codigoCurso);
                    psd.setObject(3, "no");
                    psd.executeUpdate();

                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String actualizarEstadoMatricula(String usuario) {
        String rpta = "";

        try {

            String sql = "UPDATE alumnos SET matriculado=? WHERE usuario=?";
            PreparedStatement psd = cn.getCnn().prepareStatement(sql);
            psd.setString(1, "si");
            psd.setString(2, usuario);
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

    public void matricularseCurso(Matriculados bean) {
        CursoService cursoServ = new CursoService();
        ArrayList<Cursos> listaCurso = (ArrayList<Cursos>) cursoServ.readAll();
        CursoProfesorService cps = new CursoProfesorService();

        for (Cursos cursos : listaCurso) {

            try {
                PreparedStatement ps = cn.getCnn().prepareStatement("INSERT INTO matriculadoscurso (codigoMatricula,idProfCurso)"
                        + " values (?,?)");
                int n = cps.GetIdCursoProf(bean.getGrado(), cursos.getCodigo());
                ps.setString(1, bean.getCodigo());
                ps.setInt(2, n);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AlumnoService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public List<Alumnos> getAlumnos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Alumnos> alumnos = new ArrayList();
        try {
            ps = cn.getCnn().prepareStatement("select * from alumnos");
            rs = ps.executeQuery();
            while (rs.next()) {
                alumnos.add(new Alumnos(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6))
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
        return alumnos;
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

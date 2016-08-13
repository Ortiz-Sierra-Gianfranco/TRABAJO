package colegioweb.domain;

public class Horarios {

    private String codCurProf;
    private String codigoCurso;
    private String codigoProfesor;
    private String nombreProfesor;

    private String grado;

    public Horarios() {
    }

    public Horarios(String codigoCurso, String codigoProfesor, String grado) {
        this.codigoCurso = codigoCurso;
        this.codigoProfesor = codigoProfesor;
        this.grado = grado;
    }

    public Horarios(String codCurProf, String codigoCurso, String codigoProfesor, String grado) {
        this.codCurProf = codCurProf;
        this.codigoCurso = codigoCurso;
        this.codigoProfesor = codigoProfesor;
        this.grado = grado;
    }

    public Horarios(String codCurProf, String codigoCurso, String codigoProfesor, String nombreProfesor, String grado) {
        this.codCurProf = codCurProf;
        this.codigoCurso = codigoCurso;
        this.codigoProfesor = codigoProfesor;
        this.nombreProfesor = nombreProfesor;
        this.grado = grado;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCodCurProf() {
        return codCurProf;
    }

    public void setCodCurProf(String codCurProf) {
        this.codCurProf = codCurProf;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

}

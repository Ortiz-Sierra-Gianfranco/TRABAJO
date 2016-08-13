
package colegioweb.domain;


public class Matriculados extends Alumnos{
    String codigo,anio,grado;

    public Matriculados(String codigo, String anio, String grado) {
        this.codigo = codigo;
        this.anio = anio;
        this.grado = grado;
    }
    public Matriculados(){
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
}

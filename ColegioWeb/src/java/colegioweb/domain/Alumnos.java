
package colegioweb.domain;


public class Alumnos {
   
    private String nombres,apellidos,email,usuario,password,matriculado;

    public Alumnos(String nombres, String apellidos, String email, String usuario, String password, String matriculado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.matriculado = matriculado;
    }
    
    public Alumnos(){
        
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(String matriculado) {
        this.matriculado = matriculado;
    }
    
    
}

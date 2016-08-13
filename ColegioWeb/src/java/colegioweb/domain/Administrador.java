
package colegioweb.domain;


public class Administrador {
    String usuario,nombres,password;

    public Administrador(String usuario, String nombres, String password) {
        this.usuario = usuario;
        this.nombres = nombres;
        this.password = password;
    }
    public Administrador(){
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class AccesoDB {

    /*
    public static Connection getConnection() throws ClassNotFoundException {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/colegioweb", "root", "");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
        return cn;
    }
     */
    public static AccesoDB instance;
    private Connection cnn;

    //#mysql DB PROPIEDADES
    private final String MYSQL_DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private final String MYSQL_DB_URL = "jdbc:mysql://localhost/colegioweb";
    private final String MYSQL_DB_USERNAME = "root";
    private final String MYSQL_DB_PASSWORD = "";

    private AccesoDB() {
        try {
            Class.forName(MYSQL_DB_DRIVER_CLASS);
            cnn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USERNAME, MYSQL_DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccesoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized static AccesoDB saberEstado() {
        if (instance == null) {
            instance = new AccesoDB();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void cerrarConexion() {
        instance = null;
    }
}

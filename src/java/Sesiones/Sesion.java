/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Sesiones;

//import BaseDatos.ConexionBD;
//import BaseDatos.Querys;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author futpilari
 */

//https://raibledesigns.com/rd/entry/java_web_application_security_part
/*
public class Sesion implements HttpSessionListener{

    private Querys query = new Querys();
    private ConexionBD conexionBD = new ConexionBD(); 
    private boolean sesion = false;
    
    @WebListener 
    public void sessionCreated(HttpSessionEvent se) {
        
        Statement conexion = conexionBD.Conectar();
        String strSql = query.ConsultarUsuario("eder","qwerty");
        
        ResultSet result = null;
        try {
            result = conexionBD.consultarQuery(conexion, strSql);
        } catch (SQLException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result != null){
            HttpSession session = se.getSession();
            System.out.print("A las " + getTime() + " se creo la sesion con ID: " +
            session.getId() + " MaxInactiveInterval=" +
            session.getMaxInactiveInterval());
            sesion = true;
        }
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("A las " + getTime() + " se destruyo la sesion con ID: "
        + session.getId());
        sesion = false;
    }
    private String getTime() {
        return new Date(System.currentTimeMillis()).toString();
    } 
}
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import BaseDatos.ConexionBD;
import BaseDatos.Querys;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author futpilari
 */
public class Sesion extends HttpServlet implements HttpSessionListener{

    private Querys query = new Querys();
    private ConexionBD conexionBD = new ConexionBD();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private HttpServletRequest request; 
    private boolean sesion = false;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            this.request = request;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sesion</title>");            
            out.println("</head>");
            out.println("<body>");
            if(sesion == true){
                out.println("Sesion iniciada");
            }else{
                out.println("Sesion fallida");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void sessionCreated(HttpSessionEvent se) {
        
        Statement conexion = conexionBD.Conectar();
        String strSql = query.ConsultarUsuario(this.request.getParameter("nombre"), this.request.getParameter("password"));
        
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

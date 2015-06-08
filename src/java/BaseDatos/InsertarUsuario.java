/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ghackanonymous
 */
public class InsertarUsuario extends HttpServlet {

    private ConexionBD objConexionBD = null;
    private Statement conexion = null;
    private int resultado;
    private Querys query = new Querys();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            objConexionBD = new ConexionBD();
            conexion = objConexionBD.Conectar();
            
            String strSql = query.InsertarUsuarioTablaDatos(request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("password"), request.getParameter("email"));
            
            try {
                resultado = objConexionBD.InsertarUsuario(conexion, strSql);
            } catch (SQLException ex) {
                Logger.getLogger(InsertarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            
            switch(resultado){
                case -1:
                    out.println("No se se ha podido ejecutar la solicitud a la base de datos.<br>");
                break;
                case 0:
                    out.println("No hay resultado, la sentecia ejecutada no a realizado ningun cambio.<br>");
                break;
                case 1:
                    out.println("Se ha realizado una inserción en la base de datos.<br>");
                break;
                default:
                    out.println("Error<br>");
                break;
            }
            
            out.println("<a href=\"./MostrarDatos\">Ver Todos Los Usuarios</a><br>");
            
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

}

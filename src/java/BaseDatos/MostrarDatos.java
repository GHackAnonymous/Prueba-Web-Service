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

public class MostrarDatos extends HttpServlet {
    
    private ConexionBD objConexionBD = null;
    private Statement conexion = null;
    private ResultSet resultado = null;
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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Genero la query... <br>");
            String strSql = query.ConsultarTablaDatos();
            
            try {   
                resultado = objConexionBD.consultarTabla(conexion, strSql);
                out.println("Resultado: "+resultado+"<br>");
            } catch (Exception ex) {
                out.println("Error a la hora de consultar la base de datos <br>");
            } 
            
            try {
                out.println("<ul>");
                while (resultado.next()) {
                    out.println("<li>");
                    out.println("Nombre: " + resultado.getString("nombre")
                            + "<br> Apellido: " + resultado.getString("apellido")
                            + "<br> Email: "+ resultado.getString("email")); 
                    out.println("</li>");
                }
                out.println("</ul>");
            } catch (SQLException ex) {
                Logger.getLogger(MostrarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //out.println("<h1>Servlet MostrarDatos at " + request.getContextPath() + "</h1>");
            
            out.println("<form method=\"get\" action=\"./BaseDatos/InsertarDatos.html\" name=\"insertar\">");
            out.println("<button>Insertar Usuario</button>");
            out.println("</form>");
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

package JuegosNumeros;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jugar extends HttpServlet {
    int numeroAdivinar = intRandom();
    int intentos = 0;
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Jugar</title>");            
            out.println("</head>");
            out.println("<body>");
            int numeroUsuario = Integer.parseInt(request.getParameter("numero"));
            if(numeroAdivinar < numeroUsuario){
                out.println("El numero "+numeroUsuario+" es menor<br>");
                
                intentos++;
                
                out.println("<a href=\"./Juegos/JuegoNumeros.html\">Reintertar</a><br>");
            }else if(numeroAdivinar > numeroUsuario){
                out.println("El numero "+numeroUsuario+" es mayor<br>");
                
                intentos++;
                
                out.println("<a href=\"./Juegos/JuegoNumeros.html\">Reintertar</a><br>");
            }else if(numeroAdivinar == numeroUsuario){
                out.println("<h1>¡¡¡¡GANADOR!!!!</h1><br><br><br>");
                out.println("El numero "+numeroUsuario+" es igual que el numero:"+numeroAdivinar+"<br>");
                out.println("Numero de intentos realizados: "+intentos+"<br>");
                numeroAdivinar = intRandom();
                intentos = 0;
                out.println("<a href=\"./Juegos/JuegoNumeros.html\">Jugar de Nuevo</a><br>");
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
    
    public int intRandom(){
        Random rand = new Random();
        return rand.nextInt(100);
    }

}

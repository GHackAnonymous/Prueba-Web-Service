/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaServerBD;

import Mesaje.RecibirMensaje_Service;
import Mesaje.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author futpilari
 */
public class ConsultarVentasServidor extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Prueba1Servidor/RecibirMensaje.wsdl")
    private RecibirMensaje_Service service;

    private final int operacion = 1;
    private ArrayList<java.lang.Object> lista = null;
    private int totalProducto = 0;
    private int total = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            lista = (ArrayList<Object>) operacionBD(1);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consultar Ventas Servidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Consultando<br>");
            Venta venta = new Venta();
            if(lista != null){
                out.println("1<br>");
                out.println("<ul>");
                for(int i = 0;i < lista.size();i++){
                    out.println("bucle vuelta: "+i+"<br>");
                    venta = (Venta) lista.get(i);

                    out.println("<li>ID Venta: "+venta.getIdVenta()+"</li><br>");
                    out.println("<li>Producto: "+venta.getProducto()+"</li><br>");
                    out.println("<li>Precio: "+venta.getPrecio()+"</li><br>");
                    out.println("<li>Cantidad: "+venta.getCantidad()+"</li><br>");
                    
                    totalProducto = Integer.parseInt(venta.getPrecio()) * Integer.parseInt(venta.getCantidad());
                    out.println("<li>Total Por Producto: "+totalProducto+"</li><br>");
                    
                    total = total + totalProducto;
                }
                out.println("<h1>total: "+total+"</h1><br>");
                out.println("</ul>");
            }else{
                out.println("<h1>No he podido optener los datos de ventas.</h1><br>");
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

    private java.util.List<java.lang.Object> operacionBD(int operacion) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Mesaje.RecibirMensaje port = service.getRecibirMensajePort();
        return port.operacionBD(operacion);
    }
}
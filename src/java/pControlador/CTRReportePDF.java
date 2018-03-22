/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pControlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andres
 */
@WebServlet(name = "CTRReportePDF", urlPatterns = {"/CTRReportePDF"})
public class CTRReportePDF extends HttpServlet {

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
        String gam = request.getParameter("txtGamuep");
        String gestion = request.getParameter("txtGestion");
        String dolar = request.getParameter("txtDolar");
        int op=Integer.parseInt(request.getParameter("txtTipoRepo"));
        
        
        switch(op)
            {
                case 1: 
                    request.getRequestDispatcher("reporte1?nu15_gaf{="+gam+"&ldiak="+gestion+"&insdw="+dolar).forward(request, response);
                    break;                
                case 2: 
                    request.getRequestDispatcher("reporte2?nu15_gaf{="+gam+"&ldiak="+gestion+"&insdw="+dolar).forward(request, response);
                    break;
                case 3: 
                    request.getRequestDispatcher("reporte3?nu15_gaf{="+gam+"&ldiak="+gestion+"&insdw="+dolar).forward(request, response);
                    break;
                case 4: 
                    request.getRequestDispatcher("reporte4?nu15_gaf{="+gam+"&ldiak="+gestion+"&insdw="+dolar).forward(request, response);
                    break;
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

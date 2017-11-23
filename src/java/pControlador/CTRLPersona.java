/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pControlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pClases.Persona;
import pModelo.DBPersona;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CTRLPersona", urlPatterns = {"/CTRLPersona"})
public class CTRLPersona extends HttpServlet {

     
    protected void adicion(Persona P) throws SQLException            
    {   
        DBPersona.adicion(P);
        
    }  
    
    protected void modificar(Persona P) throws SQLException            
    {   
        DBPersona.modificar(P);
    } 
    
    protected void eliminar(Persona P) throws SQLException            
    {   
        DBPersona.eliminar(P.getPer_ci());
    }
    
    public static HttpServletRequest lista_persona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{                                             
       ArrayList<Persona> lista=new ArrayList<Persona>();
       lista=DBPersona.lista_persona();                                                                   
       request.setAttribute("lista",lista);                      
       return request;
    }  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Persona P=new Persona();
        P.setPer_ci(request.getParameter("txtci"));
        P.setPer_paterno(request.getParameter("txtpaterno"));
        P.setPer_materno(request.getParameter("txtmaterno"));
        P.setPer_nombre(request.getParameter("txtnombre"));
        P.setPer_telefono(request.getParameter("txttelefono"));
                
        int op=Integer.parseInt(request.getParameter("op"));
        
        switch(op)
        { case 1: adicion(P); response.sendRedirect("alta_persona.jsp"); break;
          case 2: modificar(P); response.sendRedirect("modificar_persona.jsp"); break;   
          case 3: eliminar(P); response.sendRedirect("eliminar_persona.jsp"); break;    
        }
        
        //request.setAttribute("lista",lista); 
        // RequestDispatcher requestDispatcher =request.getRequestDispatcher("/AgenciaNuevo.jsp");
        //   requestDispatcher.forward(request, response);
        
        
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CTRLPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CTRLPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
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

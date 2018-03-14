/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pControlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pModelo.DBConexion;

/**
 *
 * @author andres
 */
@WebServlet(name = "EjemploJSON", urlPatterns = {"/EjemploJSON"})
public class EjemploJSON extends HttpServlet {

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
            out.println("<title>Servlet EjemploJSON</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EjemploJSON at " + request.getContextPath() + "</h1>");
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
        
        Statement statement;
        ResultSet rs;
        String result = "";
        Connection con = DBConexion.IniciarSesion();
        try {
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT concat_ws('. ', Codigo, Descripcion) as detalle, Codigo FROM Subcomponentes where Codigo like '2%'");

            result="{ \"subcomponente\" : [";
           
            boolean flag=false;
           
            while(rs.next()){
                if(flag){
                    result+=",{ \"detalle\" : \""+rs.getString(1)+
                    "\", \"codigo\" : \""+rs.getString(2)+"\"}\n";
                }else{
                    result+="{ \"detalle\" : \""+rs.getString(1)+
                    "\", \"codigo\" : \""+rs.getString(2)+"\"}\n";
                    flag=true;
                }
            }
           
            result+="]}";
            
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(result);

            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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

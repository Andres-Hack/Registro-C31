/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pControlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CTRLBuscar", urlPatterns = {"/CTRLBuscar"})
public class CTRLBuscar extends HttpServlet {
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
        
        List datos = new ArrayList(15);
        String id = request.getParameter("id");
        ResultSet rs = null;
        PreparedStatement ps = null;

        try (Connection con = DBConexion.IniciarSesion()) {
            ps = con.prepareStatement("select * from C31 where c_C31=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(rs.getString("c_C31"));
                datos.add(rs.getString("Fecha_Emision"));
                datos.add(rs.getString("Fecha_Pago"));
                datos.add(rs.getString("Mes_Dev"));
                datos.add(rs.getString("Mes_Pago"));
                datos.add(rs.getString("C31"));
                datos.add(rs.getString("BID_CTR"));
                datos.add(rs.getString("Inst"));
                datos.add(rs.getString("GAM_UEP"));
                datos.add(rs.getString("Beneficiario"));
                datos.add(rs.getString("Importe_Bs"));
                datos.add(rs.getString("Hoja_Ruta"));
                datos.add(rs.getString("Nro_Factura"));
            }
            rs.close();
            con.close();
        }

       catch (SQLException e)
       {
           System.err.println("ERROR .. !!! "+e);
       }
       request.setAttribute("dato", datos);
       request.getRequestDispatcher("FormModificar.jsp").forward(request, response);
        
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

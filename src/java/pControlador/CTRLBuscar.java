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
                datos.add(rs.getString("c_C31"));           //0
                datos.add(rs.getString("Fecha_Emision"));   //1
                datos.add(rs.getString("Fecha_Pago"));      //2
                datos.add(rs.getString("Mes_Dev"));         //3
                datos.add(rs.getString("Mes_Pago"));        //4
                datos.add(rs.getString("C31"));             //5
                datos.add(rs.getString("BID_CTR"));         //6
                datos.add(rs.getString("F_F"));             //7
                datos.add(rs.getString("O_F"));             //8
                datos.add(rs.getString("SubComp"));         //9
                datos.add(rs.getString("Actividad"));       //10
                datos.add(rs.getString("Subactividad"));    //11
                datos.add(rs.getString("C_G"));             //12
                datos.add(rs.getString("T_G"));             //13
                datos.add(rs.getString("Partida"));         //14
                datos.add(rs.getString("Inst"));            //15
                datos.add(rs.getString("GAM_UEP"));         //16
                datos.add(rs.getString("Beneficiario"));    //17
                datos.add(rs.getString("Tipo"));            //18
                datos.add(rs.getString("Producto"));        //19
                datos.add(rs.getString("Concepto"));        //20
                datos.add(rs.getString("Importe_Bs"));      //21
                datos.add(rs.getString("Hoja_Ruta"));       //22
                datos.add(rs.getString("Nro_Factura"));     //23
                datos.add(rs.getString("Descripcion"));      //24
                datos.add(rs.getString("Descripcion_Actividad"));//25
                datos.add(rs.getString("Descripcion_Subactividad"));//26
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

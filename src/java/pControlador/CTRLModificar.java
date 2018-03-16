/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pControlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pClases.Registro;
import pModelo.DBConexion;

/**
 *
 * @author andres
 */
@WebServlet(name = "CTRLModificar", urlPatterns = {"/CTRLModificar"})
public class CTRLModificar extends HttpServlet {
    
    protected void modificar(Registro R) throws SQLException            
    {   
        PreparedStatement preparedStatement = null;
        
        try (Connection cnn = DBConexion.IniciarSesion()){
            String query = "update C31 set Fecha_Emision=?, Fecha_Pago=?, Mes_Dev=?, Mes_Pago=?, C31=?, BID_CTR=?, Inst=?, GAM_UEP=?, Beneficiario=?, Importe_Bs=?, Importe_Us=?, Hoja_Ruta=?, Nro_Factura=? where c_C31=?";
            preparedStatement = cnn.prepareStatement(query);
            preparedStatement.setString(1, R.getFecha_Emision());
            preparedStatement.setString(2, R.getFecha_Pago());
            preparedStatement.setString(3, R.getMes_Dev());
            preparedStatement.setString(4, R.getMes_Pago());
            preparedStatement.setString(5, R.getC31());
            preparedStatement.setString(6, R.getBID_CTR());
            preparedStatement.setString(7, R.getInst());
            preparedStatement.setString(8, R.getGAM_UEP());
            preparedStatement.setString(9, R.getBeneficiario());
            preparedStatement.setString(10, R.getImporte_Bs());
            preparedStatement.setString(11, R.getImporte_Us());
            preparedStatement.setString(12, R.getHoja_Ruta());
            preparedStatement.setString(13, R.getNro_Factura());
            preparedStatement.setInt(14, R.getC_C31());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            cnn.close();
        } catch (SQLException e) {
            System.err.println("EL ERROR ES GARRAFAL ...!! EN  "+e);
        }
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        float a=Float.parseFloat(request.getParameter("txtImporte"));
        float usd = (float) (a/6.86);
        String usd2 = Float.toString(usd);
        String query = "update C31 set "
                    + "Fecha_Emision='"+request.getParameter("txtFechE")+"', "
                    + "Fecha_Pago='"+request.getParameter("txtFechP")+"', "
                    + "Mes_Dev='"+request.getParameter("txtMesC31")+"', "
                    + "Mes_Pago='"+request.getParameter("txtMesPa")+"', "
                    + "C31='"+request.getParameter("txtNroC31")+"', "
                    + "BID_CTR='"+request.getParameter("txtBidCtr")+"', "
                    + "Inst='"+request.getParameter("txtInst")+"', "
                    + "GAM_UEP='"+request.getParameter("txtGam")+"', "
                    + "Beneficiario='"+request.getParameter("txtBene")+"', "
                    + "Importe_Bs="+request.getParameter("txtImporte")+", "
                    + "Importe_Us="+usd2+", "
                    + "Hoja_Ruta='"+request.getParameter("txtHR")+"', "
                    + "Nro_Factura='"+request.getParameter("txtNroFac")+"' "
                    + "where c_C31="+request.getParameter("txtID");
        PreparedStatement preparedStatement = null;
        try (Connection cnn = DBConexion.IniciarSesion()) {            
            preparedStatement = cnn.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            cnn.close();
        } catch (SQLException e) {
            System.err.println("EL ERROR ES GARRAFAL ...!! EN  " + e);
        }
        request.getRequestDispatcher("modificar.jsp").forward(request, response);    
        
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

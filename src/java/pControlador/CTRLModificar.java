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
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pClases.Registro;
import pModelo.DBConexion;
import pControlador.CTRLRegistro;

/**
 *
 * @author andres
 */
@WebServlet(name = "CTRLModificar", urlPatterns = {"/CTRLModificar"})
public class CTRLModificar extends HttpServlet {
    
    protected void EliminarC31(String id) throws SQLException            
    {   
        String ls_query = "";
        ls_query = " delete from C31 where c_C31 = "+id;
        try (Connection cnn = DBConexion.IniciarSesion()) {
            Statement l_statement = cnn.createStatement();
            l_statement.execute(ls_query);
            l_statement.execute(ls_query);
            cnn.close();
        }
    }
    
    protected void EliminarDist(String id) throws SQLException            
    {   
        String ls_query = "";
        ls_query = " delete from Detalle where c_C31 = "+id;
        try (Connection cnn = DBConexion.IniciarSesion()) {
            Statement l_statement = cnn.createStatement();
            l_statement.execute(ls_query);
            l_statement.execute(ls_query);
            cnn.close();
        }
    }
    
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
        response.setContentType("text/html;charset=UTF-8"); 
        request.setCharacterEncoding("UTF-8");
        
        try {
            
            float a=Float.parseFloat(request.getParameter("txtImporte"));
            float usd = (float) (a/6.86);
            String usd2 = Float.toString(usd);
            Calendar cal= Calendar.getInstance();
            int year= cal.get(Calendar.YEAR);
            
            Registro R = new Registro();
            R.setC_C31(Integer.parseInt(request.getParameter("txtID")));
            R.setHoja_Ruta(request.getParameter("txtHR").toUpperCase());
            R.setNro_Factura(request.getParameter("txtFactura").toUpperCase());
            R.setAnio_Pago(String.valueOf(year));
            R.setFecha_Emision(request.getParameter("txtFechaE"));
            R.setFecha_Pago(request.getParameter("txtFechaP"));
            R.setMes_Dev(request.getParameter("txtMesC31"));
            R.setMes_Pago(request.getParameter("txtMesPa"));
            R.setC31(request.getParameter("txtNroC31"));
            R.setBID_CTR(request.getParameter("txtBidCtr").toUpperCase());
            R.setF_F(request.getParameter("txtFF"));
            R.setO_F(request.getParameter("txtOF"));
            R.setSubComp(request.getParameter("txtSubComp"));
            R.setDescripcion(request.getParameter("txtDescSubc").toUpperCase());
            R.setActividad(request.getParameter("txtAct"));
            R.setDescripcion_Actividad(request.getParameter("txtDescAct").toUpperCase());
            R.setSubactividad(request.getParameter("txtSubAct"));
            R.setDescripcion_Subactividad(request.getParameter("txtDescSubAct").toUpperCase());
            R.setC_G(request.getParameter("txtCg"));
            R.setT_G("0");
            R.setPartida(request.getParameter("txtPartida"));
            R.setInst(request.getParameter("txtInst").toUpperCase());
            R.setGAM_UEP(request.getParameter("txtGamuep").toUpperCase());
            R.setTipo(request.getParameter("txtTipo"));
            R.setBeneficiario(request.getParameter("txtBeneficiario").toUpperCase());
            R.setConcepto(request.getParameter("txtConcepto").toUpperCase());
            R.setProducto(request.getParameter("txtProducto").toUpperCase());
            R.setImporte_Bs(request.getParameter("txtImporte"));
            R.setTC("6.86");
            R.setImporte_Us(usd2);
            
            
            EliminarC31(request.getParameter("txtID"));
            EliminarDist(request.getParameter("txtID"));
           
            
            if ("UEP".equals(request.getParameter("txtInst"))) {
                CTRLRegistro wd = new CTRLRegistro();
                wd.adicion2(R, "2", request.getParameter("txtusuario"));
                request.getRequestDispatcher("modificar.jsp").forward(request, response);  
            }
            else{
                CTRLRegistro wd = new CTRLRegistro();
                wd.adicion(R, "2", request.getParameter("txtusuario"));
                request.getRequestDispatcher("modificar.jsp").forward(request, response);                  
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CTRLModificar.class.getName()).log(Level.SEVERE, null, ex);
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

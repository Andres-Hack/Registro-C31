/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pControlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CTRLDetalleC31", urlPatterns = {"/CTRLDetalleC31"})

public class CTRLDetalleC31 extends HttpServlet {
    
    public List<Registro> getAllRegistroID(String id) {
        List<Registro> registros = new ArrayList<Registro>();
        Connection cnn = DBConexion.IniciarSesion();
        try {
            Statement statement = cnn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM C31 WHERE c_C31="+id);
            while (rs.next()) {
                Registro user = new Registro();
                user.setC31(rs.getString("C31"));
                user.setAnio(rs.getString("Anio"));
                user.setAnio_Pago(rs.getString("Anio_Pago"));
                user.setFecha_Emision(rs.getString("Fecha_Emision"));
                user.setFecha_Pago(rs.getString("Fecha_Pago"));
                user.setMes_Dev(rs.getString("Mes_Dev"));
                user.setMes_Pago(rs.getString("Mes_Pago"));
                user.setBID_CTR(rs.getString("BID_CTR"));
                user.setF_F(rs.getString("F_F"));
                user.setO_F(rs.getString("O_F"));             
                user.setSubComp(rs.getString("SubComp"));
                user.setActividad(rs.getString("Actividad"));
                user.setSubactividad(rs.getString("Subactividad"));
                user.setC_G(rs.getString("C_G"));
                user.setT_G(rs.getString("T_G"));
                user.setPartida(rs.getString("Partida"));
                user.setInst(rs.getString("Inst"));
                user.setGAM_UEP(rs.getString("GAM_UEP"));
                user.setBeneficiario(rs.getString("Beneficiario"));
                user.setTipo(rs.getString("Tipo"));
                user.setProducto(rs.getString("Producto"));
                user.setConcepto(rs.getString("Concepto"));                
                user.setImporte_Bs(rs.getString("Importe_Bs"));
                user.setImporte_Us(rs.getString("Importe_Us"));
                user.setHoja_Ruta(rs.getString("Hoja_Ruta"));
                user.setNro_Factura(rs.getString("Nro_Factura"));                
                registros.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Este es el error : "+e);
        }

        return registros;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("vsd");

        request.setAttribute("registro", getAllRegistroID(id));
        request.getServletContext().getRequestDispatcher("/detalleC31.jsp").forward(request, response);
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

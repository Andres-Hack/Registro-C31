package pControlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import pModelo.DBConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
@WebServlet(name = "CTRLProgramado", urlPatterns = {"/CTRLProgramado"})
public class CTRLProgramado extends HttpServlet {
    private Statement statement;
    private Statement statement1;
    private Statement statement2;
    private Statement statement3;
    private Statement statement4;
    private Statement statement5;
    private Statement statement6;
    private Statement statement7;
    private Statement statement8;
    private Statement statement9;
    private  DecimalFormat df;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String consulta = "", consulta1A= null, consulta1B = null, consulta1 = null,
                consulta2 = null, consulta3 = null, consulta4 = null, consulta5 = null,
                consulta6 = null, consulta7 = null, consulta8 = null, consulta9 = null;
        String valor1;
        valor1 = "x";
        List datos = new ArrayList(8);
        List datos3 = new ArrayList();
        String estado = "";
                                        
        String gamuep = request.getParameter("Gamuep");
        String cambio = request.getParameter("cambio");
                                       
        Connection con = DBConexion.IniciarSesion();
                                        
        if (cambio != null) {
            estado = "importe_usd";
            valor1 = "$us";
            
        }
        else{
            estado = "importe";
            valor1 = "Bs";
        }
                                        
        consulta = "select * from presupuesto where id >= 1 ";
        consulta1A = "select SUM("+estado+") as total from tabla_c31 where bid_ctr='BID' ";
        consulta1B = "select SUM("+estado+") as total from tabla_c31 where bid_ctr='CTR' ";
        consulta1 = "select SUM("+estado+") as total from tabla_c31 where id>=1 ";
        
        consulta2 = consulta1A+" and subc='2,1'";
        consulta3 = consulta1A+" and subc='2,2'";
        consulta4 = consulta1A+" and subc='2,3'";
        consulta5 = consulta1A+" and subc='2,4'";  
        consulta6 = consulta1B+" and subc='2,1'";
        consulta7 = consulta1B+" and subc='2,2'";
        consulta8 = consulta1B+" and subc='2,3'";
        consulta9 = consulta1B+" and subc='2,4'"; 
        

        if (gamuep!=null) {
            if (gamuep=="TODO") {
                consulta = consulta+" and gam='"+gamuep+"' ";
                consulta1 = consulta1+" and gam_uep='"+gamuep+"' ";
                consulta2 = consulta2+" and gam_uep='"+gamuep+"'";
                consulta3 = consulta3+" and gam_uep='"+gamuep+"' ";
                consulta4 = consulta4+" and gam_uep='"+gamuep+"' ";
                consulta5 = consulta5+" and gam_uep='"+gamuep+"' "; 
                consulta6 = consulta6+" and gam_uep='"+gamuep+"' ";
                consulta7 = consulta7+" and gam_uep='"+gamuep+"' ";
                consulta8 = consulta8+" and gam_uep='"+gamuep+"' ";
                consulta9 = consulta9+" and gam_uep='"+gamuep+"' ";
            } else {
                consulta = consulta+" and gam='TOTAL' ";
                
            }
        }
        System.out.println("PRIMERA CONSULTA : "+consulta);
        System.out.println("SEGUNDA CONSULTA : "+consulta1);
                                       
        try {    
            statement = con.createStatement();
            statement1 = con.createStatement();
            statement2 = con.createStatement();
            statement3 = con.createStatement();
            statement4 = con.createStatement();
            statement5 = con.createStatement();
            statement6 = con.createStatement();
            statement7 = con.createStatement();
            statement8 = con.createStatement();
            statement9 = con.createStatement();
            
            ResultSet rs = statement.executeQuery(consulta);
            ResultSet rs1 = statement1.executeQuery(consulta1);
            ResultSet rs2 = statement2.executeQuery(consulta2);
            ResultSet rs3 = statement3.executeQuery(consulta3);
            ResultSet rs4 = statement4.executeQuery(consulta4);
            ResultSet rs5 = statement5.executeQuery(consulta5);
            ResultSet rs6 = statement6.executeQuery(consulta6);
            ResultSet rs7 = statement7.executeQuery(consulta7);
            ResultSet rs8 = statement8.executeQuery(consulta8);
            ResultSet rs9 = statement9.executeQuery(consulta9);
            
            df = new DecimalFormat("##,###,###.##");
            
            while (rs2.next()) {datos3.add(rs2.getString(1));}
            while (rs3.next()) {datos3.add(rs3.getString(1));}
            while (rs4.next()) {datos3.add(rs4.getString(1));}
            while (rs5.next()) {datos3.add(rs5.getString(1));}
            while (rs6.next()) {datos3.add(rs6.getString(1));}
            while (rs7.next()) {datos3.add(rs7.getString(1));}
            while (rs8.next()) {datos3.add(rs8.getString(1));}
            while (rs9.next()) {datos3.add(rs9.getString(1));}
            while (rs1.next()) {datos3.add(rs1.getString(1));}
            
            while (rs.next()) {
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
                if (cambio != null) {
                    datos.add(rs.getString(3));
                    datos.add(rs.getString(4));
                    datos.add(rs.getString(5));
                    datos.add(rs.getString(6));
                    datos.add(rs.getString(7));
                    datos.add(rs.getString(8));
                    datos.add(rs.getString(9));
                    datos.add(rs.getString(10));
                    datos.add(rs.getString(11));
                    datos.add(rs.getString(12));
                    datos.add(rs.getString(13));
                    datos.add(rs.getString(14));
                    datos.add(rs.getString(15));
                    datos.add(rs.getString(16));
                    datos.add(rs.getString(17));
                } else {
                    datos.add(Float.parseFloat(rs.getString(3))*6.86);
                    datos.add(Float.parseFloat(rs.getString(4))*6.86);
                    datos.add(Float.parseFloat(rs.getString(5))*6.86);
                    datos.add(Float.parseFloat(rs.getString(6))*6.86);
                    datos.add(Float.parseFloat(rs.getString(7))*6.86);
                    datos.add(Float.parseFloat(rs.getString(8))*6.86);
                    datos.add(Float.parseFloat(rs.getString(9))*6.86);
                    datos.add(Float.parseFloat(rs.getString(10))*6.86);
                    datos.add(Float.parseFloat(rs.getString(11))*6.86);
                    datos.add(Float.parseFloat(rs.getString(12))*6.86);
                    datos.add(Float.parseFloat(rs.getString(13))*6.86);
                    datos.add(Float.parseFloat(rs.getString(14))*6.86);
                    datos.add(Float.parseFloat(rs.getString(15))*6.86);
                    datos.add(Float.parseFloat(rs.getString(16))*6.86);
                    datos.add(Float.parseFloat(rs.getString(17))*6.86);
                }
            }
            datos.add(valor1);
            datos.add(gamuep);
        } catch (SQLException ex) {
            Logger.getLogger(CTRLProgramado.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i <= 8; i++) {
            if (datos3.get(i) == null) {
                datos3.set(i, 0);
            }
        }
        //for (int i = 0; i < 10; i++) {
        //    System.out.println("Array pocicion "+i+" es :"+datos.get(i));
        //}
        
        
        request.setAttribute("datos", datos);
        request.setAttribute("datos3", datos3);
        request.getRequestDispatcher("programado.jsp").forward(request, response);
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

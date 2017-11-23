package pControlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pModelo.DBConexion;

@WebServlet(name = "CTRLSalir", urlPatterns = {"/CTRLSalir"})
public class CTRLSalir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {    
        
        Random rnd = new Random();
        String xxx = Integer.toString(rnd.nextInt());
        /*String textoEncriptadoConSHA=DigestUtils.md5(xxx); */
        String n3 = "";
        
        String id2 = request.getParameter("id2");
        
        
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        
        PreparedStatement ps;
        Connection cnn = DBConexion.IniciarSesion();
        cnn.setAutoCommit(false);
         try {             
             String SQL="update persona set log='"+xxx+"' where id=?";         
             ps=cnn.prepareStatement(SQL);
             ps.setString(1,id2);           
             ps.executeUpdate();
             cnn.commit();
             cnn.close();
             ps.close();       
         }catch(SQLException e)
         {  
             cnn.rollback();
         }   
         
        
        response.sendRedirect("http://10.0.6.183:8084/registroC31/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CTRLSalir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CTRLSalir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

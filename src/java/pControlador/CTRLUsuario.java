package pControlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pModelo.DBUsuario;

@WebServlet(name = "CTRLUsuario", urlPatterns = {"/CTRLUsuario"})
public class CTRLUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
          HttpSession sesion = request.getSession();
          String us=request.getParameter("txtusuario");
          String pwd=request.getParameter("txtcontra");
          int n1 = 0, n2 = 0 ;
          String n3 = "";
          
          boolean sw=DBUsuario.Login(us, pwd);
          n1 = DBUsuario.Level(us, pwd);
          n2 = DBUsuario.Unico(us, pwd);
          n3 = DBUsuario.Log(us, pwd);
          
          if(sw)
          {  
              sesion.setAttribute("usuario", us);
              response.sendRedirect("caratula.jsp?id="+n1+"&id2="+n2+"&log="+n3+"");
          }
          else
          {  
              response.sendRedirect("error.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CTRLUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CTRLUsuario.class.getName()).log(Level.SEVERE, null, ex);
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

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
          //String dato = "";
          
          boolean sw = DBUsuario.Login(us, pwd);
          //System.out.println("Este es el ususario "+us+" y esta es la contraseña "+pwd+" y este es el resultado "+sw);
          //dato = DBUsuario.Log(us, pwd);
          
          if(sw==true && sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", us);
            //redirijo a página con información de login exitoso
            response.sendRedirect("inicio.jsp");
          }else{
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

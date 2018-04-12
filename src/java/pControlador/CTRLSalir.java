package pControlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CTRLSalir", urlPatterns = {"/CTRLSalir"})
public class CTRLSalir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
 
         
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect("http://pmgmc2.oopp.gob.bo/registroC31/");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
        /*
        Random rnd = new Random();
        String xxx = Integer.toString(rnd.nextInt());
        /*String textoEncriptadoConSHA=DigestUtils.md5(xxx); 
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
         }*/  
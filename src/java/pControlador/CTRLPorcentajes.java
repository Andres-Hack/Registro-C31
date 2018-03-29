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
import pClases.Porcentaje;
import pDistribucion.DTRmunicipios;
import pModelo.DBConexion;

/**
 *
 * @author andres
 */
@WebServlet(name = "CTRLPorcentajes", urlPatterns = {"/CTRLPorcentajes"})
public class CTRLPorcentajes extends HttpServlet {
    
    public List<Porcentaje> getAllPorcentaje(String gestion, String gam) {
        List<Porcentaje> porcentajes = new ArrayList<Porcentaje>();
        Connection cnn = DBConexion.IniciarSesion();
        String IDgam = DTRmunicipios.MunicipioID(gam);
        String IDgestion = DTRmunicipios.PeriodoID(gestion);
        String str1 = "";
        if (gestion.equals("2016")) { str1 = "and ( c_Periodo=4 or c_Periodo=5) "; }
        else { str1 = " and c_Periodo="+IDgestion+" "; }
        try {
            Statement statement = cnn.createStatement();
            ResultSet rs = statement.executeQuery("select c_Periodo, SubComp, round(Porcentaje, 2) as Porcentaje from Porcentajes where c_Municipio="+IDgam+" "+str1);
            while (rs.next()) {
                Porcentaje user = new Porcentaje();
                
                user.setC_Periodo(rs.getInt("c_Periodo"));
                user.setSubComp(rs.getString("SubComp"));
                user.setPorcentaje(rs.getDouble("Porcentaje"));
                
                porcentajes.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Este es el error : "+e);
        }

        return porcentajes;
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("porcentajes.jsp");
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
        
        String str1 = request.getParameter("txtgestion");
        String str2 = request.getParameter("Gamuep");
        String str3 = ListaPorcentaje.municipio(str2);
        
        request.setAttribute("gestion", str1);
        request.setAttribute("municipio", str3);
        request.setAttribute("porcentaje", getAllPorcentaje(str1, str2));
        request.getServletContext().getRequestDispatcher("/porcentajes.jsp").forward(request, response);

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

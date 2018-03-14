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
import java.util.ArrayList;
import java.util.List;
import pReporte.Consultas;

/**
 *
 * @author andres
 */
@WebServlet(name = "CTRLProgramado", urlPatterns = {"/CTRLProgramado"})
public class CTRLProgramado extends HttpServlet {    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String valor1;
        valor1 = "x";
        List total = new ArrayList(15);
        List label = new ArrayList(5);
        List ejecutado = new ArrayList(10);

        String dolar="1", sw="", montoTotal="";
        String valor21BID = "", valor22BID = "", valor23BID = "", valor24BID = "";
        String valor21CTR = "", valor22CTR = "", valor23CTR = "", valor24CTR = "";
        String gamuep = request.getParameter("Gamuep");
        String cambio = request.getParameter("cambio");
        String IDgam = ListaPorcentaje.IDmunicipio(gamuep);
        String gam = ListaPorcentaje.municipio(gamuep);
                                        
        if (cambio != null) {
            sw="1";
            valor1 = "$us";
            dolar="1";                                        
        }
        else{
            sw="2";
            valor1 = "Bs";
            dolar="6.86";                                        
        }
        label.add(valor1);
        label.add(gam);
        Connection con = DBConexion.IniciarSesion();
        Statement statement1=null;
        ResultSet rs1=null;
        
        valor21BID = Consultas.MontoTotalSubc("TODO", gamuep, "BID", sw, "1");
        valor22BID = Consultas.MontoTotalSubc("TODO", gamuep, "BID", sw, "2");
        valor23BID = Consultas.MontoTotalSubc("TODO", gamuep, "BID", sw, "3");
        valor24BID = Consultas.MontoTotalSubc("TODO", gamuep, "BID", sw, "4");
        valor21CTR = Consultas.MontoTotalSubc("TODO", gamuep, "CTR", sw, "1");
        valor22CTR = Consultas.MontoTotalSubc("TODO", gamuep, "CTR", sw, "2");
        valor23CTR = Consultas.MontoTotalSubc("TODO", gamuep, "CTR", sw, "3");
        valor24CTR = Consultas.MontoTotalSubc("TODO", gamuep, "CTR", sw, "4");        
        ejecutado.add(valor21BID);
        ejecutado.add(valor22BID);
        ejecutado.add(valor23BID);
        ejecutado.add(valor24BID);
        ejecutado.add(valor21CTR);
        ejecutado.add(valor22CTR);
        ejecutado.add(valor23CTR);
        ejecutado.add(valor24CTR);
        montoTotal=String.valueOf(Double.parseDouble(valor21BID)+Double.parseDouble(valor22BID)+Double.parseDouble(valor23BID)+Double.parseDouble(valor24BID)+
                Double.parseDouble(valor21CTR)+Double.parseDouble(valor22CTR)+Double.parseDouble(valor23CTR)+Double.parseDouble(valor24CTR));
        ejecutado.add(montoTotal);
        
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select "
                    + "(Subc21*"+dolar+") as dat1,"
                    + "(Subc21BID*"+dolar+") as dat2,"
                    + "(Subc21CTR*"+dolar+") as dat3,"
                    + "(Subc22*"+dolar+") as dat4,"
                    + "(Subc22BID*"+dolar+") as dat5,"
                    + "(Subc22CTR*"+dolar+") as dat6,"
                    + "(Subc23*"+dolar+") as dat7,"
                    + "(Subc23BID*"+dolar+") as dat8,"
                    + "(Subc23CTR*"+dolar+") as dat9,"
                    + "(Subc24*"+dolar+") as dat10,"
                    + "(Subc24BID*"+dolar+") as dat11,"
                    + "(Subc24CTR*"+dolar+") as dat12, "
                    + "(Total_us*"+dolar+") as Total "
                    + "from Presupuesto where c_Municipio="+IDgam);
            while (rs1.next()) {
                 total.add(rs1.getString("dat1"));
                 total.add(rs1.getString("dat2"));
                 total.add(rs1.getString("dat3"));
                 total.add(rs1.getString("dat4"));
                 total.add(rs1.getString("dat5"));
                 total.add(rs1.getString("dat6"));
                 total.add(rs1.getString("dat7"));
                 total.add(rs1.getString("dat8"));
                 total.add(rs1.getString("dat9"));
                 total.add(rs1.getString("dat10"));
                 total.add(rs1.getString("dat11"));
                 total.add(rs1.getString("dat12"));
                 total.add(rs1.getString("Total"));
            }

            con.close();
        } catch (SQLException ex) {
            System.err.println("EL ERROR ES ESTE ..!!! "+ex);
        }
        
        request.setAttribute("totales", total);
        request.setAttribute("ejecutados", ejecutado);
        request.setAttribute("labels", label);
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

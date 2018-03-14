package pControlador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pClases.Registro;
import pModelo.DBConexion;
import pModelo.DBRegistro;

/**
 *
 * @author core i3
 */
@WebServlet(name = "CTRLRegistro", urlPatterns = {"/CTRLRegistro"})
public class CTRLRegistro extends HttpServlet {
    
    protected void adicion(Registro R) throws SQLException  {
        DBRegistro.adicion(R);
    }
    
    protected void adicion2(Registro R) throws SQLException{
        pDistribucion.DTRmunicipios.distribucion(R);                                       
    }
    
    protected void modificar(Registro R, String xx) throws SQLException            
    {   
        String ls_query = "";
        ls_query = " update tabla_c31";
        ls_query += " set fech_emision= " + "'" + R.getFecha_Emision()+ "'";
        ls_query += " set fech_pago= " + "'" + R.getFecha_Pago()+ "'";
        ls_query += " where id = " + "" + xx + ";";
        try (Connection cnn = DBConexion.IniciarSesion()) {
            Statement l_statement = cnn.createStatement();
            l_statement.execute(ls_query);
            l_statement.execute(ls_query);
            cnn.close();
        }
    }
    
    protected void eliminar(String x) throws SQLException            
    {   
        String ls_query = "";
        ls_query = " delete from tabla_c31 where id = ";
        ls_query += "" + x + "";
        try (Connection cnn = DBConexion.IniciarSesion()) {
            Statement l_statement = cnn.createStatement();
            l_statement.execute(ls_query);
            l_statement.execute(ls_query);
            cnn.close();
        }
    }
    
    public static HttpServletRequest lista_persona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{                                             
       ArrayList<Registro> lista=new ArrayList<>();
       lista=DBRegistro.lista_persona();                                                                   
       request.setAttribute("lista",lista);                      
       return request;
    }  


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Registro R = new Registro();
            float a=Float.parseFloat(request.getParameter("txtImporte"));
            float usd = (float) (a/6.86);
            String usd2 = Float.toString(usd);
            R.setHoja_Ruta(request.getParameter("txtHR"));
            R.setNro_Factura(request.getParameter("txtFactura"));
            R.setAnio_Pago(request.getParameter("txtGestion"));         
            R.setFecha_Emision(request.getParameter("txtFechaE"));
            R.setFecha_Pago(request.getParameter("txtFechaP"));
            R.setMes_Dev(request.getParameter("txtMesC31"));
            R.setMes_Pago(request.getParameter("txtPago"));
            R.setC31(request.getParameter("txtNroC31"));
            R.setBID_CTR(request.getParameter("txtBidctr"));
            R.setF_F(request.getParameter("txtFf"));
            R.setO_F(request.getParameter("txtOf"));
            R.setSubComp(request.getParameter("txtSubc"));
            R.setDescripcion(request.getParameter("txtDescSubc"));
            R.setActividad(request.getParameter("txtAct"));
            R.setDescripcion_Actividad(request.getParameter("txtDescAct"));
            R.setSubactividad(request.getParameter("txtSubAct"));
            R.setDescripcion_Subactividad(request.getParameter("txtDescSubAct"));
            R.setC_G(request.getParameter("txtGast"));
            R.setT_G(request.getParameter("txtTipo"));
            R.setPartida(request.getParameter("txtPartida"));
            R.setInst(request.getParameter("txtInst"));
            R.setGAM_UEP(request.getParameter("txtGamuep"));
            R.setTipo(request.getParameter("txtTipo"));
            R.setBeneficiario(request.getParameter("txtBeneficiario"));
            R.setConcepto(request.getParameter("txtConcepto"));
            R.setProducto(request.getParameter("txtProducto"));
            R.setImporte_Bs(request.getParameter("txtImporte"));
            R.setTC(request.getParameter("txtTc"));
            R.setImporte_Us(usd2);       
            

            String ls_isbn = request.getParameter("txtId");
            
            int op=Integer.parseInt(request.getParameter("op"));
            if ("UEP".equals(request.getParameter("txtInst"))) {
                op = 4;
            }
            
            switch(op)
            {
                case 1: 
                    adicion(R);
                    request.setAttribute("dato", "4");
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                    break;                
                case 2: 
                    eliminar(ls_isbn); 
                    response.sendRedirect("modificar.jsp"); 
                    break;
                case 3: 
                    modificar(R, ls_isbn); 
                    response.sendRedirect("modificar.jsp"); 
                    break;
                case 4: 
                    adicion2(R);
                    request.setAttribute("dato", "4");
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                    break; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTRLRegistro.class.getName()).log(Level.SEVERE, null, ex);
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

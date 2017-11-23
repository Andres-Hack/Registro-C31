package pControlador;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public void adicion2(String nu, String sub) throws SQLException{
        String consulta = null;        
        double a1=0, a2=0, a3=0, a4=0, a5=0, a6=0, a7=0, a8=0, a9=0, a10=0, a11=0, a12=0;
                                        
        if (nu == null) {
            nu = "0";
        }
        
        float numero = Float.parseFloat(nu);
        a1 = Math.rint((numero*0.05)*100)/100;
        a2 = Math.rint((numero*0.1)*100)/100;
        a3 = Math.rint((numero*0.025)*100)/100;
        a4 = Math.rint((numero*0.05)*100)/100;
        a5 = Math.rint((numero*0.025)*100)/100;
        a6 = Math.rint((numero*0.1)*100)/100;
        a7 = Math.rint((numero*0.05)*100)/100;
        a8 = Math.rint((numero*0.05)*100)/100;
        a9 = Math.rint((numero*0.05)*100)/100;
        a10 = Math.rint((numero*0.02)*100)/100;
        a11 = Math.rint((numero*0.1)*100)/100;
        a12 = Math.rint((numero*0.2)*100)/100;
        
        Connection con = DBConexion.IniciarSesion();

        PreparedStatement pst = null;
            switch (sub){
                case "2,3": 
                    consulta = "insert into tabla_2_3 (id, cochabamba, cobija, el_alto, el_torno, oruro, potosi, sucre, sacaba, santa_cruz, tarija, trinidad, viacha, fecha, hora) values (null, '"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"', '"+a11+"', '"+a12+"', curdate(), current_time())";
                    pst = con.prepareStatement(consulta);
                    pst.executeUpdate();
                    pst.close();       
                    break;
                case "2,4": 
                    consulta = "insert into tabla_2_4 (id, cochabamba, cobija, el_alto, el_torno, oruro, potosi, sucre, sacaba, santa_cruz, tarija, trinidad, viacha, fecha, hora) values (null, '"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"', '"+a11+"', '"+a12+"', curdate(), current_time())";
                    pst = con.prepareStatement(consulta);
                    pst.executeUpdate();
                    pst.close();    
                    break;
                default: ;
            }
                                        
    }
    
    protected void modificar(Registro R, String xx) throws SQLException            
    {   
        String ls_query = "";
        ls_query = " update tabla_c31";
        ls_query += " set fech_emision= " + "'" + R.getFech_emision() + "'";
        ls_query += " set fech_pago= " + "'" + R.getFech_pago() + "'";
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
            R.setGestion(request.getParameter("txtGestion"));
            R.setFech_emision(request.getParameter("txtFechaE"));
            R.setFech_pago(request.getParameter("txtFechaP"));
            R.setMes_c31(request.getParameter("txtMesC31"));
            R.setMes_pago(request.getParameter("txtPago"));
            R.setNro_c31(request.getParameter("txtNroC31"));
            R.setBid_ctr(request.getParameter("txtBidctr"));
            R.setFf(request.getParameter("txtFf"));
            R.setOf(request.getParameter("txtOf"));
            R.setDescripcion(request.getParameter("txtDescripcion"));
            R.setSubc(request.getParameter("txtSubc"));
            R.setAct(request.getParameter("txtAct"));
            R.setSubact(request.getParameter("txtSubAct"));
            R.setCat_gast(request.getParameter("txtGast"));
            R.setTg(request.getParameter("txtTg"));
            R.setPartida(request.getParameter("txtPartida"));
            R.setInst(request.getParameter("txtInst"));
            R.setGam_uep(request.getParameter("txtGamuep"));
            R.setBeneficiario(request.getParameter("txtBeneficiario"));
            R.setTipo(request.getParameter("txtTipo"));
            R.setProducto(request.getParameter("txtProducto"));
            R.setActividad2(request.getParameter("txtActividad2"));
            R.setConcepto(request.getParameter("txtConcepto"));
            R.setImporte(request.getParameter("txtImporte"));
            R.setTc(request.getParameter("txtTc"));
            R.setImporte_usd(request.getParameter("txtImporteUSD"));
            R.setObservaciones(request.getParameter("txtObservaciones"));
            R.setHr(request.getParameter("txtHR"));
            R.setNro_factura(request.getParameter("txtFactura"));
            
            String ls_isbn = request.getParameter("txtId");
            
            int op=Integer.parseInt(request.getParameter("op"));
            String importe = request.getParameter("txtImporte");
            String subactiv = request.getParameter("txtSubc");
           
            
            switch(op)
            {
                case 1: 
                        adicion(R);
                        adicion2(importe, subactiv);
                        response.sendRedirect("inicio.jsp");
                        break;                
                case 2: eliminar(ls_isbn); response.sendRedirect("modificar.jsp"); break;
                case 3: modificar(R, ls_isbn); response.sendRedirect("modificar.jsp"); break;
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

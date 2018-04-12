package pControlador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Registro> getAllRegistro() {
        List<Registro> registros = new ArrayList<Registro>();
        Connection cnn = DBConexion.IniciarSesion();
        try {
            Statement statement = cnn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT c_C31, C31, SubComp, Actividad, Subactividad, Beneficiario, Importe_Bs FROM C31 order by c_C31 desc limit 15");
            while (rs.next()) {
                Registro user = new Registro();
                user.setC_C31(rs.getInt("c_C31"));
                user.setC31(rs.getString("C31"));
                user.setSubComp(rs.getString("SubComp"));
                user.setActividad(rs.getString("Actividad"));
                user.setSubactividad(rs.getString("Subactividad"));
                user.setBeneficiario(rs.getString("Beneficiario"));
                user.setImporte_Bs(rs.getString("Importe_Bs"));
                
                registros.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Este es el error : "+e);
        }

        return registros;
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
        request.setAttribute("registro", getAllRegistro());
        request.getServletContext().getRequestDispatcher("/inicio.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        request.setCharacterEncoding("UTF-8");
        
        try {
            Registro R = new Registro();
            float a=Float.parseFloat(request.getParameter("txtImporte"));
            float usd = (float) (a/6.86);
            String str1 = request.getParameter("txtFechaE");
            String str2 = request.getParameter("txtFechaP");
            String delimiter = "-";
            String[] temp1;
            String[] temp2;
            temp1 = str1.split(delimiter);
            temp2 = str2.split(delimiter);
            String fech_entr = String.valueOf(Integer.parseInt(temp1[1]));
            String fech_pago = String.valueOf(Integer.parseInt(temp2[1]));            
            String usd2 = Float.toString(usd);
            
            R.setHoja_Ruta(request.getParameter("txtHR"));
            R.setNro_Factura(request.getParameter("txtFactura"));
            R.setAnio_Pago(request.getParameter("txtGestion"));         
            R.setFecha_Emision(request.getParameter("txtFechaE"));
            R.setFecha_Pago(request.getParameter("txtFechaP"));
            R.setMes_Dev(fech_entr);
            R.setMes_Pago(fech_pago);
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
            R.setT_G("0");
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
                    request.setAttribute("registro", getAllRegistro());
                    request.getServletContext().getRequestDispatcher("/inicio.jsp").forward(request, response);
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
                    request.setAttribute("registro", getAllRegistro());
                    request.getServletContext().getRequestDispatcher("/inicio.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTRLRegistro.class.getName()).log(Level.SEVERE, null, ex);
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

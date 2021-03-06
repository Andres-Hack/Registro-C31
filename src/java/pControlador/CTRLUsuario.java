package pControlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pModelo.DBConexion;
import pModelo.DBUsuario;

@WebServlet(name = "CTRLUsuario", urlPatterns = {"/CTRLUsuario"})
public class CTRLUsuario extends HttpServlet {
    
    public String LogUsuario(String id) throws SQLException{
        Connection con = DBConexion.IniciarSesion();
        con.setAutoCommit(false);
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        
        String nombre ="";
        try {
            PreparedStatement ps = con.prepareStatement("insert into LogUser (c_Log,c_Personal,fecha) values (null,?,?)");
            ps.setString(1, id);
            ps.setString(2, hourdateFormat.format(date));
            ps.executeUpdate();
            
            con.commit();
            con.close();
            ps.close();
            
        } catch (SQLException e) {
            con.rollback();
            System.out.println("ESTE ES EL ERROR : "+e);
        }         
        return nombre;
    }
    
    public String IdUsuario(String usuario, String password){
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String id ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select id from personal where usuario='"+usuario+"' and clave='"+password+"' ");
            while (rs1.next()) {
                id = rs1.getString("id");
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR CtrUsr : "+ex);
        }        
        return id;
    }
    
    public String NombreUsuario(String usuario, String password){
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String nombre ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select concat(nombre,' ',apellido) as Nombre from personal where usuario='"+usuario+"' and clave='"+password+"' ");
            while (rs1.next()) {
                nombre = rs1.getString("Nombre");
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR CtrUsr : "+ex);
        }        
        return nombre;
    }
    
    public  String NivelUsuario(String usuario, String password){
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String nivel ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select nivel from personal where usuario='"+usuario+"' and clave='"+password+"' ");
            while (rs1.next()) {
                nivel = rs1.getString("nivel");
            }
            con.close();
        } catch (SQLException ex) {
             System.out.println("ERROR CtrUsr : "+ex);
        }        
        return nivel;
    }
    
    public  String Abreviado(String usuario, String password){
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String abrev ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select abrev from personal where usuario='"+usuario+"' and clave='"+password+"' ");
            while (rs1.next()) {
                abrev = rs1.getString("abrev");
            }
            con.close();
        } catch (SQLException ex) {
             System.out.println("ERROR CtrUsr : "+ex);
        }        
        return abrev;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
          
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sesion = request.getSession();
            
            String us=request.getParameter("txtusuario");
            String pwd=request.getParameter("txtcontra");
            
            boolean sw = DBUsuario.Login(us, pwd, "1");
            String nombre = NombreUsuario(us, pwd);
            String nivel = NivelUsuario(us, pwd);
            String abrev = Abreviado(us, pwd);
            
            
            
            if(sw==true && sesion.getAttribute("usuario") == null){
                sesion.setAttribute("usuario", us);
                sesion.setAttribute("nombre", nombre);
                sesion.setAttribute("nivel", nivel);
                sesion.setAttribute("abrev", abrev);
                LogUsuario(IdUsuario(us, pwd));
                switch (nivel) {
                    case "1":
                        response.sendRedirect("CTRLRegistro");
                        break;
                    case "2":
                        response.sendRedirect("buscar.jsp");
                        break;
                    case "3":
                        response.sendRedirect("buscar.jsp");
                        break;
                    case "4":
                        response.sendRedirect("inicio.jsp");
                        break;
                    case "5":
                        response.sendRedirect("inicio.jsp");
                        break;
                    default:
                        break;
                }
            }else{
                response.sendRedirect("error.jsp");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(CTRLUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

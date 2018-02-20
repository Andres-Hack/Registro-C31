package pReporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pClases.Actividad;
import pClases.Subactividad;
import pClases.Subcomponente;
import pModelo.DBConexion;

public class Consultas {
    
    public static Double Montos(String municipio, String subc, String bid_ctr){
        Connection con = DBConexion.IniciarSesion();
        double data123=MontoCompartidoSubc(municipio, subc, bid_ctr);
        String dato1="";
        if ("BID".equalsIgnoreCase(bid_ctr)) {
            dato1 = "monto_bs_bid";
        } else {
            dato1 = "monto_bs_ctr";
        }
        String consulta = "select round(sum(importe), 2) as total from tabla_c31 where inst='GAM' and gam_uep='"+municipio+"'and subc='"+subc+"' and bid_ctr='"+bid_ctr+"'";
        String consulta2 = "select round(sum("+dato1+"), 2) as total from detalle_c31 where gam='"+municipio+"'";
        double dato = 0, a= 0, b=0;        
        
        try {
            Statement statement = con.createStatement();            
            ResultSet rs = statement.executeQuery(consulta);
            
            while (rs.next()) { a=rs.getDouble("total"); }

            rs.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement statement2 = con.createStatement();            
            ResultSet rs2 = statement2.executeQuery(consulta2);
            
            while (rs2.next()) { b=rs2.getDouble("total"); }
            
            rs2.close();
            statement2.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        dato=a+b+data123;
        return dato;
    }
    public static String montoAcdtividad(String subc, String act, String gam, String bid_ctr) {
        Statement statement;
        ResultSet rs;
        String monto ="";
        Connection con = DBConexion.IniciarSesion();
        double suma = 0;
        double data123=MontoCompartidoAct(subc, act, gam, bid_ctr);
        try {
            statement = con.createStatement();
            rs = statement.executeQuery("select round(sum(importe), 2) as total from tabla_c31 where subc='"+subc+"' and act='"+act+"' and gam_uep='"+gam+"' and bid_ctr='"+bid_ctr+"'");
            while (rs.next()) {
                suma = rs.getDouble("total");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        suma = suma+data123;
        monto = String.valueOf(suma);
        return monto;
    }
    public static String montoSubactividad(String subact, String gam, String bid_ctr) {
        Statement statement;
        ResultSet rs;
        String monto ="";
        Connection con = DBConexion.IniciarSesion();
        double suma = 0;
        double data123=MontoCompartidoSubAct(subact, gam, bid_ctr);
        try {
            statement = con.createStatement();
            rs = statement.executeQuery("select round(sum(importe), 2) as total from tabla_c31 where subact='"+subact+"' and gam_uep='"+gam+"' and bid_ctr='"+bid_ctr+"'");
            while (rs.next()) {
                suma = rs.getDouble("total");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        suma = suma+data123;
        monto = String.valueOf(suma);
        return monto;
    }
    /*##############################################################
    ################################################################
    ################## CONSULTAS DE LOS CODIGOS ####################
    ################################################################
    ##############################################################*/
    public static LinkedList<Subcomponente> Subcomponente() throws SQLException {
        LinkedList<Subcomponente> subc;
        Statement statement;
        ResultSet rs;
        try (Connection cnn = DBConexion.IniciarSesion()) {
            subc = new LinkedList<Subcomponente>();
            statement = cnn.createStatement();
            rs = statement.executeQuery("select codigo from subactividad");
            while (rs.next()) {
                Subcomponente obj = new Subcomponente();
                obj.setCodigo(rs.getString("codigo"));
                subc.add(obj);
            }
            cnn.close();
        }
        rs.close();
        statement.close();
        return subc;        
    }
    public static LinkedList<Actividad> Actividad(int d) throws SQLException {
        LinkedList<Actividad> act;
        Statement statement;
        ResultSet rs;
        try (Connection cnn = DBConexion.IniciarSesion()) {
            act = new LinkedList<Actividad>();
            statement = cnn.createStatement();
            rs = statement.executeQuery("select codigo from actividad where id_subc='"+d+"'");
            while (rs.next()) {
                Actividad obj = new Actividad();
                obj.setCodigo(rs.getString("codigo"));
                act.add(obj);
            }
            cnn.close();
        }
        rs.close();
        statement.close();
        return act;        
    }
    public static LinkedList<Subactividad> Subactividad(int d) throws SQLException {
        LinkedList<Subactividad> subact;
        Statement statement;
        ResultSet rs;
        try (Connection cnn = DBConexion.IniciarSesion()) {
            subact = new LinkedList<Subactividad>();
            statement = cnn.createStatement();
            rs = statement.executeQuery("select codigo from subactividad where id_act='"+d+"'");
            while (rs.next()) {
                Subactividad obj = new Subactividad();
                obj.setCodigo(rs.getString("codigo"));
                subact.add(obj);
            }
            cnn.close();
        }
        rs.close();
        statement.close();
        return subact;        
    }
    public static String MontoDetalle(String muni) {
        Statement statement1, statement2;
        ResultSet rs1, rs2;
        String monto ="";
        Connection con = DBConexion.IniciarSesion();
        try {
            statement1 = con.createStatement();
            statement2 = con.createStatement();
            rs1 = statement1.executeQuery("select round(sum(monto_bs_bid), 2) as total from detalle_c31 where gam='"+muni+"'");
            rs2 = statement2.executeQuery("select round(sum(monto_bs_ctr), 2) as total from detalle_c31 where gam='"+muni+"'");
            while (rs1.next()) {
                monto = rs1.getString("total");
            }
            while (rs2.next()) {
                monto = monto+"-"+rs2.getString("total");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return monto;
        
    }
    /*##############################################################
    ################################################################
    ############## CONSULTAS DE MONTOS COMPARTIDOS #################
    ################################################################
    ##############################################################*/
    public static Double MontoCompartidoSubc(String municipio, String subc, String bid_ctr){
        Statement statement1;
        ResultSet rs1;
        Connection con = DBConexion.IniciarSesion();
        String monto ="", dato1="";
        double importe = 0, suma=0;
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select id from tabla_c31 where inst='UEP' and subc='"+subc+"'");
            while (rs1.next()) {
                monto = rs1.getString("id");
                Statement statement2;
                ResultSet rs2;
                if ("BID".equals(bid_ctr)) {
                    dato1 = "monto_bs_bid";
                } else {
                    dato1 = "monto_bs_ctr";
                }
                statement2 = con.createStatement();
                rs2 = statement2.executeQuery("select sum("+dato1+") as total from detalle_c31 where gam='"+municipio+"' and id_c31='"+monto+"'");
                while (rs2.next()) {
                    importe = rs2.getDouble("total");
                }
                suma = suma + importe;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return suma;
    }
    public static Double MontoCompartidoAct(String subc, String act, String gam, String bid_ctr){
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String monto ="", dato1="";
        double importe = 0, suma=0;
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select id from tabla_c31 where inst='UEP' and subc='"+subc+"' and act='"+act+"'");
            while (rs1.next()) {
                monto = rs1.getString("id");
                Statement statement2;
                ResultSet rs2;
                if ("BID".equals(bid_ctr)) {
                    dato1 = "monto_bs_bid";
                } else {
                    dato1 = "monto_bs_ctr";
                }
                statement2 = con.createStatement();
                rs2 = statement2.executeQuery("select sum("+dato1+") as total from detalle_c31 where gam='"+gam+"' and id_c31='"+monto+"'");
                while (rs2.next()) {
                    importe = rs2.getDouble("total");
                }
                suma = suma + importe;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return suma;
    }
    public static Double MontoCompartidoSubAct(String subact, String gam, String bid_ctr) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String monto ="", dato1="";
        double importe = 0, suma=0;
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select id from tabla_c31 where inst='UEP' and subact='"+subact+"'");
            while (rs1.next()) {
                monto = rs1.getString("id");
                Statement statement2;
                ResultSet rs2;
                if ("BID".equals(bid_ctr)) {
                    dato1 = "monto_bs_bid";
                } else {
                    dato1 = "monto_bs_ctr";
                }
                statement2 = con.createStatement();
                rs2 = statement2.executeQuery("select sum("+dato1+") as total from detalle_c31 where gam='"+gam+"' and id_c31='"+monto+"'");
                while (rs2.next()) {
                    importe = rs2.getDouble("total");
                }
                suma = suma + importe;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return suma;
    }
}
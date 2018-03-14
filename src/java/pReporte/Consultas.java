package pReporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pControlador.ListaPorcentaje;
import static pDistribucion.DTRmunicipios.PeriodoID;
import pModelo.DBConexion;

public class Consultas {
    /*##############################################################
    ################################################################
    ############## CONSULTAS DE REPORTE  #################
    ################################################################
    ##############################################################*/
    public static String ActividadID(String act) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String id_act ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select c_Actividad from Actividades where Codigo='"+act+"'");
            while (rs1.next()) {
                id_act = rs1.getString("c_Actividad");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return id_act;
    }
    public static String MontoActividadBID(String muni, String idact) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String monto ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select SUM(Importe * Porcentaje) / 100 AS Total_bs from Detalle where c_Municipio="+muni+" and c_Actividad="+idact+" and c_Fuente=1");
            while (rs1.next()) {
                monto = rs1.getString("Total_bs");
            }
            if(monto==null){ monto="0.0";}
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return monto;
    }
    public static String MontoActividadCTR(String muni, String idact) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String monto ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select SUM(Importe * Porcentaje) / 100 AS Total_bs from Detalle where c_Municipio="+muni+" and c_Actividad="+idact+" and c_Fuente=2");
            while (rs1.next()) {
                monto = rs1.getString("Total_bs");
            }
            if(monto==null){ monto="0.0";}
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return monto;
    }

    public static String MontoSubActividad(String muni, String subact, String bid_ctr, String Producto) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1=null;
        ResultSet rs1=null;
        double monto = 0.0;
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("SELECT        b.Codigo AS Cod_Activ, b.Descripcion AS Actividad, g.Producto AS Producto, g.BID_CTR, SUM(a.Importe * a.Porcentaje) / 100 AS Total_bs "
                    + "FROM            Detalle AS a INNER JOIN "
                    + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                    + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                    + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                    + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                    + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                    + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                    + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                    + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                    + "WHERE a.c_Municipio="+muni+" and a.c_Fuente="+bid_ctr+" and Producto='"+Producto+"' "
                    + "GROUP BY b.Codigo, b.Descripcion, g.Producto, g.BID_CTR "
                    + "ORDER BY Cod_Activ, g.BID_CTR");
            while (rs1.next()) {
                monto = rs1.getDouble("Total_bs");
            }
            if(monto==0.0){ monto=0.0;}
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return String.valueOf(monto);
    }
    public static String nombreProducto(String muni, String subact, String bid_ctr, String Producto) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1=null;
        ResultSet rs1=null;
        String descripcion ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("SELECT        b.Codigo AS Cod_Activ, b.Descripcion AS Actividad, g.Producto AS Producto, g.BID_CTR, SUM(a.Importe * a.Porcentaje) / 100 AS Total_bs "
                    + "FROM            Detalle AS a INNER JOIN "
                    + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                    + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                    + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                    + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                    + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                    + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                    + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                    + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                    + "WHERE a.c_Municipio="+muni+" and a.c_Fuente="+bid_ctr+" and Producto='"+Producto+"' and g.Subactividad LIKE '"+subact+"%' "
                    + "GROUP BY b.Codigo, b.Descripcion, g.Producto, g.BID_CTR "
                    + "ORDER BY Cod_Activ, g.BID_CTR");
            while (rs1.next()) {
                descripcion = rs1.getString("Producto");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripcion;
    }
    /*##############################################################
    ################################################################
    ############## CONSULTAS DE BUSQUEDA A DETALLE  ################
    ################################################################
    ##############################################################*/
    public static String MontoTotal(String gestion, String gam, String bid_ctr, String cambio) {
        Connection con = DBConexion.IniciarSesion();
        String BID_CTR = "", consulta_gestion="";
        double dolar=0.0;
        String IDperiodo = PeriodoID(gestion);
        String IDgam = ListaPorcentaje.IDmunicipio(gam);
        
        if (bid_ctr.equals("BID")) { BID_CTR = "1"; } else { BID_CTR = "2"; }
        if (cambio.equals("1")){ dolar=6.86; } else { dolar=1; }        
        if (!gestion.equals("TODO")) { consulta_gestion=" AND c_Periodo="+IDperiodo; }
        
        Statement statement=null;
        ResultSet rs=null;
        double monto = 0.0;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery("select SUM(Importe * Porcentaje) / (100*"+dolar+") AS Total FROM Detalle where c_Municipio="+IDgam+" "+consulta_gestion+" AND c_Fuente="+BID_CTR+"");          
            while (rs.next()) {        
                monto = monto + rs.getDouble("Total");     
            }
            if(monto==0.0){ monto=0.0;}
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return String.valueOf(monto);
    }
    public static String MontoTotalSubc(String gestion, String gam, String bid_ctr, String cambio, String subc) {
        Connection con2 = DBConexion.IniciarSesion();
        String BID_CTR = "", consulta_gestion="";
        double dolar=0.0;
        String IDperiodo = PeriodoID(gestion);
        String IDgam = ListaPorcentaje.IDmunicipio(gam);
        
        if (bid_ctr.equals("BID")) { BID_CTR = "1"; } else { BID_CTR = "2"; }
        if (cambio.equals("1")){ dolar=6.86; } else { dolar=1; } 
        if (!gestion.equals("TODO")) { consulta_gestion=" AND a.c_Periodo="+IDperiodo; }
        
        Statement statement2=null;
        ResultSet rs2=null;
        String consultaP = "SELECT    SUM(a.Importe * a.Porcentaje) / (100*" + dolar + ") AS Total_bs "
                + "FROM            Detalle AS a INNER JOIN "
                + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                + "WHERE a.c_Municipio="+IDgam+" and a.c_Fuente="+BID_CTR+" and b.c_Subcomponente="+subc+" "+consulta_gestion
                + " GROUP BY c.Codigo";

        double monto = 0.0;

                try {
                    statement2 = con2.createStatement();
                    rs2 = statement2.executeQuery(consultaP);
                    while (rs2.next()) {
                        monto = monto + rs2.getDouble("Total_bs");
                    }
                    if (monto == 0.0) {
                        monto = 0.0;
                    }
                    con2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                }

               
        return String.valueOf(monto);
    }
}
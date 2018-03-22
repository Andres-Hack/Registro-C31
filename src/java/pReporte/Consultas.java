package pReporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pClases.Registro;
import pControlador.ListaPorcentaje;
import pDistribucion.DTRmunicipios;
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
    public static String MontoActividadBID(String muni, String idact, String gestion, String dolar) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String monto ="", gest="";
        String IDgestion = DTRmunicipios.PeriodoID(gestion);
        if (IDgestion.equals("TODO")) { gest=" and (c_Periodo=1 or c_Periodo=2 or c_Periodo=3 or c_Periodo=4 or c_Periodo=5 or c_Periodo=6) "; }
        else{if(IDgestion.equals("4")){ gest=" and (c_Periodo=4 or c_Periodo=5) "; }else{ gest=" and c_Periodo="+IDgestion; }}
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select SUM(Importe * Porcentaje) / (100*"+dolar+") AS Total_bs from Detalle where c_Municipio="+muni+" and c_Actividad="+idact+" and c_Fuente=1 "+gest);
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
    public static String MontoActividadCTR(String muni, String idact, String gestion, String dolar) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1;
        ResultSet rs1;
        String monto ="", gest="";
        String IDgestion = DTRmunicipios.PeriodoID(gestion);
        if (IDgestion.equals("TODO")) { gest=" and (c_Periodo=1 or c_Periodo=2 or c_Periodo=3 or c_Periodo=4 or c_Periodo=5 or c_Periodo=6) "; }
        else{if(IDgestion.equals("4")){ gest=" and (c_Periodo=4 or c_Periodo=5) "; }else{ gest=" and c_Periodo="+IDgestion; }}
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select SUM(Importe * Porcentaje) / (100*"+dolar+") AS Total_bs from Detalle where c_Municipio="+muni+" and c_Actividad="+idact+" and c_Fuente=2 "+gest);
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

    public static String MontoSubActividad(String muni, String subact, String bid_ctr, String Producto, String gestion, String dolar) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1=null;
        ResultSet rs1=null;
        double monto = 0.0;
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("SELECT        b.Codigo AS Cod_Activ, b.Descripcion AS Actividad, g.Producto AS Producto, g.BID_CTR, SUM(a.Importe * a.Porcentaje) / (100*"+dolar+") AS Total_bs "
                    + "FROM            Detalle AS a INNER JOIN "
                    + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                    + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                    + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                    + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                    + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                    + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                    + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                    + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                    + "WHERE a.c_Municipio="+muni+" and a.c_Fuente="+bid_ctr+" and "+gestion+" and g.Producto='"+Producto+"'"
                    + " GROUP BY b.Codigo, b.Descripcion, g.Producto, g.BID_CTR "
                    + " ORDER BY Cod_Activ, g.BID_CTR");
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
    public static String MontoSubActividad2(String muni, String subact, String bid_ctr) {
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
                    + "WHERE a.c_Municipio="+muni+" and a.c_Fuente="+bid_ctr+" and g.Subactividad LIKE '"+subact+"%' "
                    + "GROUP BY b.Codigo, b.Descripcion, g.Producto, g.BID_CTR "
                    + "ORDER BY Cod_Activ, g.BID_CTR");
            System.out.println("%%%%%%"+"SELECT        b.Codigo AS Cod_Activ, b.Descripcion AS Actividad, g.Producto, g.BID_CTR, SUM(a.Importe * a.Porcentaje) / 100 AS Total_bs "
                    + "FROM            Detalle AS a INNER JOIN "
                    + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                    + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                    + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                    + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                    + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                    + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                    + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                    + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                    + "WHERE a.c_Municipio="+muni+" and a.c_Fuente="+bid_ctr+" and g.Subactividad LIKE '"+subact+"%' "
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
    public static String nombrePartida(String codigo) {
        Connection con = DBConexion.IniciarSesion();
        Statement statement1=null;
        ResultSet rs1=null;
        String descripcion ="";
        try {
            statement1 = con.createStatement();
            rs1 = statement1.executeQuery("select Descripcion from Partidas where Codigo='"+codigo+"'");
            while (rs1.next()) {
                descripcion = rs1.getString("Descripcion");
            }
            if (descripcion == null) {
                descripcion ="";
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
        if (!gestion.equals("TODO")) { 
            if (IDperiodo.equals("4")) {
                consulta_gestion=" AND (c_Periodo=4 or c_Periodo=5) ";
            } else {
                consulta_gestion=" AND c_Periodo="+IDperiodo;
            }
        }
        else{
            consulta_gestion=" AND (c_Periodo=1 or c_Periodo=2 or c_Periodo=3 or c_Periodo=4 or c_Periodo=5 or c_Periodo=6) ";
        }
        
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
        if (!gestion.equals("TODO")) { 
            if (IDperiodo.equals("4")) {
                consulta_gestion=" AND (a.c_Periodo=4 or a.c_Periodo=5) ";
            } else {
                consulta_gestion=" AND a.c_Periodo="+IDperiodo;
            }
        }
        else{
            consulta_gestion=" AND (a.c_Periodo=1 or a.c_Periodo=2 or a.c_Periodo=3 or a.c_Periodo=4 or a.c_Periodo=5 or a.c_Periodo=6) ";
        }
        
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
        System.out.println("#####> "+consultaP);
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
    public static String MontoPartida(String partida, String bid_ctr, String IDgam, String subc, String gestion, String dolar) {
        Connection con = DBConexion.IniciarSesion();        
        Statement statement=null;
        ResultSet rs=null;
        double monto = 0.0;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT        h.Gestrion AS Gestión, c.Codigo AS Cod_Subcomp, g.Partida, g.BID_CTR, SUM(a.Importe * a.Porcentaje) / (100*"+dolar+") AS Total_bs "
                    + "FROM            Detalle AS a INNER JOIN "
                    + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                    + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                    + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                    + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                    + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                    + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                    + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                    + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                    + "WHERE g.Partida='"+partida+"' and g.BID_CTR='"+bid_ctr+"' and a.c_Municipio="+IDgam+" and c.Codigo='"+subc+"' and "+gestion
                    + "GROUP BY h.Gestrion, c.Codigo, g.Partida, g.BID_CTR "
                    + "ORDER BY Gestión, Cod_Subcomp, g.Partida ");
            while (rs.next()) {        
                monto = monto + rs.getDouble("Total_bs");     
            }
            if(monto==0.0){ monto=0.0;}
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return String.valueOf(monto);
    }
    /*##############################################################
    ################################################################
    ############## CONSULTAS DE LA VISTA MODIFICAR  ################
    ################################################################
    ##############################################################*/
    public static LinkedList<Registro> getListaC31()
    {
        LinkedList<Registro> listaRigistros = new LinkedList<Registro>();

        Statement st = null;
        ResultSet rs = null;

        try (Connection con = DBConexion.IniciarSesion()) {
            st = con.createStatement();
            rs = st.executeQuery("select * from C31 order by c_C31 desc");
            while (rs.next()) {
                Registro registro = new Registro();
                registro.setC_C31(rs.getInt("c_C31"));
                registro.setAnio(rs.getString("Anio"));
                registro.setBeneficiario(rs.getString("Beneficiario"));
                listaRigistros.add(registro);
            }
            rs.close();
            st.close();
            con.close();
        }

       catch (SQLException e)
       {
           System.err.println("ERROR .. !!! "+e);
       }
       return listaRigistros;
    }
}
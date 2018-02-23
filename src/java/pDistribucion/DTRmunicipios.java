package pDistribucion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import pClases.Registro;
import pModelo.DBConexion;


/**
 *
 * @author andres
 */
public class DTRmunicipios {
    
    public static void distribucion(Registro R2) {
        distribucionA(R2);
        System.out.println("REGISTRAMOS BIEN EN C31");
        String id = buscarID();
        System.out.println("BUSCAMOS BIEN EL ID : "+id);
        distribucionB(R2, id);
        System.out.println("SE REGISTRO CORRECTAMENTE EL DISTRIBUCION");
    }
    
    public static void distribucionA(Registro R2)  {
        
        Connection cnn = DBConexion.IniciarSesion();
        
        try {
            PreparedStatement ps = cnn.prepareStatement("insert into tabla_c31(id, gestion,fech_emision,fech_pago,mes_c31,mes_pago,nro_c31,bid_ctr,ff,of,descripcion,subc,act,subact,cat_gast,tg,partida,inst,gam_uep,beneficiario,tipo,producto,actividad2,concepto,importe,tc,importe_usd,observaciones, hr, nro_factura) values "
                    + "                                 (null,YEAR(NOW()),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, R2.getFech_emision());
            ps.setString(2, R2.getFech_pago());
            ps.setString(3, R2.getMes_c31());
            ps.setString(4, R2.getMes_pago());
            ps.setString(5, R2.getNro_c31());
            ps.setString(6, R2.getBid_ctr());
            ps.setString(7, R2.getFf());
            ps.setString(8, R2.getOf());
            ps.setString(9, R2.getDescripcion());
            ps.setString(10, R2.getSubc());
            ps.setString(11, R2.getAct());
            ps.setString(12, R2.getSubact());
            ps.setString(13, R2.getCat_gast());
            ps.setString(14, R2.getTg());
            ps.setString(15, R2.getPartida());
            ps.setString(16, "UEP");
            ps.setString(17, "UEP");
            ps.setString(18, R2.getBeneficiario());
            ps.setString(19, R2.getTipo());
            ps.setString(20, R2.getProducto());
            ps.setString(21, R2.getActividad2());
            ps.setString(22, R2.getConcepto());
            ps.setString(23, R2.getImporte());
            ps.setString(24, R2.getTc());
            ps.setString(25, R2.getImporte_usd());
            ps.setString(26, R2.getObservaciones());
            ps.setString(27, R2.getHr());
            ps.setString(28, R2.getNro_factura());
            
            ps.executeUpdate();
            
            cnn.commit();
            cnn.close();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(":( ESTE ES EL ERROR : "+e);
        }        
    }
    
    public static void distribucionB(Registro R2, String id)  {
        Connection con = DBConexion.IniciarSesion();
        //############################################# AUTOMATIZAR
        String municipios[] = {"COB","COB","CBB","EAL","ORU","POT","SAC","SCZ","SER","TAR","TOR","TDD","VIA"};
        //############################################# AUTOMATIZAR
        Double porcentaje=0.0;
        String consulta="", consulta2="";
        ResultSet rs = null;
        PreparedStatement pst = null, pst2 = null;
        Calendar cal= Calendar.getInstance();
        String gestion = Integer.toString(cal.get(Calendar.YEAR));
        String fuente = R2.getBid_ctr();
        System.out.println("INGRESO AL DIST CON LA GESTION : "+gestion);
        //############################################# AUTOMATIZAR
        if(gestion.equals("2018")){
            gestion="2017";
        }
        //#############################################
        for (int j = 0; j <= 11; j++) {          
                                                                
            consulta = "select porcentaje from porcentaje_dist where gam='"+municipios[j]+"' and gestion='"+gestion+"' and subc='"+R2.getSubc()+"'";
            try {
                pst = con.prepareStatement(consulta);
                rs = pst.executeQuery();
                while (rs.next()) { 
                    porcentaje = rs.getDouble("porcentaje"); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Double importeF = Double.parseDouble(R2.getImporte());
            Double importe_usdF = Double.parseDouble(R2.getImporte_usd());
            Double resultado1 = importeF*porcentaje;
            Double resultado2 = importe_usdF*porcentaje;
            System.out.println("multiplica esto : "+importeF+" con esto : "+porcentaje+" resulta esto : "+resultado1+" de la gestion : "+gestion+" con fuente : "+fuente);
            if (fuente.equals("BID")) {
                consulta2="INSERT INTO detalle_c31 (id_c31, gestion, gam, porcentaje, monto_bs_bid, monto_usd_bid, monto_bs_ctr, monto_usd_ctr) VALUES (?,?,?,?,?,?,0.0,0.0)";
            } else {
                consulta2="INSERT INTO detalle_c31 (id_c31, gestion, gam, porcentaje, monto_bs_bid, monto_usd_bid, monto_bs_ctr, monto_usd_ctr) VALUES (?,?,?,?,0.0,0.0,?,?)";
            }
            try {
                pst2 = con.prepareStatement(consulta2);
                pst2.setString(1,id);
                pst2.setString(2,gestion);
                pst2.setString(3,municipios[j]);
                pst2.setString(4,String.valueOf(porcentaje));
                pst2.setString(5,Double.toString(resultado1));
                pst2.setString(6,Double.toString(resultado2));
                pst2.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    public static String buscarID() {
        String id = "";
        Connection con = DBConexion.IniciarSesion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("select id from tabla_c31 order by id desc limit 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
        }                                                   
        return id;
    }
    
}

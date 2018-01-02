package pDistribucion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pClases.Registro;
import pModelo.DBConexion;


/**
 *
 * @author andres
 */
public class DTRmunicipios {
    
    public static void distribucionA(Registro R2)  {
        
        String [] dist = {"3.65","21.32","23.00","8.00","5.25","5.47","8.75","8.23","6.10","2.29","5.74","2.19"};
        String municipios[] = {"COB","CBB","EAL","ORU","POT","SAC","SCZ","SRE","TAR","TOR","TDD","VIA"};
        System.out.println("SUBACTIVIDAD : "+R2.getSubc());
        
        for (int i = 0; i < 11; i++) {
            registrar(R2, dist[i], municipios[i]);
        }
    }
    
    public static void distribucionB(Registro R2)  {
        String dist[] = {"2.87","16.76","18.08","6.29","4.13","4.98","27.27","6.47","4.79","2.13","4.51","1.72"};
        String municipios[] = {"COB","CBB","EAL","ORU","POT","SAC","SCZ","SRE","TAR","TOR","TDD","VIA"};
        System.out.println("SUBACTIVIDAD : "+R2.getSubc());
        
        for (int i = 0; i < 11; i++) {
            registrar(R2, dist[i], municipios[i]);
        }
    }
    
    public static void registrar(Registro R3, String porcentaje, String municipio) {
    
        
        float a=Float.parseFloat(R3.getImporte());
        float b=Float.parseFloat(R3.getImporte_usd());
        float c=Float.parseFloat(porcentaje); 
        float result1 = (a*c)/100;
        float result2 = (b*c)/100;
        
        try {
        Connection cnn = DBConexion.IniciarSesion();
        cnn.setAutoCommit(false);
        try {
        PreparedStatement ps = cnn.prepareStatement("insert into tabla_c31(id, gestion,fech_emision,fech_pago,mes_c31,mes_pago,nro_c31,bid_ctr,ff,of,descripcion,subc,act,subact,cat_gast,tg,partida,inst,gam_uep,beneficiario,tipo,producto,actividad2,concepto,importe,tc,importe_usd,observaciones, hr, nro_factura) values "
        + "                                 (null,YEAR(NOW()),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        ps.setString(1, R3.getFech_emision());
        ps.setString(2, R3.getFech_pago());
        ps.setString(3, R3.getMes_c31());
        ps.setString(4, R3.getMes_pago());
        ps.setString(5, R3.getNro_c31());
        ps.setString(6, R3.getBid_ctr());
        ps.setString(7, R3.getFf());
        ps.setString(8, R3.getOf());
        ps.setString(9, R3.getDescripcion());
        ps.setString(10, R3.getSubc());
        ps.setString(11, R3.getAct());
        ps.setString(12, R3.getSubact());
        ps.setString(13, R3.getCat_gast());
        ps.setString(14, R3.getTg());
        ps.setString(15, R3.getPartida());
        ps.setString(16, "UEP");
        ps.setString(17, municipio);
        ps.setString(18, R3.getBeneficiario());
        ps.setString(19, R3.getTipo());
        ps.setString(20, R3.getProducto());
        ps.setString(21, R3.getActividad2());
        ps.setString(22, R3.getConcepto());
        ps.setString(23, Float.toString(result1));
        ps.setString(24, R3.getTc());
        ps.setString(25, Float.toString(result2));
        ps.setString(26, R3.getObservaciones());
        ps.setString(27, R3.getHr());
        ps.setString(28, R3.getNro_factura());
        ps.executeUpdate();
        cnn.commit();
        cnn.close();
        ps.close();
        System.out.print("se guardo con nexito ..!!");
        } catch (SQLException e) {
        cnn.rollback();
        System.out.println("ESTE ES EL ERROR : "+e);
        }
        } catch (SQLException ex) {
        Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

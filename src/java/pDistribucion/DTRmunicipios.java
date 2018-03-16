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
        
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        String IDperiodo = PeriodoID(String.valueOf(año));
        System.out.println("BUSCAMOS BIEN EL ID DEL PERIODO : "+IDperiodo+" EN AÑO : "+año);
        distribucionA(R2, IDperiodo);
        System.out.println("REGISTRAMOS BIEN EN C31");
        String id_C31 = buscarID();
        System.out.println("BUSCAMOS BIEN EL ID : "+id_C31);
        String IDactividad = ActividadID(R2.getActividad());
        System.out.println("BUSCAMOS BIEN EL ID DEL ACTIVIDAD : "+IDactividad+" DE LA ACTIVIDAD "+R2.getActividad());
        
        /*//////////////////////////////////////*/
        distribucionB(R2, id_C31, IDactividad, IDperiodo);        
        System.out.println("SE REGISTRO CORRECTAMENTE EL DISTRIBUCION");
        /*//////////////////////////////////////*/
    }
    
    public static void distribucionA(Registro R2, String IDperiodo)  {
        
        Connection cnn = DBConexion.IniciarSesion();
        
        try {
            PreparedStatement ps = cnn.prepareStatement("insert into C31(Anio, Anio_Pago, Fecha_Emision, Fecha_Pago, Mes_Dev, Mes_Pago, C31, BID_CTR, F_F, O_F, SubComp, Descripcion, Actividad, Descripcion_Actividad, Subactividad, Descripcion_Subactividad, C_G, T_G, Partida, Inst, GAM_UEP, Beneficiario, Tipo, Producto, Concepto, Importe_Bs, TC, Importe_Us, c_Periodo, Distribuible, Hoja_Ruta, Nro_Factura) values "
                    + "                                 (YEAR(NOW()),YEAR(NOW()),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, R2.getFecha_Emision());
            ps.setString(2, R2.getFecha_Pago());
            ps.setString(3, R2.getMes_Dev());
            ps.setString(4, R2.getMes_Pago());
            ps.setString(5, R2.getC31());
            ps.setString(6, R2.getBID_CTR());
            ps.setString(7, R2.getF_F());
            ps.setString(8, R2.getO_F());
            ps.setString(9, R2.getSubComp());
            ps.setString(10, R2.getDescripcion());            
            ps.setString(11, R2.getActividad());
            ps.setString(12, R2.getDescripcion_Actividad());
            ps.setString(13, R2.getSubactividad());
            ps.setString(14, R2.getDescripcion_Subactividad());
            ps.setString(15, R2.getC_G());
            ps.setString(16, R2.getT_G());
            ps.setString(17, R2.getPartida());
            ps.setString(18, "UEP");
            ps.setString(19, "UEP");
            ps.setString(20, R2.getBeneficiario());
            ps.setString(21, R2.getTipo());
            ps.setString(22, R2.getProducto());            
            ps.setString(23, R2.getConcepto());
            ps.setString(24, R2.getImporte_Bs());
            ps.setString(25, R2.getTC());
            ps.setString(26, R2.getImporte_Us());
            ps.setString(27, IDperiodo);
            ps.setString(28, "1");
            ps.setString(29, R2.getHoja_Ruta());
            ps.setString(30, R2.getNro_Factura());
            ps.executeUpdate();
            
            cnn.commit();
            cnn.close();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(":( ESTE ES EL ERROR : "+e);
        }        
    }
    
    public static void distribucionB(Registro R2, String id_C31, String IDactividad, String IDperiodo)  {
        Connection con = DBConexion.IniciarSesion();
        
        Double porcentaje=0.0;
        String consulta="", consulta2="";
        ResultSet rs = null;
        PreparedStatement pst = null, pst2 = null;
        String BID_CTR="";
        if (R2.getBID_CTR().equals("BID")) { BID_CTR = "1"; } else { BID_CTR = "2"; }

        for (int j = 1; j <= 12; j++) {          
                                                                
            consulta = "select Porcentaje from Porcentajes where c_Municipio="+j+" and c_Periodo="+IDperiodo+" and SubComp='"+R2.getSubComp()+"'";
            try {
                pst = con.prepareStatement(consulta);
                rs = pst.executeQuery();
                while (rs.next()) { 
                    porcentaje = rs.getDouble("Porcentaje"); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            consulta2="INSERT INTO Detalle (c_C31, c_Municipio, c_Actividad, c_Periodo, c_Fuente, Porcentaje, Importe, TC) VALUES (?,?,?,?,?,?,?,?)";
            try {
                pst2 = con.prepareStatement(consulta2);
                pst2.setString(1,id_C31);
                pst2.setString(2,String.valueOf(j));
                pst2.setString(3,IDactividad);
                pst2.setString(4,IDperiodo);
                pst2.setString(5,BID_CTR);
                pst2.setString(6,String.valueOf(porcentaje));
                pst2.setString(7,R2.getImporte_Bs());
                pst2.setString(8,String.valueOf(6.86));
                pst2.executeUpdate();
                System.out.println("LA DISTRIBUCION SE REALIZO SATISFACTORIUAMENTE .... XD");
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
            pst = con.prepareStatement("select c_C31 from C31 order by c_C31 desc limit 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("c_C31");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
        }                                                   
        return id;
    }
    public static String ActividadID( String idactividad) {
        String id = "";
        Connection con = DBConexion.IniciarSesion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("select c_Actividad from Actividades where Codigo='"+idactividad+"'");
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("c_Actividad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
        }                                                   
        return id;
    }
    public static String PeriodoID( String idperiodo) {
        String id = "";
        Connection con = DBConexion.IniciarSesion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("select c_Periodo from Periodos where Gestion='"+idperiodo+"'  LIMIT 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("c_Periodo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DTRmunicipios.class.getName()).log(Level.SEVERE, null, ex);
        }                                                   
        return id;
    }
}

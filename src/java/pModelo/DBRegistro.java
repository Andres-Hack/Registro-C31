package pModelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import pClases.Registro;
import pControlador.ListaPorcentaje;
import pDistribucion.DTRmunicipios;
import static pDistribucion.DTRmunicipios.ActividadID;
import static pDistribucion.DTRmunicipios.PeriodoID;
import static pDistribucion.DTRmunicipios.buscarID;
import static pDistribucion.DTRmunicipios.detalleID;

public abstract class DBRegistro {
    
    public static ArrayList<Registro> lista_persona() throws SQLException {
        Connection cnn = DBConexion.IniciarSesion();
        ArrayList<Registro> lista = new ArrayList<Registro>();
        CallableStatement cs = cnn.prepareCall("SELECT * from tabla_c31;");
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            Registro obj = new Registro() {}; 
            obj.setC_C31(rs.getInt("id"));
            obj.setAnio_Pago(rs.getString("gestion"));
            obj.setFecha_Emision(rs.getString("fech_emision"));
            obj.setFecha_Pago(rs.getString("fech_pago"));
            obj.setMes_Dev(rs.getString("mes_c31"));
            obj.setMes_Pago(rs.getString("mes_pago"));
            obj.setC31(rs.getString("nro_c31"));
            obj.setBeneficiario(rs.getString("beneficiario"));
            obj.setProducto(rs.getString("producto"));
            obj.setImporte_Bs(rs.getString("importe"));
            lista.add(obj);
        }
        cnn.close();
        cs.close();
        return lista;
    }
    
    public static void adicion(Registro R, String sw, String us) throws SQLException {
        
        Connection cnn = DBConexion.IniciarSesion();        
        cnn.setAutoCommit(false);
        
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        String IDperiodo = PeriodoID(String.valueOf(año));
        
        try {
            PreparedStatement ps = cnn.prepareStatement("insert into C31(Anio, Anio_Pago, Fecha_Emision, Fecha_Pago, Mes_Dev, Mes_Pago, C31, BID_CTR, F_F, O_F, SubComp, Descripcion, Actividad, Descripcion_Actividad, Subactividad, Descripcion_Subactividad, C_G, T_G, Partida, Inst, GAM_UEP, Beneficiario, Tipo, Producto, Concepto, Importe_Bs, TC, Importe_Us, c_Periodo, Distribuible, Hoja_Ruta, Nro_Factura) values "
                    + "                                 (YEAR(NOW()),YEAR(NOW()),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, R.getFecha_Emision());
            ps.setString(2, R.getFecha_Pago());
            ps.setString(3, R.getMes_Dev());
            ps.setString(4, R.getMes_Pago());
            ps.setString(5, R.getC31());
            ps.setString(6, R.getBID_CTR());
            ps.setString(7, R.getF_F());
            ps.setString(8, R.getO_F());
            ps.setString(9, R.getSubComp());
            ps.setString(10, R.getDescripcion());            
            ps.setString(11, R.getActividad());
            ps.setString(12, R.getDescripcion_Actividad());
            ps.setString(13, R.getSubactividad());
            ps.setString(14, R.getDescripcion_Subactividad());
            ps.setString(15, R.getC_G());
            ps.setString(16, R.getT_G());
            ps.setString(17, R.getPartida());
            ps.setString(18, R.getInst());
            ps.setString(19, R.getGAM_UEP());
            ps.setString(20, R.getBeneficiario());
            ps.setString(21, R.getTipo());
            ps.setString(22, R.getProducto());            
            ps.setString(23, R.getConcepto());
            ps.setString(24, R.getImporte_Bs());
            ps.setString(25, R.getTC());
            ps.setString(26, R.getImporte_Us());
            ps.setString(27, IDperiodo);
            ps.setString(28, "0");
            ps.setString(29, R.getHoja_Ruta());
            ps.setString(30, R.getNro_Factura());
            ps.executeUpdate();
            
            cnn.commit();
            cnn.close();
            ps.close();
           
            adicionDetalle(R, sw, us);
            
        } catch (SQLException e) {
            cnn.rollback();
            System.out.println("ESTE ES EL ERROR : "+e);
        }       
    }
    
   public static void adicionDetalle(Registro R, String sw, String us){
       String id_C31 = buscarID();
       String IDactividad = ActividadID(R.getActividad());
       String IDgam = ListaPorcentaje.IDmunicipio(R.getGAM_UEP());
       Calendar fecha = Calendar.getInstance();
       int año = fecha.get(Calendar.YEAR);
       String IDperiodo = PeriodoID(String.valueOf(año));
       String BID_CTR = "";
       if (R.getBID_CTR().equals("BID")) { BID_CTR = "1"; } else { BID_CTR = "2"; }
       
       Connection cnn = DBConexion.IniciarSesion();        
        
        try {
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO Detalle (c_C31, c_Municipio, c_Actividad, c_Periodo, c_Fuente, Porcentaje, Importe, TC) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, id_C31);
            ps.setString(2, IDgam);
            ps.setString(3, IDactividad);
            ps.setString(4, IDperiodo);
            ps.setString(5, BID_CTR);
            ps.setString(6, "100.0");
            ps.setString(7, R.getImporte_Bs());
            ps.setString(8, String.valueOf(6.86));
            ps.executeUpdate();
            
            cnn.commit();
            cnn.close();
            ps.close();
            
            String id_Detalle = detalleID();
            DTRmunicipios.LogTableAction(us,"C31",id_C31, sw);
            DTRmunicipios.LogTableAction(us,"Detalle",id_Detalle, sw);
                        
            
            
        } catch (SQLException e) {
            System.out.println("ESTE ES EL ERROR : "+e);
        }
       
   }
}

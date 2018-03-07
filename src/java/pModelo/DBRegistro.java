package pModelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pClases.Registro;

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
    
    public static void adicion(Registro R) throws SQLException {
        
        Connection cnn = DBConexion.IniciarSesion();        
        cnn.setAutoCommit(false);
        
        try {
            PreparedStatement ps = cnn.prepareStatement("insert into C31(Anio, Anio_Pago, Fecha_Emision, Fecha_Pago, Mes_Dev, Mes_Pago, C31, BID_CTR, F_F, O_F, SubComp, Descripcion, Actividad, Descripcion_Actividad, Subactividad, Descripcion_Subactividad, C_G, T_G, Partida, Inst, GAM_UEP, Beneficiario, Tipo, Producto, Concepto, Importe_Bs, TC, Importe_Us) values "
                    + "                                 (YEAR(NOW()),YEAR(NOW()),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            ps.setString(14, "ninguno");
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
            ps.executeUpdate();
            
            cnn.commit();
            cnn.close();
            ps.close();
            System.out.println("SE REGISTRO SATISFACTORIAMENTE ..!!!!!!!!!");
            
        } catch (SQLException e) {
            cnn.rollback();
            System.out.println("ESTE ES EL ERROR : "+e);
        }       
    }
}

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
            obj.setId(rs.getInt("id"));
            obj.setGestion(rs.getString("gestion"));
            obj.setFech_emision(rs.getString("fech_emision"));
            obj.setFech_pago(rs.getString("fech_pago"));
            obj.setMes_c31(rs.getString("mes_c31"));
            obj.setMes_pago(rs.getString("mes_pago"));
            obj.setNro_c31(rs.getString("nro_c31"));
            obj.setBeneficiario(rs.getString("beneficiario"));
            obj.setProducto(rs.getString("producto"));
            obj.setImporte(rs.getString("importe"));
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
            PreparedStatement ps = cnn.prepareStatement("insert into tabla_c31(id, gestion,fech_emision,fech_pago,mes_c31,mes_pago,nro_c31,bid_ctr,ff,of,descripcion,subc,act,subact,cat_gast,tg,partida,inst,gam_uep,beneficiario,tipo,producto,actividad2,concepto,importe,tc,importe_usd,observaciones, hr, nro_factura) values(null,Date_format(now(),'%Y',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, R.getFech_emision());
            ps.setString(2, R.getFech_pago());
            ps.setString(3, R.getMes_c31());
            ps.setString(4, R.getMes_pago());
            ps.setString(5, R.getNro_c31());
            ps.setString(6, R.getBid_ctr());
            ps.setString(7, R.getFf());
            ps.setString(8, R.getOf());
            ps.setString(9, R.getDescripcion());
            ps.setString(10, R.getSubc());
            ps.setString(11, R.getAct());
            ps.setString(12, R.getSubact());
            ps.setString(13, R.getCat_gast());
            ps.setString(14, R.getTg());
            ps.setString(15, R.getPartida());
            ps.setString(16, R.getInst());
            ps.setString(17, R.getGam_uep());
            ps.setString(18, R.getBeneficiario());
            ps.setString(19, R.getTipo());
            ps.setString(20, R.getProducto());
            ps.setString(21, R.getActividad2());
            ps.setString(22, R.getConcepto());
            ps.setString(23, R.getImporte());
            ps.setString(24, R.getTc());
            ps.setString(25, R.getImporte_usd());
            ps.setString(26, R.getObservaciones());
            ps.setString(27, R.getHr());
            ps.setString(28, R.getNro_factura());
            
            ps.executeUpdate();
            
            cnn.commit();
            cnn.close();
            ps.close();
            
            
        } catch (SQLException e) {
            cnn.rollback();
        }
        
    }
    
    
}

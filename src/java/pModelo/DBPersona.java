package pModelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pClases.Persona;

public abstract class DBPersona {                        
       
    public static ArrayList<Persona> lista_persona() throws SQLException {
        Connection cnn = DBConexion.IniciarSesion();
        ArrayList<Persona> lista = new ArrayList<Persona>();
        CallableStatement cs = cnn.prepareCall("SELECT * from sp_listapersona()");
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            Persona obj = new Persona() {};          
            obj.setPer_ci(rs.getString("per_ci"));            
            obj.setPer_paterno(rs.getString("per_paterno"));
            obj.setPer_materno(rs.getString("per_materno"));
            obj.setPer_nombre(rs.getString("per_nombre"));        
            obj.setPer_telefono(rs.getString("per_telefono"));                   
            lista.add(obj);
        }
        cnn.close();
        cs.close();
        return lista;
    }
       
    public static void adicion(Persona P) throws SQLException {                                             
         Connection cnn = DBConexion.IniciarSesion();
         cnn.setAutoCommit(false);
         try {             
             PreparedStatement ps=cnn.prepareStatement("insert into persona(per_ci,per_paterno,per_materno,per_nombre,per_telefono) values(?,?,?,?,?)");        
             ps.setString(1,P.getPer_ci());
             ps.setString(2,P.getPer_paterno());
             ps.setString(3,P.getPer_materno());
             ps.setString(4,P.getPer_nombre());
             ps.setString(5,P.getPer_telefono());                         
             ps.executeUpdate(); 
             cnn.commit();
             cnn.close();
             ps.close();            
         }catch(SQLException e)
         {  
            cnn.rollback();
         }    
                        
     }
     
     public static void modificar(Persona P) throws SQLException {       
         Connection cnn = DBConexion.IniciarSesion();
         cnn.setAutoCommit(false);
         try {             
             String SQL="update persona set per_paterno=?,per_materno=?,per_nombre=?,per_telefono=? where per_ci=?";         
             PreparedStatement ps=cnn.prepareStatement(SQL);                                     
             ps.setString(1,P.getPer_paterno());
             ps.setString(2,P.getPer_materno()); 
             ps.setString(3,P.getPer_nombre());
             ps.setString(4,P.getPer_telefono());
             ps.setString(5,P.getPer_ci().trim());             
             ps.executeUpdate();
             cnn.commit();
             cnn.close();
             ps.close();       
         }catch(SQLException e)
         {  
             cnn.rollback();
         }   
     }   
     
     public static void eliminar(String codigo) throws SQLException 
     {     
         Connection cnn = DBConexion.IniciarSesion();
         cnn.setAutoCommit(false);
         try {                        
             String SQL="delete from persona where per_ci=?";         
             PreparedStatement ps=cnn.prepareStatement(SQL);         
             ps.setString(1,codigo);                 
             ps.executeUpdate();   
             cnn.commit();
             cnn.close();
             ps.close();        
         }catch(SQLException e)
         {  
             cnn.rollback();
         }                      
     }
     
     public static void cambiar(String codigo) throws SQLException 
     {     
         Connection cnn = DBConexion.IniciarSesion();
         cnn.setAutoCommit(false);
         try {                        
             String SQL="delete from persona where per_ci=?";         
             PreparedStatement ps=cnn.prepareStatement(SQL);         
             ps.setString(1,codigo);                 
             ps.executeUpdate();   
             cnn.commit();
             cnn.close();
             ps.close();        
         }catch(SQLException e)
         {  
             cnn.rollback();
         }                      
     }
}
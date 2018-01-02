package pModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBUsuario {                        
       public  static boolean  Login(String usuario,String password, String log) throws SQLException{
           PreparedStatement ps;
           boolean sw;
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; //Herramienta para vincular la conexion
               ResultSet rs=null; //Para recibir los resultados            
               sw = false; //para validar si existe el usuario
               String SQL="select * from personal where usuario=? and clave=? and (log=? or log='0')";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); //Para enviar datos al parametro
               ps.setString(2,password); //Para enviar datos al parametro
               ps.setString(3,log);
               rs=ps.executeQuery(); //Ejecuta la consulta
               if (rs.next()) sw=true; // Verifica si existe resultados
           } //Herramienta para vincular la conexion
           ps.close();
           return sw; //Retornar valor
       }
       
       public static String Log(String usuario,String password) throws SQLException {
           PreparedStatement ps;
           String name = "", last="", email="", dato="";
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; 
               ResultSet rs=null;           
               String SQL="select nombre,apellido,correo from personal where usuario=? and clave=?";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); 
               ps.setString(2,password); 
               rs=ps.executeQuery(); 
               
               while (rs.next()) {
                    name = rs.getString("nombre");
                    last = rs.getNString("apellido");
                    email = rs.getNString("correo");
                }
               dato = name+" "+last;
               System.err.println("Este es el nombre"+dato);
           }
           ps.close();
           return dato; 
       }       
}
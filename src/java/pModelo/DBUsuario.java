package pModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pClases.Usuario;

public abstract class DBUsuario {                        
       public  static boolean  Login(String usuario,String password) throws SQLException{
           PreparedStatement ps;
           boolean sw;
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; //Herramienta para vincular la conexion
               ResultSet rs=null; //Para recibir los resultados            
               sw = false; //para validar si existe el usuario
               String SQL="select * from personal where usuario=? and clave=?";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); //Para enviar datos al parametro
               ps.setString(2,password); //Para enviar datos al parametro
               rs=ps.executeQuery(); //Ejecuta la consulta
               if (rs.next()) sw=true; // Verifica si existe resultados
           } //Herramienta para vincular la conexion
           ps.close();
           return sw; //Retornar valor
       }
       
       public static int Level(String usuario,String password) throws SQLException {
           PreparedStatement ps;
           int nv = 0;
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; 
               ResultSet rs=null;           
               nv = 0; 
               String SQL="select nivel from personal where usuario=? and clave=?";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); 
               ps.setString(2,password); 
               rs=ps.executeQuery(); 
               
               while (rs.next()) {
                    nv = rs.getInt("nivel");
                }
           }
           ps.close();
           return nv; 
           
       }
       
       public static int Unico(String usuario,String password) throws SQLException {
           PreparedStatement ps;
           int un = 0;
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; 
               ResultSet rs=null;           
               un = 0; 
               String SQL="select id from personal where usuario=? and clave=?";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); 
               ps.setString(2,password); 
               rs=ps.executeQuery(); 
               
               while (rs.next()) {
                    un = rs.getInt("id");
                }
           }
           ps.close();
           return un; 
       }
       
       public static String Log(String usuario,String password) throws SQLException {
           PreparedStatement ps;
           String lo = "";
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; 
               ResultSet rs=null;           
               lo = ""; 
               String SQL="select log from personal where usuario=? and clave=?";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); 
               ps.setString(2,password); 
               rs=ps.executeQuery(); 
               
               while (rs.next()) {
                    lo = rs.getString("log");
                }
           }
           ps.close();
           return lo; 
       }
       
       public static void Cambiar(String usuario,String password) throws SQLException {
           PreparedStatement ps;
           String lo = "";
           try (Connection cn = DBConexion.IniciarSesion() //Conexion a la base de datos
           ) {
               ps = null; 
               ResultSet rs=null;           
               lo = ""; 
               String SQL="select log from personal where usuario=? and clave=?";
               
               ps=cn.prepareStatement(SQL);
               ps.setString(1,usuario); 
               ps.setString(2,password); 
               rs=ps.executeQuery(); 
               
               while (rs.next()) {
                    lo = rs.getString("log");
                }
           }
           ps.close();
       }
       
}
package pModelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConexion {
     public static Connection IniciarSesion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");         
            String url = "jdbc:mysql://localhost/dbinventario";
            String user = "root";           
            String password = "sistema123";          
            cn= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            cn=null;
            System.out.println("Error no se puede cargar el driver:" + e.getMessage());
        } catch (SQLException e) {
            cn=null;
            System.out.println("Error no se establecer la conexion:" + e.getMessage());
        }
        return cn;
    }
}
package pReporte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import pClases.Actividad;
import pModelo.DBConexion;

public class Codigos {
    public static LinkedList<Actividad> Actividad(int d) throws SQLException {
        LinkedList<Actividad> act;
        Statement statement;
        ResultSet rs;
        try (Connection cnn = DBConexion.IniciarSesion()) {
            act = new LinkedList<Actividad>();
            statement = cnn.createStatement();
            rs = statement.executeQuery("select concat(codigo,\" : \",detalle) as actividad from actividad");
            while (rs.next()) {
                Actividad obj = new Actividad();
                obj.setActividad(rs.getString("actividad"));
                System.out.println("Este son las actividades : "+obj);
                act.add(obj);
            }
            cnn.close();
        }
        rs.close();
        statement.close();
        return act;        
    }
}

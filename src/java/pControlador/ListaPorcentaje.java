/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pControlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pClases.Porcentaje;
import pModelo.DBConexion;

/**
 *
 * @author andres
 */
public class ListaPorcentaje {
    
    public static LinkedList<Porcentaje> getPorsentajes(){
        Connection con = DBConexion.IniciarSesion();
        LinkedList<Porcentaje> listaPorcentaje=new LinkedList<Porcentaje>();
        String consulta = "select * from porcentaje_dist";
        
        try {
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(consulta);
            
            while (rs.next()) {
                Porcentaje porcentajes = new Porcentaje();
                porcentajes.setId(rs.getInt("id"));
                porcentajes.setGestion(rs.getString("gestion"));
                String muni = municipio(rs.getString("gam"));
                porcentajes.setGam(muni);
                porcentajes.setSubc(rs.getString("subc"));
                String porcen = porcentaje(rs.getString("porcentaje"));
                porcentajes.setPorcentaje(porcen);
                listaPorcentaje.add(porcentajes);            
            }
            
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CTRLPorcentajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaPorcentaje;
    }
    
    public static String municipio(String x1){
        String dato = "";
        switch (x1) {
            case "CBB": dato="COCHABAMBA"; break;
            case "COB": dato="COBIJA"; break;
            case "EAL": dato="EL ALTO"; break;
            case "TOR": dato="EL TORNO"; break;
            case "ORU": dato="ORURO"; break;
            case "POT": dato="POTOSI"; break;
            case "SAC": dato="SACABA"; break;
            case "SER": dato="SUCRE"; break;
            case "TAR": dato="TARIJA"; break;
            case "TDD": dato="TRINIDAD"; break;
            case "VIA": dato="VIACHA"; break;
            case "SCZ": dato="SANTA CRUZ"; break;
            default: dato="NINGUNO"; break;
        }
        return dato;
    }
    
    public static String porcentaje(String x2) {
        double doble = Double.parseDouble(x2);
        DecimalFormat df = new DecimalFormat("#.##");
        doble = doble*100;
        String cadena = String.valueOf(df.format(doble));
        return cadena;
    }
}

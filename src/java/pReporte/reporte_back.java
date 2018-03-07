/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pReporte;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pControlador.ListaPorcentaje;
import pModelo.DBConexion;

/**
 *
 * @author andres
 */
@WebServlet(name = "reporte2", urlPatterns = {"/reporte_back"})
public class reporte_back extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            
            Connection con = DBConexion.IniciarSesion();
            
            String x=request.getParameter("txtGamuep");
            String gam = ListaPorcentaje.municipio(x);
            String IDgam = ListaPorcentaje.IDmunicipio(x);
            
            String dato_subc[][] = new String[3][4];
            String dato_act1[][] = new String[3][5];
            String dato_act2[][] = new String[3][2];
            String dato_act3[][] = new String[3][3];
            String dato_act4[][] = new String[3][5];
            
            DecimalFormat formatea = new DecimalFormat("###,###,###.###");
            
            String consulta = "SELECT        c.Codigo AS Cod_Subcomp, c.Descripcion AS Subcomponente, SUM(a.Importe * a.Porcentaje) / 100 AS Total_bs "
                + "FROM            Detalle AS a INNER JOIN"
                + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN"
                + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN"
                + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN"
                + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN"
                + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN"
                + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                + "                         Gestiones AS h ON e.Gestion = h.Gestrion "
                + " WHERE a.c_Municipio=" + IDgam + " "
                + " GROUP BY c.Codigo, c.Descripcion "
                + " ORDER BY Cod_Subcomp";
            String consulta2 = "SELECT        b.Codigo AS Cod_Activ, b.Descripcion AS Actividad, SUM(a.Importe * a.Porcentaje) / 100 AS Total_bs "
                + "FROM            Detalle AS a INNER JOIN"
                + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                + "                         Gestiones AS h ON e.Gestion = h.Gestrion "
                + " WHERE a.c_Municipio=" + IDgam + "  and ";
            String consulta3 = "SELECT        g.Subactividad AS Cod_Subac, g.Descripcion_Subactividad AS Subactividad, SUM(a.Importe * a.Porcentaje) / 100 AS Total_bs "
                + "FROM            Detalle AS a INNER JOIN "
                + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                + "                         Gestiones AS h ON e.Gestion = h.Gestrion "
                + "WHERE a.c_Municipio=" + IDgam + " and g.Subactividad LIKE";
            
            String consultaAct1 = consulta2+" b.c_Subcomponente=1 GROUP BY b.Codigo, b.Descripcion ORDER BY Cod_Activ";
            String consultaAct2 = consulta2+" b.c_Subcomponente=2 GROUP BY b.Codigo, b.Descripcion ORDER BY Cod_Activ";
            String consultaAct3 = consulta2+" b.c_Subcomponente=3 GROUP BY b.Codigo, b.Descripcion ORDER BY Cod_Activ";
            String consultaAct4 = consulta2+" b.c_Subcomponente=4 GROUP BY b.Codigo, b.Descripcion ORDER BY Cod_Activ";
            
            
            Statement statement = null, statement2 = null, statement3 = null, statementSubAct=null;
            ResultSet rs = null, rs2 = null, rs3 = null, rsSubAct=null;
            try {
                statement = con.createStatement();
                rs = statement.executeQuery(consulta);
                int sw1 = 0, sw2 = 0;
                
                while (rs.next()) {
                    dato_subc[0][sw1] = rs.getString("Cod_Subcomp");
                    dato_subc[1][sw1] = rs.getString("Subcomponente");
                    dato_subc[2][sw1] = rs.getString("Total_bs");
                    sw1 = sw1 + 1;
                    if (sw1 == 4) {
                        sw1 = 0;
                    }
                }                
                statement2 = con.createStatement();
                rs2 = statement2.executeQuery(consultaAct1);
                while (rs2.next()) {
                    dato_act1[0][sw2] = rs2.getString("Cod_Activ");
                    dato_act1[1][sw2] = rs2.getString("Actividad");
                    dato_act1[2][sw2] = rs2.getString("Total_bs");
                    sw2 = sw2 + 1;
                    if (sw2 == 6) {
                        sw2 = 0;
                    }
                }
                sw2 = 0;
                statement3 = con.createStatement();
                rs3 = statement3.executeQuery(consultaAct2);
                while (rs3.next()) {
                    dato_act2[0][sw2] = rs3.getString("Cod_Activ");
                    dato_act2[1][sw2] = rs3.getString("Actividad");
                    dato_act2[2][sw2] = rs3.getString("Total_bs");
                    sw2 = sw2 + 1;
                    if (sw2 == 6) {
                        sw2 = 0;
                    }
                }
                //System.out.println(consultaAct2);
                rs2.close();
                statement2.close();
                sw2 = 0;
                statement2 = con.createStatement();
                rs2 = statement2.executeQuery(consultaAct3);
                while (rs2.next()) {
                    dato_act3[0][sw2] = rs2.getString("Cod_Activ");
                    dato_act3[1][sw2] = rs2.getString("Actividad");
                    dato_act3[2][sw2] = rs2.getString("Total_bs");
                    sw2 = sw2 + 1;
                    if (sw2 == 6) {
                        sw2 = 0;
                    }
                }
                rs2.close();
                statement2.close();
                sw2 = 0;
                statement2 = con.createStatement();
                rs2 = statement2.executeQuery(consultaAct4);
                while (rs2.next()) {
                    dato_act4[0][sw2] = rs2.getString("Cod_Activ");
                    dato_act4[1][sw2] = rs2.getString("Actividad");
                    dato_act4[2][sw2] = rs2.getString("Total_bs");
                    sw2 = sw2 + 1;
                    if (sw2 == 6) {
                        sw2 = 0;
                    }
                }
                rs2.close();
                statement2.close();
                rs.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("error : " + ex);
            }
            
         Date date = new Date();
         DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
         try{
            
            
            Document documento = new Document();

             
             PdfWriter.getInstance(documento, response.getOutputStream());
             documento.open();
             
             Image image = Image.getInstance("fotoDJ.png");
             image.scaleAbsolute(0f, 0f);

             PdfPTable table = new PdfPTable(1);
             PdfPCell cell = new PdfPCell(image);
             table.addCell(cell);
             documento.add(table);
             image = Image.getInstance("fotoDJ.png");
             image.scaleAbsolute(550f, 45f);
             documento.add(image);
             
             Font fuente= new Font();
             Font fuente0 = new Font();
             Font fuenteTitulo= new Font();
             Font subtotales= new Font();
             Font actividad= new Font();
             Font montos= new Font();
             actividad.setSize(6);
             actividad.setFamily("COURIER");
             fuenteTitulo.setSize(8);
             fuenteTitulo.setStyle(Font.BOLD);
             fuenteTitulo.setStyle(PdfPCell.ALIGN_CENTER);
             fuente0.setSize(10);
             fuente0.setFamily("COURIER");
             fuente0.setStyle(Font.BOLD);
             fuente.setSize(8);
             fuente.setFamily("COURIER");
             subtotales.setSize(8);
             subtotales.setFamily("COURIER");
             subtotales.setStyle(Font.BOLD);
             montos.setSize(6);
             montos.setFamily("COURIER");
             montos.setStyle(PdfPCell.ALIGN_LEFT);
             BaseColor cabecera = WebColors.getRGBColor("#65FF65");
             BaseColor color_subcomponente = WebColors.getRGBColor("#FFA790");
             BaseColor color_actividad = WebColors.getRGBColor("#FFE182");
             
             PdfPTable caratula = new PdfPTable(4);
             caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
             caratula.setWidths(new float[]{0.8f, 1, 1, 0.5f});
             caratula.setWidthPercentage(100);
             PdfPCell celda1 = new PdfPCell(new Paragraph("Municipio :", fuente0));
             PdfPCell celda2 = new PdfPCell(new Paragraph(gam, fuente0));
             PdfPCell celda3 = new PdfPCell(new Paragraph("", fuente0));
             PdfPCell celda4 = new PdfPCell(new Paragraph("Version 1.0", fuente0));
             PdfPCell celda5 = new PdfPCell(new Paragraph("Gestion :", fuente0));
             PdfPCell celda6 = new PdfPCell(new Paragraph("2013 - 2017", fuente0));
             PdfPCell celda7 = new PdfPCell(new Paragraph("", fuente0));
             PdfPCell celda8 = new PdfPCell(new Paragraph("", fuente0));
             PdfPCell celda9 = new PdfPCell(new Paragraph("Fecha de reporte :", fuente0));
             PdfPCell celda10 = new PdfPCell(new Paragraph(hourdateFormat.format(date), fuente0));
             PdfPCell celda11 = new PdfPCell(new Paragraph("", fuente0));
             PdfPCell celda12 = new PdfPCell(new Paragraph("", fuente0));
             caratula.addCell(celda1);
             caratula.addCell(celda2);
             caratula.addCell(celda3);
             caratula.addCell(celda4);
             caratula.addCell(celda5);
             caratula.addCell(celda6);
             caratula.addCell(celda7);
             caratula.addCell(celda8);
             caratula.addCell(celda9);
             caratula.addCell(celda10);
             caratula.addCell(celda11);
             caratula.addCell(celda12);
             documento.add(caratula);
             
             Paragraph espacio2 = new Paragraph();
             espacio2.setAlignment(Paragraph.ALIGN_CENTER);
             espacio2.setFont(FontFactory.getFont("Times New Roman", 12, Font.ITALIC, BaseColor.WHITE));
             espacio2.add("(en Bs)");
             documento.add(espacio2);
             
             Paragraph titulo = new Paragraph();
             titulo.setAlignment(Paragraph.ALIGN_CENTER);
             titulo.setFont(FontFactory.getFont("Times New Roman", 14, Font.ITALIC, BaseColor.BLACK));
             titulo.add("DETALLE DE GASTOS PMGM CII CON CARGO");
             titulo.add("AL GOBIERNO MUNICIPAL DE " + gam);
             documento.add(titulo);
             Paragraph titulo2 = new Paragraph();
             titulo2.setAlignment(Paragraph.ALIGN_CENTER);
             titulo2.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
             titulo2.add("GESTIONES 2013 - 2017");
             documento.add(titulo2);
             Paragraph titulo3 = new Paragraph();
             titulo3.setAlignment(Paragraph.ALIGN_CENTER);
             titulo3.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
             titulo3.add("(en Bs)");
             documento.add(titulo3);
             
             Paragraph espacio = new Paragraph();
             espacio.setAlignment(Paragraph.ALIGN_CENTER);
             espacio.setFont(FontFactory.getFont("Times New Roman", 12, Font.ITALIC, BaseColor.WHITE));
             espacio.add("(en Bs)");
             documento.add(espacio);
             
             PdfPTable tablesup = new PdfPTable(4);
             tablesup.setWidths(new float[]{3.5f, 1.5f, 1.5f, 1.5f});
             tablesup.setWidthPercentage(100);
             tablesup.getDefaultCell().setBackgroundColor(cabecera);
             tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
             tablesup.addCell(new Paragraph("SUBCOMPONENTE / ACTIVIDAD / SUBACTIVIDAD", fuenteTitulo));
             tablesup.addCell(new Paragraph("MONTO EN BID", fuenteTitulo));
             tablesup.addCell(new Paragraph("MONTO EN CTR", fuenteTitulo));
             tablesup.addCell(new Paragraph("TOTAL", fuenteTitulo));
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.setHorizontalAlignment(Element.ALIGN_LEFT);             
             tablesup.addCell(new Paragraph(dato_subc[0][0]+" "+dato_subc[1][0], subtotales));
             tablesup.setHorizontalAlignment(Element.ALIGN_RIGHT);
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_subc[2][0])), subtotales));
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
             for (int i = 0; i < dato_act1[0].length; i++) {
                 tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                 tablesup.addCell(new Paragraph("    "+dato_act1[1][i], actividad));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_act1[2][i])), montos));
                 try {
                     Connection cox = DBConexion.IniciarSesion();
                     statementSubAct = con.createStatement();
                     rsSubAct = statementSubAct.executeQuery(consulta3+" '"+dato_act1[0][i]+"%' GROUP BY g.Subactividad, g.Descripcion_Subactividad ORDER BY Cod_Subac ");
                     while (rsSubAct.next()) {
                         tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                         tablesup.addCell(new Paragraph("        " + rsSubAct.getString("Subactividad"), actividad));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(rsSubAct.getString("Total_bs"))), montos));
                         cox.close();
                     }
                 } catch (SQLException ex) {
                     System.out.println("error : " + ex);
                 }
             }         
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.addCell(new Paragraph(dato_subc[0][1]+" "+dato_subc[1][1], subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_subc[2][1])), subtotales));
             tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
             for (int i = 0; i < dato_act2[0].length; i++) {
                 tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                 tablesup.addCell(new Paragraph("    "+dato_act2[1][i], actividad));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_act2[2][i])), montos));
                 try {
                     Connection cox = DBConexion.IniciarSesion();
                     statementSubAct = con.createStatement();
                     rsSubAct = statementSubAct.executeQuery(consulta3+" '"+dato_act2[0][i]+"%' GROUP BY g.Subactividad, g.Descripcion_Subactividad ORDER BY Cod_Subac ");
                     while (rsSubAct.next()) {
                         tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                         tablesup.addCell(new Paragraph("        " + rsSubAct.getString("Subactividad"), actividad));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(rsSubAct.getString("Total_bs"))), montos));
                         cox.close();
                     }
                 } catch (SQLException ex) {
                     System.out.println("error : " + ex);
                 }
                 
             }         
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.addCell(new Paragraph(dato_subc[0][2]+" "+dato_subc[1][2], subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_subc[2][2])), subtotales));
             tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
             for (int i = 0; i < dato_act3[0].length; i++) {
                 tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                 tablesup.addCell(new Paragraph("    "+dato_act3[1][i], actividad));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_act3[2][i])), montos));
                 try {
                     Connection cox = DBConexion.IniciarSesion();
                     statementSubAct = con.createStatement();
                     rsSubAct = statementSubAct.executeQuery(consulta3+" '"+dato_act3[0][i]+"%' GROUP BY g.Subactividad, g.Descripcion_Subactividad ORDER BY Cod_Subac ");
                     while (rsSubAct.next()) {
                         tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                         tablesup.addCell(new Paragraph("        " + rsSubAct.getString("Subactividad"), actividad));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(rsSubAct.getString("Total_bs"))), montos));
                         cox.close();
                     }
                 } catch (SQLException ex) {
                     System.out.println("error : " + ex);
                 }
                 
             }            
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.addCell(new Paragraph(dato_subc[0][3]+" "+dato_subc[1][3], subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_subc[2][3])), subtotales));
             tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
             for (int i = 0; i < dato_act4[0].length; i++) {
                 tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                 tablesup.addCell(new Paragraph("    "+dato_act4[1][i], actividad));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph("0.0", montos));
                 tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(dato_act4[2][i])), montos));
                 try {
                     Connection cox = DBConexion.IniciarSesion();
                     statementSubAct = con.createStatement();
                     rsSubAct = statementSubAct.executeQuery(consulta3+" '"+dato_act4[0][i]+"%' GROUP BY g.Subactividad, g.Descripcion_Subactividad ORDER BY Cod_Subac ");
                     while (rsSubAct.next()) {
                         tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                         tablesup.addCell(new Paragraph("        " + rsSubAct.getString("Subactividad"), actividad));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph("0.0", montos));
                         tablesup.addCell(new Paragraph(formatea.format(Double.parseDouble(rsSubAct.getString("Total_bs"))), montos));
                         cox.close();
                     }
                 } catch (SQLException ex) {
                     System.out.println("error : " + ex);
                 }
                 
             }            
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             double suma_subc = Double.parseDouble(dato_subc[2][0])+Double.parseDouble(dato_subc[2][1])+Double.parseDouble(dato_subc[2][2])+Double.parseDouble(dato_subc[2][3]);
             tablesup.addCell(new Paragraph("TOTAL GENERAL", fuente));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph("0.0", subtotales));
             tablesup.addCell(new Paragraph(formatea.format(suma_subc), subtotales));

             documento.add(tablesup);
             
             Font fuenteComun = new Font();
             fuenteComun.setSize(10);
             fuenteComun.setFamily("COURIER");
             fuenteComun.setStyle(Font.BOLD);

             PdfPTable comunes = new PdfPTable(4);
             caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
             comunes.setWidths(new float[]{0.8f, 1, 1, 0.5f});
             comunes.setWidthPercentage(100);

             BarcodeQRCode barcodeQRCode = new BarcodeQRCode("REPORTE MUNICIPIO DE " + gam + " de la fecha " + hourdateFormat.format(date), 1000, 1000, null);
             Image codeQrImage = barcodeQRCode.getImage();
             codeQrImage.setAlignment(Paragraph.ALIGN_CENTER);
             codeQrImage.scaleAbsolute(100, 100);
             documento.add(codeQrImage);
            
             
             documento.close();
            
            
            
        } catch (DocumentException ex) {
            Logger.getLogger(reporte2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
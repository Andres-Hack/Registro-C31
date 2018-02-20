/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pReporte;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pClases.Actividad;
import pClases.Subactividad;
import pControlador.ListaPorcentaje;
import pModelo.DBConexion;

/**
 *
 * @author andres
 */
@WebServlet(name = "reporte_back", urlPatterns = {"/reporte_back"})
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
        
        DecimalFormat df = new DecimalFormat("#,###,###.##");
        Connection con = DBConexion.IniciarSesion();
        String consulta = "select detalle from actividad where id_subc=1";
        String consulta2 = "select detalle from actividad where id_subc=2";
        String consulta3 = "select detalle from actividad where id_subc=3";
        String consulta4 = "select detalle from actividad where id_subc=4";
        
        String consultaX = "select detalle from subactividad where id_act=";
        
        
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        ArrayList<String> a3 = new ArrayList<String>();
        ArrayList<String> a4 = new ArrayList<String>();
        ArrayList<String> b1 = new ArrayList<String>();
        ArrayList<String> b2 = new ArrayList<String>();
        ArrayList<String> b3 = new ArrayList<String>();
        ArrayList<String> b4 = new ArrayList<String>();
        ArrayList<String> b5 = new ArrayList<String>();
        ArrayList<String> b6 = new ArrayList<String>();
        ArrayList<String> b7 = new ArrayList<String>();
        ArrayList<String> b8 = new ArrayList<String>();
        ArrayList<String> b9 = new ArrayList<String>();
        ArrayList<String> b10 = new ArrayList<String>();
        ArrayList<String> b11 = new ArrayList<String>();
        ArrayList<String> b12 = new ArrayList<String>();
        ArrayList<String> c1B = new ArrayList<String>();
        ArrayList<String> c1C = new ArrayList<String>();
        ArrayList<String> c2B = new ArrayList<String>();
        ArrayList<String> c2C = new ArrayList<String>();
        ArrayList<String> c3B = new ArrayList<String>();
        ArrayList<String> c3C = new ArrayList<String>();
        ArrayList<String> c4B = new ArrayList<String>();
        ArrayList<String> c4C = new ArrayList<String>();
        
        ArrayList<String> sub1B = new ArrayList<String>();
        ArrayList<String> sub1C = new ArrayList<String>();
        ArrayList<String> sub2B = new ArrayList<String>();
        ArrayList<String> sub2C = new ArrayList<String>();
        ArrayList<String> sub3B = new ArrayList<String>();
        ArrayList<String> sub3C = new ArrayList<String>();
        ArrayList<String> sub4B = new ArrayList<String>();
        ArrayList<String> sub4C = new ArrayList<String>();
        
        Statement statement, statement2, statement3, statement4, statement1b,
                statement2b, statement3b, statement4b, statement5b, statement6b,
                statement7b, statement8b, statement9b, statement10b, statement11b, statement12b;  
        ResultSet rs, rs2, rs3, rs4, rs1b,
                rs2b, rs3b, rs4b, rs5b, rs6b,
                rs7b, rs8b, rs9b, rs10b, rs11b, rs12b;
            
        try {
            statement = con.createStatement();
            statement2 = con.createStatement();
            statement3 = con.createStatement();
            statement4 = con.createStatement();
            statement1b = con.createStatement();
            statement2b = con.createStatement();
            statement3b = con.createStatement();
            statement4b = con.createStatement();
            statement5b = con.createStatement();
            statement6b = con.createStatement();
            statement7b = con.createStatement();
            statement8b = con.createStatement();
            statement9b = con.createStatement();
            statement10b = con.createStatement();
            statement11b = con.createStatement();
            statement12b = con.createStatement();
            
            rs = statement.executeQuery(consulta);
            rs2 = statement2.executeQuery(consulta2);
            rs3 = statement3.executeQuery(consulta3);
            rs4 = statement4.executeQuery(consulta4);
            rs4 = statement4.executeQuery(consulta4);
            rs1b = statement1b.executeQuery(consultaX+"1");
            rs2b = statement2b.executeQuery(consultaX+"2");
            rs3b = statement3b.executeQuery(consultaX+"3");
            rs4b = statement4b.executeQuery(consultaX+"4");
            rs5b = statement5b.executeQuery(consultaX+"5");
            rs6b = statement6b.executeQuery(consultaX+"6");
            rs7b = statement7b.executeQuery(consultaX+"7");
            rs8b = statement8b.executeQuery(consultaX+"8");
            rs9b = statement9b.executeQuery(consultaX+"9");
            rs10b = statement10b.executeQuery(consultaX+"10");
            rs11b = statement11b.executeQuery(consultaX+"11");
            rs12b = statement12b.executeQuery(consultaX+"12");
            
            while (rs.next()) { a1.add(rs.getString("detalle")); }
            while (rs2.next()) { a2.add(rs2.getString("detalle")); }
            while (rs3.next()) { a3.add(rs3.getString("detalle")); }
            while (rs4.next()) { a4.add(rs4.getString("detalle")); }
            while (rs1b.next()) { b1.add(rs1b.getString("detalle")); }
            while (rs2b.next()) { b2.add(rs2b.getString("detalle")); }
            while (rs3b.next()) { b3.add(rs3b.getString("detalle")); }
            while (rs4b.next()) { b4.add(rs4b.getString("detalle")); }
            while (rs5b.next()) { b5.add(rs5b.getString("detalle")); }
            while (rs6b.next()) { b6.add(rs6b.getString("detalle")); }
            while (rs7b.next()) { b7.add(rs7b.getString("detalle")); }
            while (rs8b.next()) { b8.add(rs8b.getString("detalle")); }
            while (rs9b.next()) { b9.add(rs9b.getString("detalle")); }
            while (rs10b.next()) { b10.add(rs10b.getString("detalle")); }
            while (rs11b.next()) { b11.add(rs11b.getString("detalle")); }
            while (rs11b.next()) { b12.add(rs12b.getString("detalle")); }
            
            
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(reporte2.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        String x=request.getParameter("txtGamuep");
        String gam = ListaPorcentaje.municipio(x);
        double monto1 = Consultas.Montos(x, "2,1", "BID");
        double monto2 = Consultas.Montos(x, "2,2", "BID");
        double monto3 = Consultas.Montos(x, "2,3", "BID");
        double monto4 = Consultas.Montos(x, "2,4", "BID");
        double monto5 = Consultas.Montos(x, "2,1", "CTR");
        double monto6 = Consultas.Montos(x, "2,2", "CTR");
        double monto7 = Consultas.Montos(x, "2,3", "CTR");
        double monto8 = Consultas.Montos(x, "2,4", "CTR");
        String montoXX = Consultas.MontoDetalle(x);
        double montoAactB = 0.0, montoAactC = 0.0;
        double montoSubactB = 0.0, montoSubactC = 0.0;
        String[] temp;
        temp = montoXX.split("-");
        double suma = Double.parseDouble(temp[0])+Double.parseDouble(temp[1]);
        try {
            LinkedList<Actividad> actividad1 = Consultas.Actividad(1);
            LinkedList<Actividad> actividad2 = Consultas.Actividad(2);
            LinkedList<Actividad> actividad3 = Consultas.Actividad(3);
            LinkedList<Actividad> actividad4 = Consultas.Actividad(4);
            int sw2 = 6;
            for(int p3=0;p3<actividad1.size();p3++) {
                String montoAcBID = Consultas.montoAcdtividad("2,1", actividad1.get(p3).getCodigo(), x, "BID");
                String montoAcCTR = Consultas.montoAcdtividad("2,1", actividad1.get(p3).getCodigo(), x, "CTR");
                if (montoAcBID!=null) { c1B.add(montoAcBID); } else { c1B.add("0.0"); }
                if (montoAcCTR!=null) { c1C.add(montoAcCTR); } else { c1C.add("0.0"); }         

                LinkedList<Subactividad> actividadX = Consultas.Subactividad(p3);
                for (int i = 0; i < actividadX.size(); i++) {
                    String montoSubactBID = Consultas.montoSubactividad(actividadX.get(i).getCodigo(), x, "BID");
                    String montoSubactCTR = Consultas.montoSubactividad(actividadX.get(i).getCodigo(), x, "CTR");
                    if (montoSubactBID!=null) { sub1B.add(montoSubactBID); } else { sub1B.add("0.0"); }
                    if (montoSubactCTR!=null) { sub1C.add(montoSubactCTR); } else { sub1C.add("0.0"); }
                }
            }
            for(int p3=0;p3<actividad2.size();p3++) {
                String montoAcBID = Consultas.montoAcdtividad("2,2", actividad2.get(p3).getCodigo(), x, "BID");
                String montoAcCTR = Consultas.montoAcdtividad("2,2", actividad2.get(p3).getCodigo(), x, "CTR");
                if (montoAcBID!=null) { c2B.add(montoAcBID); } else { c2B.add("0.0"); }
                if (montoAcCTR!=null) { c2C.add(montoAcCTR); } else { c2C.add("0.0"); }
                
                
                LinkedList<Subactividad> SubactividadX = Consultas.Subactividad(sw2);
                for (int i = 0; i < SubactividadX.size(); i++) {
                    String montoSubactBID = Consultas.montoSubactividad(SubactividadX.get(i).getCodigo(), x, "BID");
                    String montoSubactCTR = Consultas.montoSubactividad(SubactividadX.get(i).getCodigo(), x, "CTR");
                    if (montoSubactBID!=null) { sub2B.add(montoSubactBID); } else { sub2B.add("0.0"); }
                    if (montoSubactCTR!=null) { sub2C.add(montoSubactCTR); } else { sub2C.add("0.0"); }
                }
            }
            
            for(int p3=0;p3<actividad3.size();p3++) {
                sw2 = sw2+1;
                String montoAcBID = Consultas.montoAcdtividad("2,3", actividad3.get(p3).getCodigo(), x, "BID");
                String montoAcCTR = Consultas.montoAcdtividad("2,3", actividad3.get(p3).getCodigo(), x, "CTR");
                if (montoAcBID!=null) { c3B.add(montoAcBID); } else { c3B.add("0.0"); }
                if (montoAcCTR!=null) { c3C.add(montoAcCTR); } else { c3C.add("0.0"); }
                LinkedList<Subactividad> SubactividadX = Consultas.Subactividad(sw2);
                for (int i = 0; i < SubactividadX.size(); i++) {
                    String montoSubactBID = Consultas.montoSubactividad(SubactividadX.get(i).getCodigo(), x, "BID");
                    String montoSubactCTR = Consultas.montoSubactividad(SubactividadX.get(i).getCodigo(), x, "CTR");
                    if (montoSubactBID!=null) { sub3B.add(montoSubactBID); } else { sub3B.add("0.0"); }
                    if (montoSubactCTR!=null) { sub3C.add(montoSubactCTR); } else { sub3C.add("0.0"); }
                }
            }
            for(int p3=0;p3<actividad4.size();p3++) {
                sw2=sw2+1;
                String montoAcBID = Consultas.montoAcdtividad("2,4", actividad4.get(p3).getCodigo(), x, "BID");
                String montoAcCTR = Consultas.montoAcdtividad("2,4", actividad4.get(p3).getCodigo(), x, "CTR");
                if (montoAcBID!=null) { c4B.add(montoAcBID); } else { c4B.add("0.0"); }
                if (montoAcCTR!=null) { c4C.add(montoAcCTR); } else { c4C.add("0.0"); }
                
                LinkedList<Subactividad> Subactividad4X = Consultas.Subactividad(sw2);
                for (int i = 0; i < Subactividad4X.size(); i++) {
                    String montoSubactBID = Consultas.montoSubactividad(Subactividad4X.get(i).getCodigo(), x, "BID");
                    String montoSubactCTR = Consultas.montoSubactividad(Subactividad4X.get(i).getCodigo(), x, "CTR");
                    //System.out.println("SUBC : "+Subactividad4X.get(i).getCodigo()+" MUNICIPIO : "+x+" MONTO :"+montoSubactBID);
                    if (montoSubactBID!=null) { sub4B.add(montoSubactBID); } else { sub4B.add("0.0"); }
                    if (montoSubactCTR!=null) { sub4C.add(montoSubactCTR); } else { sub4C.add("0.0"); }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reporte2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        try {
                Document document = new Document(PageSize.LETTER, 35, 35, 40, 40);
                
                PdfWriter.getInstance(document, response.getOutputStream());
                document.open();
                
                Image image = Image.getInstance("fotoDJ.png");
		image.scaleAbsolute(0f, 0f);
                
                PdfPTable table = new PdfPTable(1);
                PdfPCell cell = new PdfPCell(image);
		table.addCell(cell);
		document.add(table);
		image = Image.getInstance("fotoDJ.png");
		image.scaleAbsolute(550f, 45f);
		document.add(image);
                
                Paragraph espacio = new Paragraph();
                espacio.setAlignment(Paragraph.ALIGN_CENTER);
                espacio.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.WHITE));
                espacio.add("LINEA");
                document.add(espacio);
                
                document.add( Chunk.NEWLINE);
                
                
                Font fuente0= new Font();
                fuente0.setSize(10);
                fuente0.setFamily("COURIER");
                fuente0.setStyle(Font.BOLD);
                
                PdfPTable caratula = new PdfPTable(4);
                caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                caratula.setWidths(new float[] {0.8f,1,1,0.5f});
                caratula.setWidthPercentage(100);
                PdfPCell celda1 = new PdfPCell(new Paragraph("Municipio :", fuente0));
                PdfPCell celda2 = new PdfPCell(new Paragraph(gam, fuente0));
                PdfPCell celda3 = new PdfPCell(new Paragraph("", fuente0));
                PdfPCell celda4 = new PdfPCell(new Paragraph("Version 1.0", fuente0));
                PdfPCell celda5 = new PdfPCell(new Paragraph("Gestion :", fuente0));
                PdfPCell celda6 = new PdfPCell(new Paragraph("", fuente0));
                PdfPCell celda7 = new PdfPCell(new Paragraph("", fuente0));
                PdfPCell celda8 = new PdfPCell(new Paragraph("", fuente0));
                PdfPCell celda9 = new PdfPCell(new Paragraph("Fecha de reporte :", fuente0));
                PdfPCell celda10 = new PdfPCell(new Paragraph(hourdateFormat.format(date), fuente0));
                PdfPCell celda11 = new PdfPCell(new Paragraph("", fuente0));
                PdfPCell celda12 = new PdfPCell(new Paragraph("", fuente0));
                caratula.addCell(celda1);caratula.addCell(celda2);caratula.addCell(celda3);caratula.addCell(celda4);
                caratula.addCell(celda5);caratula.addCell(celda6);caratula.addCell(celda7);caratula.addCell(celda8);
                caratula.addCell(celda9);caratula.addCell(celda10);caratula.addCell(celda11);caratula.addCell(celda12);
                
                document.add(caratula);
                
                Paragraph parrafo4 = new Paragraph("");
                document.add(parrafo4);
                DottedLineSeparator dottedline = new DottedLineSeparator();
                dottedline.setOffset(-2);
                dottedline.setGap(-1f);
                parrafo4.add(dottedline);
                document.add(parrafo4);

                // Setting the space before and after the paragraph
                document.add( Chunk.NEWLINE );
                
                Font fuente= new Font();
                Font actividad= new Font();
                Font subactividad= new Font();
                Font fuenteTitulo= new Font();
                Font subtotales= new Font();
                Font montos= new Font();
                Font montos_total= new Font();
                fuente.setSize(8);
                fuente.setFamily("COURIER");
                actividad.setSize(6);
                actividad.setFamily("COURIER");
                subactividad.setSize(5);
                subactividad.setFamily("COURIER");
                fuenteTitulo.setSize(8);
                fuenteTitulo.setStyle(Font.BOLD);
                fuenteTitulo.setStyle(PdfPCell.ALIGN_CENTER);
                subtotales.setSize(8);
                subtotales.setFamily("COURIER");
                subtotales.setStyle(Font.BOLD);
                montos.setSize(6);
                montos.setFamily("COURIER");
                montos.setStyle(PdfPCell.ALIGN_LEFT);   
                montos_total.setSize(6);
                montos_total.setFamily("COURIER");
                montos_total.setStyle(Font.BOLD);
                montos_total.setStyle(PdfPCell.ALIGN_RIGHT); 
                
                BaseColor cabecera = WebColors.getRGBColor("#65FF65");
                BaseColor color_subcomponente = WebColors.getRGBColor("#FFA790");
                BaseColor color_actividad = WebColors.getRGBColor("#FFE182");
                
                document.add( Chunk.NEWLINE );
                
                Paragraph titulo = new Paragraph();
                titulo.setAlignment(Paragraph.ALIGN_CENTER);
                titulo.setFont(FontFactory.getFont("Times New Roman", 14, Font.ITALIC, BaseColor.BLACK));
                titulo.add("DETALLE DE GASTOS PMGM CII CON CARGO");
                titulo.add("AL GOBIERNO MUNICIPAL DE "+gam);
                document.add(titulo);
                Paragraph titulo2 = new Paragraph();
                titulo2.setAlignment(Paragraph.ALIGN_CENTER);
                titulo2.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
                titulo2.add("GESTIONES 2013 - 2017");
                document.add(titulo2);
                Paragraph titulo3 = new Paragraph();
                titulo3.setAlignment(Paragraph.ALIGN_CENTER);
                titulo3.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
                titulo3.add("(en Bs)");
                document.add(titulo3);
                
                document.add( Chunk.NEWLINE );
            
                PdfPTable tablesup= new PdfPTable(4);
                tablesup.setWidths(new float[] {3.5f,1.5f,1.5f,1.5f});
                tablesup.setWidthPercentage(100);
                tablesup.getDefaultCell().setBackgroundColor(cabecera);
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                tablesup.addCell(new Paragraph("SUBCOMPONENTE / ACTIVIDAD / SUBACTIVIDAD", fuenteTitulo));
                tablesup.addCell(new Paragraph("MONTO EN BID", fuenteTitulo));
                tablesup.addCell(new Paragraph("MONTO EN CTR", fuenteTitulo));
                tablesup.addCell(new Paragraph("TOTAL", fuenteTitulo));
                tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
                tablesup.setHorizontalAlignment(Element.ALIGN_LEFT);
                tablesup.addCell(new Paragraph("2,1 ACTUALIZACIÓN DE LOS REGISTROS DE CATASTRO", subtotales));
                tablesup.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto1)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto5)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto1+monto5)), subtotales));
                tablesup.setHorizontalAlignment(Element.ALIGN_LEFT);
                int sw = 0, sw3 = 0, sw4 = 0;
                for(int p1=0;p1<a1.size();p1++) {
                    tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                    montoAactB = Double.parseDouble(c1B.get(p1));
                    montoAactC = Double.parseDouble(c1C.get(p1));
                    tablesup.addCell(new Paragraph("    "+a1.get(p1), actividad));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactC)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB+montoAactC)), montos));
                    tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                    switch (p1){
                        case 0: for(int p2=0;p2<b1.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub1B.get(p2));
                                    montoSubactC = Double.parseDouble(sub1C.get(p2));
                                    tablesup.addCell(new Paragraph("        "+b1.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw=sw+1;
                                }
                                break;
                        case 1:
                             for(int p2=0;p2<b2.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub1B.get(sw));
                                    montoSubactC = Double.parseDouble(sub1C.get(sw));
                                    tablesup.addCell(new Paragraph("        "+b1.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw=sw+1;
                                }
                             break;
                        case 2:
                             for(int p2=0;p2<b3.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub1B.get(sw));
                                    montoSubactC = Double.parseDouble(sub1C.get(sw));
                                    tablesup.addCell(new Paragraph("        "+b1.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw=sw+1;
                                }
                             break;
                        case 3:
                             for(int p2=0;p2<b4.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub1B.get(sw));
                                    montoSubactC = Double.parseDouble(sub1C.get(sw));
                                    tablesup.addCell(new Paragraph("        "+b1.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw=sw+1;
                                }
                             break;
                        case 4:
                             for(int p2=0;p2<b5.size();p2++) {
                                    tablesup.addCell(new Paragraph("        "+b5.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB+montoAactC)), montos));
                                }
                             break;
                    }
                    
                }
                sw = 0;
                tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                tablesup.addCell(new Paragraph("2,2 DESARROLLO DEL SISTEMA DE CATASTRO", subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto2)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto6)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto2+monto6)), subtotales));
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                for(int p1=0;p1<a2.size();p1++) {
                    tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                    montoAactB = Double.parseDouble(c2B.get(p1));
                    montoAactC = Double.parseDouble(c2C.get(p1));
                    tablesup.addCell(new Paragraph("    "+a2.get(p1), actividad));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactC)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB+montoAactC)), montos));
                    tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                     switch (p1){
                        case 0: 
                                    montoSubactB = Double.parseDouble(sub2B.get(p1));
                                    montoSubactC = Double.parseDouble(sub2C.get(p1));
                                    tablesup.addCell(new Paragraph("        "+b6.get(p1), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                break;
                        case 1:
 
                                    montoSubactB = Double.parseDouble(sub2B.get(p1));
                                    montoSubactC = Double.parseDouble(sub2C.get(p1));
                                    tablesup.addCell(new Paragraph("        "+b6.get(p1), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                             break;
                     }
                }
                tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                tablesup.addCell(new Paragraph("2,3 CAPACITACION, DIFUSIÓN Y ASISTENCIA TECNICA", subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto3)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto7)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto3+monto7)), subtotales));
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                for(int p1=0;p1<a3.size();p1++) {
                    tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                    montoAactB = Double.parseDouble(c3B.get(p1));
                    montoAactC = Double.parseDouble(c3C.get(p1));
                    tablesup.addCell(new Paragraph("    "+a3.get(p1), actividad));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactC)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB+montoAactC)), montos));
                    tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                    switch (p1){
                        case 0: for(int p2=0;p2<b7.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub3B.get(p2));
                                    montoSubactC = Double.parseDouble(sub3C.get(p2));
                                    tablesup.addCell(new Paragraph("        "+b7.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw3=sw3+1;
                                }
                                break;
                        case 1:
                             for(int p2=0;p2<b8.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub3B.get(sw3));
                                    montoSubactC = Double.parseDouble(sub3C.get(sw3));
                                    tablesup.addCell(new Paragraph("        "+b8.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw3=sw3+1;
                                }
                             break;
                        case 2:
                             for(int p2=0;p2<b9.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub3B.get(sw3));
                                    montoSubactC = Double.parseDouble(sub3C.get(sw3));
                                    tablesup.addCell(new Paragraph("        "+b9.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                }
                             break;
                    }
                }
                tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                tablesup.addCell(new Paragraph("2,4 ADMINISTRACION, EVALUACIÓN Y AUDITORIAS", subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto4)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto8)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto4+monto8)), subtotales));
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                for(int p1=0;p1<a4.size();p1++) {
                    tablesup.getDefaultCell().setBackgroundColor(color_actividad);
                    montoAactB = Double.parseDouble(c4B.get(p1));
                    montoAactC = Double.parseDouble(c4C.get(p1));
                    tablesup.addCell(new Paragraph("    "+a4.get(p1), actividad));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactC)), montos));
                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoAactB+montoAactC)), montos));
                    tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                    switch (p1){
                        case 0: for(int p2=0;p2<b10.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub4B.get(p2));
                                    montoSubactC = Double.parseDouble(sub4C.get(p2));
                                    tablesup.addCell(new Paragraph("        "+b10.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw4=sw4+1;
                                }
                                break;
                        case 1:
                             for(int p2=0;p2<b11.size();p2++) {
                                    montoSubactB = Double.parseDouble(sub4B.get(sw4));
                                    montoSubactC = Double.parseDouble(sub4C.get(sw4));
                                    tablesup.addCell(new Paragraph("        "+b11.get(p2), actividad));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactC)), montos));
                                    tablesup.addCell(new Paragraph(String.valueOf(df.format(montoSubactB+montoSubactC)), montos));
                                    sw4=sw4+1;
                                }
                             break;
                    }
                }
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                tablesup.addCell(new Paragraph("TOTAL GENERAL", fuente));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto1+monto2+monto3+monto4)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto5+monto6+monto7+monto8)), subtotales));
                tablesup.addCell(new Paragraph(String.valueOf(df.format(monto1+monto2+monto3+monto4+monto5+monto6+monto7+monto8)), subtotales));
                
                document.add(tablesup);
                /*
                Paragraph mensaje = new Paragraph();
                Paragraph mensaje2 = new Paragraph();
                Paragraph mensaje3 = new Paragraph();
                mensaje.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                mensaje.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
                mensaje.add("Monto BID : "+df.format(Double.parseDouble(temp[0]))+" Bs");
                mensaje2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                mensaje2.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
                mensaje2.add("Monto CTR : "+df.format(Double.parseDouble(temp[1]))+" Bs");
                mensaje3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                mensaje3.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
                mensaje3.add("TOTAL : "+df.format(suma)+" Bs");
                document.add(mensaje);
                document.add(mensaje2);
                document.add(mensaje3);
                */
                document.add( Chunk.NEWLINE);
                
                Font fuenteComun= new Font();
                fuenteComun.setSize(10);
                fuenteComun.setFamily("COURIER");
                fuenteComun.setStyle(Font.BOLD);
                
                PdfPTable comunes = new PdfPTable(4);
                caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                comunes.setWidths(new float[] {0.8f,1,1,0.5f});
                comunes.setWidthPercentage(100);
                
                PdfPCell celda01 = new PdfPCell(new Paragraph("Gastos Comunes", fuenteComun));
                PdfPCell celda02 = new PdfPCell(new Paragraph("BID", fuenteComun));
                PdfPCell celda03 = new PdfPCell(new Paragraph("CTR", fuenteComun));
                PdfPCell celda04 = new PdfPCell(new Paragraph("Total", fuenteComun));
                PdfPCell celda05 = new PdfPCell(new Paragraph("Monto en Bs.", fuenteComun));
                PdfPCell celda06 = new PdfPCell(new Paragraph(df.format(Double.parseDouble(temp[0])), fuente));
                PdfPCell celda07 = new PdfPCell(new Paragraph(df.format(Double.parseDouble(temp[1])), fuente));
                PdfPCell celda08 = new PdfPCell(new Paragraph(df.format(suma), subtotales));

                comunes.addCell(celda01);comunes.addCell(celda02);comunes.addCell(celda03);comunes.addCell(celda04);
                comunes.addCell(celda05);comunes.addCell(celda06);comunes.addCell(celda07);comunes.addCell(celda08);
                
                document.add(comunes);
                
                BarcodeQRCode barcodeQRCode = new BarcodeQRCode("REPORTE MUNICIPIO DE "+gam+" de la fecha "+hourdateFormat.format(date), 1000, 1000, null);
                Image codeQrImage = barcodeQRCode.getImage();
                codeQrImage.setAlignment(Paragraph.ALIGN_CENTER);
                codeQrImage.scaleAbsolute(100, 100);
                document.add(codeQrImage);
                
                               
                
                document.close();
            } catch (DocumentException de) {
                throw new IOException(de.getMessage());
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

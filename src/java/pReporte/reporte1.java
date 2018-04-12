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
@WebServlet(name = "reporte1", urlPatterns = {"/reporte1"})
public class reporte1 extends HttpServlet {

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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            
            Connection con = DBConexion.IniciarSesion();
            
            String x=request.getParameter("nu15_gaf{");
            String y=request.getParameter("ldiak");
            String z=request.getParameter("insdw");
            
            String gest = "", ano = "", cambio="Bs", dolar="1";
            if (y.equals("TODO")) {gest=" (e.Gestion='2013' or e.Gestion='2014' or e.Gestion='2015' or e.Gestion='2016' or e.Gestion='2017')"; ano = "2013 - 2017";}
            else{ gest = " e.Gestion='"+y+"' "; ano = y; }
            if (z.equals("true")) { dolar="6.86"; cambio="$us"; }
            String gam = ListaPorcentaje.municipio(x);
            String IDgam = ListaPorcentaje.IDmunicipio(x);
            
            String dato_subcBID[][] = new String[4][4];
            String dato_subcCTR[][] = new String[4][4];
            for (int i = 0; i < dato_subcBID[0].length; i++) {
                for (int j = 0; j < dato_subcBID[0].length; j++) {
                    dato_subcBID[i][j]="0.0";
                    dato_subcCTR[i][j]="0.0";
                }
            }
            
            DecimalFormat formatea = new DecimalFormat("###,###,###");
            String consulta = "SELECT        c.Codigo AS Cod_Subcomp, c.Descripcion AS Subcomponente, i.Fuente, SUM(a.Importe * a.Porcentaje) / (100*"+dolar+") AS Total_bs "
                + "FROM            Detalle AS a INNER JOIN "
                + "                         Actividades AS b ON a.c_Actividad = b.c_Actividad INNER JOIN "
                + "                         Subcomponentes AS c ON b.c_Subcomponente = c.c_Subcomponente INNER JOIN "
                + "                         Componentes AS d ON c.c_Componente = d.c_Componente INNER JOIN "
                + "                         Periodos AS e ON a.c_Periodo = e.c_Periodo INNER JOIN "
                + "                         Municipios AS f ON a.c_Municipio = f.c_Municipio INNER JOIN "
                + "                         C31 AS g ON a.c_C31 = g.c_C31 INNER JOIN "
                + "                         Gestiones AS h ON e.Gestion = h.Gestrion INNER JOIN "
                + "                         Fuentes AS i ON a.c_Fuente = i.c_Fuente "
                + "WHERE a.c_Municipio=" + IDgam + "  and c.Codigo=";


        Statement statementBID = null, statementCTR = null;
        ResultSet rsBID = null, rsCTR = null;
        try {
            for (int i = 0; i < 4; i++) {
                int sw1 = i + 1;
                statementBID = con.createStatement();
                statementCTR = con.createStatement();
                rsBID = statementBID.executeQuery(consulta + "'2," + sw1 + "' and a.c_Fuente = 1 and "+gest
                        + " GROUP BY c.Codigo, c.Descripcion, i.Fuente "
                        + " ORDER BY Cod_Subcomp, i.Fuente ");
                rsCTR = statementCTR.executeQuery(consulta + "'2," + sw1 + "' and a.c_Fuente = 2 and "+gest
                        + " GROUP BY c.Codigo, c.Descripcion, i.Fuente "
                        + " ORDER BY Cod_Subcomp, i.Fuente ");
                while (rsBID.next()) {
                    dato_subcBID[i][0] = rsBID.getString("Cod_Subcomp");
                    dato_subcBID[i][1] = rsBID.getString("Subcomponente");
                    dato_subcBID[i][2] = rsBID.getString("Fuente");
                    dato_subcBID[i][3] = rsBID.getString("Total_bs");
                }
                while (rsCTR.next()) {
                    dato_subcCTR[i][0] = rsCTR.getString("Cod_Subcomp");
                    dato_subcCTR[i][1] = rsCTR.getString("Subcomponente");
                    dato_subcCTR[i][2] = rsCTR.getString("Fuente");
                    dato_subcCTR[i][3] = rsCTR.getString("Total_bs");
                }
            }
            

        } catch (SQLException ex) {
            System.out.println("error : " + ex);
        }
        
        
            
         Date date = new Date();
         DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
         try{
            
            
            Document documento = new Document();

             
             PdfWriter.getInstance(documento, response.getOutputStream());
             documento.open();
             
             Image image = Image.getInstance("/opt/tomcat/bin/fotoDJ.png");
             image.scaleAbsolute(0f, 0f);

             PdfPTable table = new PdfPTable(1);
             PdfPCell cell = new PdfPCell(image);
             table.addCell(cell);
             documento.add(table);
             image = Image.getInstance("/opt/tomcat/bin/fotoDJ.png");
             image.scaleAbsolute(550f, 45f);
             documento.add(image);
             
             Font fuente= new Font();
             Font fuente0 = new Font();
             Font fuenteTitulo= new Font();
             Font subtotales= new Font();
             Font actividad= new Font();
             Font montos= new Font();
             Font cabecera2 = new Font();
             cabecera2 = FontFactory.getFont("Courier", 9, BaseColor.WHITE);
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
             BaseColor cabecera = WebColors.getRGBColor("#053C6B");
             BaseColor color_subcomponente = WebColors.getRGBColor("#91BEE0");
             BaseColor color_actividad = WebColors.getRGBColor("#FFFFFF");
             
             PdfPTable caratula = new PdfPTable(4);
             caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
             caratula.setWidths(new float[]{0.8f, 1, 1, 0.5f});
             caratula.setWidthPercentage(100);
             PdfPCell celda1 = new PdfPCell(new Paragraph("Municipio :", fuente0));
             PdfPCell celda2 = new PdfPCell(new Paragraph(gam, fuente0));
             PdfPCell celda3 = new PdfPCell(new Paragraph("", fuente0));
             PdfPCell celda4 = new PdfPCell(new Paragraph("Version 1.0", fuente0));
             PdfPCell celda5 = new PdfPCell(new Paragraph("Gestion :", fuente0));
             PdfPCell celda6 = new PdfPCell(new Paragraph(ano, fuente0));
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
             titulo.add(" AL GOBIERNO MUNICIPAL DE " + gam);
             documento.add(titulo);
             Paragraph titulo2 = new Paragraph();
             titulo2.setAlignment(Paragraph.ALIGN_CENTER);
             titulo2.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
             titulo2.add("GESTIONES "+ano);
             documento.add(titulo2);
             Paragraph titulo3 = new Paragraph();
             titulo3.setAlignment(Paragraph.ALIGN_CENTER);
             titulo3.setFont(FontFactory.getFont("Times New Roman", 8, Font.ITALIC, BaseColor.BLACK));
             titulo3.add("(en "+cambio+")");
             documento.add(titulo3);
             
             Paragraph espacio = new Paragraph();
             espacio.setAlignment(Paragraph.ALIGN_CENTER);
             espacio.setFont(FontFactory.getFont("Times New Roman", 12, Font.ITALIC, BaseColor.WHITE));
             espacio.add("(en "+cambio+")");
             documento.add(espacio);
             
            PdfPTable tablesup = new PdfPTable(4);
            tablesup.setWidths(new float[]{3.5f, 1.5f, 1.5f, 1.5f});
            tablesup.setWidthPercentage(100);
            tablesup.getDefaultCell().setBackgroundColor(cabecera);
            tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell celdaC = new PdfPCell(new Paragraph("SUB COMPONENTE / PARTIDA", cabecera2));
            celdaC.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC.setBackgroundColor(cabecera);
            tablesup.addCell(celdaC);
            celdaC = new PdfPCell(new Paragraph("MONTO BID", cabecera2));
            celdaC.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC.setBackgroundColor(cabecera);
            tablesup.addCell(celdaC);
            celdaC = new PdfPCell(new Paragraph("MONTO CTR", cabecera2));
            celdaC.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC.setBackgroundColor(cabecera);
            tablesup.addCell(celdaC);
            celdaC = new PdfPCell(new Paragraph("TOTAL ("+cambio+")", cabecera2));
            celdaC.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaC.setBackgroundColor(cabecera);
            tablesup.addCell(celdaC);   
             /********************* SUB COMPONENTE 2,1 ******************************/
             String label01="";
             if (dato_subcBID[0][0].equals("0.0")) { label01 = dato_subcCTR[0][0]+" "+dato_subcCTR[0][1]; }
             else { label01 = dato_subcBID[0][0]+" "+dato_subcBID[0][1];  }
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);             
             tablesup.addCell(new Paragraph(label01, subtotales));
             PdfPCell celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[0][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcCTR[0][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[0][3])+Double.parseDouble(dato_subcCTR[0][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             /********************* SUB COMPONENTE 2,2 ******************************/
             if (dato_subcBID[1][0].equals("0.0")) { label01 = dato_subcCTR[1][0]+" "+dato_subcCTR[1][1]; }
             else { label01 = dato_subcBID[1][0]+" "+dato_subcBID[1][1];  }
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.addCell(new Paragraph(label01, subtotales));
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[1][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcCTR[1][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[1][3])+Double.parseDouble(dato_subcCTR[1][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);     
             /********************* SUB COMPONENTE 2,3 ******************************/
             if (dato_subcBID[2][0].equals("0.0")) { label01 = dato_subcCTR[2][0]+" "+dato_subcCTR[2][1]; }
             else { label01 = dato_subcBID[2][0]+" "+dato_subcBID[2][1];  }
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.addCell(new Paragraph(label01, subtotales));
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[2][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcCTR[2][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[2][3])+Double.parseDouble(dato_subcCTR[2][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);   
             /********************* SUB COMPONENTE 2,4 ******************************/
             if (dato_subcBID[3][0].equals("0.0")) { label01 = dato_subcCTR[3][0]+" "+dato_subcCTR[3][1]; }
             else { label01 = dato_subcBID[3][0]+" "+dato_subcBID[3][1];  }
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             tablesup.addCell(new Paragraph(label01, subtotales));             
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[3][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcCTR[3][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(Double.parseDouble(dato_subcBID[3][3])+Double.parseDouble(dato_subcCTR[3][3])), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             /********************* MONTOS TOTALES ******************************/
             tablesup.getDefaultCell().setBackgroundColor(color_subcomponente);
             double suma_bid = Double.parseDouble(dato_subcBID[0][3])+Double.parseDouble(dato_subcBID[1][3])+Double.parseDouble(dato_subcBID[2][3])+Double.parseDouble(dato_subcBID[3][3]);
             double suma_ctr = Double.parseDouble(dato_subcCTR[0][3])+Double.parseDouble(dato_subcCTR[1][3])+Double.parseDouble(dato_subcCTR[2][3])+Double.parseDouble(dato_subcCTR[3][3]);
             tablesup.addCell(new Paragraph("TOTAL GENERAL", subtotales));
             celda = new PdfPCell(new Paragraph(formatea.format(suma_bid), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(suma_ctr), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);
             celda = new PdfPCell(new Paragraph(formatea.format(suma_bid+suma_ctr), subtotales));
             celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
             celda.setBackgroundColor(color_actividad);
             tablesup.addCell(celda);

             documento.add(tablesup);
             
             Font fuenteComun = new Font();
             fuenteComun.setSize(10);
             fuenteComun.setFamily("COURIER");
             fuenteComun.setStyle(Font.BOLD);

             PdfPTable comunes = new PdfPTable(4);
             caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
             comunes.setWidths(new float[]{0.8f, 1, 1, 0.5f});
             comunes.setWidthPercentage(100);

             BarcodeQRCode barcodeQRCode = new BarcodeQRCode("REPORTE MUNICIPIO DEL GAM " + gam + " DE LA GESION(ES) "+y, 1000, 1000, null);
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
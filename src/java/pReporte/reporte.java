package pReporte;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pModelo.DBConexion;


@WebServlet(name = "reporte", urlPatterns = {"/reporte"})
public class reporte extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String gamuep = "", subc="", partida="", suba="", bid_ctr="", actividad="",municipio="";
        String consulta="", consulta2="", consulta3="", num3 = "", num4="";
        float valorX = 0, valorY=0;
        
        gamuep = request.getParameter("v1");
        municipio=gamuep;
        subc = request.getParameter("v2");
        partida = request.getParameter("v3");
        suba = request.getParameter("v4");
        bid_ctr = request.getParameter("v5");
        actividad = request.getParameter("v6");
        switch (gamuep){
            case "CBB" : gamuep="COCHABAMBA"; break;
            case "COB" : gamuep="COBIJA"; break;
            case "EAL" : gamuep="EL ALTO"; break;
            case "TOR" : gamuep="EL TORNO"; break;
            case "ORU" : gamuep="ORURO"; break;
            case "POT" : gamuep="POTOSI"; break;
            case "SAC" : gamuep="SACABA"; break;
            case "SRE" : gamuep="SUCRE"; break;
            case "TAR" : gamuep="TARIJA"; break;
            case "TDD" : gamuep="TRINIDAD"; break;
            case "VIA" : gamuep="VIACHA"; break;
            case "SCZ" : gamuep="SANTA CRUZ"; break;
            default: gamuep=""; break;
        }
        
        try {
            DecimalFormat df = new DecimalFormat("###,###,###.##");
            
            response.setContentType("application/pdf");
            Connection con = DBConexion.IniciarSesion();
            
            consulta = "select * from tabla_c31 where id >= '1'";
            
            if (partida != "") {
                consulta += " and partida = '"+partida+"'";
            }
            if (subc != "") {
                consulta += " and subc = '"+subc+"'";
                consulta2 += " and subc = '"+subc+"'";
            }
            if (municipio != "") {
                consulta += " and gam_uep = '"+municipio+"'";
            }
            if (suba != "") {
                consulta += " and subact = '"+suba+"' ";
            }
            if (bid_ctr != "") {
                consulta += " and bid_ctr = '"+bid_ctr+"' ";
            }
            if (actividad != "") {
                consulta += " and act = '"+actividad+"' ";
            }
            ResultSet rs = null;
            PreparedStatement pst = null;
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();             

            
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
                
                Font fuente0= new Font();
                fuente0.setSize(10);
                fuente0.setFamily("COURIER");
                fuente0.setStyle(Font.BOLD);
                
                PdfPTable caratula = new PdfPTable(4);
                caratula.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                caratula.setWidths(new float[] {0.8f,1,1,0.5f});
                caratula.setWidthPercentage(100);
                PdfPCell celda1 = new PdfPCell(new Paragraph("Municipio :", fuente0));
                PdfPCell celda2 = new PdfPCell(new Paragraph(gamuep, fuente0));
                PdfPCell celda3 = new PdfPCell(new Paragraph("", fuente0));
                PdfPCell celda4 = new PdfPCell(new Paragraph("Version 1.0", fuente0));
                PdfPCell celda5 = new PdfPCell(new Paragraph("Sub componente :", fuente0));
                PdfPCell celda6 = new PdfPCell(new Paragraph(subc, fuente0));
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
                Font fuenteTitulo= new Font();
                fuente.setSize(5);
                fuente.setFamily("COURIER");
                fuenteTitulo.setSize(5);
                fuenteTitulo.setColor(BaseColor.WHITE);
                fuenteTitulo.setStyle(Font.BOLD);
                fuenteTitulo.setStyle(cell.ALIGN_CENTER);
                
            
                PdfPTable tablesup= new PdfPTable(8);
                tablesup.setWidths(new float[] {0.5f,1,1.5f,0.5f,1,3,0.5f,0.5f});
                tablesup.setWidthPercentage(100);
                tablesup.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
                tablesup.setHorizontalAlignment(Element.ALIGN_MIDDLE);
                tablesup.addCell(new Paragraph("Gestion", fuenteTitulo));
                tablesup.addCell(new Paragraph("Fecha de emision", fuenteTitulo));
                tablesup.addCell(new Paragraph("Descripción", fuenteTitulo));
                tablesup.addCell(new Paragraph("gam/uep", fuenteTitulo));
                tablesup.addCell(new Paragraph("Beneficiario", fuenteTitulo));
                tablesup.addCell(new Paragraph("Concepto", fuenteTitulo));
                tablesup.addCell(new Paragraph("Importe Bs.", fuenteTitulo));
                tablesup.addCell(new Paragraph("Importe $us.", fuenteTitulo));
                tablesup.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                while(rs.next()){
                    String v1 = rs.getString("gestion");
                    String v2 = rs.getString("fech_emision");
                    String v3 = rs.getString("descripcion");
                    String v4 = rs.getString("gam_uep");
                    String v5 = rs.getString("beneficiario");
                    String v6 = rs.getString("concepto");
                    Float v7 = rs.getFloat("importe");
                    Float v8 = rs.getFloat("importe_usd");
                    
                    String num1 = df.format(v7);
                    String num2 = df.format(v8);
                    num3 = df.format(valorX);
                    num4 = df.format(valorY);
                    tablesup.addCell(new Paragraph(v1, fuente));
                    tablesup.addCell(new Paragraph(v2, fuente));
                    tablesup.addCell(new Paragraph(v3, fuente));
                    tablesup.addCell(new Paragraph(v4, fuente));
                    tablesup.addCell(new Paragraph(v5, fuente));
                    tablesup.addCell(new Paragraph(v6, fuente));
                    tablesup.addCell(new Paragraph(num1 , fuente));
                    tablesup.addCell(new Paragraph(num2, fuente));
                }
                tablesup.addCell(new Paragraph("", fuente));
                tablesup.addCell(new Paragraph("", fuente));
                tablesup.addCell(new Paragraph("", fuente));
                tablesup.addCell(new Paragraph("", fuente));
                tablesup.addCell(new Paragraph("", fuente));
                tablesup.addCell(new Paragraph("TOTAL", fuente));
                tablesup.addCell(new Paragraph(num3 , fuente));
                tablesup.addCell(new Paragraph(num4, fuente));
                document.add(tablesup);
                
                               
                
                document.close();
            } catch (DocumentException de) {
                throw new IOException(de.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("EL ERROR ES : "+ex);
        }
    }
}


package Modelo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
public class CrearPDF {
    
    public static void crear(String nombre,String texto1,String texto2){
        Document documento = new Document();  
        FileOutputStream ficheroPdf;
        try 
        {
         ficheroPdf = new FileOutputStream(nombre+".PDF");
         PdfWriter.getInstance(
                               documento, 
                               ficheroPdf
                               ).setInitialLeading(20);
        }
        catch (Exception ex) 
        {
         System.out.println(ex.toString());
        }
        try{
            documento.open();
            documento.add(new Paragraph(texto1));
            Paragraph parrafo2 = new Paragraph(texto2);
            parrafo2.setAlignment(1);//el 1 es para centrar
            documento.add(parrafo2);
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(3);
            //el numero indica la cantidad de Columnas
            tabla.addCell("celda1");
            tabla.addCell("celda2");
            tabla.addCell("celda3");
            tabla.addCell("celda4");
            tabla.addCell("celda5");
            tabla.addCell("celda6");
            // esto nos crea una tabla de 3 Columnas por dos Filas
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            PdfPTable tabla2 = new PdfPTable(3);
            PdfPCell celda = new PdfPCell(
                               new Paragraph("celda \nmodificada")
                                         );
            celda.setColspan(2);
           //cantidad de columnas que ocupa esta celda
            celda.setRowspan(2);
           //cantidad de filas que ocupa esta celda
            tabla2.addCell(celda);
            tabla2.addCell("celda5");
            tabla2.addCell("celda6");
            tabla2.addCell("celda7");
            tabla2.addCell("celda8");
            tabla2.addCell("celda9");
            documento.add(tabla2);
            documento.close();
           
        }catch(Exception ex){
            System.out.println(ex.toString());
        } 
        
        
        
    }
    
    
}

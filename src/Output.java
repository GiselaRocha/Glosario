package src;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Output {

    public Output() { 
    }

    public void printLines(Lines lines){
        

        try {
             // Crear un nuevo documento PDF
             Document document = new Document(PageSize.A4, 50, 50, 50, 50);

             // Crear un objeto PdfWriter para escribir en el archivo PDF
             PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Glosario.pdf"));
 
             // Abrir el documento
             document.open();

             printIntro(document);

             for (String line : lines.getLines()) {
                String parts[] = line.split("\\:");
                System.out.println(parts[0].toUpperCase()+":");
                document.add(new Paragraph(parts[0].toUpperCase()+":"));
                System.out.println("    " +parts[1] + "\n");
                document.add(new Paragraph("    " +parts[1] + "\n"));
            }

            // Cerrar el documento
            document.close();

            System.out.println("Archivo PDF creado correctamente.");
 
        } catch (DocumentException | FileNotFoundException e) {
            // TODO: handle exception
        }
        
    }

    public void printIntro(Document document) throws DocumentException{
        System.out.println("GLOSARIO \n");
        document.add(new Paragraph("GLOSARIO \n"));
    }
    
}

package src;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Output {

    public Output() { 
    }

    public void out(Lines lines){
        
        try {

             // Crear un nuevo documento PDF
             Document document = new Document(PageSize.A4, 50, 50, 50, 50);

             System.out.println("Ingresa el nombre del nuevo glosario:");

            String title = nameGlosary();
           
             // Crear un objeto PdfWriter para escribir en el archivo PDF
             PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(title));
 
             // Abrir el documento
             document.open();

             printIntro(document);

             for (String line : lines.getLines()) {
                
                String parts[] = line.split("\\:");
                System.out.println(parts[0]+":");
                document.add(new Paragraph(parts[0]+":"));
                try {
                System.out.println("    " +parts[1] + "\n");
                document.add(new Paragraph("    " +parts[1] + "\n"));
                } catch (Exception e) {
                    System.out.println("No se encontró\n");
                    document.add(new Paragraph("No se encontró\n"));
                }
                
            }

            // Cerrar el documento
            document.close();

            System.out.println("Archivo PDF creado correctamente.");
 
        } catch (DocumentException | FileNotFoundException e) {
            //  handle exception
        }
        
    }

    public void printIntro(Document document) throws DocumentException{
        System.out.println("\nGLOSARIO \n");
        document.add(new Paragraph("GLOSARIO \n"));
    }

    public String nameGlosary(){
        Scanner scanner = new Scanner(System.in, "Cp850");

        String tittle = scanner.nextLine();

        String doc = tittle + ".pdf";

        return doc;
    }

    
}

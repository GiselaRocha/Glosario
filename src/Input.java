package src;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class Input {

    public Input() {
    }

     public void readTittle (Lines inputLines, Lines keyWordLines) throws IOException{
        Scanner scanner = new Scanner(System.in, "Cp850");

        System.out.println("Ingresa el nombre del archivo con las palabras clave (TXT):");

        String line = scanner.nextLine();

        String docKey ="files/" + line;

        readTXT(keyWordLines, docKey);


        System.out.println("Ingresa el nombre del archivo que deseas crear tu glosario (PDF):");

        line = scanner.nextLine();

        String doc ="files/" + line + ".pdf";

        readPDF(inputLines, doc);

        scanner.close();
        
    }

    public void readPDF (Lines inputLines, String rutaArchivoPdf) throws IOException{
       // String rutaArchivoPdf = "files/prueba3.pdf";

        PdfReader reader = new PdfReader(rutaArchivoPdf);

        try {
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                String textoPagina = PdfTextExtractor.getTextFromPage(reader, i);
                String[] lineasPagina = textoPagina.split("\n");

                for (String linea : lineasPagina) {
                    if (!linea.trim().isEmpty()) {
                        inputLines.storageLines(linea + "$$" + i);
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error cargando pdf");
        }
        inputLines.announce();
    }

    public void readTXT (Lines keyWordLines, String rutaArchivoTxt) throws IOException{
        //String rutaArchivoTxt = "files/keyWordsFile";

        try {
            Scanner scanner = new Scanner(new File(rutaArchivoTxt), "Cp850");

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                keyWordLines.storageLines(linea);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error leyendo txt");
        }
    }
}

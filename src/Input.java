package src;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class Input {

    public Input() {
    }

     public void read (Lines inputLines, Lines keyWordLines) throws IOException{
        Scanner scanner = new Scanner(System.in, "Cp850");
        boolean correct = false;

        while(correct == false){

        System.out.println("Ingresa el nombre del archivo con las palabras clave (TXT):");

        String line = scanner.nextLine();

        String docKey ="files/" + line;

        correct = readTXT(keyWordLines, docKey);

        }
        correct = false;
        
        while(correct == false){

        System.out.println("Ingresa el nombre del archivo que deseas crear tu glosario (PDF):");

        String line = scanner.nextLine();

        String doc ="files/" + line + ".pdf";

        correct = readPDF(inputLines, doc);

        }
    }

    public boolean readPDF (Lines inputLines, String rutaArchivoPdf) throws IOException{

        try {
            PdfReader reader = new PdfReader(rutaArchivoPdf);
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
            System.out.println("Error cargando pdf. Intente de nuevo.");
            return false;
        }
        inputLines.announce();
        return true; 
    }

    public boolean readTXT (Lines keyWordLines, String rutaArchivoTxt) throws IOException{
        
        try {
            Scanner scanner = new Scanner(new File(rutaArchivoTxt));

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                keyWordLines.storageLines(linea);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo txt. Intrente de nuevo.");
            return false;
        }

        return true;
    }
}

package src;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class Input {

    public Input() {
    }

   /*  public void readLines (Lines inputLines){
        Scanner scanner = new Scanner(System.in, "Cp850");

        System.out.println("Introduce las lineas de texto (para terminar introduce una linea vacia):");

        String[][] line = scanner.nextLine();

        while (!line.isEmpty()){

            inputLines.storageLines(line);

            line = scanner.nextLine();

        }

        scanner.close();

    }*/

    public void readPDF (Lines inputLines) throws IOException{
        String rutaArchivoPdf = "files/pruebas.pdf";

        PdfReader reader = new PdfReader(rutaArchivoPdf);

        try {
            System.out.println(reader.getNumberOfPages());
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
    }

    public void readTXT (Lines keyWordLines) throws IOException{
        String rutaArchivoTxt = "files/keyWordsFile";

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

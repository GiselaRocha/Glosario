package src;

import java.io.IOException;

public class MasterControl{
    public static Lines shiftedLines;
    public static Lines inputLines;
    public static Lines keyWordsLines;
    public static Lines keyWordsPages;

    public static void main(String[] args) throws IOException{
        inputLines = new Lines("inputLines");
        shiftedLines = new Lines("shiftedLines");

        keyWordsLines = new Lines("keyWordsLines");
        keyWordsPages = new Lines("keyWordsPages");


        IChangeObserver shift = new SearchKeyWords();
        IChangeObserver order = new Aphabetizer();

        inputLines.addChangeObservers(shift);
        shiftedLines.addChangeObservers(order);

        Input input = new Input();
        input.readTXT(keyWordsLines);
        input.readPDF(inputLines);

        Output output = new Output();
        output.printLines(shiftedLines); 
        output.printLines(keyWordsLines);

    }     
    
}

package src;

import java.io.IOException;

public class MasterControl{
    public static Lines searchLines;
    public static Lines inputLines;
    public static Lines keyWordsLines;
    public static Lines keyWordsPages;

    public static void main(String[] args) throws IOException{
        inputLines = new Lines("inputLines");
        searchLines = new Lines("searchLines");
        keyWordsLines = new Lines("keyWordsLines");

        IChangeObserver search = new SearchKeyWords();
        IChangeObserver order = new Aphabetizer();

        inputLines.addChangeObservers(search);
        searchLines.addChangeObservers(order);

        Input input = new Input();
        input.readTittle(inputLines, keyWordsLines);

        Output output = new Output();
        output.printLines(searchLines); 

    }     
    
}

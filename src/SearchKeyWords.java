package src;

import java.util.ArrayList;

public class SearchKeyWords implements IChangeObserver {

    
    public void notifyListener(Lines changedLine) {
        if(changedLine.name == "inputLines") {
            searchingKeyWords(changedLine);
        }
    }

    public void searchingKeyWords(Lines inputLines) {

        String glosarioLine = "";
        String keyWord = "";    

        for (String keyWords : MasterControl.keyWordsLines.getLines()) {
            keyWord = keyWords + ":";
            glosarioLine = keyWord;
            for (String line : inputLines.getLines()) {
                if (line.toLowerCase().contains(keyWords.toLowerCase())) {

                    String[] parts = line.split("\\$\\$");
                    //glosarioLine += parts[1] + ",";
                    glosarioLine = repeatPages(glosarioLine, parts[1]);
                }
            }
            MasterControl.searchLines.storageLines(glosarioLine);
            glosarioLine = "";
        }
        MasterControl.inputLines.clearLines();
        MasterControl.searchLines.announce();
    }

    public String repeatPages (String glosarioLine, String page) {
        String[] parts = glosarioLine.split("\\:");
        String lastPages = parts[parts.length-1];
        String[] pages = lastPages.split("\\,");
        String lastPage = pages[pages.length-1];
        
        if(!lastPage.equals(page))
        glosarioLine += page + ",";
        
        return glosarioLine;
    }	

}
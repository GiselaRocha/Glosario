package src;

public class SearchKeyWords implements IChangeObserver {

    
    public void notifyListener(Lines changedLine) {
        if(changedLine.name == "inputLines") {
            searchingKeyWords(changedLine);
        }
    }

    public void searchingKeyWords(Lines inputLines) {

        for (String keyWord : MasterControl.keyWordsLines.getLines()) {
            for (String line : inputLines.getLines()) {
                if (line.contains(keyWord)) {
                    String[] parts = line.split("\\$\\$");
                    String glosarioLine = parts[1] + ",";
                    keyWord = keyWord + ": ";
                    MasterControl.shiftedLines.storageLines(keyWord += glosarioLine);
                }
            }
        }
        MasterControl.inputLines.clearLines();
    }

}
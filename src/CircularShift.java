package src;

public class CircularShift implements IChangeObserver {
  
    public void notifyListener(Lines changedLine) {
        if(changedLine.name == "inputLines") {
            circularShift(changedLine);
        }
    }

    public void circularShift(Lines inputLines) {
        for(int i = 0; i < inputLines.getLines().size(); i++) {
            String line = inputLines.getLines().get(i);
            String[] words = line.split(" ");
            String newLine;
            for(int j = 0; j < words.length; j++) {
                newLine = "";
                for(int k = j; k < words.length; k++) {
                    newLine += words[k] + " ";
                }
                for(int k = 0; k < j; k++) {
                    newLine += words[k] + " ";
                }
                MasterControl.shiftedLines.storageLines(newLine);
            }
        }
        MasterControl.inputLines.clearLines();
    }
}
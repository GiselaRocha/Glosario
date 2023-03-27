package src;

import java.util.List;

public class Aphabetizer implements IChangeObserver {
   
    @Override
    public void notifyListener(Lines changedLine) {
        if(changedLine.name == "shiftedLines"){
            organizeLines(changedLine.getLines());
        }
    }

    public void organizeLines(List<String> lines){
        for(int i = 1; i < lines.size(); i++) {
            String actual = lines.get(i);
            int j = i - 1;
            
            while(j >= 0 && checkWordOrder(actual, lines.get(j))) {
                lines.set(j+1, lines.get(j));
                j--;
            } 
            
            lines.set(j+1, actual);
        
        }

    if(lines.size() == 1)
        lines.set(0,lines.get(0));
    }

    public boolean checkWordOrder(String actual, String line) {
        int index = 0;
        while(Character.toLowerCase(checkAccent(actual, index)) == Character.toLowerCase(checkAccent(line, index)))
            index++;
        if(Character.toLowerCase(checkAccent(actual, index)) < Character.toLowerCase(checkAccent(line, index)))
            return true;
        else
            return false;
    }

    public char checkAccent(String line, int index){
        for (int i = 0; i < 12; i++) {
            if(line.charAt(index) == EAccents.values()[i].toString().charAt(0)) 
                return EAccents.values()[i+12].toString().charAt(0);
        }
        return line.charAt(index);
    }
}
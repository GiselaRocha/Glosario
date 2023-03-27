package src;

import java.util.ArrayList;
import java.util.List;

public class Lines extends TElement {

    String name;
    List<String> lines = new ArrayList<String>();

    public Lines(String name) {
        this.name = name;
    }

    public void storageLines(String line){
        lines.add(line);
        
    }

    public void clearLines(){
        lines.clear();
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void announce() {
        announceChangeEvent(this);
    }

    
}
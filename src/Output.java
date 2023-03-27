package src;

public class Output {

    public Output() { 
    }

    public void printLines(Lines lines){
        for (String line : lines.getLines()) {
            System.out.println(line);
        }
    }
    
}

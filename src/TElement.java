package src;

import java.util.ArrayList;
import java.util.List;

public abstract class TElement extends Object {
    private static List<IChangeObserver> changeObservers = new ArrayList<>();
    protected void announceChangeEvent(Lines changedElement) {
        for(IChangeObserver o : changeObservers) {
                o.notifyListener(changedElement);
        }
    }
    public void addChangeObservers(IChangeObserver o){
        changeObservers.add(o);
    }
}

package Observer.ObserverPartII;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {

    private int myValue;
    private List<IObserver> observerList = new ArrayList<>();

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
        notifyObservers(myValue);
    }

    @Override
    public void register(IObserver o) {
        observerList.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers(int i) {
        observerList.forEach(x -> x.update(i));
    }
}

package Observer.ObserverBasic;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {

    private List<Observer> observerList = new ArrayList<Observer>();
    private int _flag;

    public int getFlag() {
        return _flag;
    }

    public void setFlag(int _flag) {
        this._flag = _flag;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(Observer::Update);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }
}

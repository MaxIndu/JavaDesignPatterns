package Observer.ObserverInBuilt;


import java.util.Observable;

class MessageBoard extends Observable {

    void changeMessage(String message){
        setChanged();
        notifyObservers(message);
    }

}

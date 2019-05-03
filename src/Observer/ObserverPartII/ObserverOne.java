package Observer.ObserverPartII;

public class ObserverOne implements IObserver {
    @Override
    public void update(int i) {
        System.out.println("Observer 01 : i : " + i);
    }
}

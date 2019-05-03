package Observer.ObserverPartII;

public class ObserverTwo implements IObserver {
    @Override
    public void update(int i) {
        System.out.println("Observer 02 : Observes => MyValue is changed in Subject to : " + i);
    }
}

package Observer.ObserverPartII;

public class ObserverPatternModifiedEx {
    public static void main(String[] args) {
        System.out.println("*** Modified Observer Pattern Demo***\n");
        Subject sub = new Subject();
        ObserverOne ob1 = new ObserverOne();
        ObserverTwo ob2 = new ObserverTwo();
        sub.register(ob1);
        sub.register(ob2);
        sub.setMyValue(5);
        System.out.println();
        sub.setMyValue(25);
        System.out.println();
        //unregister ob1 only
        sub.unregister(ob1);
        //Now only ob2 will observe the change
        sub.setMyValue(100);
    }
}

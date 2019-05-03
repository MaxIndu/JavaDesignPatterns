package Observer.ObserverInBuilt;

public class MessageBoardTest {
    public static void main(String[] args) {
        MessageBoard messageBoard = new MessageBoard();
        Student bob = new Student();
        Student tom = new Student();
        messageBoard.addObserver(bob);
        messageBoard.addObserver(tom);
        messageBoard.changeMessage("1 week vacation...");
        messageBoard.changeMessage("2 week vacation...");
    }
}

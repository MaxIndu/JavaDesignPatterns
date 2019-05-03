# Observer Design Pattern

**Observer pattern** is used when there is one-to-many relationship between objects such as if one object is 
modified, its dependent objects are to be notified automatically.

#### When should we use Inbuilt Observer and Observable?

[question](https://stackoverflow.com/questions/13744450/when-should-we-use-observer-and-observable)

* [`Observable`](https://docs.oracle.com/javase/8/docs/api/java/util/Observable.html) is a class and [`Observer`](https://docs.oracle.com/javase/8/docs/api/java/util/Observer.html) is an interface.
* The `Observable` class maintains a list of `Observer`s.
* When an `Observable` object is updated, it invokes the `update()` method of each of its `Observer`s to notify that, it is changed.

```java
import java.util.Observable;
import java.util.Observer;

class MessageBoard extends Observable
{
    public void changeMessage(String message) 
    {
        setChanged();
        notifyObservers(message);
    }
}

class Student implements Observer 
{
    @Override
    public void update(Observable o, Object arg) 
    {
        System.out.println("Message board changed: " + arg);
    }
}

public class MessageBoardTest 
{
    public static void main(String[] args) 
    {
        MessageBoard board = new MessageBoard();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }
}
```



> You have a concrete example of a Student and a Message Board.  The  Student registers by adding itself to the list of Observers that want to  be notified when a new Message is posted to the Message Board.  When a  Message is added to the Message Board, it iterates over its list of  Observers and notifies them that the event occurred.
>
> Think Twitter.  When you say you want to follow someone, Twitter adds  you to their follower list.  When they sent a new tweet in, you see it  in your input.  In that case, your Twitter account is the Observer and  the person you're following is the Observable.
>
> The analogy might not be perfect, because Twitter is more likely to be a Mediator.  But it illustrates the point.



### In Java 9 Inbuilt Observer and Observable are depricated

>  The event model supported by Observer and Observable is quite limited, the order of notifications delivered by Observable is unspecified, and state changes are not in one-for-one correspondence with
> notifications. For a richer event model, consider using the **java.beans** package. For reliable and ordered messaging among threads, consider using one of the concurrent data structures in the
> **java.util.concurrent** package. For reactive streams style programming, see the Flow API.



##### **Implementation with `PropertyChangeListener`**

**Observable**

**In this implementation, an observable must keep a reference to the `PropertyChangeSupport`instance.** It helps to send the notifications to observers when a property of the class is changed.

```java
public class PCLNewsAgency {
    private String news;
 
    private PropertyChangeSupport support;
 
    public PCLNewsAgency() {
        support = new PropertyChangeSupport(this);
    }
 
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
 
    public void setNews(String value) {
        // Using this support, we can add and remove observers, 
        // and notify them when the state of the observable changes.
        // Here, the first argument is the name of the observed property. 
        // The second and the third arguments are its old and new value accordingly.
        support.firePropertyChange("news", this.news, value);
        this.news = value;
    }
}
```

##### Observer

Observers should implement *`PropertyChangeListener`*:

```java
public class PCLNewsChannel implements PropertyChangeListener {
 
    private String news;
 
    public void propertyChange(PropertyChangeEvent evt) {
        this.setNews((String) evt.getNewValue());
    }
}
```

Due to the *`PropertyChangeSupport`* class which is doing the wiring for us, we can restore the new property value from the event.

##### Test

```java
PCLNewsAgency observable = new PCLNewsAgency();
PCLNewsChannel observer = new PCLNewsChannel();
 
observable.addPropertyChangeListener(observer);
observable.setNews("news");
 
assertEquals(observer.getNews(), "news");
```


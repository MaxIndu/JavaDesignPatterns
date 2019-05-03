package DefaultInterface;

public class Main {
    public static void main(String[] args) {
        Attributes attributes = new Attributes("Shimakaze", 45, 11, 36, "Hmmmmmmm...");
        ShipConfig shipConfig = new DestroyerConfig();
        shipConfig.setState(attributes);
        shipConfig.horn(attributes);
        shipConfig.print(attributes);
    }
}

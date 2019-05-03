package DefaultInterface;

public interface ShipConfig {

    void setState(Attributes attributes);

    String getSound(Attributes attributes);

    default void horn(Attributes attributes){
        System.out.println("Horn Sound : "+ getSound(attributes));
    }

    default void print(Attributes attributes){
        System.out.println(attributes.toString());
    }

}

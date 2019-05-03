package DefaultInterface;

public class DestroyerConfig implements ShipConfig {

    private Attributes destroyerAttributes = new Attributes();

    @Override
    public void setState(Attributes attributes) {
        this.destroyerAttributes = attributes;
    }

    @Override
    public String getSound(Attributes attributes) {
        return this.destroyerAttributes.getSound();
    }
}

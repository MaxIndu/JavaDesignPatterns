package DefaultInterface;

public class BattleshipConfig implements ShipConfig {

    private Attributes bbAttributes = new Attributes();

    @Override
    public void setState(Attributes attributes) {
        // Do something
        this.bbAttributes = attributes;
    }

    @Override
    public String getSound(Attributes attributes) {
        // Do something
        return this.bbAttributes.getSound();
    }
}

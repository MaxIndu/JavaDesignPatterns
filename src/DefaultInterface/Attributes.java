package DefaultInterface;

public class Attributes {

    private String name;
    private long length;
    private long width;
    private long height;
    private String sound;

    public Attributes(String name, long length, long width, long height, String sound) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.sound = sound;
    }

    public Attributes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}

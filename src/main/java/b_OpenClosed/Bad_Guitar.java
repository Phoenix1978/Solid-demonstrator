package b_OpenClosed;

public class Bad_Guitar {

    private String make;
    private String model;
    private int volume;
    private String flameColor;

    public Bad_Guitar(String make, String model, int volume) {
        this.make = make;
        this.model = model;
        this.volume = volume;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getFlameColor() {
        return flameColor;
    }

    public void setFlameColor(String flameColor) {
        this.flameColor = flameColor;
    }

    public String toString() {
        return "Make: " + this.make
                + ", Model: " + this.model
                + ", Volume:  " + this.volume;
    }

    public String toStringWithFlames() {
        return this.toString() + ", Flame:  " + this.flameColor;
    }
}

class TesterBadGuitar {
    static void go() {
        Bad_Guitar guitarA = new Bad_Guitar("Fender", "Bronco", 159);
        guitarA.setFlameColor("Orange");
        Bad_Guitar guitarB = new Bad_Guitar("Elypse", "Dryade", 25);
        guitarB.setFlameColor("Blue");

        System.out.println(guitarA.toStringWithFlames());
        System.out.println(guitarB.toStringWithFlames());
    }
}

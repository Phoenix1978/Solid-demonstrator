package b_OpenClosed;

public class Good_Guitar {
    private String make;
    private String model;
    private int volume;

    public Good_Guitar(String make, String model, int volume) {
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

    public String toString() {
        return "Make: " + this.make
                + ", Model: " + this.model
                + ", Volume:  " + this.volume;
    }

}

class SuperCoolGuitarWithFlames extends Good_Guitar {

    private String flameColor;

    public SuperCoolGuitarWithFlames(String make, String model, int volume, String flameColor) {
        super(make, model, volume);
        this.flameColor = flameColor;
    }

    public String getFlameColor() {
        return flameColor;
    }

    public void setFlameColor(String flameColor) {
        this.flameColor = flameColor;
    }
    public String toString() {
        return super.toString() + ", Flame:  " + this.flameColor;
    }
}
class TesterGoodGuitar {
    static void go() {
        Good_Guitar guitarA = new SuperCoolGuitarWithFlames("Fender", "Bronco", 159, "Orange");
        Good_Guitar guitarB = new SuperCoolGuitarWithFlames("Elypse", "Dryade", 25, "Blue");
        System.out.println(guitarA);
        System.out.println(guitarB);
    }
}


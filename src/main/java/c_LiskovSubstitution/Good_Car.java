package c_LiskovSubstitution;

public interface Good_Car {
    void turnOnEngine();
    void accelerate();
}


class MotorCarG implements Good_Car {

    private Engine engine= new Engine(false);;
    private int pace = 0;

    //Constructors, getters + setters

    public void turnOnEngine() {
        //turn on the engine!
        engine.on();
    }

    public void accelerate() {
        //move forward!
        engine.increasePower(10);
        this.pace += 10;
        System.out.println("The pace is at is at : " + this.pace);
    }
}


class ElectricG_Car implements Good_Car {

    private int pace = 0;

    public void turnOnEngine() {
        System.out.println("I didn't engine on, but that's ok ;) ");
    }

    public void accelerate() {
        this.pace += 1000;
        System.out.println("The pace is at is at : " + this.pace);
    }
}




class EngineG {
    boolean started;
    int power;

    public EngineG(boolean started) {
        this.started = started;
        this.power = 0;
    }

    public boolean isStarted() {
        return started;
    }

    public void on() {
        this.started = true;
        this.power = 0;
        System.out.println("Engine is on!!!");
    }

    public void off() {
        this.started = false;
        this.power = 0;
    }

    public int getPower() {
        return power;
    }

    public void increasePower(int power) {
        this.power = power + power;
        System.out.println("The power is at : " + this.power);
    }

    public void decreasePower(int power) {
        this.power = power - power;
    }
}

class TesterGoodCar {
    static void go() {
        MotorCarG myMoto = new MotorCarG();
        myMoto.turnOnEngine();
        myMoto.accelerate();
        ElectricG_Car myEletricCar = new ElectricG_Car();
        myEletricCar.turnOnEngine();
        myEletricCar.accelerate();

    }
}
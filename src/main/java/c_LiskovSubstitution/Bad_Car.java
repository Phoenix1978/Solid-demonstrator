package c_LiskovSubstitution;

import a_SingleResonsability.Good_Employee;

public interface Bad_Car {
    void turnOnEngine();
    void accelerate();
}

class MotorCar implements Bad_Car {
    private int pace = 0;
    private Engine engine = new Engine(false);

    //Constructors, getters + setters

    public void turnOnEngine() {
        //turn on the engine!
        engine.on();
        this.pace = 0;
    }

    public void accelerate() {
        //move forward!
        engine.increasePower(10);
        this.pace += 10;
        System.out.println("The pace is at is at : " + this.pace);
    }
}

class Electric_Car implements Bad_Car {

    private int pace = 0;

    public void turnOnEngine() {
        throw new AssertionError("EXCEPTION: I don't have an engine!");
    }

    public void accelerate() {
        //this acceleration is crazy!
        this.pace += 1000;
        System.out.println("The pace is at is at : " + this.pace);
    }
}

class Engine{
    boolean started;
    int power;

    public Engine(boolean started) {
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
    }

    public void decreasePower(int power) {
        this.power = power - power;
    }
}

class TesterBadCar {
    static void go() {
        MotorCar myMoto = new MotorCar();
        myMoto.turnOnEngine();
        myMoto.accelerate();
        Electric_Car myEletricCar = new Electric_Car();
        try{
            myEletricCar.turnOnEngine();
        } catch (Error e){
            System.out.println(e.getMessage());
        }
        myEletricCar.accelerate();

    }
}
package e_DependencyInjection;

public class Good_Machine {

    private final StandardKeyboardG keyboard;
    private final MonitorG monitor;

    public Good_Machine(StandardKeyboardG keyboard, MonitorG monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public String toString() {
        return "Monitor: " + this.monitor.getMonitorConf() + ", Monitor: " + this.keyboard.getKeyboardConf();
    }

}

class StandardKeyboardG {
    private String keyboardConf;

    public StandardKeyboardG(String keyboardConf) {
        this.keyboardConf = keyboardConf;
    }

    public String getKeyboardConf() {
        return keyboardConf;
    }
}

class MonitorG {
    private String monitorConf;

    public MonitorG(String monitorConf) {
        this.monitorConf = monitorConf;
    }

    public String getMonitorConf() {
        return monitorConf;
    }
}

class TesterGoodMachine {
    static void go() {
        Good_Machine myMachine = new Good_Machine(
                new StandardKeyboardG("French"),
                new MonitorG("600/800")
        );
        System.out.println(myMachine);
    }
}
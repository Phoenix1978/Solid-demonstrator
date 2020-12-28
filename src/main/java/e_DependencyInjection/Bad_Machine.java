package e_DependencyInjection;

public class Bad_Machine {

    private final StandardKeyboard keyboard;
    private final Monitor monitor;

    public Bad_Machine() {
        monitor = new Monitor("600/800");
        keyboard = new StandardKeyboard("French");
    }

    public String toString(){
        return "Monitor: " + this.monitor.getMonitorConf() + ", Monitor: " + this.keyboard.getKeyboardConf();
    }

}

class StandardKeyboard{
    private String keyboardConf;

    public StandardKeyboard(String keyboardConf) {
        this.keyboardConf = keyboardConf;
    }

    public String getKeyboardConf() {
        return keyboardConf;
    }
}

class Monitor{
    private String monitorConf;
    public Monitor(String monitorConf) {
        this.monitorConf = monitorConf;
    }

    public String getMonitorConf() {
        return monitorConf;
    }
}

class TesterBadMachine {
    static void go() {
        Bad_Machine myMachine = new Bad_Machine();
        System.out.println(myMachine);
    }
}
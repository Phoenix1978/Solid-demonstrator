package d_InterfaceSegregation;

import b_OpenClosed.Bad_Guitar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Bad_Clock {
    public void setTime();
    public String getTime();
    public void setAlarm(String alarm);
    public String getAlarm();
    public void setRadio(String radio);
    public String getRadio();
}

class AlarmClock implements Bad_Clock{
    private String radio = "nrj";
    private String alarm = "22h30";
    private String time = "22h00";

    @Override
    public void setTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.time = dtf.format(now);
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public void setAlarm(String time) {
        this.alarm = alarm;
    }

    @Override
    public String getAlarm() {
        return this.alarm;
    }

    @Override
    public void setRadio(String radioName) {
        this.radio = radioName;
    }

    @Override
    public String getRadio() {
        return this.radio;
    }

    public String toString(){
        return new StringBuilder("MyClock: ")
                .append("Radio: ")
                .append(this.radio)
                .append(", Time: ")
                .append(this.getTime())
                .append(", Alarme: " )
                .append(this.getAlarm())
                .toString();
    }
}

class TesterBadClock {
    static void go() {
        AlarmClock myClock = new AlarmClock();
        myClock.setAlarm("06h00");
        myClock.setTime();
        myClock.setRadio("Fun");
        System.out.println(myClock.toString());
    }
}
package d_InterfaceSegregation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface Time {
    public void setTime();
    public String getTime();
}

interface Alarm {
    public void setAlarm(String alarm);
    public String getAlarm();
}

interface Radio {
    public void setRadio(String radio);
    public String getRadio();
}

interface AlarmClockd extends Time  {
    public void setRadio(String radio);
    public String getRadio();
}

class cheapClock implements Time {
    private String time = "";

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
}

class HighTechClockG extends cheapClock implements Radio, Alarm{
    private String radio = "";
    private String alarm = "";

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

class TesterGoodClock {
    static void go() {
        AlarmClock myClock = new AlarmClock();
        myClock.setAlarm("06h00");
        myClock.setTime();
        myClock.setRadio("Fun");
        System.out.println(myClock.toString());
    }
}
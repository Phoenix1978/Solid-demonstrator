package c_LiskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class Good_Bird {
    public void eat() {
    }
}

class FlightBird extends Good_Bird{
    public void fly(){
        System.out.println("I fly (motherClass FlightBird definition)");
    }
}

class CrowG extends FlightBird {
}

class OstrichG extends Good_Bird {
}


class TesterGoodBird {
    static void go() {
        List<Good_Bird> birdList = new ArrayList<Good_Bird>();
        birdList.add(new FlightBird());
        birdList.add(new CrowG());
        birdList.add(new OstrichG());
        letTheBirdsFly(birdList);
    }

    static void letTheBirdsFly(List<Good_Bird> birdList) {
        for (Good_Bird b : birdList) {
            try {
                if(b instanceof FlightBird){
                    ((FlightBird) b).fly();
                } else {
                    System.out.println("we won't manage this object");
                }
            } catch (UnsupportedOperationException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

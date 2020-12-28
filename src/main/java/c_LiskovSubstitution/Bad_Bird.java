package c_LiskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class Bad_Bird {
    public void fly() {
        System.out.println("I fly (motherClass definition)");
    }

    public void eat() {
    }
}

class Crow extends Bad_Bird {
}

class Ostrich extends Bad_Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Fly method not supported");
    }
}


class TesterBadBird {
    static void go() {
        List<Bad_Bird> birdList = new ArrayList<Bad_Bird>();
        birdList.add(new Bad_Bird());
        birdList.add(new Crow());
        birdList.add(new Ostrich());
        letTheBirdsFly(birdList);
    }

    static void letTheBirdsFly(List<Bad_Bird> birdList) {
        for (Bad_Bird b : birdList) {
            try {
                b.fly();
            } catch (UnsupportedOperationException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

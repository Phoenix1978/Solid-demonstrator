package c_LiskovSubstitution;

import utils.Presentation;

public class TesterL {
    /**
     * Liskov substitution
     * 	Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program
     */
    public static void goTest(){
        Presentation.showSeparation("Liskov Substitution");
        TesterBadCar.go();
        TesterGoodCar.go();
        System.out.println("*".repeat(20));
        TesterBadBird.go();
        TesterGoodBird.go();

    }
}

package d_InterfaceSegregation;

import utils.Presentation;

public class TesterI {
    /**
     * Interface segregation
     * 	Many client-specific interfaces are better than one general-purpose interface
     */
    public static void goTest(){
        Presentation.showSeparation("Interface segregation");
        TesterBadClock.go();
        TesterGoodClock.go();
        System.out.println("*".repeat(20));
        TesterBadEmployee.go();
        TesterGoodEmployee.go();

    }
}

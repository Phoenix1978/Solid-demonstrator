package b_OpenClosed;

import utils.Presentation;

public class TesterO {

    /**
     * Open–closed
     * 	An application entity (class, function, module ...) must be open to extension, but closed to modification
     */
    public static void goTest(){
        Presentation.showSeparation("Single responsibility");
        TesterBadPriceCalculator.go();
        TesterGoodPriceCalculator.go();
        System.out.println("*".repeat(20));
        TesterBadGuitar.go();
        TesterGoodGuitar.go();
    }
}

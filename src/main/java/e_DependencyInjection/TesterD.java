package e_DependencyInjection;

import utils.Presentation;

public class TesterD {
    /**
     * Dependency inversion
     * 	Depend on abstractions, not implementations
     */
    public static void goTest(){
        Presentation.showSeparation("Dependency inversion");
        TesterBadBook.go();
        TesterGoodBook.go();
        System.out.println("*".repeat(20));
        TesterBadMachine.go();
        TesterGoodMachine.go();


    }
}

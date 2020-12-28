package a_SingleResonsability;

import utils.Presentation;

public class TesterS {

    /**
     * Single-responsibility
     *  A class, method or function should only have a single responsibility
     */
    public static void goTest(){
        Presentation.showSeparation("Single responsibility");
        TesterBadBlog.go();
        TesterGoodBlog.go();
        System.out.println("*".repeat(20));
        TesterBadEmployee.go();
        TesterGoodEmployee.go();
    }
}

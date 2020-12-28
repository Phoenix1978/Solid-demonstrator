import a_SingleResonsability.TesterS;
import b_OpenClosed.TesterO;
import c_LiskovSubstitution.TesterL;
import d_InterfaceSegregation.TesterI;
import e_DependencyInjection.TesterD;

public class Tester {
    public static void main (String args[]){
        TesterS.goTest();
        TesterO.goTest();
        TesterL.goTest();
        TesterI.goTest();
        TesterD.goTest();
    }
}

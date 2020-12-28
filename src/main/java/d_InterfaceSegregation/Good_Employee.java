package d_InterfaceSegregation;

public class Good_Employee implements Conventional {

    private String name;
    private double salary;

    public Good_Employee(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary: " + this.salary;
    }
}

interface Conventional {
    public double getSalary();
}

interface Commissionable {
    public double getCommission();
}

class SellerG extends Good_Employee implements Commissionable {

    private int totalSales;

    public SellerG(double salary, int totalSales) {
        super(salary);
        this.totalSales = totalSales;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + this.getCommission();
    }

    @Override
    public double getCommission() {
        return this.totalSales * 0.2;
    }

    @Override
    public String toString() {
        return "Salary: " + super.getSalary() + ", Commission: " + this.getCommission();
    }
}

class TesterGoodEmployee {
    static void go() {
        SellerG mySeller = new SellerG(1500.00, 15000);
        Good_Employee myDeveloper = new Good_Employee(3500.00);
        System.out.println(mySeller.toString());
        System.out.println(myDeveloper.toString());
    }
}

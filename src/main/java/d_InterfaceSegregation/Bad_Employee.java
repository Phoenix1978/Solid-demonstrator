package d_InterfaceSegregation;

public abstract class Bad_Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getSalary();

    public abstract double getCommission();
}

class Seller extends Bad_Employee{

    private double salary;
    private int totalSales;

    public Seller(double salary, int totalSales) {
        this.salary = salary;
        this.totalSales = totalSales;
    }

    @Override
    public double getSalary() {
        return this.salary + this.getCommission();
    }

    @Override
    public double getCommission() {
        return this.totalSales * 0.2;
    }

    public String toString(){
        return "Salary: " + this.salary + ", Commission: " + this.getCommission();
    }
}

class Developer extends Bad_Employee{

    private double salary;

    public Developer(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public double getCommission() {
        return 0d;
    }

    public String toString(){
        return "Salary: " + this.salary + ", Commission: " + this.getCommission();
    }
}


class TesterBadEmployee {
    static void go() {
        Seller mySeller = new Seller(1500.00, 15000);
        Developer myDeveloper = new Developer(3500.00);
        System.out.println(mySeller.toString());
        System.out.println(myDeveloper.toString());
    }
}

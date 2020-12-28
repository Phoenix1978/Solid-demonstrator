package a_SingleResonsability;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Bad_Employee {

    private Integer id;
    private String name;
    private Double salary;
    private Connection connection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double calculateSalary() {
        Double salary = this.salary - (this.salary * 0.225);
        System.out.println("Salary: " + salary);
        return salary;
    }

    public void save() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false", "root", "");
        Statement stmt = this.connection.createStatement();
        String sql = "insert into employee (id, name, salary) values (" + this.id + "," + this.name + "," + this.salary + ")";
        int rs = stmt.executeUpdate(sql);

        if (rs == 1){
            System.out.println("Successfully inserted Employee - id:" + this.id);
        }else if (rs == 0){
            System.out.println("No employee inserted.");
        }
    }
}

class TesterBadEmployee {
    static void go() {
        Bad_Employee badEmployee = new Bad_Employee();
        badEmployee.setName("Baptiste");
        badEmployee.setSalary(300000.00);
        badEmployee.calculateSalary();
        try {
            badEmployee.save();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

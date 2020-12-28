package a_SingleResonsability;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Good_Employee {
    private Integer id;
    private String name;
    private double salary;
    private Position position;

    public Good_Employee() {
    }

    public Good_Employee(Integer id, String name, double salary, Position position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double calculatesSalary() {
        Double salary = position.getRule().calculates(this);
        System.out.println("Salary: " + salary);
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", position=" + position + "]";
    }
}

interface CalculationRule {
    public double calculates(Good_Employee employee);
}

class TwentyTwoAndAHalfPercentRule implements CalculationRule {

    @Override
    public double calculates(Good_Employee employee) {
        return employee.getSalary() - (employee.getSalary() * 0.225);
    }

}

class ElevenPercentRule implements CalculationRule {

    @Override
    public double calculates(Good_Employee employee) {
        return employee.getSalary() - (employee.getSalary() * 0.11);
    }

}

enum Position {

    SENIOR_DEVELOPER(new TwentyTwoAndAHalfPercentRule()),
    JUNIOR_DEVELOPER(new ElevenPercentRule());

    private CalculationRule rule;

    Position(CalculationRule rule) {
        this.rule = rule;
    }

    public CalculationRule getRule() {
        return rule;
    }

}

class ConnectionDAO {

    private Properties connectionProps;
    private Connection conn;
    private String dbms;
    private String dbName;
    private String serverName;
    private String portNumber;

    private static final String JDBC = "jdbc:";

    private static final Logger logger = Logger.getLogger(ConnectionDAO.class);

    public ConnectionDAO() {
        super();
    }

    public ConnectionDAO(String username, String password) {
        super();
        connectionProps = new Properties();
        connectionProps.put("user", username);
        connectionProps.put("password", password);
    }

    public Properties getConnectionProps() {
        return connectionProps;
    }

    public void setConnectionProps(Properties connectionProps) {
        this.connectionProps = connectionProps;
    }

    public Connection getConnection() {
        return conn;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public Connection createConnection() throws SQLException {
        Connection newConnection = null;
        try {

            if (getDbms().equals("mysql")) {
                newConnection = DriverManager.getConnection(JDBC + getDbms() + "://" + getServerName() + ":" + getPortNumber()
                        + "/" + getDbName() + "?useSSL=false", getConnectionProps());
            } else if (getDbms().equals("postgreSQL")) {
                newConnection = DriverManager.getConnection(JDBC + getDbms() + "://" + getServerName() + ":" + getPortNumber()
                        + "/" + getDbName() + "?useSSL=false", getConnectionProps());
            } else if (getDbms().equals("derby")) {
                newConnection = DriverManager.getConnection(JDBC + getDbms() + ":" + getDbName() + ";create=true", getConnectionProps());
            }
            setConnection(newConnection);
            logger.info("Connected to database");
        } catch (SQLException e) {
            logger.error(e);
            throw e;
        }

        return newConnection;
    }
}

class EmployeeDAO {

    private static final Logger logger = Logger.getLogger(EmployeeDAO.class);

    public void save(Good_Employee employee) throws SQLException {

        ConnectionDAO connectionDAO = new ConnectionDAO("root", "");
        connectionDAO.setDbms("mysql");
        connectionDAO.setServerName("localhost");
        connectionDAO.setPortNumber("8080");
        connectionDAO.setDbName("mock");

        try {
            Connection connection = connectionDAO.createConnection();
            Statement stmt = connection.createStatement();
            String sql = "insert into employee (id, name, salary) values (" + employee.getId() + "," +
                    employee.getName() + "," + employee.getSalary() + ")";
            int rs = stmt.executeUpdate(sql);

            if (rs == 1) {
                logger.info("Successfully inserted Employee - id:" + employee.getId());
            }
        } catch (SQLException e) {
            logger.error("No employee inserted." + e);
            throw e;

        }

    }
}

class TesterGoodEmployee {
    static void go() {
        Good_Employee goodEmployee = new Good_Employee();
        goodEmployee.setName("Baptiste");
        goodEmployee.setSalary(300000.00);
        goodEmployee.setPosition(Position.SENIOR_DEVELOPER);
        goodEmployee.calculatesSalary();
        try {
            EmployeeDAO myDao = new EmployeeDAO();
            myDao.save(goodEmployee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
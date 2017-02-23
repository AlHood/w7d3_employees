import db.SqlRunner;
import java.sql.ResultSet;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void save() {
        String sql = String.format("INSERT INTO employees (name, salary, department_id) VALUES ('%s', %7.2f, %d);", this.name, this.salary, this.department.getId());
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = String.format("SELECT * FROM employees;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                Double salary = rs.getDouble(salary);
                System.out.println(name);
                System.out.println(salary);
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }


    public static void deleteAll() {
        String sql = String.format("DELETE FROM employees;");
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        String sql = String.format("UPDATE employees SET (name, salary, department_id) = ('%s', %7.2f, %d)  WHERE id = %d;", this.name, this.getSalary(), this.department.getId());
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


public void delete() {
   String sql = String.format("DELETE FROM employees WHERE id = %d;", this.getId() );
            SqlRunner.executeUpdate(sql);
    SqlRunner.closeConnection();
}

}
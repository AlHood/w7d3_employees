/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){
        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");

        department1.save();
        department2.save();

        Employee employee1 = new Employee("Suzie Smith", department1, 45000);
        Employee employee2 = new Employee("Jamie Jones", department2, 25000);
        Employee employee3 = new Employee("Kirit Singh", department1, 27500);


        employee1.save();
        employee2.save();
        employee3.save();

        Employee.all();
    }
}

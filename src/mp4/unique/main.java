package mp4.unique;

import mp2.ObjectPlus;

import java.util.Calendar;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        Calendar date = Calendar.getInstance();
        date.set(1999,1,25);
        Employee employee = new Employee("AQdasd","Bebra", date,"emp1");
        Employee employee2 = new Employee("AQdasd","Bebra", date,"emp2");
        Employee employee3 = new Employee("AQdasd","Bebra", date,"emp3");
        Employee employee1 = new Employee("AQdasd","Bebra", date,"emp4");

        //Employee employee2 = new Employee("Illia","Bebra", date);

        System.out.println(employee.getEmpNumber());

        //System.out.println(employee2.getEmpNumber());

       // List<Employee> employees = ObjectPlus.getExtent(Employee.class);
       // System.out.println(employees);


       // System.out.println(Employee.getExtent().containsValue(employee.getEmpNumber()));

    }
}

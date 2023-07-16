package mp3.MultyInheritance;

import java.time.LocalDate;

public class Employee extends Person{

    Integer salary;

    public Employee(String name, String surname, LocalDate dob,Integer salary) throws Exception {
        super(name, surname, dob);
        checkInteger(salary);
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) throws Exception {
        checkInteger(salary);
        this.salary = salary;
    }
}

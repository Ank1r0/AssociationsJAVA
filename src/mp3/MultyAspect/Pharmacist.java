package mp3.MultyAspect;

import mp1.Methods;

public class Pharmacist extends Person implements Methods {

    String empNumber;
    Integer salary;
    public Pharmacist(String name, SkillLevel level, String empNumber, Integer salary) {
        super(name, level);

        this.salary = salary;
        this.empNumber = empNumber;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) throws Exception {
        checkString(empNumber);
        this.empNumber = empNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) throws Exception {
        checkInteger(salary);
        this.salary = salary;
    }
}

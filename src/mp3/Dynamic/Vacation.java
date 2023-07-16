package mp3.Dynamic;

import mp1.Methods;

public class Vacation extends Person implements Methods {
    private Integer vacations;

    public Vacation(String name, Integer vacations) throws Exception {
        super(name);
        checkInteger(vacations);
        this.vacations = vacations;

        this.addToExtent();
    }

    public Vacation(Person oldRole, Integer vacations) throws Exception {
        super(oldRole);
        checkInteger(vacations);
        this.vacations = vacations;

        this.addToExtent();
    }

    public double getVacations() {
        return vacations;
    }

    public void setVacations(Integer vacations) throws Exception {
        checkInteger(vacations);
        this.vacations = vacations;
    }

    public void changeRoleToStudent(Integer salary,String studentNumber) throws Exception {
        Intern newRole = new Intern(this, studentNumber,salary);

        newRole.addToExtent();

        // Remove this object from the extent
        this.removeFromExtent();
    }

    public void changeRoleToEmployee(Integer salary) throws Exception {
        // Create a new Employee object with the same name and salary as this object
        Employee newRole = new Employee(this, salary);

        newRole.addToExtent();

        // Remove this object from the extent
        this.removeFromExtent();
    }
}
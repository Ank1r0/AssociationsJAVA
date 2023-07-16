package mp3.Dynamic;

public class Employee extends Person {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
        this.addToExtent();
    }

    public Employee(Person oldRole, double salary) {
        super(oldRole);
        this.salary = salary;
        this.addToExtent();
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void changeRoleToStudent(Integer salary,String studentNumber) throws Exception {  // idk if it`s okay but I think possibility
                                                                        // to change role to student for a task not for real work should be possible
        Intern newRole = new Intern(this, studentNumber,salary);

        newRole.addToExtent();

        // Remove this object from the extent
        this.removeFromExtent();
    }

    public void changeRoleToVacation(Integer salary) throws Exception {

        Vacation newRole = new Vacation(this, salary);

        newRole.addToExtent();

        this.removeFromExtent();
    }
}

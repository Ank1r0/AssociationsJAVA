package mp3.Dynamic;

import mp1.Methods;

public class Intern extends Person implements Methods {
    private String internNumber;
    private Integer wages;

    public Intern(String name, String internNumber, Integer wages) throws Exception {
        super(name);

        checkNumber(wages);
        checkString(internNumber);

        this.internNumber = internNumber;
        this.wages = wages;

        this.addToExtent();
    }

    public Intern(Person oldRole, String internNumber, Integer wages) throws Exception {
        super(oldRole);

        checkNumber(wages);
        checkString(internNumber);

        this.internNumber = internNumber;
        this.wages = wages;

        this.addToExtent();
    }

    public Integer getWages() throws Exception {
        return wages;
    }

    public void setWages(Integer wages) throws Exception {
        checkNumber(wages);
        this.wages = wages;
    }

    public String getInternNumber() {
        return internNumber;
    }

    public void setInternNumber(String internNumber) throws Exception {
        checkString(internNumber);
        this.internNumber = internNumber;
    }

    public void changeRoleToEmployee(Integer salary) throws Exception {
        // Create a new Employee object with the same name and salary as this object
        Employee newRole = new Employee(this, salary);

        newRole.addToExtent();

        // Remove this object from the extent
        this.removeFromExtent();
    }

    public void changeRoleToVacation(Integer salary) throws Exception {
        // Create a new Employee object with the same name and salary as this object
        Vacation newRole = new Vacation(this, salary);

        newRole.addToExtent();

        // Remove this object from the extent
        this.removeFromExtent();
    }
}
package mp3.MultyInheritance;

import java.time.LocalDate;

public class Intern extends Person{

    String personalNumber;

    Integer wages;

    public Intern(String name, String surname, LocalDate dob, String personalNumber, Integer wages) throws Exception {
        super(name, surname, dob);
        this.personalNumber = personalNumber;
        this.wages = wages;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) throws Exception {
        checkString(personalNumber);
        this.personalNumber = personalNumber;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) throws Exception {
        checkInteger(wages);
        this.wages = wages;
    }
}

package mp3.MultyInheritance;

import mp1.Methods;

import java.time.LocalDate;

public class WorkingInternOnVacation extends Employee implements InterfaceStudent,InterfaceVacation, Methods {

    private String InternNumber;
    private Integer vacations;
    private Integer wages;

    @Override
    public void setInternNumber(String internNumber) throws Exception {
        checkString(internNumber);
        InternNumber = internNumber;
    }

    @Override
    public void setWages(Integer wages) throws Exception {
        checkInteger(wages);
        this.wages = wages;
    }

    public WorkingInternOnVacation(String name, String surname, LocalDate dob, Integer salary, String internNumber) throws Exception {
        super(name, surname, dob, salary);
        checkString(internNumber);
        this.InternNumber = internNumber;
    }

    @Override
    public String getInternNumber() {
        return InternNumber;
    }

    @Override
    public Integer getWages() {
        return wages;
    }


    @Override
    public Integer getVacations() {
        return vacations;
    }

    public void setVacations(Integer vacations) throws Exception {
        checkInteger(vacations);
        this.vacations = vacations;
    }

}

package mp3.MultyInheritance;

import java.time.LocalDate;

public class Vacation extends Person{
    Integer vacations;

    public Vacation(String name, String surname, LocalDate dob,Integer vacations) throws Exception {
        super(name, surname, dob);
        checkInteger(vacations);
        this.vacations = vacations;
    }

    public Integer getVacations() {
        return vacations;
    }

    public void setVacations(Integer vacations) throws Exception {
        checkInteger(vacations);
        this.vacations = vacations;
    }
}

package mp3.MultyInheritance;

import mp1.Methods;

import java.time.LocalDate;

public class Person implements Methods {
    private String name;
    private String surname;

    private LocalDate dob;

    public Person(String name, String surname, LocalDate dob) throws Exception {
        checkString(name);
        checkString(surname);
        checkLocalDate(dob);
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception{
        checkString(surname);
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) throws Exception{
        checkLocalDate(dob);
        this.dob = dob;
    }
}

package mp4.bag;

import mp1.Methods;

import java.util.HashSet;
import java.util.Set;

public class Patient implements Methods {
    private String name;
    private String passportNumber;

    private Set<Regimen> treatmentPlan;

    public Patient(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.treatmentPlan = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) throws Exception {
        checkString(passportNumber);
        this.passportNumber = passportNumber;
    }

    public void addRegiment(Regimen regimen) throws Exception{
        checkIfNotNull(regimen);
            treatmentPlan.add(regimen);
    }
}

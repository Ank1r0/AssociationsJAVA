package mp2;

import mp1.Methods;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JobDuty extends ObjectPlus implements Methods { //8

    private String duty;
    private Drugstore drugstore;
    private Set<Pharmacist> personnel = new HashSet<>(); //single drugstore
    // only one drugstore and one personnel for 1 jobduty
    //not be able to change it later
    // notes who did what

    public JobDuty(String duty,Drugstore drugstore) throws Exception {
        checkString(duty);
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) throws Exception {
        checkString(duty);
        this.duty = duty;
    }

    public Set<Pharmacist> getPersonnel(){
        Set<Pharmacist> copy = new HashSet<>(personnel);
        return copy;
    }

    public void addPersonnel(Pharmacist pharmacist) throws Exception { //8.5
        //check later
        checkPharmacist(pharmacist);
        personnel.add(pharmacist);
    }

    public void removePersonnel(Pharmacist pharmacist) throws Exception { //& 8.6
        //we don`t have to check pharmacist of it`s correctness because they are checked before adding
        personnel.remove(pharmacist);
    }

    public void removeDuties()
    {
         removeFromExtent();
    }

}

package mp4.subset;

import mp1.Methods;

import java.util.*;

public class Pharmacist implements Methods {
    private String name;
    private Integer salary;
    private Set<Drugstore> workIn;
    private Set<Drugstore> curatesIn;


    public Pharmacist(String name, Integer salary, Set<Drugstore> workIn, Set<Drugstore> curatesIn) throws Exception {

        checkString(name);
        checkInteger(salary);
        checkSet(workIn);
        checkSet(curatesIn);


        this.name = name;
        this.salary = salary;
        this.workIn = workIn;
        this.curatesIn = curatesIn;
    }

    public Pharmacist(String name, Integer salary) throws Exception {
        checkString(name);
        checkInteger(salary);

        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) throws Exception {
        checkInteger(salary);
        this.salary = salary;
    }

    public Set<Drugstore> getWorkIn() {
        return Collections.unmodifiableSet(workIn);
    }

    public void addWorkIn(Drugstore drugstore) throws Exception {
        checkDrugstoreMP4(drugstore);
        drugstore.addListOfWorkers(this);
        workIn.add(drugstore);
    }
    public void remWorkIn(Drugstore drugstore) throws Exception {
        checkDrugstoreMP4(drugstore);
        drugstore.remListOfWorkers(this);
        workIn.remove(drugstore);
    }

    public Set<Drugstore> getCuratesIn() {
        return Collections.unmodifiableSet(curatesIn);
    }

    public void addCuratesIn(Drugstore drugstore) throws Exception {
        if(workIn.contains(drugstore))
        {
            checkDrugstoreMP4(drugstore);
            drugstore.addListOfCurators(this);
            curatesIn.add(drugstore);
        }
        else {
            throw new Exception("Pharmacist cannot curates in drugstore without working in it");
        }

    }
    public void remCuratesIn(Drugstore drugstore) throws Exception {
        if(workIn.contains(drugstore))
        {
            checkDrugstoreMP4(drugstore);
            drugstore.remListOfCurators(this);
            curatesIn.remove(drugstore);
        }
        else {
            throw new Exception("This pharmacist dont work in this drugstore");
        }

    }
}

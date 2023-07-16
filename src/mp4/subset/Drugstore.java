package mp4.subset;

import mp1.Methods;

import java.util.*;

public class
Drugstore implements Methods {
    private String name;
    private String address;

    private Set<Pharmacist> listOfWorkers;
    private Set<Pharmacist> listOfCurators;


    public Set<Pharmacist> getListOfWorkers() {
        return Collections.unmodifiableSet(listOfWorkers);
    }

    public void addListOfWorkers(Pharmacist pharmacist) throws Exception {
        checkPharmacistMP4(pharmacist);
        listOfWorkers.add(pharmacist);
    }
    public void remListOfWorkers(Pharmacist pharmacist) {
        listOfWorkers.remove(pharmacist);
    }

    public Set<Pharmacist> getListOfCurators() {
        return Collections.unmodifiableSet(listOfCurators);

    }

    public void addListOfCurators(Pharmacist pharmacist) throws Exception {
        checkPharmacistMP4(pharmacist);
        listOfWorkers.add(pharmacist);
    }
    public void remListOfCurators(Pharmacist pharmacist) {
        listOfCurators.add(pharmacist);
    }

    public Drugstore(String name, String address) throws Exception {
        checkString(name);
        checkString(address);

        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        checkString(address);
        this.address = address;
    }
}

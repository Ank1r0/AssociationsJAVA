package mp4.ordered;

import mp1.Methods;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Retailer implements Methods {
    private String name;
    private String address;

    private Set<Drug> drugSet;


    public Retailer(String name, String address) throws Exception {
        checkString(name);
        checkString(address);

        this.name = name;
        this.address = address;
    }

    public List<Drug> getDrugList(){
        return drugSet.stream().sorted(Comparator.comparing(Drug::getName)).toList();
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

    public void addDrug(Drug drug) throws Exception {
        checkIfNotNull(drug);
        drugSet.add(drug);
    }
}

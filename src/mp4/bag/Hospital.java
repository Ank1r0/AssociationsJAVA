package mp4.bag;

import mp1.Methods;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hospital implements Methods {
    private String name;
    private String address;

    private Set<Regimen> regimenSet;

    public Hospital(String name, String address) throws Exception {
        checkString(name);
        checkString(address);

        this.name = name;
        this.address = address;
        regimenSet = new HashSet<>();
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

    public Set<Regimen> getRegimenSet() {
        return Collections.unmodifiableSet(regimenSet);
    }

    public void addRegimen(Regimen regimen) throws Exception {
        checkIfNotNull(regimen);
        regimenSet.add(regimen);

    }

}

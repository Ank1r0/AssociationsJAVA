package mp4.xor;

import mp1.Methods;
import mp4.subset.Pharmacist;

import java.util.HashSet;
import java.util.Set;

public class Company implements Methods {
    private String name;
    private Set<Programmer> programmers = new HashSet<>();

    public Company(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public void addProgrammer(Programmer programmer) throws Exception {
        if(programmer != null)
        {
            checkString(programmer.getName());
            checkString(programmer.getFavoriteFood());
            programmers.add(programmer);
        }
    }

    public void remProgrammer(Programmer programmer) throws Exception {
        if (programmer != null)
        {
            programmers.remove(programmer);
        }
    }
}

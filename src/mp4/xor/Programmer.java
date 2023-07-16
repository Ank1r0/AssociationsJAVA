package mp4.xor;

import mp1.Methods;

import java.util.*;

public class Programmer implements Methods {

    private String name;
    private String favoriteFood;
    private Set<Freelance> projects = new HashSet<>();
    private Company contractWith;

    public Programmer(String name, String favoriteFood) throws Exception {
        checkString(name);
        checkString(favoriteFood);

        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public void addProject(Freelance freelance) throws Exception {
        if(contractWith == null)
        {
            projects.add(freelance);
        }
        else{
            throw new Exception("You cannot take freelance contract due company with contract");
        }
    }

    public void hireInCompany(Company company) throws Exception {
        if(!projects.isEmpty())
        {
            throw new Exception("First of all dead with projects and then try to get a contract");
        } else if (!(contractWith == null)) {
            throw new Exception("Due laws of this code you cannot be hired in another company if u already hired");
        }
        contractWith = company;
    }

    public void remProject(Freelance freelance) throws Exception {
        if(contractWith == null)
        {
            projects.remove(freelance);
        }
        else{
            throw new Exception("Forget freelance if u have contract with company");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public String getFavoriteFood() {

        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) throws Exception {
        checkString(favoriteFood);
        this.favoriteFood = favoriteFood;
    }

    public Set<Freelance> getProjects() {
        return Collections.unmodifiableSet(projects);
    }

    public Company getContractWith() {
        return contractWith;
    }

}

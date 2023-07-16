package mp1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Allergens implements Serializable, Methods {
    private String name;
    private List<String> allergen_group = new ArrayList<>(); // Inhalant, Ingestant, Injectant, Contactant, Infectant allergens

    public Allergens(String name, List<String> allergen_group) throws Exception {
        checkString(name);
        checkList(allergen_group);
        this.name = name;
        this.allergen_group = allergen_group;
    }

    public Allergens(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        checkString(name);
        this.name = name;
    }

    public List<String> getAllergen_group() {
        return allergen_group;
    }

    public void addAllergenType(String type) throws Exception
    {
        checkString(type);
        allergen_group.add(type);
    }
    public void removeAllergenType(String allergytype) { // add and remove
        for (int i = 0; i < allergen_group.size(); i++)
            if(allergen_group.get(i).equals(allergytype))
            {
                allergen_group.remove(i);
            }

    }

    @Override
    public String toString() {
        return "Product.Allergens{" +
                "name='" + name + '\'' +
                ", allergen_groups=" + allergen_group +
                '}';
    }
}

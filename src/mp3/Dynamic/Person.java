package mp3.Dynamic;

import mp2.ObjectPlus;

public abstract class Person extends ObjectPlus {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(Person oldRole){
        this.name = oldRole.name;
        oldRole.removeFromExtent();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
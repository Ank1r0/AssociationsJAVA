package mp3.MultyAspect;

import mp1.Methods;

public abstract class Person implements Methods {
    private String name;
    private SkillLevel level;

    private Boolean possibilityToCreateMedicines;
    private Boolean possibilityToSellMedicines;

    public Person(String name, SkillLevel level) {
        this.name = name;
        this.level = level;
        if(SkillLevel.BEGINNER == level)
        {
            this.possibilityToCreateMedicines = false ;
            this.possibilityToSellMedicines = false;
        }
        else if
        (SkillLevel.INTERMEDIATE == level)
        {
            this.possibilityToCreateMedicines = false ;
            this.possibilityToSellMedicines = true;
        }
        else if
        (SkillLevel.PROFESSIONAL == level)
        {
            this.possibilityToCreateMedicines = true ;
            this.possibilityToSellMedicines = true;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {

        this.level = level;
    }

    public Boolean getPossibilityToCreateMedicines() {
        return possibilityToCreateMedicines;
    }

    public void setPossibilityToCreateMedicines(Boolean possibilityToCreateMedicines) {
        this.possibilityToCreateMedicines = possibilityToCreateMedicines;
    }

    public Boolean getPossibilityToSellMedicines() {
        return possibilityToSellMedicines;
    }

    public void setPossibilityToSellMedicines(Boolean possibilityToSellMedicines) {
        this.possibilityToSellMedicines = possibilityToSellMedicines;
    }
    
    public void doDrugs() throws Exception {
        if(level != null && SkillLevel.PROFESSIONAL == level)
        {
            System.out.println(name+": Doing drugs.");
        }
        else 
            throw new Exception("Only professional can do drugs!");
    }
    public void sellDrugs() throws Exception {
        if(level != null && SkillLevel.BEGINNER == level)
        {
            throw new Exception("Only above beginner can sell drugs!");
        }
        else
            System.out.println(name+":Selling drugs.");

    }
}

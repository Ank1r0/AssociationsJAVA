package mp3.MultyAspect;

import mp1.Methods;

public class Intern extends Person implements Methods {

    String internNumber;
    public Intern(String name, SkillLevel level, String InternNumber) {
        super(name, level);
        this.internNumber = InternNumber;
    }

    public String getInternNumber() {
        return internNumber;
    }

    public void setInternNumber(String internNumber) throws Exception {
        checkString(internNumber);
        this.internNumber = internNumber;
    }
}
package mp3.MultyAspect;

public class main {
    public static void main(String[] args) throws Exception {
        Intern intern = new Intern("asd",SkillLevel.BEGINNER,"s22734");
        Intern intern2 = new Intern("Walter White",SkillLevel.PROFESSIONAL,"s22734");
        Pharmacist pharmacist  = new Pharmacist("Walter White",SkillLevel.BEGINNER,"1422",7567);

        //intern.doDrugs();
        intern2.doDrugs();
        pharmacist.doDrugs();

    }
}

package mp2;

import mp1.Methods;


import java.util.*;

public class Pharmacist extends  ObjectPlus implements Methods { // idk 8.3,

    private Drugstore drugstore; // Drugstore in which pharmacist works
    private Set<JobDuty> duties = new HashSet<>(); // 8.2
    private List<Licence> licences; // first of all create licence second first one pharmacist

    private Long Id;
    private String FirstName;
    private String SecondName;
    private long dob;

    //Date of birth

    // when deleting, delete licence also


    public Pharmacist( Long id, String firstName, String secondName, long dob,Licence licence) throws Exception {

        checkLong(id);
        checkString(firstName);
        checkString(secondName);
        checkLong(dob);
        checkLicence(licence);

        licences.add(licence);
        Id = id;
        FirstName = firstName;
        SecondName = secondName;
        this.dob = dob;
    }

    public Pharmacist( Pharmacist pharmacist) throws Exception {

        checkLong(pharmacist.getId());
        checkString(pharmacist.getFirstName());
        checkString(pharmacist.getSecondName());
        checkLong(pharmacist.getDateOfBirth());
        checkLicence((Licence) pharmacist.getLicences().get(0));

        licences.add((Licence) pharmacist.getLicences().get(0));
        Id = pharmacist.getId();
        FirstName = pharmacist.getFirstName();
        SecondName = pharmacist.getSecondName();
        this.dob = pharmacist.getDateOfBirth();
    }

    public Pharmacist(Long id, String firstName, String secondName, long dob, Licence licence, Drugstore drugstore, Set<JobDuty> duties)throws Exception {

        checkLong(id);
        checkString(firstName);
        checkString(secondName);
        checkLong(dob);
        checkLicence(licence);

        this.drugstore = drugstore;
        this.duties = duties;
        licences.add(licence);
        Id = id;
        FirstName = firstName;
        SecondName = secondName;
        this.dob = dob;
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public Set<JobDuty> getDuties() {
        return Set.copyOf(duties);
    }

    public List getLicences() {
        return Collections.unmodifiableList(licences);
    }

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public long getDateOfBirth() {
        return dob;
    }

    //SETTERS || SETTERS || SETTERS || SETTERS || SETTERS || SETTERS || SETTERS
    public void setDrugstore(Drugstore drugstore)  throws Exception{
        //checkDrugstore
        this.drugstore = drugstore;
    }

    public void setDuties(Set<JobDuty> duties)  throws Exception{
        //checkDuties
        this.duties = duties;
    }

    public void setLicence(Licence licence) throws Exception {
        checkLicence(licence);
        licences.add(licence);
    }

    public void removeLicence(Licence licence) throws Exception {
        checkLicence(licence);
        licences.remove(licence);
    }

    public void removeLicence(int number) throws Exception {
        licences.remove(number);
    }

    public void setId(Long id)  throws Exception{
        checkLong(Id);
        Id = id;
    }

    public void setFirstName(String firstName)  throws Exception{
        checkString(firstName);
        FirstName = firstName;
    }

    public void setSecondName(String secondName)  throws Exception{
        checkString(secondName);
        SecondName = secondName;
    }

    public void setDob(Date dob)  throws Exception{
        //rework mb?
        Date date = new Date();

        checkDate(dob);
        checkIsDateCorrect(dob.getTime(),date.getTime());
        checkValidAge(dob);

        this.dob = dob.getTime();
    }

    private void deleteLicence() // add method remove licence
    {
        for (int i = 0; i < licences.size(); i++) {
            licences.get(0).deleteLicence();
        }

        licences = null;
    }

    public void gettingFired()
    {
        removeFromExtent();
        deleteLicence();
    }

    public static void fire(Pharmacist pharmacist) throws Exception {
        if(pharmacist != null)
        {
            pharmacist.gettingFired();
            pharmacist = null;
            //garbage collector will clean this
        }
        else throw new Exception("Pharmacist cannot be null");
    }

    /*@Override
    public List getExtent(Class klass) {
        return super.getExtent(klass);
    }*/
}

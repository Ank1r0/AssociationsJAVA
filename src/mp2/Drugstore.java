package mp2;

import mp1.Methods;

import java.util.*;

public class Drugstore extends ObjectPlus implements Methods {

    //Based on laws which I found there are no official document which says in which drugstore he/she/etc. should work
    // but if it exists, it is called the 'Pharmacist Employment Agreement',
    // and the recreated connection is not an employment contract.
    // So that`s my recreation of Pharmacist Employment Agreement
    private String name;
    private String address;
    private MedicalSupplier supplier;//7 change it one to many
    //add remove get and update both
    private Map<String,JobDuty> storeDuties; // change it notes in jobduty, get add remove
    private Map<Integer,Pharmacist> pharmacists = new HashMap(); // 9.2 with a hash map would be better to create hierarchy,
                                                                 // but I didn't have a time to find some information about ranks in pharmacy
                                                                 // That`s why they will have numbers instead of their roles


    public Drugstore(String name, String address, MedicalSupplier supplier) throws Exception {
        checkString(name);
        checkString(address);
        checkSupplier(supplier);

        this.name = name;
        this.address = address;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSupplierName()
    {
        return supplier.getName();
    }

    public String getSupplierAddress()
    {
        return supplier.getAddress();
    }


    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }
    public void setAddress(String address) throws Exception {
        checkString(address);
        this.address = address;
    }

    public void setSupplier(MedicalSupplier supplier) throws Exception {
        checkSupplier(supplier);
    }

    public Map<Integer, Pharmacist> getPharmacists(){ // Integer + get list
        return Collections.unmodifiableMap(pharmacists);
    }

    public void addPharmacist(Pharmacist pharmacist,Integer rank) throws Exception {

        checkPharmacist(pharmacist);
        pharmacists.put(rank,pharmacist);//rework it take the rank from  pharmacist
        //write in pharmacist where he is working
    }

    public void removePharmacist(Integer rank) throws Exception { // should be automatically updated 9.3
        checkInteger(rank);
        pharmacists.remove(rank);

    }

    public void addStoreDuty(JobDuty duty) throws Exception {
        checkDuty(duty);
        storeDuties.put(duty.getDuty(),duty);
        //write in pharmacist where he is working

    }

    public void removeDuties(JobDuty duty)
    {

    }
    public void deleteDrugstore()
    {
        removeFromExtent();
        storeDuties = null;// ask here
        pharmacists = null;
    }


}

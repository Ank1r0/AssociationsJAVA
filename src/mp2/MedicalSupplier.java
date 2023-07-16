package mp2;

import mp1.Methods;
import mp1.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicalSupplier extends ObjectPlus implements Methods { //7
   private String name;
   private String address;

   private Drugstore drugstore;// add set and get and remove

    public MedicalSupplier(String name, String address, Drugstore drugstore) throws Exception {


        checkString(name);
        checkString(address);

        this.drugstore = drugstore;
        this.name = name;
        this.address = address;
    }

    public MedicalSupplier(String name, String address) throws Exception {

        checkString(name);
        checkString(address);

        this.name = name;
        this.address = address;
    }




    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }
    public void setAddress(String address) throws Exception{
        checkString(address);
        this.address = address;
    }



}

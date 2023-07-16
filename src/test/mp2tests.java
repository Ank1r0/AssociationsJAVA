package test;
import mp2.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


class mp2tests {


    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    Date dateOfIssue = dateFormat.parse("2000-01-15 14:30:00.000");
    Date ExpirationDate = dateFormat.parse("2023-04-27 14:30:00.000");
    Date dateOfBirth = dateFormat.parse("2000-01-15 14:30:00.000");
    Licence licence = new Licence("tempAC","tempLicenceNO","tempStringNO",dateOfIssue.getTime(),ExpirationDate.getTime(),"tempQualification","tempAddress","tempAutotiry");

    Pharmacist pharmacist = new Pharmacist(0L,"Illia","Volchetskyi",dateOfBirth.getTime(),licence);

    MedicalSupplier supplier = new MedicalSupplier("tempMedSupp","tempAddress");


    Drugstore drugstore = new Drugstore("Apteka N3","tempStreet",supplier);

    JobDuty duty = new JobDuty("Prepare documentation",drugstore);


    void MyFirstJUnitJupiterTests() throws Exception {

    }

    mp2tests() throws Exception {

    }

    @Test
    void Licence() throws Exception {
        Licence temp = new Licence("tempAC","tempLicenceNO","tempStringNO",dateOfIssue.getTime(),ExpirationDate.getTime(),"tempQualification","tempAddress","tempAutotiry");

        assertNotEquals(licence,temp);

        assertEquals(licence.getAC(),temp.getAC());
        assertEquals(licence.getLicenceNO(),temp.getLicenceNO());
        assertEquals(licence.getExpirationD(),temp.getExpirationD());
        assertEquals(licence.getControlNO(),temp.getControlNO());
        assertEquals(licence.getQualification(),temp.getQualification());
        assertEquals(licence.getIssuedAuthority(),temp.getIssuedAuthority());
        assertEquals(licence.getDateOfIssue(),temp.getDateOfIssue());
        assertEquals(licence.getIssuedAuthorityAddress(),temp.getIssuedAuthorityAddress());

    }

    @Test
    void Pharmacist() throws Exception {
        Licence tempLicence = new Licence("tempAC123","tempLicenceNO","tempStringNO",dateOfIssue.getTime(),ExpirationDate.getTime(),"tempQualification","tempAddress","tempAutotiry");

        Pharmacist temp = new Pharmacist(0L,"Illia","Volchetskyi",dateOfBirth.getTime(),tempLicence);

        assertNotEquals(pharmacist,temp);

        assertEquals(pharmacist.getDateOfBirth(),temp.getDateOfBirth());
        assertEquals(pharmacist.getFirstName(),temp.getFirstName());
        assertEquals(pharmacist.getSecondName(),temp.getSecondName());
        assertEquals(pharmacist.getId(),temp.getId());

        assertNotEquals(pharmacist.getLicences().get(0),temp.getLicences().get(0));

    }

    @Test
    void DrugstoreAndSupplier() throws Exception {
        assertEquals(drugstore.getSupplierName(),supplier.getName());
        assertEquals(drugstore.getSupplierAddress(),supplier.getAddress());

        assertEquals( drugstore.getPharmacists().size(),0);

        drugstore.addPharmacist(pharmacist,1);

        assertEquals( drugstore.getPharmacists().size(),1);

    }

    @Test
    void JobDuty() throws Exception {
        assertEquals(duty.getDuty(),"Prepare documentation");
        assertEquals(duty.getPersonnel().size(),0);
        duty.addPersonnel(pharmacist);
        assertEquals(duty.getPersonnel().size(),1);
    }



}
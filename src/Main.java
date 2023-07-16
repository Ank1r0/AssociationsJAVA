
import mp1.Product;
import mp2.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) throws Exception {

       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date dateOfIssue = dateFormat.parse("2000-01-15 14:30:00.000");
        System.out.println(dateOfIssue.getTime());
        System.out.println(new Date().getTime());*/

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date dateOfIssue = dateFormat.parse("2000-01-15 14:30:00.000");
        Date ExpirationDate = dateFormat.parse("2023-04-27 14:30:00.000");
        Date dateOfBirth = dateFormat.parse("2000-01-15 14:30:00.000");

        System.out.println(dateOfIssue);
        Licence licence = new Licence("tempAC","tempLicenceNO","tempStringNO",dateOfIssue.getTime(),ExpirationDate.getTime(),"tempQualification","tempAddress","tempAutotiry");

        Pharmacist pharmacist = new Pharmacist(0L,"Illia","Volchetskyi",dateOfBirth.getTime(),licence);
        MedicalSupplier supplier = new MedicalSupplier("tempMedSupp","tempAddress");

        Drugstore drugstore = new Drugstore("Apteka N3","tempStreet",supplier);

        System.out.println(dateOfIssue.getTime());
        //assertEquals(licence,new Licence("tempAC","tempLicenceNO","tempStringNO",dateOfIssue,ExpirationDate,"tempQualification","tempAddress","tempAutotiry"));




    }
}

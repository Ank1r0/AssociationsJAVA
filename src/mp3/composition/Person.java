package mp3.composition;

import mp2.Licence;
import mp2.Pharmacist;
import mp3.overlapping.Type;

import java.time.LocalDate;
import java.util.Date;
import java.util.EnumSet;

public class Person {

    private String name;

    private LocalDate dob;

    private final Pharmacist pharmacist;

    public Person(EnumSet<Type> types, String name,String surname, LocalDate birthDate,
                  String studentNumber, Double scholarShip, Double salary,
                  String medicalTests, Double pensions) throws Exception {
        validateType(types);
        this.name = name;
        this.dob = birthDate;
        if (types.contains(Type.EMPLOYEE)){ //student do not have licence in my case, because licence on my point of view is similar to diploma
            pharmacist = new Pharmacist(12L,name,surname,6464640L,new Licence("tempAC","tempLicenceNO","tempStringNO",6464645L,64646456L,"tempQualification","tempAddress","tempAutotiry"));
        }else {
            pharmacist = null;
        }

    }

    private void validateType(EnumSet<Type> types){
        //validation
    }

    public Pharmacist getPharmacist() throws Exception {
        return new Pharmacist(pharmacist);
    }
}

package mp1;

import mp2.*;

import java.time.LocalDate;
import java.util.*;

public interface Methods {
    default void checkBoolean(Boolean bool) throws Exception {
        if(bool == null)
        {
            throw new Exception("Boolean cannot be null");
        }
    }

    default void checkLocalDate(LocalDate date) throws Exception {
        if(date == null)
        {
            throw new Exception("Date is not correct");
        }
    }

    default void checkString(String name) throws Exception {
        if(name.length() < 3 || name.length() > 200)
            throw new Exception("NotInRangeException");
    }

    default void checkIfNotNull(Object any) throws Exception{
        if(any == null)
        {
            throw new Exception("This object cannot be null!");
        }
    }

    static void staticCheckString(String name) throws Exception {
        if(name.length() < 3 || name.length() > 200)
            throw new Exception("NotInRangeException");
    }

    default void checkList(List<String> list) throws Exception {
        if(list == null)
            throw new Exception("NullListException");
    }

    default void checkPharmacistMP4(mp4.subset.Pharmacist pharmacist) throws Exception {
        if( pharmacist == null)
        {
            throw new Exception("Pharmacist cannot be null");
        }
        else {
            checkString(pharmacist.getName());
            checkInteger(pharmacist.getSalary());
        }
    }

    default void checkLong(Long id) throws Exception {
        if(id == null || id < 0)
            throw new Exception("InvalidIdException");

    }

    default void checkDiscount(Integer discount) throws Exception {
        if(discount != null)
        {
            if(discount < 0 || discount > 100)
                throw new Exception("OutOfDiscountBounds");
        }
    }

    default void checkNumber(int number) throws Exception {
        if(number < 0)
            throw new Exception("LowerZeroException");
    }

    default void checkInteger(Integer number) throws Exception {
        if(number < 0)
            throw new Exception("LowerZeroException");
    }

    default void checkSet(Set<mp4.subset.Drugstore> drugstoreSet) throws Exception {
        if(drugstoreSet == null){
            throw new Exception("You cannot enter null set, if u want to do it use constructor with no sets");
        }
    }

    default void checkDrugstoreMP4(mp4.subset.Drugstore drugstore) throws Exception {
        if(drugstore == null){
            throw new Exception("Drugstore cannot be null");
        }
        else {
            checkString(drugstore.getName());
            checkString(drugstore.getAddress());
        }
    }

    default void checkCorrectCalendar(Calendar calendar) throws Exception {
        if(calendar == null)
        {
            throw new Exception("This cannot be null");
        }
    }

    static void staticCheckNumber(int number) throws Exception {
        if(number < 0)
            throw new Exception("LowerZeroException");
    }

    default void checkAllergens(Allergens allergens) throws Exception{
        checkString(allergens.getName());
        checkList(allergens.getAllergen_group());
    }

    static void outOfBounds(int number,List<String>List) throws Exception {
        staticCheckNumber(number);

        if(number >= List.size())
        {
            throw new Exception("OutOfBounds");
        }
    }
    default void checkDate(Date date) throws Exception {
       if(date.getTime() > 0)
       {
           throw new Exception("Date cannot be null");
       }
    }

    default void checkIsDateCorrect(long earlier,long later) throws Exception {
        checkLong(earlier);
        checkLong(later);

        if(earlier > later)
        {
            throw new Exception("Date earlier is not valid");
        }
    }

    default int getYearsFromDate(Date date){
        long milliseconds = date.getTime();
        // Calculate the number of milliseconds in a year (assuming 365.25 days per year)
        double msPerYear = 365.25 * 24 * 60 * 60 * 1000;

        // Divide the input milliseconds by the number of milliseconds in a year
        return (int)Math.round(milliseconds / msPerYear);
    }

    default void checkValidAge(Date dob) throws Exception {

        int yearsNowMinus18 = getYearsFromDate(new Date()) - 18;

        if (getYearsFromDate(dob) < yearsNowMinus18) {
            throw new Exception("Person who is under 18 cannot be added to this class/attribute");
        }

    }

    default void checkLicence(Licence licence) throws Exception {
        if(licence != null)
        {
            checkString(licence.getAC());
            checkString(licence.getLicenceNO());
            checkString(licence.getControlNO());

            checkLong(licence.getDateOfIssue());
            checkLong(licence.getExpirationD());
           // checkIsDateCorrect(licence.getDateOfIssue(),licence.getExpirationD());

            checkString(licence.getQualification());
            checkString(licence.getIssuedAuthority());
            checkString(licence.getIssuedAuthorityAddress());
        }
        else {
            throw new Exception("Licence cannot be null");
        }
    }

    default void checkPharmacist(Pharmacist pharmacist) throws Exception{

        if(pharmacist != null)
        {
            List<Licence> licences = pharmacist.getLicences();

            for (int i = 0; i < licences.size(); i++) {
                checkLicence(licences.get(i));
            }

            checkLong(pharmacist.getId());
            checkString(pharmacist.getFirstName());
            checkString(pharmacist.getSecondName());
            checkLong(pharmacist.getDateOfBirth());
            // checkValidAge(pharmacist.getDateOfBirth());
        }
        else {
            throw new Exception("Pharmacist cannot be null");
        }

    }

    default void checkDrugstore(Drugstore drugstore) throws Exception{
        if(drugstore != null)
        {
            checkString(drugstore.getName());
            checkString(drugstore.getAddress());
        }
        throw new Exception("Drugstore cannot be null");

    }

    default void checkSupplier(MedicalSupplier supplier) throws Exception{
        if(supplier != null)
        {
            checkString(supplier.getName());
            checkString(supplier.getAddress());
        }
        else throw new Exception("MedicalSupplier cannot be null");
    }

    default void checkDuty(JobDuty duty) throws Exception {
        if(duty != null)
        {
            checkString(duty.getDuty());
        }
    }


}

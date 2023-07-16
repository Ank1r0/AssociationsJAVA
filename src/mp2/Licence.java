package mp2;

import mp1.Methods;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Licence extends ObjectPlus implements Methods {// 10 create pharmacist first and this after

    public static final String FILENAME = "licences.txt";
    private String AC;//(AC#6565694)
    private String LicenceNO; //PH 29080
    private String ControlNO; // 87758

    private long DateOfIssue;
    private long ExpirationDate;

    private String qualification;
    private String IssuedAuthority; //authority which issued the certificate\licence
    private String IssuedAuthorityAddress;

    private Pharmacist owner;//? you cannot change it

    private static List<Licence> extent =new ArrayList<Licence>();

    public Licence(String AC, String licenceNO, String controlNO, long dateOfIssue, long expirationDate, String qualification, String issuedAuthority, String issuedAuthorityAddress) throws Exception {
        checkString(AC);
        checkString(licenceNO);
        checkString(controlNO);
        checkString(licenceNO);
        checkLong(dateOfIssue);
        checkLong(expirationDate);
        checkIsDateCorrect(dateOfIssue,expirationDate);
        checkString(qualification);
        checkString(issuedAuthority);
        checkString(issuedAuthorityAddress);

        this.AC = AC;
        LicenceNO = licenceNO;
        ControlNO = controlNO;
        DateOfIssue = dateOfIssue;
        ExpirationDate = expirationDate;
        this.qualification = qualification;
        IssuedAuthority = issuedAuthority;
        IssuedAuthorityAddress = issuedAuthorityAddress;

        extent.add(this);
    }

    public Pharmacist getOwner() {
        return owner;
    }

    public void setOwner(Pharmacist owner) throws Exception {
        checkPharmacist(owner);
        this.owner = owner;
    }


    // GETTERS GETTERS
    public String getAC() {
        return AC;
    }

    public String getLicenceNO() {
        return LicenceNO;
    }

    public String getControlNO() {
        return ControlNO;
    }

   /* public Date getDateOfIssue() {
        return DateOfIssue;
    }*/

    public void deleteLicence()
    {
        removeFromExtent(); //disconnect

    }
    public long getDateOfIssue()
    {
        return DateOfIssue;
    }
    public long getExpirationD() {
        return ExpirationDate;
    }

    public String getQualification() {
        return qualification;
    }

    public String getIssuedAuthority() {
        return IssuedAuthority;
    }

    public String getIssuedAuthorityAddress() {
        return IssuedAuthorityAddress;
    }

    //SETTERS    SETTERS

    public void setAC(String AC) throws Exception {
        checkString(AC);
        this.AC = AC;
    }

    public void setLicenceNO(String licenceNO) throws Exception {
        checkString(LicenceNO);
        LicenceNO = licenceNO;
    }

    public void setControlNO(String controlNO) throws Exception{
        checkString(controlNO);
        ControlNO = controlNO;
    }

    /*public void setDateOfIssue(Date dateOfIssue) throws Exception{
        checkDate(dateOfIssue);
        checkIsDateCorrect(dateOfIssue,ExpirationDate);
        DateOfIssue = dateOfIssue;
    }

    public void setExpirationDate(Date expirationDate) throws Exception{
        checkDate(DateOfIssue);
        checkIsDateCorrect(DateOfIssue,expirationDate);
        ExpirationDate = expirationDate;
    }*/

    public void setQualification(String qualification) throws Exception{
        checkString(qualification);
        this.qualification = qualification;
    }

    public void setIssuedAuthority(String issuedAuthority) throws Exception{
        checkString(issuedAuthority);
        IssuedAuthority = issuedAuthority;
    }

    public void setIssuedAuthorityAddress(String issuedAuthorityAddress) throws Exception{
        checkString(issuedAuthorityAddress);
        IssuedAuthorityAddress = issuedAuthorityAddress;
    }
    /*@Override
    public List getExtent(Class klass) {
        return super.getExtent(klass);
    }*/
}

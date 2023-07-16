package mp3.overlapping;

import mp1.Methods;

import java.time.LocalDate;
import java.util.EnumSet;

public class Person implements Methods {

    private EnumSet<Type> types;
    private String name;

    private LocalDate birthDate;

    private String EmpNumber;
    private Integer wages;//for student
    private Integer salary; // for emp
    private Integer Vacations; // for vacation



    private String studentGmail;//Identification



    public Person(EnumSet<Type> types, String name, LocalDate birthDate, String empNumber, Integer wages, Integer salary, Integer vacations, String studentGmail) throws Exception {



        setTypes(types);
        setName(name);


        if(types.contains(Type.STUDENT)){

            checkString(studentGmail);
            checkNumber(wages);

            setWages(wages);
            setStudentGmail(studentGmail);
        }

        if(types.contains(Type.EMPLOYEE)){

            checkNumber(salary);
            setSalary(salary);
        }

        if(types.contains(Type.VACATION)){

            checkNumber(vacations);
            setVacations(vacations);
        }



        this.types = types;
        this.name = name;
        this.birthDate = birthDate;
        EmpNumber = empNumber;
        this.wages = wages;
        this.salary = salary;
        Vacations = vacations;
    }

    public EnumSet<Type> getTypes() {
        return types;
    }

    public void setTypes(EnumSet<Type> types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmpNumber() throws Exception {
        if(types.contains(Type.EMPLOYEE)){
            return EmpNumber;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public void setEmpNumber(String empNumber) throws Exception {
        if(types.contains(Type.EMPLOYEE)){
            this.EmpNumber = empNumber;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public Integer getWages() throws Exception {

        if(types.contains(Type.STUDENT)){
            return wages;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public void setWages(Integer wages) throws Exception {

        if(types.contains(Type.STUDENT)){
            this.wages = wages;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public Integer getSalary() throws Exception {
        if(types.contains(Type.EMPLOYEE)){
            return salary;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }


    }

    public void setSalary(Integer salary) throws Exception {
        if(types.contains(Type.EMPLOYEE)){
            this.salary = salary;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public Integer getVacations() throws Exception {
        if(types.contains(Type.VACATION)){
            return Vacations;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public void setVacations(Integer vacations) throws Exception {
        if(types.contains(Type.VACATION)){
            this.Vacations = vacations;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

    public String getStudentGmail() throws Exception {

        if(types.contains(Type.STUDENT)){
            return studentGmail;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }


    public void setStudentGmail(String studentGmail) throws Exception {
        if(types.contains(Type.STUDENT)){
            this.studentGmail = studentGmail;
        }else{
            throw new Exception("You cannot set or get variables which are not yours");
        }
    }

}

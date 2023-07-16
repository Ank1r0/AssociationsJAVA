package mp4.unique;

import mp1.Methods;
import mp2.ObjectPlus;

import java.util.*;

public class Employee extends ObjectPlus implements Methods {
    private String name;

    private Calendar dob;
    private String BornIn;
    private String empNumber;//this is unique



    public Employee(String name, String bornIn, Calendar dob,String empNumber) throws Exception {
        checkString(name);
        checkCorrectCalendar(dob);
        checkString(bornIn);

        this.name = name;
        this.dob = dob;
        BornIn = bornIn;

        this.empNumber = generateEmpNumber(empNumber);
    }

    private String generateEmpNumber(String empNumber) throws Exception {

        List<Employee> list = ObjectPlus.getExtent().get(Employee.class);

        boolean exists = list.stream().anyMatch(e -> e != this && e.getEmpNumber().equals(empNumber));

        if(exists)
        {
            throw new Exception("this number already exists");
        }
        return empNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public String getBornIn() {
        return BornIn;
    }

    public void setBornIn(String bornIn) {
        BornIn = bornIn;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +

                ", BornIn='" + BornIn + '\'' +
                ", empNumber='" + empNumber + '\'' +
                '}';
    }

    /*private String generateEmpNumber(String name, Calendar dob, String bornIn, Integer modification) throws Exception {

        List<Employee> list = ObjectPlus.getExtent().get(Employee.class);

        System.out.println(list);
        String temp = "";

        temp = name.substring(0,1) + *//*(Calendar.getInstance().getTimeInMillis()/1000)%10000 +*//* bornIn.substring(0,1) + modification;

        String finalTemp = temp;
        boolean exists = list.stream().anyMatch(e -> e != this || e.getEmpNumber().equals(finalTemp));

        *//*for (Employee emp: list) {
            if (emp != this && emp.getEmpNumber().equals(temp)) {
                System.out.println(emp);
                exists = true;
                break;
            }
        }*//*

        if(exists){
            throw new Exception("Exaclty same empNumber is in the system");
        }
        return empNumber;
    }*/
}

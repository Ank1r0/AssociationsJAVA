package mp4.xor;

import mp1.Methods;

public class Freelance implements Methods {
    private String name;
    private String customer;

    private Integer payment;

    public Freelance(String name, String customer, Integer payment) throws Exception {
        checkString(name);
        checkString(customer);
        checkInteger(payment);

        this.name = name;
        this.customer = customer;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) throws Exception {
        checkString(customer);
        this.customer = customer;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) throws Exception {
        checkInteger(payment);
        this.payment = payment;
    }
}

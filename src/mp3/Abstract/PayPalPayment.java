package mp3.Abstract;

import mp1.Methods;
import mp2.MedicalSupplier;

public class PayPalPayment extends PaymentMethod implements Methods {
    private String email;

    private Integer taxRate;

    public PayPalPayment(Integer amount, String email, Integer taxRate) throws Exception {
        super(amount);
        checkString(email);
        this.taxRate = taxRate;
        this.email = email;
    }

    public boolean processPayment() {
        System.out.println("PayPal payment was successful");
        return true;
    }

    @Override
    public float fullAmount() {
        return amount+((float) (amount * taxRate) /100);
    }


}

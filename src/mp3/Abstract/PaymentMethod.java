package mp3.Abstract;

import mp1.Methods;

public abstract class PaymentMethod implements Methods {
    protected Integer amount;

    public PaymentMethod(Integer amount) throws Exception {
        checkNumber(amount);
        this.amount = amount;
    }

    public abstract boolean processPayment();

    public Integer getAmount() {
        return amount;
    }

    public abstract float fullAmount();
}


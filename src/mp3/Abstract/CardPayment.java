package mp3.Abstract;

import mp1.Methods;

public class CardPayment extends PaymentMethod implements Methods {
    private String cardNumber;
    private String cardholderName;
    private String expirationDate;
    private int cvv;
    private int bankDiscount;

    public CardPayment(Integer amount, String cardNumber, String cardholderName, String expirationDate, int cvv, int bankDiscount) throws Exception {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.bankDiscount = bankDiscount;
    }

    public boolean processPayment() {
        System.out.println("Card payment was successful");
        return true;
    }

    @Override
    public float fullAmount() {
        return amount-((float) (amount * bankDiscount) /100);
    }
}

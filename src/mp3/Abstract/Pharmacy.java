package mp3.Abstract;

public class Pharmacy {
    public static void main(String[] args) throws Exception {
        Integer pharmacyBalance = 0;

        PaymentMethod payment2 = new PayPalPayment(322, "s22734@pjwst.edu.pl", 10);

        PaymentMethod payment1 = new CardPayment(1400, "3314 1231 6456 5354", "Illia Volchetskyi", "7/27", 345, 10);

        if (payment1.processPayment()) {
            pharmacyBalance += payment1.amount;
        }

        System.out.println(payment1.fullAmount());

        if (payment2.processPayment()) {
            pharmacyBalance += payment2.amount;


        }
        System.out.println(payment2.fullAmount());

        System.out.println(pharmacyBalance);
    }
}

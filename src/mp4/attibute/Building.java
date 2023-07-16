package mp4.attibute;

import mp1.Methods;

public class Building implements Methods {
    private String Name;
    private String Address;
    private Integer rentalPrice;
    private Integer discount;

    private final Integer bounders = 25; // in %

    public Building(String name, String address, Integer rentalPrice, Integer discount) throws Exception {

        checkString(name);
        checkString(address);
        checkInteger(rentalPrice);// for 1 month
        checkDiscount(discount);

        setName(name);
        setAddress(address);
        setDiscount(discount);
        setRentalPrice(rentalPrice);

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) throws Exception {
        checkString(address);
        Address = address;
    }

    public Integer getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Integer rentalPrice) throws Exception {
        checkNumber(rentalPrice);
        if(this.rentalPrice == null || this.rentalPrice == 0)
        {
            this.rentalPrice = rentalPrice;
        }
        else {
            double temp = (double) this.rentalPrice / 100; //%1
            //System.out.println(rentalPrice + ">" + temp);
            if(rentalPrice > this.rentalPrice + temp*bounders || rentalPrice < this.rentalPrice - temp*bounders)
            {
                throw new Exception("You cannot change rental payment more than 25%");
            }
            else {
                this.rentalPrice = rentalPrice;
            }
        }
    }

    public Integer getRentalPriceWithDiscount()
    {
        return (getRentalPrice()/100)*(100- getDiscount());
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) throws Exception {
        checkDiscount(discount); // discount can be from 0 to 100
        this.discount = discount;
    }
}

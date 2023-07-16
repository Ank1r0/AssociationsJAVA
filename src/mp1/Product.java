package mp1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product implements Serializable,Methods//CLASS EXTENT 1&2
{
    //CLASS EXTENT | CLASS EXTENT | CLASS EXTENT | CLASS EXTENT | CLASS EXTENT | CLASS EXTENT |
    private static List<Product> extent =new ArrayList<>();
    public static final String FILENAME = "data.txt";

    public static String getFilename(){
        return FILENAME;
    }

    public static List<Product> getExtent(){
        return Collections.unmodifiableList(extent);
    }

    public static void saveExtent(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(extent);
    }

    public static void loadExtent(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        extent = (List<Product>) objectInputStream.readObject();
    }

    // ATTRIBUTES | ATTRIBUTES | ATTRIBUTES | ATTRIBUTES | ATTRIBUTES | ATTRIBUTES | ATTRIBUTES |
    private Long id;
    private String name; //MANDATORY ATTRIBUTE 5
    private String active_substance;

    private Integer discount; // OPTIONAL ATTRIBUTE 4, can be null or more but not bigger than 100
    private int milligram,price,amount; // I use price as int because in this system 1 USD\EUR equals 100 and 2.99 equals to 299 to have more precise calculation information

    private double pricePerMilligram; //DERIVED ATTRIBUTE 8
    private Allergens allergens; // COMPLEX ATTRIBUTE 3


    //MULTI-VALUE ATTRIBUTE 6 (ЛИСТ НАПРИМЕР ЖАНР ФИЛЬМА ТРИЛЛЕР ДРАМА)
    private List<String> groups;


    private String addiction;
    private static List<String>addiction_type = new ArrayList<>(); //CLASS ATTRIBUTE 7 (ТОЛЬКО ТО ЧТО ПРЕНАДЛЕЖИТ ТОК ЭТОМУ КЛАССУ)

    // GETTERS |  GETTERS |  GETTERS |  GETTERS |  GETTERS |  GETTERS |  GETTERS |  GETTERS |
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActive_substance() {
        return active_substance;
    }

    public Integer getDiscount() {
        return discount;
    }

    public int getMilligram() {
        return milligram;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public List<String> getGroups() {
        return groups;
    }

    public double getPricePerMilligram() {
        return pricePerMilligram;
    }

    public Allergens getAllergens() {
        return allergens;
    }

    public String getAddiction() {
        return addiction;
    }


    public static String getAddictionType(int id) throws Exception {
        Methods.staticCheckNumber(id);
        return addiction_type.get(id);
    }

    // SETTERS |  SETTERS |  SETTERS |  SETTERS |  SETTERS |  SETTERS |  SETTERS |  SETTERS |  SETTERS |

    public void setId(Long id) throws Exception {
        checkLong(id);
        this.id = id;
    }

    public void setName(String name) throws Exception {
        checkString(name);
        this.name = name;
    }

    public void setActive_substance(String active_substance) throws Exception {
        checkString(name);
        this.active_substance = active_substance;
    }

    public void setDiscount(Integer discount) throws Exception {
        checkDiscount(discount);
        this.discount = discount;

        setPricePerMilligram();
    }

    public void setMilligram(int milligram) throws Exception {
        checkNumber(milligram);
        this.milligram = milligram;

        setPricePerMilligram();
    }

    public void setPrice(int price) throws Exception {
        checkNumber(price);
        this.price = price;

        setPricePerMilligram();
    }

    public void setAmount(int amount) throws Exception {
        checkNumber(amount);
        this.amount = amount;

        setPricePerMilligram();
    }

    private void setPricePerMilligram() throws Exception {
        pricePerMilligram = (double) (milligram * amount) /price;
        if(discount != null)
        {
            checkNumber(discount);
            pricePerMilligram -= (pricePerMilligram*discount) / 100;

        }
             // I use this formula because on the package you have to write milligram of active substance per one capsule/dose/tablet etc.
    }

    public void setAllergens(Allergens allergens) throws Exception {
        checkAllergens(allergens);
        this.allergens = allergens;
    }

    public void addGroups(String group) throws Exception {
        checkList(groups);
        checkString(group);
        groups.add(group);
    }

    public static void addAddictionType(String addiction) throws Exception {
        Methods.staticCheckString(addiction);
        addiction_type.add(addiction);
    }

    public void removeGroup(String group) throws Exception {
        checkList(groups);
        checkString(group);

        for (int i = 0; i < groups.size(); i++)
            if(groups.get(i).equals(group))
                groups.remove(i);
    }

    public void setAddiction(int i) throws Exception {
        checkNumber(i);
        Methods.outOfBounds(i,addiction_type);
        this.addiction = addiction_type.get(i);
    }

    public static void saveAllExtents() throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(Product.getFilename()));){
            Product.saveExtent(objectOutputStream);
        }
    }

    public static void loadAllExtents() throws IOException,ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Product.getFilename()));){
            Product.loadExtent(objectInputStream);
        }
    }


    //DEFAULT CONSTRUCTOR | DEFAULT CONSTRUCTOR | DEFAULT CONSTRUCTOR | DEFAULT CONSTRUCTOR | DEFAULT CONSTRUCTOR |


    // Сделать всё нужно в конструкторе все листы
    public Product(Long id, String name, String active_substance, int milligram, int price, int amount,int discount, String allergens_,String allergen_type, String group_s, int addiction) throws Exception {
        checkLong(id);
        checkString(name);
        checkString(active_substance);
        checkString(allergens_);
        checkString(group_s);


        checkDiscount(discount);
        checkNumber(milligram);
        checkNumber(price);
        checkNumber(amount);




        Allergens allergens = new Allergens(allergens_);
        allergens.addAllergenType(allergen_type);

        checkAllergens(allergens);

        Product.addAddictionType("No addiction");
        Product.addAddictionType("Physical addiction");
        Product.addAddictionType("Mental addiction");
        Product.addAddictionType("Physical and mental addiction");

        checkNumber(addiction);
        Methods.outOfBounds(addiction,addiction_type);

        List<String> group = new ArrayList<>();
        group.add(group_s);


        checkList(group);

        this.id = id;
        this.name = name;
        this.active_substance = active_substance;
        this.milligram = milligram;
        this.price = price;
        this.amount = amount;
        this.discount = discount;
        this.allergens = allergens;
        this.groups = group;
        this.addiction = addiction_type.get(addiction);
        setPricePerMilligram();
        extent.add(this);
    }
    //OVERLOADED CONSTRUCTOR 11 | OVERLOADED CONSTRUCTOR 11 | OVERLOADED CONSTRUCTOR 11 | OVERLOADED CONSTRUCTOR 11 |

    public Product(Long id, String name, String active_substance, int milligram, int price, int amount, String allergens_,String allergen_type, String group_s, int addiction) throws Exception {
        checkLong(id);
        checkString(name);
        checkString(active_substance);
        checkString(allergens_);
        checkString(group_s);

        checkDiscount(discount);
        checkNumber(milligram);
        checkNumber(price);
        checkNumber(amount);


        checkNumber(addiction);

        Allergens allergens = new Allergens(allergens_);
        allergens.addAllergenType(allergen_type);

        checkAllergens(allergens);

        Product.addAddictionType("No addiction");
        Product.addAddictionType("Physical addiction");
        Product.addAddictionType("Mental addiction");
        Product.addAddictionType("Physical and mental addiction");
        List<String> group = new ArrayList<>();
        group.add(group_s);

        checkList(group);

        this.id = id;
        this.name = name;
        this.active_substance = active_substance;
        this.milligram = milligram;
        this.price = price;
        this.amount = amount;
        this.allergens = allergens;
        this.groups = group;
        this.addiction = addiction_type.get(addiction);
        setPricePerMilligram();
        extent.add(this);
    }
    //METHOD OVERRIDING 10
    @Override
    public String toString() {
        return "Product.Product{" + " \n" +
                "id=" + id +" \n" +
                "name='" + name + '\'' + " \n" +
                "active_substance='" + active_substance + '\'' + " \n" +
                "discount=" + discount + " \n" +
                "milligram=" + milligram + " \n" +
                "price=" + price + " \n" +
                "amount=" + amount + " \n" +
                "pricePerMilligram=" + pricePerMilligram + " \n" +
                "allergens=" + allergens + " \n" +
                "groups: " + groups + " \n" +
                "addiction='" + addiction + '\'' +
                '}';
    }
    //CLASS METHOD 9 расспространяется на все классы
    public static int amountOfProduct() throws Exception {
        return extent.size();
    }
    public static Product getProductWithName(String name) throws Exception {
        for (int i = 0; i < extent.size(); i++) {
            if (name.equals(extent.get(i).name)) {
                return extent.get(i);
            }
        }
        return null;
    }
}

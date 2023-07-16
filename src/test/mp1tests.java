package test;
import mp1.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


class MyFirstJUnitJupiterTests {



    Product ProductTest1 = new Product(0L,"Ibuprofen Forte","Ibuprofen",250,100,2,10,"Lactose","Ingestant","nonsteroidal anti-inflammatory drug",0);

    MyFirstJUnitJupiterTests() throws Exception {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(Product.getFilename()));
        writer.write("");
        writer.flush();
    }

    @Test
    void Init() {

        try {
            assertNotEquals(ProductTest1, null);
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    void idTest() {

        try {
            assertEquals(Optional.of(0L).get(),ProductTest1.getId());
            ProductTest1.setId(1L);
            assertEquals(Optional.of(1L).get(),ProductTest1.getId());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void nameTest() {

        try {
            assertEquals("Ibuprofen Forte",ProductTest1.getName());
            ProductTest1.setName("Paracetamol");
            assertEquals("Paracetamol",ProductTest1.getName());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void activeSubstanceTest() {

        try {
            assertEquals("Ibuprofen",ProductTest1.getActive_substance());
            ProductTest1.setActive_substance("Paracetamol");
            assertEquals("Paracetamol",ProductTest1.getActive_substance());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void miligramTest() {

        try {
            assertEquals(250,ProductTest1.getMilligram());
            ProductTest1.setMilligram(310);
            assertEquals(310,ProductTest1.getMilligram());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void priceTest() {

        try {
            assertEquals(100,ProductTest1.getPrice());
            ProductTest1.setPrice(100);
            assertEquals(100,ProductTest1.getPrice());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void amountTest() {

        try {
            assertEquals(2,ProductTest1.getAmount());
            ProductTest1.setAmount(4);
            assertEquals(4,ProductTest1.getAmount());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void discountTest() {

        try {
            assertEquals(Optional.of(10).get(),ProductTest1.getDiscount());
            ProductTest1.setDiscount(10);
            assertEquals(Optional.of(10).get(),ProductTest1.getDiscount());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void pricePerMiligramTest() {

        try {
            assertEquals(Optional.of(10).get(),ProductTest1.getDiscount());
            assertEquals(4.5,ProductTest1.getPricePerMilligram(),0.001);

            ProductTest1.setDiscount(0);
            assertEquals(5,ProductTest1.getPricePerMilligram(),0.001);

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void allergensTest() {

        try {
            assertEquals("Lactose",ProductTest1.getAllergens().getName());
            assertEquals("Ingestant",ProductTest1.getAllergens().getAllergen_group().get(0));

            Allergens allergens = new Allergens("Casein", Collections.singletonList("Ingestant"));
            ProductTest1.setAllergens(allergens);

            assertEquals("Casein",ProductTest1.getAllergens().getName());
            assertEquals("Ingestant",ProductTest1.getAllergens().getAllergen_group().get(0));
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void productGroupTest() {

        try {
            assertEquals("nonsteroidal anti-inflammatory drug",ProductTest1.getGroups().get(0));
            ProductTest1.addGroups("Test123");
            assertEquals("Test123",ProductTest1.getGroups().get(1));
            ProductTest1.removeGroup("Test123");
            assertEquals(1,ProductTest1.getGroups().size());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void addictionTest() {

        try {
            assertEquals("No addiction",ProductTest1.getAddiction());
            ProductTest1.setAddiction(1);
            assertEquals("Physical addiction",ProductTest1.getAddiction());
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void extentTest() {

        try {

            List<Product> list = new ArrayList<>();

            Product product1 = new Product(0L,"APAP","Paracetamol",500,100,2,30,"N-acetyl-p-benzoquinone imine","Ingestant","nonsteroidal anti-inflammatory drug",0);

            Product.saveAllExtents();

            list.add(ProductTest1);
            list.add(product1);

            List<Product> compareList;
            Product.loadAllExtents();

            compareList = Product.getExtent();

            assertEquals(2,compareList.size());

            for (int i = 0; i < compareList.size(); i++) {
                assertEquals(list.get(i).toString(),compareList.get(i).toString());
            }
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void publicClassCommands() {

        try {
           assertEquals(1,Product.amountOfProduct());
           assertEquals(ProductTest1,Product.getProductWithName("Ibuprofen Forte"));
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
package com.Coffe.DB;

import com.Coffe.model.Coffee;
import com.Coffe.model.CoffeeType;
import com.Coffe.model.Packing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OperateVanTableTest {
    OperateVanTable operator = new OperateVanTable();
    @Test
    void addCoffeeTest() {
        operator.clearVanTable();

        int quantity = 3;
        Coffee coffee = new Coffee("Premium Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.0, 90);
        operator.addCoffee(coffee, quantity);
        assertEquals("1 Premium Arabica 10.5 3 Bag Grian 0.5 1.0 90 7.0\n", operator.getVanTable());

        operator.clearVanTable();
    }

    @Test
    void clearVanTableTest() {
        operator.clearVanTable();
        assertEquals("", operator.getVanTable());
    }

    @Test
    void getVanTableTest() {
        operator.clearVanTable();

        int quantity = 3;
        Coffee coffee = new Coffee("Premium Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.0, 90);
        operator.addCoffee(coffee, quantity);
        assertEquals(operator.getVanTable(), "1 Premium Arabica 10.5 3 Bag Grian 0.5 1.0 90 7.0\n");

        operator.clearVanTable();
    }

    @Test
    void sortByCoefTest() {
        operator.clearVanTable();

        int quantity = 3;
        Coffee coffee = new Coffee("Premium Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.0, 90);
        operator.addCoffee(coffee, quantity);
        coffee.setName("Luxury Arabica");
        coffee.setPrice(5);
        operator.addCoffee(coffee, quantity);
        assertEquals("2 Luxury Arabica 5.0 3 Bag Grian 0.5 1.0 90 3.3333333333333335\n" +
                "1 Premium Arabica 10.5 3 Bag Grian 0.5 1.0 90 7.0\n", operator.sortByCoef());

        operator.clearVanTable();
    }

    @Test
    void getCoffeeByQualityTest() {
        operator.clearVanTable();
        int maxQuality = 100;
        int minQuality = 0;
        operator.getCoffeeByQuality(0,1);
        int quantity = 3;
        Coffee coffee = new Coffee("Premium Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.0, 90);
        operator.addCoffee(coffee, quantity);
        coffee.setName("Luxury Arabica");
        coffee.setPrice(5);
        coffee.setQuality(150);
        operator.addCoffee(coffee, quantity);
        assertEquals("1 Premium Arabica 10.5 3 Bag Grian 0.5 1.0 90 7.0\n", operator.getCoffeeByQuality(minQuality,maxQuality));
        operator.clearVanTable();
    }

    @Test
    void getCurrentVolumeTest() {
        operator.clearVanTable();
        int quantity = 3;
        Coffee coffee = new Coffee("Premium Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.2, 90);
        Coffee coffee2 = new Coffee("Luxury Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.9, 90);

        operator.addCoffee(coffee, quantity);
        operator.addCoffee(coffee2, quantity+1);

        assertEquals(coffee.getPackVolume()*quantity + coffee2.getPackVolume()*(quantity+1), operator.getCurrentVolume());
        operator.clearVanTable();
    }

    @Test
    void getCurrentPriceTest() {
        operator.clearVanTable();
        int quantity = 3;
        Coffee coffee = new Coffee("Premium Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.2, 90);
        Coffee coffee2 = new Coffee("Luxury Arabica", 10.5, Packing.Bag, CoffeeType.Grian, 0.5, 1.9, 90);

        operator.addCoffee(coffee, quantity);
        operator.addCoffee(coffee2, quantity+1);//73.5
        assertEquals(coffee.getPrice()*quantity + coffee2.getPrice()*(quantity+1), operator.getCurrentPrice());
        operator.clearVanTable();
    }
}
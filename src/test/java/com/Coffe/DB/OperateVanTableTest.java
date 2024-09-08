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
    void getCoffeeByQualityTest()
    {
        operator.clearVanTable();
        operator.getCoffeeByQuality(0,1);



        operator.clearVanTable();
    }
}
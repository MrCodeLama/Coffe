package com.Coffe.DB;

import com.Coffe.model.Coffee;
import com.Coffe.model.CoffeeType;
import com.Coffe.model.Packing;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ConnectDBTest {
    @Test
    void insertion() {
        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                int quantity = 3;
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS van (id INTEGER PRIMARY KEY, name TEXT, price REAL, quantity INTEGER, packing TEXT, type TEXT, weight REAL, packVolume REAL, quality INTEGER)";
                statement.executeUpdate(createTable);
                Coffee coffee = new Coffee("Luca", 1, Packing.Bag, CoffeeType.Grian, 2.4, 0.5, 10);
                String insertion = "INSERT INTO van (name, price, quantity, packing, type, weight, packVolume, quality) VALUES "+ "(" +
                        "'" + coffee.getName() + "', " +
                        coffee.getPrice() + ", " +
                        quantity + ", " +
                        "'" + coffee.getPacking() + "', " +
                        "'" + coffee.getCoffeeType() + "', " +
                        coffee.getWeight() + ", " +
                        coffee.getPackVolume() + ", " +
                        coffee.getQuality() + ")";
                statement.executeUpdate(insertion);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed.");
        }
    }
}
package com.Coffe;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import com.Coffe.DB.ConnectDB;
import com.Coffe.model.Coffee;
import com.Coffe.model.CoffeeType;
import com.Coffe.model.Van;
//UpdateVanMaxWeight can add option to clear van
public class Main {

    public static void main(String[] args) {

    }

}
/*

ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS van (id INTEGER PRYMARY KEY, name TEXT, price REAL, weight REAL, quality REAL)";
                statement.executeUpdate(createTable);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        while (true)
        {
            System.out.println("0 - exit\n" +
                "1 - set max weight\n" +
                "2 - add coffee\n" +
                "3 - find coffee by quality\n" +
                "4 - sort coffee by price/weight\n" +
                "5 - clear van\n");

            int taskN = scanner.nextInt();
            switch (taskN) {
                case 0:
                    db.closeConnection();
                    System.exit(0);
                    break;
                case 1:
                    UpdateVanMaxWeight();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }

        }
    }

    private static void UpdateVanMaxWeight() {
        double newMaxWeight = scanner.nextDouble();
        if(newMaxWeight > van.getCurrentWeight()) {
            van.setMaxWeight(newMaxWeight);
        }
        else {
            System.out.println("Current weight: " + van.getCurrentWeight() +
                    " is bigger than new max Weight\nClear van and try again");
        }
    }
0 - exit
1 - set max weight
2 - add coffee
3 - find coffee by quality
4 - sort coffee by price/weight
5 - clear van
 */

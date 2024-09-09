package com.Coffe.DB;

import com.Coffe.model.Coffee;
import com.Coffe.model.CoffeeType;
import com.Coffe.model.Packing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OperateVanTable {

    //in table
    private void connectExecuteUpdate(String command) {
        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS van (id INTEGER PRIMARY KEY, name TEXT, price REAL, quantity INTEGER, packing TEXT, type TEXT, weight REAL, packVolume REAL, quality INTEGER, coef REAL)";

                statement.executeUpdate(createTable);

                statement.executeUpdate(command);

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed.");
        }
    }

    //from table
    private String connectExecuteQuery(String command) {
        String res = new String();

        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS van (id INTEGER PRIMARY KEY, name TEXT, price REAL, quantity INTEGER, packing TEXT, type TEXT, weight REAL, packVolume REAL, quality INTEGER, coef REAL)";
                statement.executeUpdate(createTable);
                ResultSet resultSet = statement.executeQuery(command);
                while (resultSet.next()) {
                    res += resultSet.getInt(1) +
                            " " + resultSet.getString(2) +
                            " " + resultSet.getDouble(3) +
                            " " + resultSet.getInt(4) +
                            " " + resultSet.getString(5) +
                            " " + resultSet.getString(6) +
                            " " + resultSet.getDouble(7) +
                            " " + resultSet.getDouble(8) +
                            " " + resultSet.getInt(9) +
                            " " + resultSet.getDouble(10) + "\n";
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed.");
        }
        return res;
    }

    public void addCoffee(Coffee coffee, int quantity) {
        double coef = coffee.getPrice()/(coffee.getWeight()*quantity);
        String insertion = "INSERT INTO van (name, price, quantity, packing, type, weight, packVolume, quality, coef) VALUES "+ "(" +
                "'" + coffee.getName() + "', " +
                coffee.getPrice() + ", " +
                quantity + ", " +
                "'" + coffee.getPacking() + "', " +
                "'" + coffee.getCoffeeType() + "', " +
                coffee.getWeight() + ", " +
                coffee.getPackVolume() + ", " +
                coffee.getQuality() + ", " +
                coef + ")";
        connectExecuteUpdate(insertion);
    }

    public void clearVanTable() {
        connectExecuteUpdate("DELETE FROM van");
    }

    public String getVanTable() {
        return connectExecuteQuery("SELECT * FROM van");
    }

    public String sortByCoef() {
        return connectExecuteQuery("SELECT * FROM van ORDER BY coef ASC");
    }

    public String getCoffeeByQuality(int minQuality, int maxQuality) {
        return connectExecuteQuery("SELECT * FROM van WHERE quality <= " + maxQuality +" AND quality >=" + minQuality + " ORDER BY quality ASC");
    }

    public double getCurrentVolume() {
        ConnectDB db = new ConnectDB();
        double volume = 0;
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS van (id INTEGER PRIMARY KEY, name TEXT, price REAL, quantity INTEGER, packing TEXT, type TEXT, weight REAL, packVolume REAL, quality INTEGER, coef REAL)";
                statement.executeUpdate(createTable);
                ResultSet resultSet = statement.executeQuery("SELECT packVolume, quantity FROM van");
                while (resultSet.next()) {
                    double tempVolume = resultSet.getDouble(1) * resultSet.getInt(2);
                    volume+=tempVolume;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed.");
        }
        return volume;
    }

    public double getCurrentPrice() {
        ConnectDB db = new ConnectDB();
        double price = 0;
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable = "CREATE TABLE IF NOT EXISTS van (id INTEGER PRIMARY KEY, name TEXT, price REAL, quantity INTEGER, packing TEXT, type TEXT, weight REAL, packVolume REAL, quality INTEGER, coef REAL)";
                statement.executeUpdate(createTable);
                ResultSet resultSet = statement.executeQuery("SELECT price, quantity FROM van");
                while (resultSet.next()) {
                    double tempVolume = resultSet.getDouble(1) * resultSet.getInt(2);
                    price+=tempVolume;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed.");
        }
        return price;
    }

    //"SELECT packVolume, price, quantity FROM van"
}

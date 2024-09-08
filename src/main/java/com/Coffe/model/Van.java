package com.Coffe.model;
import com.Coffe.DB.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Van {
    private double maxMoney;
    private double currentMoney;
    private double maxVolume;
    private double currentVolume;

    public Van() {
        this.maxMoney = 0;
        this.currentMoney = 0;
        this.maxVolume = 0;
        this.currentVolume = 0;
    }

    public Van(double maxMoney, double maxVolume) {
        this.maxMoney = maxMoney;
        this.currentMoney = 0;
        this.maxVolume = maxVolume;
        this.currentVolume = 0;
    }

    public double getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(double maxMoney) {
        this.maxMoney = maxMoney;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getCurrentVolume() {
        updateCurrents();
        return currentVolume;
    }

    public double getCurrentMoney() {
        updateCurrents();
        return currentMoney;
    }

    public void updateCurrents() {
        currentMoney = 0;
        currentVolume = 0;
        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Van");

                while (resultSet.next()) {
                    currentMoney += resultSet.getDouble(2)*resultSet.getInt(3);
                    currentVolume += resultSet.getInt(3)*resultSet.getInt(7);
                    if(currentMoney > maxMoney || currentVolume > maxVolume) {
                        System.out.println("Pack limit reached!");
                        break;
                    }
                }
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed");
        }
    }

    public void loadCoffee(Coffee coffee, int quantity) {
        updateCurrents();
        if(coffee.getPackVolume()*quantity > maxVolume) {
            System.out.println("Pack limit reached!");
        } else {
            ConnectDB db = new ConnectDB();
            Connection connection = db.getConnection();
            if (connection != null) {
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("INSERT INTO Van (name, price, quantity, packing, type, weight, packVolume, quality) VALUES" +
                            "'" + coffee.getName() + "', " +
                            "'" + coffee.getPrice() + "', " +
                            quantity + ", " +
                            "'" + coffee.getPacking() + "', " +
                            "'" + coffee.getCoffeeType() + "', " +
                            "'" + coffee.getWeight() + "', " +
                            "'" + coffee.getPackVolume() + "', " +
                            coffee.getQuality()+
                            ")");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    db.closeConnection();
                }
            } else {
                System.out.println("Connection failed");
            }
        }
    }

}


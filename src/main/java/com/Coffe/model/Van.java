package com.Coffe.model;
import com.Coffe.DB.ConnectDB;
import com.Coffe.DB.OperateVanTable;

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
    public OperateVanTable operateVanTable = new OperateVanTable();

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

    public void addCoffee(Coffee coffee, int quantity) {
        if(coffee.getPrice() * quantity + currentMoney >= maxMoney || coffee.getPackVolume() * quantity + currentVolume >= maxVolume) {
            System.out.println("Reached limit!");
        } else {
            operateVanTable.addCoffee(coffee, quantity);
        }
    }

    public void clearVan() {
        operateVanTable.clearVanTable();
    }

    public String getVanStorage() {
        return operateVanTable.getVanTable();
    }

    public void printVanStorage() {
        String storage = getVanStorage();
        System.out.println("|-id-|-name-|-price-|-quantity-|-packing-|-type-|-weight-|-packVolume-|-quality-|-price/weight-|");
        System.out.println(storage);
    }

    public String getSortedByCoef() {
        return operateVanTable.sortByCoef();
    }

    public void printSortedByCoef() {
        String sortedStorage = getSortedByCoef();
        System.out.println("|-id-|-name-|-price-|-quantity-|-packing-|-type-|-weight-|-packVolume-|-quality-|-price/weight-|");
        System.out.println(sortedStorage);
    }

    public String getCoffeByQualityRange(int minQuality, int maxQuality) {
        return operateVanTable.getCoffeeByQuality(minQuality, maxQuality);
    }

    public void printCoffeByQualityRange(int minQuality, int maxQuality) {
        String coffeeByQualityRange = getCoffeByQualityRange(minQuality, maxQuality);
        System.out.println("|-id-|-name-|-price-|-quantity-|-packing-|-type-|-weight-|-packVolume-|-quality-|-price/weight-|");
        System.out.println(coffeeByQualityRange);
    }

    //Setters and getters

    public double getCurrentMoney() {
        updateValues();
        return currentMoney;
    }

    public double getCurrentVolume() {
        updateValues();
        return currentVolume;
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

    public void updateValues() {
        double curMoneyFromTable = operateVanTable.getCurrentPrice();
        double curVolumeFromTable = operateVanTable.getCurrentVolume();
        if(curMoneyFromTable > maxMoney || curVolumeFromTable > maxVolume) {
            System.out.println("Reached limit!");
        } else {
            currentMoney = curMoneyFromTable;
            currentVolume = curVolumeFromTable;
        }
    }

}


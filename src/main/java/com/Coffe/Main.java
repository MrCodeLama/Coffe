package com.Coffe;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import com.Coffe.DB.ConnectDB;
import com.Coffe.model.Coffee;
import com.Coffe.model.CoffeeType;
import com.Coffe.model.Packing;
import com.Coffe.model.Van;
//UpdateVanMaxWeight can add option to clear van
//
public class Main {
    public static void main(String[] args) {
        Van van = new Van();
        Scanner scanner = new Scanner(System.in);
        System.out.println("CoffeeVan");
        int action = 1;
        Coffee tempCoffee = new Coffee();
        while (action!=0)
        {
            System.out.println("1 - set max volume\n" +
                    "2 - set max price\n" +
                    "3 - add coffee\n" +
                    "4 - find coffee by quality range\n" +
                    "5 - sort coffee by price/weight\n" +
                    "6 - clear van\n" +
                    "7 - print van storage\n" +
                    "0 - exit");
            System.out.print("Enter action: ");

            action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Enter new max volume: ");
                    double newMaxVolume = scanner.nextDouble();
                    van.setMaxVolume(newMaxVolume);
                    System.out.println("Max volume set to " + newMaxVolume);
                    break;
                case 2:
                    System.out.print("Enter new max price: ");
                    double newMaxPrice = scanner.nextDouble();
                    van.setMaxMoney(newMaxPrice);
                    System.out.println("Max price set to " + newMaxPrice);
                    break;
                case 3:
                    System.out.println("Enter parameters of coffee:");
                    System.out.print("\tname: ");
                    tempCoffee.setName(scanner.next());
                    System.out.print("\tprice: ");
                    tempCoffee.setPrice(scanner.nextDouble());
                    System.out.print("\tpacking(Jar, Bag, Pouch: ");
                    tempCoffee.setCoffeeType(CoffeeType.valueOf(scanner.next()));
                    System.out.print("\t coffee type(Grian, Ground, Instant): ");
                    tempCoffee.setCoffeeType(CoffeeType.valueOf(scanner.next()));
                    System.out.print("\t weight: ");
                    tempCoffee.setWeight(scanner.nextDouble());
                    System.out.print("\t pack volume: ");
                    tempCoffee.setPackVolume(scanner.nextDouble());
                    System.out.print("\tquality: ");
                    tempCoffee.setQuality(scanner.nextInt());
                    System.out.print("Enter number of packages: ");
                    int quantity = scanner.nextInt();
                    van.addCoffee(tempCoffee, quantity);
                    System.out.println("Added coffee " + tempCoffee);
                    break;
                case 4:
                    System.out.print("Enter min and max quality: ");
                    int minQuality = scanner.nextInt();
                    int maxQuality = scanner.nextInt();
                    van.getCoffeByQualityRange(minQuality, maxQuality);
                    break;
                case 5:
                    van.printSortedByCoef();
                    break;
                case 6:
                    van.clearVan();
                    System.out.println("Van cleared");
                    break;
                case 7:
                    van.printVanStorage();
                    break;
            }
        }
    }
}
/*
("1 - set max volume\n" +
                    "2 - set max price\n" +
                    "3 - add coffee\n" +
                    "4 - find coffee by quality range\n" +
                    "5 - sort coffee by price/weight\n" +
                    "6 - clear van\n" +
                    "0 - exit");
 */

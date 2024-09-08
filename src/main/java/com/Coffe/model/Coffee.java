package com.Coffe.model;

public class Coffee {
    private String name;
    private double price;
    private Packing packing;
    private CoffeeType coffeeType;
    private double weight;
    private double packVolume;
    private int quality;

    public Coffee() {}

    public Coffee(String name, double price, Packing packing, CoffeeType coffeeType, double weight, double packVolume, int quality) {
        this.name = name;
        this.price = price;
        this.packing = packing;
        this.coffeeType = coffeeType;
        this.weight = weight;
        this.packVolume = packVolume;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", packing=" + packing.toString() +
                ", coffeeType=" + coffeeType.toString() +
                ", weight=" + weight +
                ", packVolume=" + packVolume +
                ", quality=" + quality +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPacking() {
        return packing.toString();
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    public String getCoffeeType() {
        return coffeeType.toString();
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPackVolume() {
        return packVolume;
    }

    public void setPackVolume(double packVolume) {
        this.packVolume = packVolume;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}


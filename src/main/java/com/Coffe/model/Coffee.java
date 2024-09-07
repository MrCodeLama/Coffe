package com.Coffe.model;

public abstract class Coffee {
    private String name;
    private double price;
    private double weight;
    private double quality;

    public Coffee() {}

    public Coffee(String name, double price, double weight, double quality) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quality = quality;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quality=" + quality +
                '}';
    }
}


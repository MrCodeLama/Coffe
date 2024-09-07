package com.Coffe.model;
import java.util.List;

public class Van {
    private double maxWeight;
    private double currentWeight;
    private List<Coffee> coffeeList;

    public Van() {
    }

    public Van(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void loadCoffee(Coffee coffee)
    {
        if(currentWeight + coffee.getWeight() <= maxWeight)
        {
            coffeeList.add(coffee);
            currentWeight += coffee.getWeight();
        }
        else
        {
            System.out.println("Not enough space" + coffee.getName());
        }
    }

    public double getCurrentWeight() {
        return currentWeight;
    }
}


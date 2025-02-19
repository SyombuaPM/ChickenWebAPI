package com.chickensystem.mis.datamodel;

public class FeedComponent 
{
    private String name;
    private double proportion; // proportion in percentage

    // Constructor
    public FeedComponent(String name, double proportion) {
        this.name = name;
        this.proportion = proportion;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }
    
    // method to display feed component details

    public void displayComponent(double totalFeed) {
        double requiredAmount = (proportion / 100) * totalFeed;
        System.out.println(name + ": " + requiredAmount + " grams");
    }


}

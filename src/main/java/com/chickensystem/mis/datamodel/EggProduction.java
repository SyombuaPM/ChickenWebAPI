package com.chickensystem.mis.datamodel;

import java.time.LocalDate;

public class EggProduction {
     private LocalDate date;
    private int totalEggsCollected;
    private int eggsTakenToIncubation;
    private int eggsSold;

    // Constructor
    public EggProduction(LocalDate date, int totalEggsCollected, int eggsTakenToIncubation, int eggsSold) {
        this.date = date;
        this.totalEggsCollected = totalEggsCollected;
        this.eggsTakenToIncubation = eggsTakenToIncubation;
        this.eggsSold = eggsSold;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalEggsCollected() {
        return totalEggsCollected;
    }
    public void setTotalEggsCollected(int totalEggsCollected) {
        this.totalEggsCollected = totalEggsCollected;
    }

    public int getEggsTakenToIncubation() {
        return eggsTakenToIncubation;
    }

    public void setEggsTakenToIncubation(int eggsTakenToIncubation) {
        this.eggsTakenToIncubation = eggsTakenToIncubation;
    }

    public int getEggsSold() {
        return eggsSold;
    }

    public void setEggsSold(int eggsSold) {
        this.eggsSold = eggsSold;
    }
    // Method to display egg production details
    public void displayEggProduction() {
        System.out.println("Date: " + date);
        System.out.println("Total Eggs Collected: " + totalEggsCollected);
        System.out.println("Eggs Taken to Incubation: " + eggsTakenToIncubation);
        System.out.println("Eggs Sold: " + eggsSold);
    }



}

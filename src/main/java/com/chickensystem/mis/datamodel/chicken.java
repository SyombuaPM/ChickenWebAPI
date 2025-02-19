package com.chickensystem.mis.datamodel;

import java.time.LocalDate;

import utils.validationUtils;

public class chicken {
    private String id;
    private String healthStatus;
    private LocalDate dateIntroducedToLayingFlock;
    private LocalDate dateSold;
    private double weight;
    private final AgeGroup ageGroup = AgeGroup.HENS_AND_ROOSTERS;


    //constructor
    public chicken(String id, String healthStatus, LocalDate dateIntroducedToLayingFlock, LocalDate dateSold, double weight) {
        validationUtils.validateId(id);
        validationUtils.validateHealthStatus(healthStatus);
        validationUtils.validateDateIntroducedToLayingFlock(dateIntroducedToLayingFlock);
        this.id = id;
        this.healthStatus = healthStatus;
        this.dateIntroducedToLayingFlock = dateIntroducedToLayingFlock;
        this.dateSold = dateSold;
        this.weight = weight;
    }
    //getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getHealthStatus() {
        return healthStatus;
    }
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
    public LocalDate getDateIntroducedToLayingFlock() {
        return dateIntroducedToLayingFlock;
    }
    public void setDateIntroducedToLayingFlock(LocalDate dateIntroducedToLayingFlock) {
        this.dateIntroducedToLayingFlock = dateIntroducedToLayingFlock;
    }
    public LocalDate getDateSold() {
        return dateSold;
    }
    public void setDateSold(LocalDate dateSold) {
        this.dateSold = dateSold;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public AgeGroup getAgeGroup() {
        return ageGroup;
    }
    //method to display chicken details
    public void displayChickenDetails() {
        System.out.println("Chicken ID: " + id);
        System.out.println("Health Status: " + healthStatus);
        System.out.println("Date Introduced to Laying Flock: " + dateIntroducedToLayingFlock);
        if (dateSold != null) {
            System.out.println("Date Sold: " + dateSold);
        }
        System.out.println("Weight: " + weight);
        System.out.println("Age Group: " + ageGroup);
    }


}

package com.chickensystem.mis.datamodel;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
//import jakarta.validation.constraints.NotNull;

public class layerChicken 
{
    private String id;
    private int eggsGivenForBreeding;
    private int eggsHatchedByChicken;
    private int eggsDestroyed;
    private int eggsHatchedByIncubator;
    private LocalDate incubationStartDate;
    private LocalDate hatchDate;
    //@NotNull
    @Enumerated(EnumType.STRING)
    private IncubationMethod incubationMethod;

    //constructor
    public layerChicken(String id,int eggsGivenForBreeding, int eggsHatchedByChicken, int eggsSold, int eggsDestroyed, int eggsHatchedByIncubator, LocalDate incubationStartDate, LocalDate hatchDate) {
        this.id = id;
        this.eggsGivenForBreeding = eggsGivenForBreeding;
        this.eggsHatchedByChicken = eggsHatchedByChicken;
        this.eggsDestroyed = eggsDestroyed;
        this.eggsHatchedByIncubator = eggsHatchedByIncubator;
        this.incubationStartDate = incubationStartDate;
        this.hatchDate = hatchDate;
    }

    //getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getEggsGivenForBreeding() {
        return eggsGivenForBreeding;
    }
    public void setEggsGivenForBreeding(int eggsGivenForBreeding) {
        this.eggsGivenForBreeding = eggsGivenForBreeding;
    }
    public int getEggsHatchedByChicken() {
        return eggsHatchedByChicken;
    }
    public void setEggsHatchedByChicken(int eggsHatchedByChicken) {
        this.eggsHatchedByChicken = eggsHatchedByChicken;
    }

    public int getEggsDestroyed() {
        return eggsDestroyed;
    }
    public void setEggsDestroyed(int eggsDestroyed) {
        this.eggsDestroyed = eggsDestroyed;
    }
    public int getEggsHatchedByIncubator() {
        return eggsHatchedByIncubator;
    }
    public void setEggsHatchedByIncubator(int eggsHatchedByIncubator) {
        this.eggsHatchedByIncubator = eggsHatchedByIncubator;
    }
    public LocalDate getIncubationStartDate() {
        return incubationStartDate;
    }
    public void setIncubationStartDate(LocalDate incubationStartDate) {
        this.incubationStartDate = incubationStartDate;
    }
    public LocalDate getHatchDate() {
        return hatchDate;
    }
    public void setHatchDate(LocalDate hatchDate) {
        this.hatchDate = hatchDate;
    }
    public IncubationMethod getIncubationMethod() {
        return incubationMethod;
    }
    public void setIncubationMethod(IncubationMethod incubationMethod) {
        this.incubationMethod = incubationMethod;
    }

    //method to display layer chicken details
    public void displayLayerChickenDetails() {
        System.out.println("Eggs Given for Breeding: " + eggsGivenForBreeding);
        System.out.println("Eggs Hatched by Chicken: " + eggsHatchedByChicken);
        System.out.println("Eggs Destroyed: " + eggsDestroyed);
        System.out.println("Eggs Hatched by Incubator: " + eggsHatchedByIncubator);
        System.out.println("Incubation Start Date: " + incubationStartDate);
        System.out.println("Hatch Date: " + hatchDate);
        System.out.println("Incubation Method: " + incubationMethod);
    }



}

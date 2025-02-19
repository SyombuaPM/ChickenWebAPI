package com.chickensystem.mis.datamodel;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import utils.validationUtils;
@JsonPropertyOrder({"groupId", "hatchDate", "numberOfChicks", "mortalityRate", "numberOfChicksSold", "age", "ageGroup"})
public class ChickGroup {

    private String groupId;
    private LocalDate hatchDate;
    private int numberOfChicks;
    //private String broodingMethod;
    private int mortalityRate;
    private int numberOfChicksSold;
    @JsonIgnore
    private Period age;
    private String ageGroup;

    public ChickGroup(String groupId,LocalDate hatchDate, int numberOfChicks, String broodingMethod, int mortalityRate, int numberOfChicksSold) {
        validationUtils.validateHatchDate(hatchDate);
        validationUtils.validateNumberOfChicks(numberOfChicks);
        //validationUtils.validateBroodingMethod(broodingMethod);
        validationUtils.validateMortalityRate(mortalityRate);
        validationUtils.validateNumberOfChicksSold(numberOfChicksSold);
        validationUtils.validateGroupID(groupId);

        this.groupId = groupId;
        this.hatchDate = hatchDate;
        this.numberOfChicks = numberOfChicks;
        // this.broodingMethod = broodingMethod;
        this.mortalityRate = mortalityRate;
        this.numberOfChicksSold = numberOfChicksSold;
        this.age = calculateAge(hatchDate);
        this.ageGroup = determineAgeGroup(this.age);
    }

    private Period calculateAge(LocalDate hatchDate) {
        return Period.between(hatchDate, LocalDate.now());
    }
    //method to determine age group

    private String determineAgeGroup(Period age) {
        int totalMonths = age.getYears() * 12 + age.getMonths();
        if (totalMonths < 1 || (totalMonths == 1 && age.getDays() == 0)) {
            return AgeGroup.ZERO_TO_ONE_MONTH.name();
        } else if (totalMonths < 4 || (totalMonths == 4 && age.getDays() == 0)) {
            return AgeGroup.TWO_TO_FOUR_MONTHS.name();
        } else if (totalMonths < 7 || (totalMonths == 7 && age.getDays() == 0)) {
            return AgeGroup.FIVE_TO_SEVEN_MONTHS.name();
        } else {
            return AgeGroup.HENS_AND_ROOSTERS.name();
        }
    }
     // Method to format the Period object into a human-readable string

     @JsonProperty("age")
     public String getFormattedAge() {
        StringBuilder formattedAge = new StringBuilder();
        if (age.getYears() > 0) {
            formattedAge.append(age.getYears()).append(" years ");
        }
        if (age.getMonths() > 0) {
            formattedAge.append(age.getMonths()).append(" months ");
        }
        if (age.getDays() > 0) {
            formattedAge.append(age.getDays()).append(" days");
        }
        return formattedAge.toString().trim();
    }

    //getters and setters
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public LocalDate getHatchDate() {
        return hatchDate;
    }

    public void setHatchDate(LocalDate hatchDate) {
        this.hatchDate = hatchDate;
        this.age = calculateAge(hatchDate);
        this.ageGroup = determineAgeGroup(this.age);
    }

    public int getNumberOfChicks() {
        return numberOfChicks;
    }

    public void setNumberOfChicks(int numberOfChicks) {
        this.numberOfChicks = numberOfChicks;
    }

    public int getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(int mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    public int getNumberOfChicksSold() {
        return numberOfChicksSold;
    }

    public void setNumberOfChicksSold(int numberOfChicksSold) {
        this.numberOfChicksSold = numberOfChicksSold;
    }

    public Period getAge() {
        return age;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    //method to display chick group details
    public void displayChickGroupDetails() {
        System.out.println("Group ID: " + groupId);
        System.out.println("Hatch Date: " + hatchDate);
        System.out.println("Number of Chicks: " + numberOfChicks);
        System.out.println("Mortality Rate: " + mortalityRate);
        System.out.println("Number of Chicks Sold: " + numberOfChicksSold);
        System.out.println("Age Group: " + ageGroup);
        System.out.println("Age: " + age.getMonths() + " months, " + age.getDays() + " days");
    }

}

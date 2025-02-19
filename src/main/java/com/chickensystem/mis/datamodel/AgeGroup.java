package com.chickensystem.mis.datamodel;

public enum AgeGroup 
{
    ZERO_TO_ONE_MONTH(60),
    TWO_TO_FOUR_MONTHS(75),
    FIVE_TO_SEVEN_MONTHS(100),
    HENS_AND_ROOSTERS(120);

    private final int feedRate;

    AgeGroup(int feedRate) {
        this.feedRate = feedRate;
    }

    public int getFeedRate() {
        return feedRate;
    }

}

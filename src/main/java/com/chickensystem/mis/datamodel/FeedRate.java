package com.chickensystem.mis.datamodel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeedRate 
{
    private Map<AgeGroup, Integer> feedRates;
    private List<FeedComponent> locallyAvailableFeedComponents;


    public FeedRate() {
        feedRates = Map.of(
            AgeGroup.ZERO_TO_ONE_MONTH, 60,
            AgeGroup.TWO_TO_FOUR_MONTHS, 75,
            AgeGroup.FIVE_TO_SEVEN_MONTHS, 100,
            AgeGroup.HENS_AND_ROOSTERS, 120
        );
        // initialize locally available feed components with standard propotions
        locallyAvailableFeedComponents = List.of(
            new FeedComponent("Maize", 50),
            new FeedComponent("Cowpeas", 20),
            new FeedComponent("Sorghum", 10),
            new FeedComponent("Azolla", 10),
            new FeedComponent("Banana Stem", 5),
            new FeedComponent("Mango leaves", 5)
        );
    }
    public int getFeedRate(AgeGroup ageGroup) {
        return feedRates.get(ageGroup);
    }
    public double calculateFeed(int numberOfChickens, AgeGroup ageGroup) {
        return numberOfChickens * feedRates.get(ageGroup);
    }
    public FeedType getFeedType(AgeGroup ageGroup,int day) {
        return switch (ageGroup) {
            case ZERO_TO_ONE_MONTH -> FeedType.COMMERCIAL;
            case TWO_TO_FOUR_MONTHS, FIVE_TO_SEVEN_MONTHS -> FeedType.LOCALLY_AVAILABLE;
            // Two days of the week we feed with locally available feed, the third day we feed with commercial feed
            case HENS_AND_ROOSTERS -> (day % 3 == 0) ? FeedType.COMMERCIAL : FeedType.LOCALLY_AVAILABLE;
            default -> throw new IllegalArgumentException("Unknown age group: " + ageGroup);
        };
    }
    public Map<String, Double> calculateLocallyAvailableFeedComponents(double requiredFeed) {
        return locallyAvailableFeedComponents.stream()
                .collect(Collectors.toMap(
                        FeedComponent::getName,
                        component -> component.getProportion() * requiredFeed / 100
                ));
    }


    public String displayRequiredFeed(int numberOfChickens, AgeGroup ageGroup, int day) {
        FeedType feedType = getFeedType(ageGroup, day);
        double requiredFeed = calculateFeed(numberOfChickens, ageGroup);
        StringBuilder result = new StringBuilder();
        result.append("Day ").append(day).append(": Required feed for ").append(numberOfChickens).append(" chickens in age group ").append(ageGroup).append(": ").append(requiredFeed).append(" grams");

        if (feedType == FeedType.LOCALLY_AVAILABLE) {
            result.append("\nLocally Available Feed Components:");
            for (FeedComponent component : locallyAvailableFeedComponents) {
                result.append("\n").append(component.getName()).append(": ").append(component.getProportion() * requiredFeed / 100).append(" grams");
            }
        } else {
            result.append("\nCommercial feed: ").append(requiredFeed).append(" grams");
        }
        return result.toString();
    }
    public String displayFeedingSchedule(int numberOfChickens, AgeGroup ageGroup, int days) {
        StringBuilder schedule = new StringBuilder();
        for (int day = 1; day <= days; day++) {
            schedule.append("Day ").append(day).append(": ");
            schedule.append(displayRequiredFeed(numberOfChickens, ageGroup, day));
            schedule.append("\n");
        }
        return schedule.toString();
    }

}

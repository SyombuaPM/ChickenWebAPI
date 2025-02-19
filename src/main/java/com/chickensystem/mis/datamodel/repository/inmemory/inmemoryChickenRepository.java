package com.chickensystem.mis.datamodel.repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.chickensystem.mis.datamodel.FeedRate;
import com.chickensystem.mis.datamodel.FeedType;
import com.chickensystem.mis.datamodel.chicken;
import com.chickensystem.mis.datamodel.repository.ChickenRepository; // Add this import statement
@Repository
public class inmemoryChickenRepository implements ChickenRepository {
    private final List<chicken> chickens = new ArrayList<>();
    private final FeedRate feedRate = new FeedRate(); // Assuming FeedRate is a class you have

    @Override
    public void addChicken(chicken _chicken) {
        chickens.add(_chicken);
    }

    @Override
    public void removeChicken(chicken _chicken) {
        chickens.remove(_chicken);
    }

    @Override
    public chicken getChicken(String id) {
        for (chicken _chicken : chickens) {
            if (_chicken.getId().equals(id)) {
                return _chicken;
            }
        }
        return null;
    }

    @Override
    public void updateChicken(chicken _chicken) {
        for (int i = 0; i < chickens.size(); i++) {
            if (chickens.get(i).getId().equals(_chicken.getId())) {
                chickens.set(i, _chicken);
                return;
            }
        }
    }

    @Override
    public List<chicken> getAllChickens() {
         return chickens.stream()
                .filter(layerChicken -> layerChicken.getDateSold() == null)
                .collect(Collectors.toList());
    }
    public String displayRequiredFeed(String id, int day) {
        chicken chicken = getChicken(id);
        if (chicken != null) {
            return feedRate.displayRequiredFeed(1, chicken.getAgeGroup(), day);
        }
        return "Chicken not found";
    }

   public String displayFeedingSchedule(String id, int days) {
        chicken chicken = getChicken(id);
        if (chicken != null) {
            return feedRate.displayFeedingSchedule(1, chicken.getAgeGroup(), days);
        }
        return "Chicken not found";
    }
    public String displayTotalRequiredFeed(int day) {
        double totalCommercialFeed = 0;
        Map<String, Double> totalLocallyAvailableFeed = new HashMap<>();

        for (chicken chicken : chickens) {
            double requiredFeed = feedRate.calculateFeed(1, chicken.getAgeGroup());
            FeedType feedType = feedRate.getFeedType(chicken.getAgeGroup(), day);

            if (feedType == FeedType.COMMERCIAL) {
                totalCommercialFeed += requiredFeed;
            } else {
                Map<String, Double> feedComponents = feedRate.calculateLocallyAvailableFeedComponents(requiredFeed);
                for (Map.Entry<String, Double> entry : feedComponents.entrySet()) {
                    totalLocallyAvailableFeed.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("Total required feed for all chickens on day ").append(day).append(":\n");

        if (totalCommercialFeed > 0) {
            result.append("Commercial feed: ").append(totalCommercialFeed).append(" grams\n");
        }

        if (!totalLocallyAvailableFeed.isEmpty()) {
            result.append("Locally Available Feed Components:\n");
            for (Map.Entry<String, Double> entry : totalLocallyAvailableFeed.entrySet()) {
                result.append(entry.getKey()).append(": ").append(entry.getValue()).append(" grams\n");
            }
        }

        return result.toString();
    }


}

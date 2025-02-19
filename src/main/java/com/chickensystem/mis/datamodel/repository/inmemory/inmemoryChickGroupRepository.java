package com.chickensystem.mis.datamodel.repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chickensystem.mis.datamodel.AgeGroup;
import com.chickensystem.mis.datamodel.ChickGroup;
import com.chickensystem.mis.datamodel.FeedRate;
import com.chickensystem.mis.datamodel.FeedType;
import com.chickensystem.mis.datamodel.repository.ChickGroupRepository;

@Repository
public class inmemoryChickGroupRepository implements ChickGroupRepository {
    private final List<ChickGroup> chickGroups = new ArrayList<>();
    private final FeedRate feedRate = new FeedRate();

    // Removed duplicate getAllChickGroups method

    @Override
    public ChickGroup getChickGroup(String groupId) {
        return chickGroups.stream()
                .filter(chickGroup -> groupId.equals(chickGroup.getGroupId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addChickGroup(ChickGroup chickGroup) {
        chickGroups.add(chickGroup);
    }

    @Override
    public void updateChickGroup(ChickGroup chickGroup) {
        for (int i = 0; i < chickGroups.size(); i++) {
            if (chickGroups.get(i).getGroupId().equals(chickGroup.getGroupId())) {
                chickGroups.set(i, chickGroup);
                return;
            }
        }
    }

    @Override
    public void removeChickGroup(ChickGroup chickGroup) {
        chickGroups.removeIf(existingChickGroup -> existingChickGroup.getGroupId().equals(chickGroup.getGroupId()));
    }
     @Override
    public List<ChickGroup> getAllChickGroups() {
        return new ArrayList<>(chickGroups);
    }

    public String displayTotalRequiredFeed(String groupId, int day) {
        ChickGroup chickGroup = getChickGroup(groupId);
        if (chickGroup == null) {
            return "Chick group not found";
        }

        double totalCommercialFeed = 0;
        Map<String, Double> totalLocallyAvailableFeed = new HashMap<>();

        AgeGroup ageGroup = AgeGroup.valueOf(chickGroup.getAgeGroup().toUpperCase());
        double requiredFeed = feedRate.calculateFeed(chickGroup.getNumberOfChicks(), ageGroup);
        FeedType feedType = feedRate.getFeedType(ageGroup, day);

        if (feedType == FeedType.COMMERCIAL) {
            totalCommercialFeed += requiredFeed;
        } else {
            Map<String, Double> feedComponents = feedRate.calculateLocallyAvailableFeedComponents(requiredFeed);
            for (Map.Entry<String, Double> entry : feedComponents.entrySet()) {
                totalLocallyAvailableFeed.merge(entry.getKey(), entry.getValue(), Double::sum);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("Total required feed for chick group ").append(groupId).append(" on day ").append(day).append(":\n");

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

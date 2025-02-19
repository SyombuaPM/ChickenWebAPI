package com.chickensystem.mis.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<chicken> chickens;
    private List<layerChicken> layerChickens;
    private List<ChickGroup> chickGroups;
    private final List<EggProduction> eggProductions;
    private FeedRate feedRate;

    public Farm() {
        this.chickens = new ArrayList<>();
        this.layerChickens = new ArrayList<>();
        this.chickGroups = new ArrayList<>();
        this.eggProductions = new ArrayList<>();
        this.feedRate = new FeedRate();
    }

    //Methods to manage chickens
    public void addChicken(chicken chicken) {
        chickens.add(chicken);
    }
    public List<chicken> getChickens() {
        return chickens;
    }
    public void removeChicken(chicken chicken) {
        chickens.remove(chicken);
    }
    //Methods to manage layer chickens
    public void addLayerChicken(layerChicken layerChicken) {
        layerChickens.add(layerChicken);
    }
    public List<layerChicken> getLayerChickens() {
        return layerChickens;
    }
    public void removeLayerChicken(layerChicken layerChicken) {
        layerChickens.remove(layerChicken);
    }
    //Methods to manage chick groups
    public void addChickGroup(ChickGroup chickGroup) {
        chickGroups.add(chickGroup);
    }
    public List<ChickGroup> getChickGroups() {
        return chickGroups;
    }
    public void removeChickGroup(ChickGroup chickGroup) {
        chickGroups.remove(chickGroup);
    }
    //Methods to manage egg productions
    public void addEggProduction(EggProduction eggProduction) {
        eggProductions.add(eggProduction);
    }
    public List<EggProduction> getEggProductions() {
        return eggProductions;
    }
    public void removeEggProduction(EggProduction eggProduction) {
        eggProductions.remove(eggProduction);
    }
   
    // Methods to display all farm details
    public void displayFarmDetails() {
        System.out.println("Farm Details");
        System.out.println("Chickens: ");
        for (chicken chicken : chickens) {
            chicken.displayChickenDetails();
        }
        System.out.println("Layer Chickens: ");
        for (layerChicken layerChicken : layerChickens) {
            layerChicken.displayLayerChickenDetails();
        }
        System.out.println("Chick Groups: ");
        for (ChickGroup chickGroup : chickGroups) {
            chickGroup.displayChickGroupDetails();
        }
        System.out.println("Egg Productions: ");
        for (EggProduction eggProduction : eggProductions) {
            eggProduction.displayEggProduction();
        }
        System.out.println("Feed Rate: ");
        }
    
        // Method to display feed rate details based on age groups in chick groups
        public void displayFeedRateDetails(int days) {
            for (ChickGroup chickGroup : chickGroups) {
                AgeGroup ageGroup = AgeGroup.valueOf(chickGroup.getAgeGroup());
                System.out.println("Feed Rate Details for Chick Group ID: " + chickGroup.getGroupId());
                for (int day = 1; day <= days; day++) {
                    FeedType feedType = feedRate.getFeedType(ageGroup, day);
                    System.out.println("Day " + day + ": Feed Type for " + ageGroup + " is " + feedType);
                }
                System.out.println();
            }
        }

}

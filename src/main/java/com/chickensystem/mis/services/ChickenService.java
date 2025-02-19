package com.chickensystem.mis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickensystem.mis.datamodel.chicken;
import com.chickensystem.mis.datamodel.repository.ChickenRepository;
import com.chickensystem.mis.datamodel.repository.inmemory.inmemoryChickenRepository;

@Service
public class ChickenService {

    private final ChickenRepository chickenRepository;

    @Autowired
    public ChickenService(ChickenRepository chickenRepository) {
        this.chickenRepository = chickenRepository;
    }

    public void addChicken(chicken chicken) {
        chickenRepository.addChicken(chicken);
    }

    public List<chicken> getChickens() {
        return chickenRepository.getAllChickens();
    }

    public void removeChicken(chicken chicken) {
        chickenRepository.removeChicken(chicken);
    }

    public chicken getChickenById(String id) {
        for (chicken chicken : chickenRepository.getAllChickens()) {
            if (chicken.getId().equals(id)) {
                return chicken;
            }
        }
        return null;
    }

    public void updateChicken(chicken chicken) {
        chickenRepository.updateChicken(chicken);
    }
    @Autowired
    private inmemoryChickenRepository inmemoryChickenRepository;
    
    public String displayRequiredFeed(String id, int day) {
        return inmemoryChickenRepository.displayRequiredFeed(id, day);
    }

    public String displayFeedingSchedule(String id, int days) {
        return inmemoryChickenRepository.displayFeedingSchedule(id, days);
    }
    public String displayTotalRequiredFeed(int day) {
        return inmemoryChickenRepository.displayTotalRequiredFeed(day);
    }


}

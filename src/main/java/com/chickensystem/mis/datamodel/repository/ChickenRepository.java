package com.chickensystem.mis.datamodel.repository;

import java.util.List;

import com.chickensystem.mis.datamodel.chicken;

public interface ChickenRepository {
    void addChicken(chicken _chicken);
    void removeChicken(chicken _chicken);
    chicken getChicken(String id);
    void updateChicken(chicken chicken);
    List<chicken> getAllChickens();

}

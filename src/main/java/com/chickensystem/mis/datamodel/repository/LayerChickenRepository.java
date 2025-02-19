package com.chickensystem.mis.datamodel.repository;

import java.util.List;

import com.chickensystem.mis.datamodel.layerChicken;

public interface LayerChickenRepository {
    void addLayerChicken(layerChicken _layerChicken);
    void removeLayerChicken(layerChicken _layerChicken);
    layerChicken getLayerChicken(String id);
    void updateLayerChicken(layerChicken layerChicken);
    List<layerChicken> getAllLayerChickens();

}

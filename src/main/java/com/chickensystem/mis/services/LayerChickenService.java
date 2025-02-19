package com.chickensystem.mis.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.chickensystem.mis.datamodel.layerChicken;
import com.chickensystem.mis.datamodel.repository.LayerChickenRepository;

@Service

public class LayerChickenService {

    private final LayerChickenRepository layerChickenRepository;

   // @Autowired
    public LayerChickenService(LayerChickenRepository layerChickenRepository) {
        this.layerChickenRepository = layerChickenRepository;
    }

    public void addLayerChicken(layerChicken layerChicken) {
        layerChickenRepository.addLayerChicken(layerChicken);
    }

    public List<layerChicken> getLayerChickens() {
        return layerChickenRepository.getAllLayerChickens();
    }

    public void removeLayerChicken(layerChicken layerChicken) {
        layerChickenRepository.removeLayerChicken(layerChicken);
    }

    public layerChicken getLayerChickenById(String id) {
        layerChicken layerChicken = layerChickenRepository.getLayerChicken(id);
        if (layerChicken != null && layerChicken.getId().equals(id)) {
            return layerChicken;
        }
        return null;
    }

    public void updateLayerChicken(layerChicken layerChicken) {
        layerChickenRepository.updateLayerChicken(layerChicken);
    }

}

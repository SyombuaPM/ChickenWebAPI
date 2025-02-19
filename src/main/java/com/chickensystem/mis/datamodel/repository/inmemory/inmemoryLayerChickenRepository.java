package com.chickensystem.mis.datamodel.repository.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chickensystem.mis.datamodel.layerChicken;
import com.chickensystem.mis.datamodel.repository.LayerChickenRepository;
@Repository
public class inmemoryLayerChickenRepository implements LayerChickenRepository {
    private final List<layerChicken> layerChickens = new ArrayList<>();

    @Override
    public void addLayerChicken(layerChicken _layerChicken) {
        layerChickens.add(_layerChicken);
    }

    @Override
    public void removeLayerChicken(layerChicken _layerChicken) {
        layerChickens.remove(_layerChicken);
    }

    @Override
    public layerChicken getLayerChicken(String id) {
        for (layerChicken _layerChicken : layerChickens) {
            if (_layerChicken.getId().equals(id)) {
                return _layerChicken;
            }
        }
        return null;
    }

    @Override
    public void updateLayerChicken(layerChicken _layerChicken) {
        boolean updated = false;
        for (int i = 0; i < layerChickens.size(); i++) {
            if (layerChickens.get(i).getId().equals(_layerChicken.getId())) {
                layerChickens.set(i, _layerChicken);
                updated = true;
                break;
            }
        }
        if (!updated) {
            layerChickens.add(_layerChicken);
        }
    }

    @Override
    public List<layerChicken> getAllLayerChickens() {
        return layerChickens;
    }

}

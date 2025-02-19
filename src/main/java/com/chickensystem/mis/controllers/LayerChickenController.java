package com.chickensystem.mis.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chickensystem.mis.datamodel.layerChicken;
import com.chickensystem.mis.services.LayerChickenService;

@RestController
@RequestMapping("/Layer Chicken")

public class LayerChickenController {
    private final LayerChickenService layerChickenService;

    //@Autowired
    public LayerChickenController(LayerChickenService layerChickenService) {
        this.layerChickenService = layerChickenService;
    }

    @PostMapping
    public void addLayerChicken(@RequestBody layerChicken layerChicken) {
        layerChickenService.addLayerChicken(layerChicken);
    }

    @GetMapping
    public List<layerChicken> getLayerChickens() {
        return layerChickenService.getLayerChickens();
    }

    @GetMapping("/{id}")
    public layerChicken getLayerChickenById(@PathVariable String id) {
        return layerChickenService.getLayerChickenById(id);
    }

    @PutMapping("/{id}")
    public void updateLayerChicken(@PathVariable String id, @RequestBody layerChicken layerChicken) {
        layerChicken.setId(id);
        layerChickenService.updateLayerChicken(layerChicken);
        
    }

    @DeleteMapping("/{id}")
    public void removeLayerChicken(@PathVariable String id) {
        layerChicken layerChicken = layerChickenService.getLayerChickenById(id);
        if (layerChicken != null) {
            layerChickenService.removeLayerChicken(layerChicken);
        }
    }

}

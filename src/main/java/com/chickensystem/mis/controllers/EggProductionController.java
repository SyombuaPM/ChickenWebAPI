package com.chickensystem.mis.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chickensystem.mis.datamodel.EggProduction;
import com.chickensystem.mis.services.EggProductionService;

@RestController
@RequestMapping("/Egg Productions")

public class EggProductionController {
    private final EggProductionService eggProductionService;

    //@Autowired
    public EggProductionController(EggProductionService eggProductionService) {
        this.eggProductionService = eggProductionService;
    }

    @PostMapping
    public void addEggProduction(@RequestBody EggProduction eggProduction) {
        eggProductionService.addEggProduction(eggProduction);
    
    }

    @GetMapping
    public List<EggProduction> getEggProductions() {
        return eggProductionService.getEggProductions();
    }

    @GetMapping("/{date}")
    public EggProduction getEggProductionByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return eggProductionService.getEggProductionByDate(localDate);
    }

    @PutMapping("/{date}")
    public void updateEggProduction(@PathVariable String date, @RequestBody EggProduction eggProduction) {
        LocalDate localDate = LocalDate.parse(date);
        eggProduction.setDate(localDate);
        eggProductionService.updateEggProduction(eggProduction);
    }

    @DeleteMapping("/{date}")
    public void removeEggProduction(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        EggProduction eggProduction = eggProductionService.getEggProductionByDate(localDate);
        if (eggProduction != null) {
            eggProductionService.removeEggProduction(eggProduction);
        }
    }

}
